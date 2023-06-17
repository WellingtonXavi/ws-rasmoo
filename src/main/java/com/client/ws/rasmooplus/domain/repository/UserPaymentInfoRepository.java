package com.client.ws.rasmooplus.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.ws.rasmooplus.domain.model.UserPaymentInfo;

@Repository
public interface UserPaymentInfoRepository extends JpaRepository<UserPaymentInfo, Long>{

}
