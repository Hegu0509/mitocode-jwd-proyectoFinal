package com.mitocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.entities.Cuenta;

@Repository
public interface UserRepository  extends JpaRepository<Cuenta, Long>{
	Cuenta findByUserName(String userName);
}
