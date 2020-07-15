package com.andresLlinas.tourism_CRUD_app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.andresLlinas.tourism_CRUD_app.model.Travel;

public interface ITravelService {
	public List<Travel> list();

	public Optional<Travel> listById(int id);

	public int save(Travel travel);

	public void delete(int id);
}
