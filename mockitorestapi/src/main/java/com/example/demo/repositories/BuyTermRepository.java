package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.BuyTerm;

@Repository
public interface BuyTermRepository extends JpaRepository<BuyTerm, Integer> {

}
