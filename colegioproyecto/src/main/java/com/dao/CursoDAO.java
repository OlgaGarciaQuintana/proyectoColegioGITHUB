package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.model.Curso;
import com.util.HibernateUtil;

import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;

public class CursoDAO {

	//INSERTAR CURSO:

    public void insertarCurso(Session session, Curso c) {
		session.persist(c);
		System.out.println("Curso insertado");
	}
	
	//ACTUALIZAR CURSO:

	public void actualizarCurso(Session session, Curso c) {
		session.merge(c);
		System.out.println("Curso actualizado");
	}

	//BORRAR CURSO:
	
	public void deleteCurso(Session session, int idcurso) {
		Curso c = session.get(Curso.class, idcurso);
		if (c != null ) {
			session.remove(c);
			System.out.println("Curso eliminado");
		}
	}

	//SELECCIONAR SOLO UN CURSO:

	public Curso selectCursoById(Session session, int idcurso) {
		return session.get(Curso.class, idcurso);
	}
	
	//SELECCIONAR TODOS LOS CURSOS:
	
	public List<Curso> selectAllCursos(Session session) {
		return session.createQuery("FROM Curso", Curso.class).list();
	}
    
}
