package org.xiaomao.hibernate.entity.base;

import org.xiaomao.hibernate.utils.IdGen;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class IdEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	protected String id; // 唯一标识,32位uuid

	public IdEntity() {
		this(IdGen.uuid());
	}

	public IdEntity(String id) {
		this.id = id;
	}

	@Id
	@Column(name = "ID")
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
