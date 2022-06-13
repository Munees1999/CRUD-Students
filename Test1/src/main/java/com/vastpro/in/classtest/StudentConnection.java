package com.vastpro.in.classtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class StudentConnection {
	
	public static Connection getConnection() throws SQLException,ClassNotFoundException {
		Connection con;
		
		
			Class.forName("org.postgresql.Driver");
			 con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/Demo", "postgres", "postgres");
			System.out.println("Succesfully Connected");
			return con;
	
	}
	
		public static int insert(Student sn) {
			int status=0;
			try {
			Connection con=StudentConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into student(name,id,roll_Number,age,total_Marks,grade) values(?,?,?,?,?,?)");
			ps.setString(1,sn.getName());
			ps.setString(2,sn.getId());
			ps.setString(3,sn.getRollNumber());
			ps.setString(4, sn.getAge());
			ps.setString(5,sn.getTotalMarks());
			ps.setString(6,sn.getGrade());
			status=ps.executeUpdate();
			ps.close();
		}catch(Exception e)
			{
			System.out.println(e);
			}
			return status;
		
	}
		public static int update(Student sn) {
			int status=0;
			try {
			
				Connection con=StudentConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("update student set total_Marks=?,grade=? where roll_number=?");
				ps.setString(1,sn.getTotalMarks() );
				ps.setString(2,sn.getGrade() );
				ps.setString(3,sn.getRollNumber());
				status=ps.executeUpdate();
				ps.close();
				
			}
			catch(Exception e) {
				System.out.println(e);
				}
			return status;
		}
		
		
		public static int delete(String rollNmber) {
			int status=0;
			try {
				Connection con=StudentConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("delete from student where roll_number=?");
				ps.setString(1, rollNmber);
				
				status=ps.executeUpdate();
				ps.close();
			}catch(Exception e) {
				System.out.println(e);
			}
			return status;
		}

	
}

