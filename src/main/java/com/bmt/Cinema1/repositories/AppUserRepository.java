package com.bmt.Cinema1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmt.Cinema1.models.AppUsers;

public interface AppUserRepository extends JpaRepository<AppUsers, Integer>{

	public AppUsers findByEmail(String email);
}