package com.andresLlinas.tourism_CRUD_app.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id;
	private String name;
	private int numberOfInhabitants;
	private String mostTouristicPlace;
	private String mostBookedHotel;
	@OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Travel> travels;

	public City() {
	}

	public City(int id, String name, int numberOfInhabitants, String mostTouristicPlace, String mostBookedHotel,
			List<Travel> travels) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfInhabitants = numberOfInhabitants;
		this.mostTouristicPlace = mostTouristicPlace;
		this.mostBookedHotel = mostBookedHotel;
		this.travels = travels;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfInhabitants() {
		return numberOfInhabitants;
	}

	public void setNumberOfInhabitants(int numberOfInhabitants) {
		this.numberOfInhabitants = numberOfInhabitants;
	}

	public String getMostTouristicPlace() {
		return mostTouristicPlace;
	}

	public void setMostTouristicPlace(String mostTouristicPlace) {
		this.mostTouristicPlace = mostTouristicPlace;
	}

	public String getMostBookedHotel() {
		return mostBookedHotel;
	}

	public void setMostBookedHotel(String mostBookedHotel) {
		this.mostBookedHotel = mostBookedHotel;
	}

	@Override
	public String toString() {
		return id + "- " + name.toUpperCase();
	}

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

}