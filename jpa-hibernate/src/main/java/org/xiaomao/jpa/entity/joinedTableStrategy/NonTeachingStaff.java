package org.xiaomao.jpa.entity.joinedTableStrategy;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "NONTEACHINGSTAFF_JOINED")
@PrimaryKeyJoinColumn(referencedColumnName = "sid")
public class NonTeachingStaff extends Staff {

	private String areaexpertise;

	public NonTeachingStaff(String sname, String areaexpertise) {
		super(sname);
		this.areaexpertise = areaexpertise;
	}

	public NonTeachingStaff() {
		super();
	}

	public String getAreaexpertise() {
		return areaexpertise;
	}

	public void setAreaexpertise(String areaexpertise) {
		this.areaexpertise = areaexpertise;
	}

}
