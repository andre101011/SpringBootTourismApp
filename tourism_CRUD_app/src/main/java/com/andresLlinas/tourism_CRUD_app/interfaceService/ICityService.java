package com.andresLlinas.tourism_CRUD_app.interfaceService;

import java.util.List;
import java.util.Optional;

import com.andresLlinas.tourism_CRUD_app.model.City;

public interface ICityService {
	public List<City> list();
	public Optional<City> listById(int id);
	public int save(City city);
	public void delete(int id);
}
