package com.cake.type.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cake.entity.Type;
import com.cake.util.DbUtil;

public class TypeDao {
	
	public List<Type> findTopType(){
		Connection con = null;
		List<Type> list = new ArrayList<Type>(0);
		try {
			con = DbUtil.getCon();
			PreparedStatement pstm = con.prepareStatement("select * from tbl_type where parentId is null");
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Type type = new Type();
				type.setId(rs.getInt(1));
				type.setName(rs.getString(2));
				type.setParentId(rs.getInt(3));
				list.add(type);
				
				PreparedStatement pstm1 = con.prepareStatement("select * from tbl_type where parentId = ?");
				pstm1.setInt(1, type.getId());
				ResultSet rs1 = pstm1.executeQuery();
				while(rs1.next()) {
					Type type1 = new Type();
					type1.setId(rs1.getInt(1));
					type1.setName(rs1.getString(2));
					type1.setParentId(rs1.getInt(3));
					type.getTypes().add(type1);
				}
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			DbUtil.close(con);
		}
	}

}
 