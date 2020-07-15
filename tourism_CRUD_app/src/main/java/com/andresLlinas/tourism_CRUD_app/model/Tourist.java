/**
 * 
 */
package com.andresLlinas.tourism_CRUD_app.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author AndresLlinas
 *
 */
@Entity
@Table(name = "tourist")
public class Tourist {

	private String fullName;
	private Date birthDate;
	@Id
	@Column(unique = true)
	private String id;
	private String idType;
	private int travelFrecuency;
	private double travelBudget;
	@OneToMany(mappedBy = "tourist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Travel> travels;
	private boolean hasCreditCard;

	public Tourist() {
	}

	public Tourist(String fullName, Date birthDate, String id, String idType, int travelFrecuency, double travelBudget,
			List<Travel> travels, boolean hasCreditCard) {
		super();
		this.fullName = fullName;
		this.birthDate = birthDate;
		this.id = id;
		this.idType = idType;
		this.travelFrecuency = travelFrecuency;
		this.travelBudget = travelBudget;
		this.travels = travels;
		this.hasCreditCard = hasCreditCard;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getIdType() {
		return idType;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public int getTravelFrecuency() {
		return travelFrecuency;
	}

	public void setTravelFrecuency(int travelFrecuency) {
		this.travelFrecuency = travelFrecuency;
	}

	public double getTravelBudget() {
		return travelBudget;
	}

	public void setTravelBudget(double travelBudget) {
		this.travelBudget = travelBudget;
	}

	public boolean isHasCreditCard() {
		return hasCreditCard;
	}

	public void setHasCreditCard(boolean hasCreditCard) {
		this.hasCreditCard = hasCreditCard;
	}

	public List<Travel> getTravels() {
		return travels;
	}

	public void setTravels(List<Travel> travels) {
		this.travels = travels;
	}

	@Override
	public String toString() {
		return fullName + " - " + id;
	}

}
