/**
 * 
 */
package com.renanrramos.opentelemetrytest.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author renan.ramos
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class Product {

	private Long id;
	
	private String name;
	
	private String description;

	public Product() {
		// Intentionally empty
	}
}
