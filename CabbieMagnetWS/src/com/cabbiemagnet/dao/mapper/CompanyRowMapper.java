package com.cabbiemagnet.dao.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cabbiemagnet.model.Company;


/**
 * rowmapper is used by Spring to read a line from a database table 
 * and to fill an instance of the class with the values
 */
public class CompanyRowMapper implements RowMapper<Company> {

	@Override
	public Company mapRow(ResultSet rs, int line) throws SQLException {
		
		Company comp = new Company();
		comp.setId(rs.getLong("ID"));
		comp.setName(rs.getString("NAME"));
		comp.setLocation(rs.getString("LOCATION"));
		comp.setRating(rs.getString("RATING_AVG"));
		return comp;
	}

}