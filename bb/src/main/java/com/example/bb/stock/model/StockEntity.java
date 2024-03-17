package com.example.bb.stock.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import com.example.bb.base.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="stock")
public class StockEntity extends BaseEntity{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="unit")
	private Integer unit;
	
	@Column(name="price")
	private BigDecimal price;
	
	@Column(name="delivery_time")
	private Integer deliveryTime;
	
	@Column(name="purchased_from_id")
	private Long purchasedFromId;
	
	@Column(name="purchased_from_name")
	private String purchasedFromName;

	@Column(name="remarks")
	private String remarks;
	
}
