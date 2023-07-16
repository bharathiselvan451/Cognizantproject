package com.cognizant.project.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import com.cognizant.project.model.User;

public class UserMapper implements RowMapper{
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();

        user.setEmail(rs.getString("email"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));
        user.setPhoneNo(rs.getString("phoneno"));
      

        return user;
    }

	@Override
	public int[] getRowsForPaths(TreePath[] path) {
		// TODO Auto-generated method stub
		return null;
	}
}