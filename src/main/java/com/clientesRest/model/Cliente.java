package com.clientesRest.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdCliente;

	@Column(name = "nombre", nullable = false, length = 70)
	private String nombre;
	
	@Column(name = "apellido", nullable = false, length = 150)
	private String apellido;
	
	@Column(name = "edad", nullable = false, length = 70)
	private Integer edad;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	private Date fecha_nacimiento;
	
	private String fecha_muerte;

	public Integer getIdCliente() {
		return IdCliente;
	}

	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getFecha_muerte() {
		return fecha_muerte;
	}

	public void setFecha_muerte(String fecha_muerte) {
		this.fecha_muerte = fecha_muerte;
	}
	
	
	
}
