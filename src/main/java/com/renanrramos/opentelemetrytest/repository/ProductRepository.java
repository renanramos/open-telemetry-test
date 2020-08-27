/**
 * 
 */
package com.renanrramos.opentelemetrytest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renanrramos.opentelemetrytest.model.Product;

/**
 * @author renan.ramos
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

}
