package com.renovai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renovai.Model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, String> {

}
