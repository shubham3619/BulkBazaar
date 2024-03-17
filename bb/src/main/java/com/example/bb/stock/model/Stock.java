package com.example.bb.stock.model;

import java.math.BigDecimal;

import com.example.bb.base.model.Base;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Stock extends Base{
	
	private Long id;
	private String name;
	private Integer unit;
	private BigDecimal price;
	private Integer deliveryTime;
	private Long purchasedFromId;
	private String purchasedFromName;
	private String remarks;
	
	public Stock(StockEntity stockEntity) {
	  super(stockEntity);
	  this.id=stockEntity.getId();
	  this.name=stockEntity.getName();
	  this.unit=stockEntity.getUnit();
	  this.price=stockEntity.getPrice();
	  this.deliveryTime=stockEntity.getDeliveryTime();
	  this.purchasedFromId=stockEntity.getPurchasedFromId();
	  this.purchasedFromName=stockEntity.getPurchasedFromName();
	  this.remarks=stockEntity.getRemarks();
	}
	
	public StockEntity populateUserEntity() {
		StockEntity stockEntity = new StockEntity();
		stockEntity.setId(getId());
		stockEntity.setName(getName());
		stockEntity.setUnit(getUnit());
		stockEntity.setPrice(getPrice());
		stockEntity.setDeliveryTime(getDeliveryTime());
		stockEntity.setPurchasedFromId(getPurchasedFromId());
		stockEntity.setPurchasedFromName(getPurchasedFromName());
		stockEntity.setRemarks(getRemarks());
		super.populateBaseEntity();
		return stockEntity;
	}
	
}
