package org.xiaomao.hibernate.entity;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "T_PERSONS")
@DynamicUpdate
@DynamicInsert
public class Person {

	@Id
	@GeneratedValue
	private Long id;
	@Column(name = "AGE")
	private int age;
	@Column(name = "FIRST_NAME")
	private String firstname;
	@Column(name = "LAST_NAME")
	private String lastname;
	@ManyToMany
	@JoinTable(name = "PERSON_EVENT",
			joinColumns = {@JoinColumn(name = "PERSON_ID")},
			inverseJoinColumns = {@JoinColumn(name = "EVENT_ID")})
	private Set<Event> events;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

}
