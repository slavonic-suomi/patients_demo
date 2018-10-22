package com.itsm.pub.courses.patients.front.repository.domain.impl;

import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.front.repository.AbstractCrudRepository;
import com.itsm.pub.courses.patients.front.repository.ICrudRepository;
import com.itsm.pub.courses.patients.front.repository.domain.IProductRepository;
import com.itsm.pub.courses.patients.front.repository.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
public class ProductRepository extends AbstractCrudRepository<Product> implements IProductRepository {


    @Autowired
    public ProductRepository(EntityMapper<Product> mapper, JdbcTemplate jdbcTemplate) {
        super(mapper, jdbcTemplate);
    }

    @Override
    protected Class<Product> getEntityClass() {
        return Product.class;
    }

    @Override
    public Product findByName(String name) {
        try {
            return jdbcTemplate.queryForObject("select * from product where name = ? ", mapper, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void create(Product product) {
        KeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement st = con.prepareStatement(
                    "insert into product (name, state_id) values (?, ?) ",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, product.getName());
            st.setInt(2, product.getState().getId());
            return st;
        }, holder);

        int id = holder.getKey().intValue();
        product.setId(id);
    }

    @Override
    public void update(Product product) {
        jdbcTemplate.update("update product set name = ?, state_id = ? where id = ?",
                product.getName(),
                product.getState().getId(),
                product.getId()
        );
    }
}
