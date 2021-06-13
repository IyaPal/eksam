package com.example.demo.repositories;

import com.example.demo.entities.Function;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionRepository extends CrudRepository<Function, Long>{}