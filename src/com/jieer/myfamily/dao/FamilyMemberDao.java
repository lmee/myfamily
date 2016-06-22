package com.jieer.myfamily.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.jieer.myfamily.enity.FamilyMember;
import com.jieer.myfamily.enity.User;

public class FamilyMemberDao {
	
	private final String jdbcurl="jdbc:mysql://localhost:3306/myfamliy?user=root&password=root";
	Statement stmt=null;
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public FamilyMemberDao(){
		try {
			Connection conn = DriverManager.getConnection(jdbcurl);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public boolean validateLogin(User user){
		String query = "select * from user where name='"+user.getName()+"'";
		System.out.println("query--->"+query);
		String queryPass =null;
		try {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				queryPass =rs.getString("pass");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user.getPass().equals(queryPass);
	}

	public ArrayList<FamilyMember> queryMemberList(){
		
		ArrayList<FamilyMember> memberlist = new ArrayList<FamilyMember>();
		String queryurl = "select * from member";
		ResultSet rs;
		try {
			rs = stmt.executeQuery(queryurl);
			while(rs.next()){
				FamilyMember member =new FamilyMember();
				member.setId(rs.getInt("id"));
				member.setAppellation(rs.getString("appellation"));
				member.setAge(rs.getInt("age"));
				member.setFavorite(rs.getString("favorite"));
				member.setJob(rs.getString("job"));
				member.setName(rs.getString("name"));
				memberlist.add(member);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return memberlist;
	}
}
