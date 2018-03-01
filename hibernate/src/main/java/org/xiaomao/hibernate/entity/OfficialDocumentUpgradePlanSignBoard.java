package org.xiaomao.hibernate.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.xiaomao.hibernate.entity.base.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "T_OFFICIAL_DOCUMENT_UPGRADE_PLAN_SIGN_BOARD")
@DynamicInsert
@DynamicUpdate
public class OfficialDocumentUpgradePlanSignBoard extends IdEntity {

	private static final long serialVersionUID = 1L;

	private String fkSignBoardId;
	private String fkUpgradePlanId;
	private int upgradeStatus;
	private Date upgradeStartTime;
	private Date upgradeEndTime;
	private Integer isDownload;
	private Integer isRead;

	@Column(name = "FK_SIGN_BOARD_ID")
	public String getFkSignBoardId() {
		return fkSignBoardId;
	}

	public void setFkSignBoardId(String fkSignBoardId) {
		this.fkSignBoardId = fkSignBoardId;
	}

	@Column(name = "FK_OFFICIAL_DOCUMENT_UPGRADE_PLAN_ID")
	public String getFkUpgradePlanId() {
		return fkUpgradePlanId;
	}

	public void setFkUpgradePlanId(String fkUpgradePlanId) {
		this.fkUpgradePlanId = fkUpgradePlanId;
	}

	@Column(name = "UPGRADE_STATUS")
	public int getUpgradeStatus() {
		return upgradeStatus;
	}

	public void setUpgradeStatus(int upgradeStatus) {
		this.upgradeStatus = upgradeStatus;
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

	@Column(name = "IS_DOWNLOAD")
	public Integer getIsDownload() {
		return isDownload;
	}

	public void setIsDownload(Integer isDownload) {
		this.isDownload = isDownload;
	}

	@Column(name = "IS_READ")
	public Integer getIsRead() {
		return isRead;
	}

	public void setIsRead(Integer isRead) {
		this.isRead = isRead;
	}
}