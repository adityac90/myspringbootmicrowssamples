package com.example.vi.batch.repositories;

import com.example.vi.batch.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository extends JpaRepository<Tutorial, Integer> {
}
