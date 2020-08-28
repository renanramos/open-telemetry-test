/**
 * 
 */
package com.renanrramos.opentelemetrytest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.renanrramos.opentelemetrytest.model.Product;
import com.renanrramos.opentelemetrytest.service.ProductService;

import io.opentelemetry.OpenTelemetry;
import io.opentelemetry.context.Scope;
import io.opentelemetry.trace.Span;
import io.opentelemetry.trace.Tracer;

/**
 * @author renan.ramos
 *
 */
@RestController
public class OpenTelemetryController {

	private static Logger LOG = LoggerFactory.getLogger(OpenTelemetryController.class);

	@Autowired
	private Tracer tracer;

	private Span span;
	
	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@GetMapping(path = "/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = new ArrayList<>();
		span = setSpanProperties();

		try (Scope scope = tracer.withSpan(span)) {
			span.addEvent("Searching for the product with id 2");
			
			searchForProductById();
			
			products = productService.getProducts();
			span.end();
			return ResponseEntity.ok(products);
		} finally {
			span.end();
		}
	}

	/**
	 * @return
	 */
	private Span setSpanProperties() {
		tracer = OpenTelemetry.getTracer("com.renanrramos.opentelemetrytest.controller.OpenTelemetryController");
		return tracer.spanBuilder("Parent Span")
				.setAttribute("http.method", "get")
				.setAttribute("http.url", "http://localhost:8080/products")
				.setNoParent()
				.startSpan();
	}

	private void searchForProductById() {
		Span childSpan = tracer.spanBuilder("Child span")
				.setParent(span)
				.setNoParent()
				.startSpan();

		childSpan.addEvent("reading product with id 2");
		Optional<Product> productOptional = productService.getProductById(2L);

		Product product = productOptional.isPresent() ? productOptional.get() : new Product();
		
		childSpan.setAttribute("product with id 2 found", product.toString());

		LOG.info("Product found: {}", product);

		childSpan.end();
	}
}
