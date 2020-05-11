package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Pageable;

import com.example.demo.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

	@Override
	@Query(value = "SELECT * FROM persona WHERE status = 1", nativeQuery = true)
	public Page<Persona> findAll(Pageable page);

	public Optional<Persona> findByStatus(boolean status);

//	@Override
//	@Query(value = "SELECT * FROM persona WHERE id = %?1% AND status = 1 ", nativeQuery = true)
//	public Optional<Persona> findById(Integer id);
}