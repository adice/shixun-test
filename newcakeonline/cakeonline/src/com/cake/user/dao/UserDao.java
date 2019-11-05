package com.cake.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cake.entity.User;
import com.cake.util.DbUtil;

public class UserDao {
	
	public User findByEamilAndPassword(String email, String password) {
		Connection con=null;
		try {
			con = DbUtil.getCon();
			PreparedStatement pstm = con.prepareStatement("select * from tbl_user where email = ? and password = ?");
			pstm.setString(1, email);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setEmail(email);
				user.setNickName(rs.getString(2));
				user.setPassword(password);
				user.setRegistTime(rs.getDate(4));
				return user;
			}else
				return null;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			DbUtil.close(con);
		}
	}

}
