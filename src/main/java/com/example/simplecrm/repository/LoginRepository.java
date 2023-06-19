package com.example.simplecrm.repository;

import com.example.simplecrm.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
  Login findByLoginId(String loginId);

  boolean existsByLoginId(String loginId);
}
