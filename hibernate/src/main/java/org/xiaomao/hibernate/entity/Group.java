package org.xiaomao.hibernate.entity;

import java.util.HashSet;
import java.util.Set;

public class Group {
	private long id;
	private String name;

	private Set<User> users = new HashSet<User>();

	public Group(String name) {
		this.name = name;
	}
	
	public void addUser(User user) {
		this.users.add(user);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}