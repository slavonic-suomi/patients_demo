package com.itsm.pub.courses.patients.web.repository;

import com.itsm.pub.courses.patients.common.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(path = "/product")
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
