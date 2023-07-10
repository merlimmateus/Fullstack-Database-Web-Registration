package com.dataBaseWebProject.demo.repository;

import com.dataBaseWebProject.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
}
