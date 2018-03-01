package org.xiaomao.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.xiaomao.hibernate.entity.base.TableEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "T_OFFICIAL_DOCUMENT_UPGRADE_PLAN")
@DynamicInsert
@DynamicUpdate
public class OfficialDocumentUpgradePlan extends TableEntity {

	private static final long serialVersionUID = 1L;

	private String fkOfficialDocumentId;
	private int planSignBoardNum;
	private int upgradeSignBoardNum;
	private String upgradeDesc;
	private int upgradeStatus;

	private Date planUpgradeStartTime;
	private Date planUpgradeEndTime;
	private Date upgradeStartTime;
	private Date upgradeEndTime;

	private String startTime;
	private String endTime;
	private String startTime2;
	private String endTime2;
	private List<String> fkSignBoardIds;
	private List<String> fkSignBoardNos;

	@Transient
	public List<String> getFkSignBoardNos() {
		return fkSignBoardNos;
	}

	public void setFkSignBoardNos(List<String> fkSignBoardNos) {
		this.fkSignBoardNos = fkSignBoardNos;
	}

	@Column(name = "FK_OFFICIAL_DOCUMENT_ID")
	public String getFkOfficialDocumentId() {
		return fkOfficialDocumentId;
	}

	public void setFkOfficialDocumentId(String fkOfficialDocumentId) {
		this.fkOfficialDocumentId = fkOfficialDocumentId;
	}

	@Column(name = "PLAN_SIGN_BOARD_NUM")
	public int getPlanSignBoardNum() {
		return planSignBoardNum;
	}

	public void setPlanSignBoardNum(int planSignBoardNum) {
		this.planSignBoardNum = planSignBoardNum;
	}

	@Column(name = "UPGRADE_SIGN_BOARD_NUM")
	public int getUpgradeSignBoardNum() {
		return upgradeSignBoardNum;
	}

	public void setUpgradeSignBoardNum(int upgradeSignBoardNum) {
		this.upgradeSignBoardNum = upgradeSignBoardNum;
	}

	@Column(name = "UPGRADE_DESC")
	public String getUpgradeDesc() {
		return upgradeDesc;
	}

	public void setUpgradeDesc(String upgradeDesc) {
		this.upgradeDesc = upgradeDesc;
	}

	@Column(name = "UPGRADE_STATUS")
	public int getUpgradeStatus() {
		return upgradeStatus;
	}

	public void setUpgradeStatus(int upgradeStatus) {
		this.upgradeStatus = upgradeStatus;
	}

	@Column(name = "PLAN_UPGRADE_START_TIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	public Date getPlanUpgradeStartTime() {
		return planUpgradeStartTime;
	}

	public void setPlanUpgradeStartTime(Date planUpgradeStartTime) {
		this.planUpgradeStartTime = planUpgradeStartTime;
	}

	@Column(name = "PLAN_UPGRADE_END_TIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	public Date getPlanUpgradeEndTime() {
		return planUpgradeEndTime;
	}

	public void setPlanUpgradeEndTime(Date planUpgradeEndTime) {
		this.planUpgradeEndTime = planUpgradeEndTime;
	}

	@Column(name = "UPGRADE_START_TIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	public Date getUpgradeStartTime() {
		return upgradeStartTime;
	}

	public void setUpgradeStartTime(Date upgradeStartTime) {
		this.upgradeStartTime = upgradeStartTime;
	}

	@Column(name = "UPGRADE_END_TIME")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
	public Date getUpgradeEndTime() {
		return upgradeEndTime;
	}

	public void setUpgradeEndTime(Date upgradeEndTime) {
		this.upgradeEndTime = upgradeEndTime;
	}

}