/**
 * 
 */
package com.renanrramos.opentelemetrytest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author renan.ramos
 *
 */
@Getter
@Setter
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@ToString
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	
	private String description;

	public Product() {
		// Intentionally empty
	}
}
