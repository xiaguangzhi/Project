package com.iotek.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iotek.dao.UserDao;
import com.iotek.entry.User;

public class UserDaoImpl extends BaseDao implements UserDao{

	@Override
	public boolean addUser(User user) {
		String sql="insert into User(name,password)values(?,?);";
		List<Object> list=new ArrayList<Object>();
		list.add(user.getName());
		list.add(user.getPassword());
		return operUpdate(sql, list);
	}

	@Override
	public User queryUser(User user) {
		List<User> list=new ArrayList<User>();
		List<Object> params = null;
		String sql="select * from User where name=? and password=? and type=?";
		Connection connection=getConn();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getType());
			rs = ps.executeQuery();
			while (rs.next()) {
				User user2=new User(rs.getInt(1), rs.getString(2), rs.getString(3), 
						rs.getInt(4), rs.getString(5), rs.getString(6));
				list.add(user2);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		colse(connection, ps, rs);
		/* try {
			list=operQuery(sql, params, User.class);
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		 return list.get(0);
	}*/
		if (list.size()>0) {
			return list.get(0);
		}else {
			return null;
		}
		
	}

}
