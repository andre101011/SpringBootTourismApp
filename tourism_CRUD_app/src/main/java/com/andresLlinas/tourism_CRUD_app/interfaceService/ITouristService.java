package com.andresLlinas.tourism_CRUD_app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.andresLlinas.tourism_CRUD_app.model.Tourist;

public interface ITouristService {
	public List<Tourist> list();
	public Optional<Tourist> listById(String id);
	public int save(Tourist tourist);
	public void delete(String id);
}
