package com.colegio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.CursoDAO;
import com.dao.EstudianteDAO;
import com.model.Curso;
import com.model.Estudiante;
import com.util.HibernateUtil;

public class Main {

    static void mostrarMenu() {
        System.out.println("Seleccione opción:");
        System.out.println("1. Insertar estudiante");
        System.out.println("2. Actualizar estudiante");
        System.out.println("3. Borrar estudiante");
        System.out.println("4. Insertar curso");
        System.out.println("5. Actualizar curso");
        System.out.println("6. Borrar curso");
        System.out.println("0. Salir");
    }
    public static void main(String[] args) {
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {

            int opcion;

            EstudianteDAO estudianteDAO = new EstudianteDAO();
            CursoDAO cursoDAO = new CursoDAO();

            do {
                Scanner s = new Scanner(System.in);
				mostrarMenu();
	            opcion = s.nextInt();
	            s.nextLine();
	            
	            switch(opcion) {
	            
	            	case 1:
                    
                    System.out.println("Pon un nombre");
                    String nombreE = s.next();

                    System.out.println("Pon una edad");
                    int edadE = s.nextInt();

                    Estudiante estu = new Estudiante(nombreE, edadE);

                    estudianteDAO.insertarEstudiante(session, estu);

                    List<Estudiante> estudiantes = estudianteDAO.selectAllEstudiantes(session);

                    for (Estudiante e : estudiantes) {
                        System.out.println(e.getIdestudiante() + " " + e.getNombre() + " " + e.getEdad()); 
                    }
	            		
	            	break;
	            	
	            	case 2:
	            		
	            		//ACTUALIZAR UN ESTUDIANTE:

                        System.out.println("Pon un id");
                        int idE = s.nextInt();

                        Estudiante estudiante = estudianteDAO.selectEstudianteById(session, idE);

                        System.out.println("Pon un nombre");
                        nombreE = s.next();
    
                        System.out.println("Pon una edad");
                        edadE = s.nextInt();

                        estudiante.setNombre(nombreE);
                        estudiante.setEdad(edadE);

                        estudianteDAO.actualizarEstudiante(session, estudiante);

                        estudiantes = estudianteDAO.selectAllEstudiantes(session);

                        for (Estudiante e : estudiantes) {
                            System.out.println(e.getIdestudiante() + " " + e.getNombre() + " " + e.getEdad()); 
                        }

	            		
	            	break;
	            	
	            	case 3:
	            		
	            		//BORRAR UN ESTUDIANTE:

                        System.out.println("Pon un id");
                        idE = s.nextInt();

                        estudianteDAO.deleteEstudiante(session, idE);

                        estudiantes = estudianteDAO.selectAllEstudiantes(session);

                        for (Estudiante e : estudiantes) {
                            System.out.println(e.getIdestudiante() + " " + e.getNombre() + " " + e.getEdad()); 
                        }
	            		
	            	break;
	            	
	            	case 4:

                    //INSERTAR UN CURSO:
	            		
                    System.out.println("Pon un nombre");
                    String nombreC = s.next();

                    System.out.println("Pon una duracion");
                    int duracionC = s.nextInt();

                    Curso cur = new Curso(nombreC, duracionC);

                    cursoDAO.insertarCurso(session, cur);

                    List<Curso> cursos = cursoDAO.selectAllCursos(session);

                    for (Curso c : cursos) {
                        System.out.println(c.getIdcurso() + " " + c.getNombre() + " " + c.getDuracion()); 
                    }
	            		
	            	break;
	            	
	            	case 5:
	            		
                    //ACTUALIZAR UN CURSO:

                    System.out.println("Pon un id");
                    int idC = s.nextInt();

                    Curso curso = cursoDAO.selectCursoById(session, idC);

                    System.out.println("Pon un nombre");
                    nombreC = s.next();

                    System.out.println("Pon una duracion");
                    duracionC = s.nextInt();

                    curso.setNombre(nombreC);
                    curso.setDuracion(duracionC);

                    cursoDAO.actualizarCurso(session, curso);

                    cursos = cursoDAO.selectAllCursos(session);

                    for (Curso c : cursos) {
                        System.out.println(c.getIdcurso() + " " + c.getNombre() + " " + c.getDuracion()); 
                    }

	            		
	            	break;

                    case 6:
	            		
                    //BORRAR UN CURSO:

                    System.out.println("Pon un id");
                    idC = s.nextInt();

                    cursoDAO.deleteCurso(session, idC);

                    cursos = cursoDAO.selectAllCursos(session);

                    for (Curso c : cursos) {
                        System.out.println(c.getIdcurso() + " " + c.getNombre() + " " + c.getDuracion()); 
                    }

	            		
	            	break;
	            	
	            	case 0:
		                    System.out.println("Fin del programa");
		            break;
		            
		            default:
		                    System.out.println("Opción no válida");
	            		
	            }
				
			}while (opcion != 0);


        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }
}