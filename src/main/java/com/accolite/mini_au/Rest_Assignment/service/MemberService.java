package com.accolite.mini_au.Rest_Assignment.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accolite.mini_au.Rest_Assignment.model.Member;

public class MemberService {
//	static List<Member> list =  new ArrayList<Member>();

	public boolean deleteMember(String name) {
		MyConnection con = MyConnection.getConnection();
		try {
			con.stmt.execute("delete from members where name='"+name+"';");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean modifyMember(Member m) {
		MyConnection con = MyConnection.getConnection();
		try {
			con.stmt.execute("update members set email='"+m.getEmail()+"',password='"+m.getPassword()+"' where name='"+m.getName()+"';");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean addMember(Member m) {
		MyConnection con = MyConnection.getConnection();
		try {
			con.stmt.execute("insert into members values('"+m.getName()+"','"+m.getEmail()+"','"+m.getPassword()+"');");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Member getMemberByName(String name) {
		MyConnection con = MyConnection.getConnection();
		ResultSet rs;
		Member m =null;
		try {
			rs = con.stmt.executeQuery("select * from members where name='"+name+"';");
			if(rs.next())
			{
				m = new Member(rs.getString(1),rs.getString(2),rs.getString(3));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
	}

	public List<Member> getMembers() {
		MyConnection con = MyConnection.getConnection();
		ResultSet rs;
		List<Member> l = new ArrayList<Member>();
		try {
			rs = con.stmt.executeQuery("select * from members");
		while(rs.next())
			l.add(new Member(rs.getString(1),rs.getString(2),rs.getString(3)));
		} catch (Exception e) {
			e.printStackTrace();
		}  
		return l;
	}
	
}
