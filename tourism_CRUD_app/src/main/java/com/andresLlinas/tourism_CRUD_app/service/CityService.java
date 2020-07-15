package com.andresLlinas.tourism_CRUD_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andresLlinas.tourism_CRUD_app.interfaceService.ICityService;
import com.andresLlinas.tourism_CRUD_app.interfaces.ICity;
import com.andresLlinas.tourism_CRUD_app.model.City;

@Service
public class CityService implements ICityService {

	@Autowired
	private ICity data;

	@Override
	public List<City> list() {
		return (List<City>) data.findAll();
	}

	@Override
	public Optional<City> listById(int id) {
		return data.findById(id);
	}

	@Override
	public int save(City c) {
		int ans = 0;
		City city = data.save(c);
		if (!city.equals(null)) {
			ans = 1;
		}
		return ans;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);

	}

}
