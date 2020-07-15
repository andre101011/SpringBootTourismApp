package com.andresLlinas.tourism_CRUD_app.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.andresLlinas.tourism_CRUD_app.model.Tourist;

@Repository
public interface ITourist extends CrudRepository<Tourist, String>{
	
}
