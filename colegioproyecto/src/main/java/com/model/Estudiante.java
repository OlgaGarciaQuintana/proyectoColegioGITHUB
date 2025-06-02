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
import org.hibernate.Session;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="estudiante")
@Getter
@Setter
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

	//AÑADIR UN CURSO A UN ESTUDIANTE:

	public void añadirCurso(Curso c) {
		cursos.add(c);
		c.getEstudiantes().add(this);
	}

	public void quitarCurso(Curso c) {
		cursos.remove(c);
		c.getEstudiantes().remove(this);
	}
    
}
