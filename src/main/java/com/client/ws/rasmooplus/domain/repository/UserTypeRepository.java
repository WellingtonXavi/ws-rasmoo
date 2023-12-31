package com.client.ws.rasmooplus.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.client.ws.rasmooplus.domain.model.UserType;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long>{

}
