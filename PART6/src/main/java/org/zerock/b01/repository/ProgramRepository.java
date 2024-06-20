package org.zerock.b01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.b01.domain.Program;

public interface ProgramRepository extends JpaRepository<Program, Integer> {
}
