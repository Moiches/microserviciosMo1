package com.example.ms1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ms1.entity.User;

@Repository
public interface UserInterface extends JpaRepository<User, Long>{

}
