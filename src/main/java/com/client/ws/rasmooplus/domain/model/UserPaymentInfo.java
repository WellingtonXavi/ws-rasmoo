package com.client.ws.rasmooplus.domain.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "user_payment_info")
@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserPaymentInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_payment_info_id")
	private Long id;

	@Column(name = "card_number" , unique = true)
	private String cardNumber;

	@Column(name = "card_expiration_month")
	private Long cardExpirationMonth;

	@Column(name = "card_expiration_year")
	private Long cardExpirationYear;

	@Column(name = "card_security_code")
	private String cardSecurityCode;

	private BigDecimal price;

	private Long instalments;

	@Column(name = "dt_payment")
	private OffsetDateTime dtPayment;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	User user;



}
