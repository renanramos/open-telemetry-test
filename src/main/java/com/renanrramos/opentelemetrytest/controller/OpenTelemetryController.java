/**
 * 
 */
package com.renanrramos.opentelemetrytest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.renanrramos.opentelemetrytest.model.Product;
import com.renanrramos.opentelemetrytest.service.ProductService;

/**
 * @author renan.ramos
 *
 */
@RestController
public class OpenTelemetryController {

	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@GetMapping(path = "/products")
	public ResponseEntity<List<Product>> getAllProducts() {
		return ResponseEntity.ok(productService.getProducts());
	}
}
