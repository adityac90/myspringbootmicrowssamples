package com.example.demo.producer.repository;

import com.example.demo.producer.model.CustomEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventProducerRepository extends JpaRepository<CustomEvent, Long> {
}
