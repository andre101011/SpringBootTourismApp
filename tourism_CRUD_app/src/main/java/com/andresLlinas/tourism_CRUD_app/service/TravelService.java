package com.andresLlinas.tourism_CRUD_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andresLlinas.tourism_CRUD_app.interfaceService.ITravelService;
import com.andresLlinas.tourism_CRUD_app.interfaces.ITravel;
import com.andresLlinas.tourism_CRUD_app.model.Travel;

@Service
public class TravelService implements ITravelService {

	@Autowired
	private ITravel data;

	@Override
	public List<Travel> list() {
		return (List<Travel>) data.findAll();
	}

	@Override
	public Optional<Travel> listById(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Travel c) {
		int ans = 0;
		Travel Travel = data.save(c);
		if (!Travel.equals(null)) {
			ans = 1;
		}
		return ans;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);

	}

}
