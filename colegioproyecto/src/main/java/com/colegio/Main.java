package com.colegio;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
        System.out.println("7. Insertar matricula");
        System.out.println("8. Borrar matricula");
        System.out.println("9. Mostrar todos los estudiantes");
        System.out.println("10. Mostrar todos los cursos");
        System.out.println("11. Mostrar todas las matriculas");
        System.out.println("0. Salir");
    }
    public static void main(String[] args) {
        
        
        int opcion = 12;
        do {

            Session session = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = session.beginTransaction();

            EstudianteDAO estudianteDAO = new EstudianteDAO();
            CursoDAO cursoDAO = new CursoDAO();

            try {
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

                    case 7:

                    //INSERTAR UNA MATRICULA:

                    System.out.println("Pon el id del alumno");
                    idE = s.nextInt();

                    System.out.println("Pon el id del curso");
                    idC = s.nextInt();

                    estudiante = estudianteDAO.selectEstudianteById(session, idE);
                    curso = cursoDAO.selectCursoById(session, idC);

                    estudiante.añadirCurso(curso);

                    estudianteDAO.insertarEstudiante(session, estudiante);

                    break;

                    case 8:

                    //BORRAR UNA MATRICULA:

                    System.out.println("Pon el id del alumno");
                    idE = s.nextInt();

                    System.out.println("Pon el id del curso");
                    idC = s.nextInt();

                    estudiante = estudianteDAO.selectEstudianteById(session, idE);
                    curso = cursoDAO.selectCursoById(session, idC);

                    estudiante.quitarCurso(curso);
                    curso.quitarEstudiante(estudiante);


                    break;

                    case 9:

                    //MOSTRAR TODOS LOS ESTUDIANTES:

                    estudiantes = estudianteDAO.selectAllEstudiantes(session);

                    for (Estudiante e : estudiantes) {
                        System.out.println(e.getIdestudiante() + " " + e.getNombre() + " " + e.getEdad()); 
                    }

                    break;

                    case 10:

                    //MOSTRAR TODOS LOS CURSOS:

                    cursos = cursoDAO.selectAllCursos(session);

                    for (Curso c : cursos) {
                        System.out.println(c.getIdcurso() + " " + c.getNombre() + " " + c.getDuracion()); 
                    }

                    break;

                    case 11:

                    //MOSTRAR TODAS LAS MATRICULAS:

                    estudiantes = estudianteDAO.selectAllEstudiantes(session);

                    for (Estudiante e : estudiantes) {
                        Set<Curso> cursosEstudiante = e.getCursos();
                        for (Curso c : cursosEstudiante) {
                            System.out.println("Estudiante ID: " + e.getIdestudiante() + " - Curso ID: " + c.getIdcurso());
                        }
                    }


                    
	            	
	            	case 0:
		                    System.out.println("Fin del programa");
		            break;
		            
		            default:
		                    System.out.println("Opción no válida");
	            		
	            }
				transaction.commit();
                session.clear();
			}catch (Exception e) {
                if (transaction != null) {
                    transaction.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
            

        } while (opcion != 0);

    }
}