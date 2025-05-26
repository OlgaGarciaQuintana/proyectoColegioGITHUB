package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.model.Curso;
import com.util.HibernateUtil;

import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;

public class CursoDAO {

    //INSERTAR:
    
        public void insertCurso(Curso c) {
            org.hibernate.Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.persist(c);
                transaction.commit();
            } catch (Exception e) {
                if (transaction!=null) {
                    transaction.rollback();
                }
            }
        }

        //UPDATE:
        
        public void updateCurso(Curso c) {
            org.hibernate.Transaction transaction = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                session.merge(c);
                transaction.commit();
            } catch (Exception e) {
                if (transaction!=null) {
                    transaction.rollback();
                }
            }
        }
        
        //BORRADO:
        
        public void deleteCurso(int idcurso) {
            org.hibernate.Transaction transaction = null;
            Curso c = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                c = session.get(Curso.class, idcurso);
                session.remove(c);
                transaction.commit();
            } catch (Exception e) {
                if (transaction!=null) {
                    transaction.rollback();
                }
            }
        }
        
        //SELECCION SIMPLE:
        
        public Curso selectCursoById(int idcurso) {
            org.hibernate.Transaction transaction = null;
            Curso c = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                c = session.get(Curso.class, idcurso);
                transaction.commit();
            } catch (Exception e) {
                if(transaction!=null) {
                    transaction.rollback();
                }
            }
            return c;
        }
        
        //SELECCION MULTIPLE:
        
        public List<Curso> selectAllCurso() {
            org.hibernate.Transaction transaction = null;
            List<Curso> cursos = null;
            Curso c = null;
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                transaction = session.beginTransaction();
                cursos=session.createQuery("from Curso", Curso.class).getResultList();
                transaction.commit();
            } catch (Exception e) {
                if(transaction!=null) {
                    transaction.rollback();
                }
            }
            return cursos;
        }
    
}
