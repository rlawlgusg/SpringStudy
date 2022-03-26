package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sist.db.ConnectionProvider;
import com.sist.vo.customerVO;


public class customerDAO {
	
	public int deleteCustomer(int custid) {
		int re = -1;
		try {
			String sql = "delete customer where custid = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
			
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
	
	
	
	public customerVO getCustomer(int custid) {
		customerVO c = null;
		String sql = "select * from customer where custid=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, custid);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				c = new customerVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
				ConnectionProvider.close(conn, pstmt, rs);
			}
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return c;
	}
	
	
	public int update(customerVO c) {
		int re = -1;
		try {
			String sql = "update customer set name = ?, address = ?, phone = ? where custid = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getAddress());
			pstmt.setString(3, c.getPhone());
			pstmt.setInt(4, c.getCustid());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;	
	}
	
	public int insert(customerVO c) {
		int re = -1;
		try {
			String sql = "insert into customer values(?,?,?,?)";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c.getCustid());
			pstmt.setString(2, c.getName());
			pstmt.setString(3, c.getAddress());
			pstmt.setString(4, c.getPhone());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt);
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;	
	}
	
	
	
	public ArrayList<customerVO> listAll(){
		ArrayList<customerVO> list = new ArrayList<customerVO>();
		String sql= "select * from customer order by custid";
		try {
			Connection conn =  ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new customerVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			ConnectionProvider.close(conn, stmt, rs);		
		} catch (Exception e) {
			System.out.println("예외발생:"+e.getMessage());
		}
		
		return list;
	}
}
