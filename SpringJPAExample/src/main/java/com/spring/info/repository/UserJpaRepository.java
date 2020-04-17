package com.spring.info.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.info.beans.User;

@Repository
public interface UserJpaRepository extends JpaRepository<User, Integer>{

}
