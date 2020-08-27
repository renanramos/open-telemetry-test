/**
 * 
 */
package com.renanrramos.opentelemetrytest.service;

import java.util.List;

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
}
