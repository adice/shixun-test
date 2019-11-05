package com.cake.cake.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cake.entity.Cake;
import com.cake.entity.Type;
import com.cake.util.DbUtil;

public class CakeDao {
	public Cake findById(int id){
		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = DbUtil.getCon();
			String sql="select * from tbl_cake where id = ?";
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rs = pstm.executeQuery();
			Cake cake = null;
			if(rs.next()) {
				cake = new Cake();
				cake.setId(rs.getInt(1));
				cake.setName(rs.getString(2));
				cake.setDescription(rs.getString(3));
				cake.setPrice(rs.getInt(4));
				cake.setType(rs.getInt(13));
			}
			return cake;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			DbUtil.close(con);
		}
	}
	
	public int countByType(int type, String name) {
		Connection con = null;
		PreparedStatement pstm = null;
		int count = 0;
		try {
			con = DbUtil.getCon();
			String sql="";
			if(name!=null && !name.equals("")) {
				sql = "select count(*) from tbl_cake where type = ? and name like ?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, type);
				pstm.setString(2, "%"+name+"%");
			}else {
				sql = "select count(*) from tbl_cake where type = ?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, type);
			}
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
			return count;
		}catch(Exception e) {
			e.printStackTrace();
			return 0;
		}finally {
			DbUtil.close(con);
		}
	}
	
	public List<Cake> findByType(int type, String name, int pageNum, int pageSize){
		Connection con = null;
		PreparedStatement pstm = null;
		List<Cake> list = new ArrayList<Cake>(0);
		try {
			con = DbUtil.getCon();
			String sql="";
			if(name!=null && !name.equals("")) {
				sql = "select * from tbl_cake where type = ? and name like ? limit ?, ?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, type);
				pstm.setString(2, "%"+name+"%");
				pstm.setInt(3, (pageNum-1)*pageSize);
				pstm.setInt(4, pageSize);
			}else {
				sql = "select * from tbl_cake where type = ? limit ?, ?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, type);
				pstm.setInt(2, (pageNum-1)*pageSize);
				pstm.setInt(3, pageSize);
			}
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Cake cake = new Cake();
				cake.setId(rs.getInt(1));
				cake.setName(rs.getString(2));
				cake.setDescription(rs.getString(3));
				cake.setPrice(rs.getInt(4));
				cake.setType(rs.getInt(13));
				list.add(cake);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			DbUtil.close(con);
		}
	}
	
	public List<Cake> findByType(int type, String name){
		Connection con = null;
		PreparedStatement pstm = null;
		List<Cake> list = new ArrayList<Cake>(0);
		try {
			con = DbUtil.getCon();
			String sql="";
			if(name!=null && !name.equals("")) {
				sql = "select * from tbl_cake where type = ? and name like ?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, type);
				pstm.setString(2, "%"+name+"%");
			}else {
				sql = "select * from tbl_cake where type = ?";
				pstm = con.prepareStatement(sql);
				pstm.setInt(1, type);
			}
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Cake cake = new Cake();
				cake.setId(rs.getInt(1));
				cake.setName(rs.getString(2));
				cake.setDescription(rs.getString(3));
				cake.setPrice(rs.getInt(4));
				cake.setType(rs.getInt(13));
				list.add(cake);
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
