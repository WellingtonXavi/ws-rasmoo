package com.client.ws.rasmooplus.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "subscriptions_type")
@NoArgsConstructor
@Data
public class SubscriptionType implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Column(name = "subscriptions_type_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	@Column(name = "access_months")
	private Integer accessMonths;
	
	private BigDecimal price;
	
	@Column(name = "product_key" , unique = true)
	private String productKey;

	public SubscriptionType(String name, Integer accessMonths, BigDecimal price, String productKey) {
		this.name = name;
		this.accessMonths = accessMonths;
		this.price = price;
		this.productKey = productKey;
	}
	
	
	
	

}
