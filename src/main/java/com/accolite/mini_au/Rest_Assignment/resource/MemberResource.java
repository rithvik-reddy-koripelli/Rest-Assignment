package com.accolite.mini_au.Rest_Assignment.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.accolite.mini_au.Rest_Assignment.model.Member;
import com.accolite.mini_au.Rest_Assignment.service.MemberService;

@Path("/members")
public class MemberResource {
	MemberService memberservice = new MemberService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Member> getMembers()
	{
		return memberservice.getMembers();
	}
	
	@GET
	@Path("/{membername}")
	@Produces(MediaType.APPLICATION_XML)
	public Member getEmployeeById(@PathParam("membername") String name)
	{
		return memberservice.getMemberByName(name);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean addEmployee(Member msg)
	{
		return memberservice.addMember(msg);
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public boolean modifyEmployee(Member m)
	{
		return memberservice.modifyMember(m);
	}
	
	@DELETE
	@Path("/{membername}")
	public boolean deleteEmployee(@PathParam("membername") String name)
	{
		return memberservice.deleteMember(name);
	}

}
