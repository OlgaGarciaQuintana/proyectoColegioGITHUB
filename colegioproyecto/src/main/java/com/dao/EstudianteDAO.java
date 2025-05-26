package com.dao;

import java.util.List;

import org.hibernate.Session;

import com.model.Estudiante;
import com.util.HibernateUtil;

import jakarta.transaction.Transaction;

public class EstudianteDAO {

    //INSERTAR:
	
	public void insertEstudiante(Estudiante es) {
		org.hibernate.Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.persist(es);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
	}

	//UPDATE:
	
	public void updateEstudiante(Estudiante es) {
		org.hibernate.Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.merge(es);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
	}
	
	//BORRADO:
	
	public void deleteEstudiante(int idestudiante) {
		org.hibernate.Transaction transaction = null;
		Estudiante es = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			es = session.get(Estudiante.class, idestudiante);
			session.remove(es);
			transaction.commit();
		} catch (Exception e) {
			if (transaction!=null) {
				transaction.rollback();
			}
		}
	}
	
	//SELECCION SIMPLE:
	
	public Estudiante selectEstudianteById(int idestudiante) {
		org.hibernate.Transaction transaction = null;
		Estudiante es = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			es = session.get(Estudiante.class, idestudiante);
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		return es;
	}
	
	//SELECCION MULTIPLE:
	
	public List<Estudiante> selectAllEstudiante() {
		org.hibernate.Transaction transaction = null;
		List<Estudiante> estudiantes = null;
		Estudiante es = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			estudiantes=session.createQuery("from Estudiante", Estudiante.class).getResultList();
			transaction.commit();
		} catch (Exception e) {
			if(transaction!=null) {
				transaction.rollback();
			}
		}
		return estudiantes;
	}
    
}
