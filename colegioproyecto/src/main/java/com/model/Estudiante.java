package com.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="estudiante")
public class Estudiante {
    
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idestudiante")
	private int idestudiante;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="edad")
	private int edad;

	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
    @JoinTable(name = "matriculacion", joinColumns = @JoinColumn(name = "idestudiante"), inverseJoinColumns = @JoinColumn(name = "idcurso"))
    private Set<Curso> cursos = new HashSet<>();
	
	public Estudiante(String nombre, int edad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
	}

	public Estudiante() {
		super();
	}

	public int getIdestudiante() {
		return idestudiante;
	}

	public void setIdestudiante(int idestudiante) {
		this.idestudiante = idestudiante;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public void añadirCurso(Curso c) {
		cursos.add(c);
	}
    
}
