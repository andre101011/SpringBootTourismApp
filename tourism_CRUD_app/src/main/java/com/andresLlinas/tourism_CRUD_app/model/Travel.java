package com.andresLlinas.tourism_CRUD_app.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "travel")
public class Travel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true)
	private int id;

	@ManyToOne()
	@JoinColumn(name = "tourist_id", referencedColumnName = "id", updatable = false)
	private Tourist tourist;
	private Date date;
	@ManyToOne()
	@JoinColumn(name = "city_id", referencedColumnName = "id", updatable = false)
	private City city;

	public Travel() {
		super();
	}

	public Travel(int id, Tourist tourist, Date date, City city) {
		super();
		this.id = id;
		this.tourist = tourist;
		this.date = date;
		this.city = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Tourist getTourist() {
		return tourist;
	}

	public void setTourist(Tourist tourist) {
		this.tourist = tourist;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

}
