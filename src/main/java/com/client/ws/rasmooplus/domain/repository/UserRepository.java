package com.client.ws.rasmooplus.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<com.client.ws.rasmooplus.domain.model.User, Long>{

}
