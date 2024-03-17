package com.example.bb.base.model;

import java.time.LocalDate;

import com.example.bb.audit.model.AuditEntity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseEntity extends AuditEntity {

	@Column(name = "effective_date")
	LocalDate effectiveDate;

	@Column(name = "end_date")
	LocalDate endDate;

	@Column(name = "is_deleted")
	Boolean deletedInd;

	@PrePersist
	private void afterAnyUpdate() {
		if (deletedInd == null) {
			this.deletedInd = false;
		}
	}

}
