package com.client.ws.rasmooplus.domain.model;

import java.io.Serializable;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "users_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String phone;

	@Column(unique = true)
	private String cpf;

	@Column(name = "dt_subscription")
	private OffsetDateTime dtSubscription;

	@Column(name = "dt_expiration")
	private OffsetDateTime dtExpiration;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_type_id")
	private UserType userType;

	
	  
	  @ManyToOne(fetch = FetchType.LAZY)
	  
	  @JoinColumn(name = "subscriptions_type_id")
	  private SubscriptionType subscriptionType;
	 
	public User(String name, String email, String phone, String cpf, OffsetDateTime dtSubscription,
			OffsetDateTime dtExpiration, UserType type , SubscriptionType subscriptionType) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
		this.dtSubscription = dtSubscription;
		this.dtExpiration = dtExpiration;
		this.userType = type;
		this.subscriptionType = subscriptionType;
	}

}
