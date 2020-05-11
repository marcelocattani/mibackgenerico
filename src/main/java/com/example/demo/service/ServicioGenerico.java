package com.example.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.BaseEntity;

public abstract class ServicioGenerico<ENTITY extends BaseEntity, R extends JpaRepository<ENTITY, Integer>>
		implements IservicioGenerico<ENTITY> {

	@Autowired
	protected R repository;

	@Override
	public List<ENTITY> findAll(int page, int size) throws Exception {
		try {
			Pageable pageable = PageRequest.of(page, size);
			return repository.findAll(pageable).getContent();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public ENTITY findById(int id) throws Exception {
		try {
			Optional<ENTITY> varOptional = repository.findById(id).filter(data -> data.getStatus());
			ENTITY entity = varOptional.get();
			return entity;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ENTITY save(ENTITY entityForm) throws Exception {
		try {
			entityForm.setStatus(true);
			entityForm = repository.save(entityForm);
			return entityForm;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ENTITY update(int id, ENTITY entityForm) throws Exception {
		entityForm.setId(id); // Por si el objeto no trae el id correctamente
		try {
			Optional<ENTITY> entityOptional = repository.findById(id).filter(data -> data.getStatus());
			ENTITY entity = entityOptional.get();
			entity = repository.save(entityForm);
			return entity;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public int countPages(int size) throws Exception {
		try {
			Pageable pageable = PageRequest.of(0, size);
			return repository.findAll(pageable).getTotalPages();
		} catch (Exception e) {
			throw e;
		}
	}

	public boolean delete(int id) throws Exception {
		try {
//			Optional<ENTITY> entityOptional = repository.findById(id);
			Optional<ENTITY> entityOptional = repository.findById(id).filter(data -> data.getStatus());
			ENTITY entity = entityOptional.get();
			entity.setStatus(false);
			repository.save(entity);
		} catch (Exception e) {
			throw e;
		}
		return true;
	}

}
