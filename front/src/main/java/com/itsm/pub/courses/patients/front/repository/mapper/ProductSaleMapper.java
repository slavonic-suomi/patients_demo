package com.itsm.pub.courses.patients.front.repository.mapper;

import com.itsm.pub.courses.patients.common.entities.Patient;
import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.common.entities.ProductSale;
import com.itsm.pub.courses.patients.front.repository.IListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductSaleMapper implements EntityMapper<ProductSale> {

    private final IListRepository<Patient> patientRepository;
    private final IListRepository<Product> productRepository;

    @Autowired
    public ProductSaleMapper(
            IListRepository<Patient> patientRepository,
            IListRepository<Product> productRepository
    ) {
        this.patientRepository = patientRepository;
        this.productRepository = productRepository;
    }

    @Override
    public String getTableName() {
        return "product_sale";
    }

    @Override
    public ProductSale mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        int patientId = rs.getInt("patient_id");
        int productId = rs.getInt("product_id");
        Date date = rs.getDate("date");

        Patient patient = patientRepository.find(patientId);
        Product product = productRepository.find(productId);

        return new ProductSale(id, patient, product, date);
    }
}
