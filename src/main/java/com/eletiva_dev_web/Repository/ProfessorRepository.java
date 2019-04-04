package com.eletiva_dev_web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eletiva_dev_web.Model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, String> {

}
