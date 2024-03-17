package com.example.bb.base.model;

import java.time.LocalDate;

import com.example.bb.audit.model.Audit;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Base extends Audit {
	
	LocalDate effectiveDate;
	
	LocalDate endDate;
	
	Boolean deletedInd;
	
	
	public Base(BaseEntity baseEntity) {
		super(baseEntity);
		this.effectiveDate = baseEntity.getEffectiveDate();
		this.endDate = baseEntity.getEndDate();
		this.deletedInd = baseEntity.getDeletedInd();
	}

	public BaseEntity populateBaseEntity() {
		BaseEntity baseEntity = new BaseEntity();
		baseEntity.setEffectiveDate(getEffectiveDate());
		baseEntity.setEndDate(getEndDate());
		baseEntity.setDeletedInd(getDeletedInd());
		super.populateAuditEntity();
		return baseEntity;
	}
}
