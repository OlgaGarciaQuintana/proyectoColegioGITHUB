package com.dao;

import java.util.List;

import org.hibernate.Session;

import com.model.Estudiante;
import com.util.HibernateUtil;

import jakarta.transaction.Transaction;

public class EstudianteDAO {

	//INSERTAR UN ESTUDIANTE:

    public void insertarEstudiante(Session session, Estudiante e) {
		session.persist(e);
		System.out.println("Estudiante insertado");
	}

	//ACTUALIZAR UN ESTUDIANTE:
	
	public void actualizarEstudiante(Session session, Estudiante e) {
		session.merge(e);
		System.out.println("Estudiante actualizado");
	}

	//BORRAR UN ESTUDIANTE:
	
	public void deleteEstudiante(Session session, int idestudiante) {
		Estudiante e = session.get(Estudiante.class, idestudiante);
		if (e != null ) {
			session.remove(e);
			System.out.println("Estudiante eliminado");
		}
	}

	//SELECCIONAR SOLO UN ESTUDIANTE:

	public Estudiante selectEstudianteById(Session session, int idestudiante) {
		return session.get(Estudiante.class, idestudiante);
	}

	//SELECCIONAR TODOS LOS ESTUDIANTES:
	
	public List<Estudiante> selectAllEstudiantes(Session session) {
		return session.createQuery("FROM Estudiante", Estudiante.class).list();
	}
    
}
