package com.YooFood.mongo.model;

import java.io.Serializable;
import java.util.List;

public class DireccionModel implements Serializable{
	
	private List<Double> location;
	private String numero;
	private String calle;
	private String distrito;
	private String localidad;
	private String departamento;
	private String pais;
	private String codlocation;
	
	
	public List<Double> getLocation() {
		return location;
	}
	public void setLocation(List<Double> location) {
		this.location = location;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getCodlocation() {
		return codlocation;
	}
	public void setCodlocation(String codlocation) {
		this.codlocation = codlocation;
	}
	
	
}
