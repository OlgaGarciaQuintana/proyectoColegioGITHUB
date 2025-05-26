package com.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="matriculacion")
public class Matricula {

    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="idmatriculacion")
	private int id;
	
	@Column(name="idestudiante")
	private int id_usuario;
	
	@Column(name="idcurso")
	private int id_curso;
	
	public Matricula(int id_usuario, int id_curso) {
		super();
		this.id_usuario = id_usuario;
		this.id_curso = id_curso;
	}

	public Matricula() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}
    
}
