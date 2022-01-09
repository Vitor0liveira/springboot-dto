package com.jv.example.springbootdtotutorial.repository;

import com.jv.example.springbootdtotutorial.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
