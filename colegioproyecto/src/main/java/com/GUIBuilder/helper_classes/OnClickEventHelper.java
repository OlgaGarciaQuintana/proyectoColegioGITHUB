package com.GUIBuilder.helper_classes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.CursoDAO;
import com.dao.EstudianteDAO;
import com.model.Curso;
import com.model.Estudiante;
import com.util.HibernateUtil;
import com.GUIBuilder.WindowBuilder;
import com.GUIBuilder.resources.*;

public class OnClickEventHelper {

    public static void setOnClickColor(JButton button, Color pressedColor, Color originalColor, 
                                        DefaultTableModel modelE, JTextField idEstudiante, JTextField nombreEstudiante, JTextField edadEstudiante,
                                        DefaultTableModel modelC, JTextField idCurso, JTextField nombreCurso, JTextField duracionCurso,  
                                        DefaultTableModel modelM, JTextField idEstudianteM, JTextField idCursoM, Session session) {
    button.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                button.setContentAreaFilled(false);
                button.setBackground(pressedColor);
                button.setOpaque(true);
                button.repaint();
                
                Estudiante estudiante = new Estudiante();
                Curso curso = new Curso();

                EstudianteDAO estudianteDAO = new EstudianteDAO();
                CursoDAO cursoDAO = new CursoDAO();

                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();

                try {
                    Scanner s = new Scanner(System.in);
                    String action = button.getActionCommand();
                   
                    if (button.getText().equals("Insertar E")) {

                        String nombre = nombreEstudiante.getText();
                        String edadTexto = edadEstudiante.getText();
                        int edad = Integer.parseInt(edadTexto);

                        estudiante = new Estudiante(nombre, edad);
                        estudianteDAO.insertarEstudiante(session, estudiante);

                        nombreEstudiante.setText("");
                        edadEstudiante.setText("");

                        modelE.setRowCount(0);

                        List<Estudiante> estudiantes = estudianteDAO.selectAllEstudiantes(session);

                       for(Estudiante es:estudiantes){
                            Object[]filaE={es.getIdestudiante(), es.getNombre(), es.getEdad()};
                             modelE.addRow(filaE);
                        }


                    } else if (button.getText().equals("Actualizar E")) {

                        String idTexto = idEstudiante.getText();
                        int idE = Integer.parseInt(idTexto);
                        String nombre = nombreEstudiante.getText();
                        String edadTexto = edadEstudiante.getText();
                        int edad = Integer.parseInt(edadTexto);

                        estudiante = estudianteDAO.selectEstudianteById(session, idE);

                        estudiante.setNombre(nombre);
                        estudiante.setEdad(edad);

                        estudianteDAO.actualizarEstudiante(session, estudiante);

                        idEstudiante.setText("");
                        nombreEstudiante.setText("");
                        edadEstudiante.setText("");

                        modelE.setRowCount(0);

                        List<Estudiante> estudiantes = estudianteDAO.selectAllEstudiantes(session);

                       for(Estudiante es:estudiantes){
                            Object[]filaE={es.getIdestudiante(), es.getNombre(), es.getEdad()};
                             modelE.addRow(filaE);
                        }


                    } else if (button.getText().equals("Borrar E")) {

                         String idTexto = idEstudiante.getText();
                         int idE = Integer.parseInt(idTexto);

                         estudianteDAO.deleteEstudiante(session, idE);

                         idEstudiante.setText("");
                         nombreEstudiante.setText("");
                         edadEstudiante.setText("");

                         modelE.setRowCount(0);

                         List<Estudiante> estudiantes = estudianteDAO.selectAllEstudiantes(session);

                         for(Estudiante es:estudiantes){
                            Object[]filaE={es.getIdestudiante(), es.getNombre(), es.getEdad()};
                            modelE.addRow(filaE);
                         }

                    }  else if (button.getText().equals("Insertar C")) {

                         String nombre = nombreCurso.getText();
                         String duracionTexto = duracionCurso.getText();
                         int duracion = Integer.parseInt(duracionTexto);

                         curso = new Curso(nombre, duracion);
                         cursoDAO.insertarCurso(session, curso);

                         nombreCurso.setText("");
                         duracionCurso.setText("");

                         modelC.setRowCount(0);

                         List<Curso> cursos = cursoDAO.selectAllCursos(session);

                         for (Curso cu:cursos){
                            Object[]filaC={cu.getIdcurso(), cu.getNombre(), cu.getDuracion()};
                            modelC.addRow(filaC);
                         }

                    } else if (button.getText().equals("Actualizar C")) {

                        String idTexto = idCurso.getText();
                        int idC = Integer.parseInt(idTexto);
                        String nombre = nombreCurso.getText();
                        String duracionTexto = duracionCurso.getText();
                        int duracion = Integer.parseInt(duracionTexto);

                        curso = cursoDAO.selectCursoById(session, idC);

                        curso.setNombre(nombre);
                        curso.setDuracion(duracion);

                        cursoDAO.actualizarCurso(session, curso);

                        idCurso.setText("");
                        nombreCurso.setText("");
                        duracionCurso.setText("");

                        modelC.setRowCount(0);

                        List<Curso> cursos = cursoDAO.selectAllCursos(session);

                        for (Curso cu:cursos){
                            Object[]filaC={cu.getIdcurso(), cu.getNombre(), cu.getDuracion()};
                            modelC.addRow(filaC);
                        }



                    } else if (button.getText().equals("Borrar C")) {

                        String idTexto = idCurso.getText();
                        int idC = Integer.parseInt(idTexto);

                        cursoDAO.deleteCurso(session, idC);

                        idCurso.setText("");
                        nombreCurso.setText("");
                        duracionCurso.setText("");

                        modelC.setRowCount(0);

                        List<Curso> cursos = cursoDAO.selectAllCursos(session);

                        for (Curso cu:cursos){
                            Object[]filaC={cu.getIdcurso(), cu.getNombre(), cu.getDuracion()};
                            modelC.addRow(filaC);
                        }

                    } else if (button.getText().equals("Insertar M")) {

                        String idEMTexto = idEstudianteM.getText();
                        int idEM = Integer.parseInt(idEMTexto);

                        String idCMTexto = idCursoM.getText();
                        int idCM = Integer.parseInt(idCMTexto);

                        Estudiante estudianteElegido = estudianteDAO.selectEstudianteById(session, idEM);
                        Curso cursoElegido = cursoDAO.selectCursoById(session, idCM);

                        estudianteElegido.añadirCurso(cursoElegido);

                        transaction.commit();

                        idEstudianteM.setText("");
                        idCursoM.setText("");

                        modelM.setRowCount(0);

                        List<Estudiante> estudiantes = estudianteDAO.selectAllEstudiantes(session);

                        for(Estudiante es: estudiantes){
                            for(Curso cu: es.getCursos()){
                                 Object[]filaM={es.getIdestudiante(), cu.getIdcurso()};
                                 modelM.addRow(filaM);
                            }
                        }



                    } else if (button.getText().equals("Borrar M")) {

                        String idEMTexto = idEstudianteM.getText();
                        int idEM = Integer.parseInt(idEMTexto);

                        String idCMTexto = idCursoM.getText();
                        int idCM = Integer.parseInt(idCMTexto);

                        Estudiante estudianteElegido = estudianteDAO.selectEstudianteById(session, idEM);
                        Curso cursoElegido = cursoDAO.selectCursoById(session, idCM);

                        estudianteElegido.quitarCurso(cursoElegido);

                        transaction.commit();

                        modelM.setRowCount(0);

                        List<Estudiante> estudiantes = estudianteDAO.selectAllEstudiantes(session);

                        for(Estudiante es: estudiantes){
                            for(Curso cu: es.getCursos()){
                                 Object[]filaM={es.getIdestudiante(), cu.getIdcurso()};
                                 modelM.addRow(filaM);
                            }
                        }


                    }
                   
                }catch (Exception ex) {
                     if (transaction != null && transaction.getStatus().canRollback()) {
                         transaction.rollback();
                    }
                    ex.printStackTrace();
                } finally {
                    session.close();
                }


            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(originalColor);
                button.repaint();
            }
        });
    }

    

}