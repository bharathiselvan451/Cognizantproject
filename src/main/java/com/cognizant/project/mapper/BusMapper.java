package com.cognizant.project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import com.cognizant.project.model.Bus;

public class BusMapper implements RowMapper{
	public Bus mapRow(ResultSet rs, int rowNum) throws SQLException {
        Bus bus = new Bus();

        bus.setDestination(rs.getString("destination"));
        bus.setName(rs.getString("name"));
        bus.setSource(rs.getString("source"));
        bus.setPrice(rs.getInt("price"));
      
        return bus;
    }

	@Override
	public int[] getRowsForPaths(TreePath[] path) {
		// TODO Auto-generated method stub
		return null;
	}
}