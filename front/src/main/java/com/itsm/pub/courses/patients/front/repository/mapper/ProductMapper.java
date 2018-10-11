package com.itsm.pub.courses.patients.front.repository.mapper;

import com.itsm.pub.courses.patients.common.entities.Product;
import com.itsm.pub.courses.patients.common.entities.State;
import com.itsm.pub.courses.patients.front.repository.IListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class ProductMapper implements EntityMapper<Product> {

    private final IListRepository<State> stateRepository;

    @Autowired
    public ProductMapper(IListRepository<State> stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public String getTableName() {
        return "product";
    }

    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");

        int stateId = rs.getInt("state_id");
        State state = stateRepository.find(stateId);

        return new Product(id, name, state);
    }
}
