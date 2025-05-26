package com.dao;

import java.util.List;

import org.hibernate.Session;

import com.model.Estudiante;
import com.util.HibernateUtil;

import jakarta.transaction.Transaction;

public class EstudianteDAO {

    public void insertarEstudiante(Session session, Estudiante e) {
		session.persist(e);
		System.out.println("Estudiante insertado");
	}
	
	public void actualizarEstudiante(Session session, Estudiante e) {
		session.merge(e);
		System.out.println("Estudiante actualizado");
	}
	
	public void deleteEstudiante(Session session, int idestudiante) {
		Estudiante e = session.get(Estudiante.class, idestudiante);
		if (e != null ) {
			session.remove(e);
			System.out.println("Estudiante eliminado");
		}
	}

	public Estudiante selectEstudianteById(Session session, int idestudiante) {
		return session.get(Estudiante.class, idestudiante);
	}
	
	
	public List<Estudiante> selectAllEstudiantes(Session session) {
		return session.createQuery("FROM Estudiante", Estudiante.class).list();
	}
    
}
