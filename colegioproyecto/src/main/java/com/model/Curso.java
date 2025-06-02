package com.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="curso")
@Getter
@Setter
public class Curso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idcurso")
	private int idcurso;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="duracion")
	private int duracion;

	@ManyToMany(mappedBy = "cursos", fetch = FetchType.EAGER)
    private Set<Estudiante> estudiantes = new HashSet<>();
	
	public Curso(String nombre, int duracion) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public Curso(String nombre, int duracion, Estudiante estudiantes) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
	}

	public Curso() {
		super();
	}

	//AÑADIR UN ESTUDIANTE A UN CURSO:

	public void añadirEstudiante(Estudiante e) {
		estudiantes.add(e);
		e.getCursos().add(this);
	}

	//QUITAR UN ESTUDIANTE DE UN CURSO:

	public void quitarEstudiante(Estudiante e) {
		estudiantes.remove(e);
		e.getCursos().remove(this);
	}
    
}
