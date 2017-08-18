package org.xiaomao.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name = "A")
@DynamicInsert
@DynamicUpdate
public class A {

	String id;
	String fkBId;
	String name;

	@Id
	@Column(name = "ID")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "FK_B_ID")
	public String getFkBId() {
		return fkBId;
	}

	public void setFkBId(String fkBId) {
		this.fkBId = fkBId;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private B b;

	@ManyToOne(fetch = FetchType.LAZY)
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn(name = "FK_B_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	public B getB() {
		return b;
	}

	public void setB(B b) {
		this.b = b;
	}

}
