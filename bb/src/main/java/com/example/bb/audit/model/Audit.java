package com.example.bb.audit.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Audit{

	String createdBy;
	
	LocalDateTime createdDatetime;
	
	String lastUpdatedBy;
	
	LocalDateTime lastUpdateDatetime;
	
	public Audit(AuditEntity auditEntity) {
		this.createdBy = auditEntity.getCreatedBy();
		this.createdDatetime = auditEntity.getCreatedDatetime();
		this.lastUpdateDatetime = auditEntity.getLastUpdateDatetime();
		this.lastUpdatedBy=auditEntity.getLastUpdatedBy();
	}

	public AuditEntity populateAuditEntity() {
		AuditEntity auditEntity = new AuditEntity();
		auditEntity.setCreatedBy(getLastUpdatedBy());
		auditEntity.setCreatedDatetime(getCreatedDatetime());
		auditEntity.setLastUpdateDatetime(getLastUpdateDatetime());
		auditEntity.setLastUpdatedBy(getLastUpdatedBy());
		return auditEntity;
	}
}
