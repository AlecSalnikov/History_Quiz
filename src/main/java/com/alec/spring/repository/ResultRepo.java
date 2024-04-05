package com.alec.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alec.spring.models.Result;

@Repository
public interface ResultRepo extends JpaRepository<Result, Integer> {


}