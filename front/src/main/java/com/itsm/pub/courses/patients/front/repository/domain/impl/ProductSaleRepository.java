package com.itsm.pub.courses.patients.front.repository.domain.impl;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.common.entities.ProductSale;
import com.itsm.pub.courses.patients.front.context.Auditable;
import com.itsm.pub.courses.patients.front.repository.AbstractListRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IProductSaleRepository;
import com.itsm.pub.courses.patients.front.repository.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class ProductSaleRepository extends AbstractListRepository<ProductSale> implements IProductSaleRepository {

    @Autowired
    protected ProductSaleRepository(EntityMapper<ProductSale> mapper, JdbcTemplate jdbcTemplate) {
        super(mapper, jdbcTemplate);
    }

    @Override
    @Auditable
    public void sale(Product product, Patient patient) {
        if (!product.getState().equals(patient.getState())) {
            throw new IllegalArgumentException("Patient and product state mismatch");
        }

        jdbcTemplate.update("insert into product_sale (patient_id, product_id, date) values (?,?,?)",
                patient.getId(),
                product.getId(),
                new Date()
        );
    }
}
