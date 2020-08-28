/**
 * 
 */
package com.renanrramos.opentelemetrytest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renanrramos.opentelemetrytest.model.Product;
import com.renanrramos.opentelemetrytest.repository.ProductRepository;

/**
 * @author renan.ramos
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProducts() {
		return this.productRepository.findAll();
	}

	public Product saveProduct(Product product) {
		return this.productRepository.save(product);
	}

	public Optional<Product> getProductById(Long id) {
		return this.productRepository.findById(id);
	}

	public Product updateProduct(Product product) {
		return this.productRepository.save(product);
	}

	public void removeProduct(Long id) {
		this.productRepository.deleteById(id);
	}
}
