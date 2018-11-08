package com.demo.sampleapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.sampleapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
