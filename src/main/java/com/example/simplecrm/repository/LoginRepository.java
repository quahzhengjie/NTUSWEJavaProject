package com.example.simplecrm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.simplecrm.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

}