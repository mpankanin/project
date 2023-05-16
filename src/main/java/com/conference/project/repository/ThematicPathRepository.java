package com.conference.project.repository;

import com.conference.project.model.ThematicPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThematicPathRepository extends JpaRepository<ThematicPath, Long> {
}
