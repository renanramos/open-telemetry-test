/**
 * 
 */
package com.renanrramos.opentelemetrytest.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.renanrramos.opentelemetrytest.model.Product;

/**
 * @author renan.ramos
 *
 */
@Service
public class ProductService {

	public List<Product> getProducts() {
		return Arrays.asList(
				new Product(1L, "Item 1", "This is the first item"), 
				new Product(2L, "Item 2", "This is the second item"),
				new Product(3L, "Item 3", "This is the third item"),
				new Product(4L, "Item 4", "This is the fourth item"),
				new Product(5L, "Item 5", "This is the fifth item"));
	}
}
