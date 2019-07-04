package com.studentsql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex92_4_StudentSQL {

	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String strTemp = "";
		//������������
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		} catch(ClassNotFoundException e) {
		}
		//�������ݿ�����
		try {
			con = DriverManager.getConnection("jdbc:odbc:student", "", "");
			stmt = con.createStatement();
		} catch(SQLException ee) {
		}
		/*
		 * ������
		 * strTemp = "CREATE TABLE student (id TEXT(20) PRIMARY KEY, name TEXT(20), gender TEXT(2), "
				+ "address TEXT(50), phone TEXT(20), major TEXT(30))";
		   try {
			   stmt.executeUpdate(strTemp);
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
		 */
		
		/*
		 * �������
		 * strTemp = "INSERT INTO student VALUES('2012001', '����', '��', '̫ԭ��ӭ�������79��',"
				+ "'13803511208', '�������')";
		   try {
			   stmt.executeUpdate(strTemp);
		   } catch (SQLException e) {
			   e.printStackTrace();
		   }
		 */
		
		//��ȡ���������
		strTemp = "SELECT * FROM student";
		try {
			rs = stmt.executeQuery(strTemp);
			while (rs.next()) {
				System.out.println(rs.getString("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("gender"));
				System.out.println(rs.getString("address"));
				System.out.println(rs.getString("phone"));
				System.out.println(rs.getString("major"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//�ͷ���Դ
		try{
			rs.close();
			stmt.close();
			con.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
