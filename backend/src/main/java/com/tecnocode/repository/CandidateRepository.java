package com.tecnocode.repository;

import com.tecnocode.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{
}
