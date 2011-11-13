package com.cabbiemagnet.dao.mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.cabbiemagnet.model.Service;


/**
 * 
 * ================================================================================
 * @author anlazarov
 * @date Nov 13, 2011
 * @time 6:45:51 PM
 *								
 * @project CabbieMagnetWS	
 * @package com.cabbiemagnet.dao.mapper	
 * @filename ServiceRowMapper.java
 * @description rowmapper is used by Spring to read a line from a database table 
 * and to fill an instance of the class with the values
 * ================================================================================
 */
public class ServiceRowMapper implements RowMapper<Service> {

	@Override
	public Service mapRow(ResultSet rs, int line) throws SQLException {
		
		Service service = new Service();
		service.setId(rs.getLong("ID"));
		service.setName(rs.getString("NAME"));
		return service;
	}

}