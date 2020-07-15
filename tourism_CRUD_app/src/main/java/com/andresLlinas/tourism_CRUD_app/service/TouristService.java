package com.andresLlinas.tourism_CRUD_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andresLlinas.tourism_CRUD_app.interfaceService.ITouristService;
import com.andresLlinas.tourism_CRUD_app.interfaces.ITourist;
import com.andresLlinas.tourism_CRUD_app.model.Tourist;

@Service
public class TouristService implements ITouristService{

	@Autowired
	private ITourist data;
	
	@Override
	public List<Tourist> list() {
		return (List<Tourist>) data.findAll();
	}

	@Override
	public Optional<Tourist> listById(String id) {
		return data.findById(id);
	}

	@Override
	public int save(Tourist t) {
		int ans=0;
		Tourist tourist = data.save(t);
		if (!tourist.equals(null)) {
			ans=1;
		}
		return ans;
	}

	@Override
	public void delete(String id) {
		data.deleteById(id);
	}
}
