package org.xiaomao.jacksontest.entity;

import java.util.Date;
import java.util.List;

public class Artist {
	public String name;
	private Date birthDate;
	private Integer age;
	private String homeTown;
	private List<String> awardWon;

	public String getName() { return name; }

	public void setName(String name) { this.name = name; }

	public Date getBirthDate() { return birthDate; }

	public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

	public Integer getAge() { return age; }

	public void setAge(Integer age) { this.age = age; }

	public String getHomeTown() { return homeTown; }

	public void setHomeTown(String homeTown) { this.homeTown = homeTown; }

	public List<String> getAwardWon() { return awardWon; }

	public void setAwardWon(List<String> awardWon) { this.awardWon = awardWon; }
}
