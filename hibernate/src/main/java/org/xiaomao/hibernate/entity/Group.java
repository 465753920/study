package org.xiaomao.hibernate.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_GROUP")
@DynamicInsert
@DynamicUpdate
public class Group {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "NAME")
	private String name;
	@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
	private Set<User> users = new HashSet<User>();

	public Group() {
	}

	public Group(String name) {
		this.name = name;
	}

	public void addUser(User user) {
		this.users.add(user);
	}

	public long getId() { return id; }

	public void setId(long id) { this.id = id; }

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Set<User> getUsers() { return users; }

	public void setUsers(Set<User> users) { this.users = users; }
}