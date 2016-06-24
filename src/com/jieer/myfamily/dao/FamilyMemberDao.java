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
	private Connection conn= null;
	private Statement stmt=null;
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
			conn = DriverManager.getConnection(jdbcurl);
			stmt = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public boolean validateLogin(User user){
		String query = "select * from user where name='"+user.getName()+"'";
		String queryPass =null;
		try {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				queryPass =rs.getString("pass");
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user.getPass().equals(queryPass);
	}
	
	public FamilyMember queryFamilyMember(int id){
		String query = "select * from member where id="+id;
		FamilyMember member =new FamilyMember();
		try {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()){
				member.setId(rs.getInt("id"));
				member.setAppellation(rs.getString("appellation"));
				member.setAge(rs.getInt("age"));
				member.setFavorite(rs.getString("favorite"));
				member.setJob(rs.getString("job"));
				member.setName(rs.getString("name"));
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return member;
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
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return memberlist;
	}
	
	public void addFamilyMember(FamilyMember member){
		String addurl ="insert member values(null,'"+member.getAppellation()+"','"+member.getName()+"',"+member.getAge()+",'"+member.getFavorite()+"','"+member.getJob()+"')";
		System.out.println("addurl--->"+addurl);
		try {
			boolean flag = stmt.execute(addurl);
			System.out.println("flag-->"+flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateFamilyMember(FamilyMember member){
		String updateurl="update member set appellation='"+member.getAppellation()+"',name='"+member.getName()+"',age="+member.getAge()+",favorite='"+member.getFavorite()+"',job='"+member.getJob()+"' where id="+member.getId();
		System.out.println("updateurl--->"+updateurl);
		try {
			boolean flag = stmt.execute(updateurl);
			System.out.println("flag-->"+flag);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteFamilyMember(int id){
		String deleteUrl =null;
		if(id==0){
			 deleteUrl = "delete from member";
		}else{
			 deleteUrl = "delete from member where id="+id;
		}
		 System.out.println("deleteUrl-->"+deleteUrl);
			try {
				boolean flag = stmt.execute(deleteUrl);
				System.out.println("flag-->"+flag);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public void destroyConnection(){
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
