package com.andresLlinas.tourism_CRUD_app.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andresLlinas.tourism_CRUD_app.model.City;
import com.andresLlinas.tourism_CRUD_app.model.Tourist;
import com.andresLlinas.tourism_CRUD_app.model.Travel;
import com.andresLlinas.tourism_CRUD_app.service.CityService;
import com.andresLlinas.tourism_CRUD_app.service.TouristService;
import com.andresLlinas.tourism_CRUD_app.service.TravelService;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {
	@Autowired
	private TouristService serviceTourist;

	@GetMapping("/tourists/list")
	public String listTourists(Model model) {
		List<Tourist> tourists = serviceTourist.list();
		model.addAttribute("tourists", tourists);
		return "tourists";
	}

	@GetMapping("/tourists/new")
	public String addTourist(Model model) {
		model.addAttribute("tourist", new Tourist());
		return "forms/touristForm";
	}

	@PostMapping("/tourists/save")
	public String saveTourist(@Validated Tourist t, Model model) {
		serviceTourist.save(t);
		return "redirect:/tourists/list";
	}

	@GetMapping("/tourists/edit/{id}")
	public String editTourist(@PathVariable String id, Model model) {
		Optional<Tourist> tourist = serviceTourist.listById(id);
		model.addAttribute("tourist", tourist);
		return "forms/touristForm";
	}

	@GetMapping("/tourists/delete/{id}")
	public String deleteTourist(@PathVariable String id, Model model) {
		serviceTourist.delete(id);
		return "redirect:/tourists/list";
	}

	@ModelAttribute("cities")
	public List<City> populateStates() {
		List<City> listStates = new ArrayList<City>();
		for (City c : serviceCity.list()) {
			listStates.add(c);
		}
		return listStates;
	}

	// Cities

	@Autowired
	private CityService serviceCity;

	@GetMapping("/cities/listWebService")
	public List<City> listCitiesOD(Model model) {
		List<City> cities = serviceCity.list();
		return cities;
	}

	@GetMapping("/cities/list")
	public String listCities(Model model) {
		List<City> cities = serviceCity.list();
		model.addAttribute("cities", cities);
		return "cities";
	}

	@GetMapping("/cities/new")
	public String addCity(Model model) {
		model.addAttribute("city", new City());
		return "forms/cityForm";
	}

	@PostMapping("/cities/save")
	public String save(@Validated City c, Model model) {
		serviceCity.save(c);
		return "redirect:/cities/list";
	}

	@GetMapping("/cities/edit/{id}")
	public String editCity(@PathVariable int id, Model model) {
		Optional<City> city = serviceCity.listById(id);
		model.addAttribute("city", city);
		return "forms/cityForm";
	}

	@GetMapping("/cities/delete/{id}")
	public String deleteCity(@PathVariable int id, Model model) {
		serviceCity.delete(id);
		return "redirect:/cities/list";
	}

	// travels

	@Autowired
	private TravelService serviceTravel;

	@GetMapping("/travels/list")
	public String listTravels(Model model) {
		List<Travel> travels = serviceTravel.list();
		model.addAttribute("travels", travels);
		return "travels";
	}

	@GetMapping("/travels/new")
	public String addTravel(Model model) {
		model.addAttribute("travel", new Travel());
		model.addAttribute("tourist", new Tourist());
		model.addAttribute("city", new City());
		return "forms/travelForm";

	}

	@PostMapping("/travels/save")
	public String save(@Validated Travel t, BindingResult bindingResult, Model model) {
		if (serviceTourist.listById(t.getTourist().getId()).isPresent()) {
			serviceTravel.save(t);
		} else {
		
		}

		return "redirect:/travels/list";
	}

	@GetMapping("/travels/delete/{id}")
	public String deleteTravel(@PathVariable int id, Model model) {
		serviceTravel.delete(id);
		return "redirect:/travels/list";
	}

}
