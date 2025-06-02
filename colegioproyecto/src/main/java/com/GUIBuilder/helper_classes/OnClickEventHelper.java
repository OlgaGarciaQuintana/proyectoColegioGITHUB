package com.GUIBuilder.helper_classes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JOptionPane;
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

    //FUNCION RECARGAR TABLA ESTUDIANTE:

    public static void recargarTablaEstudiantes(DefaultTableModel modelE, Session session, EstudianteDAO estudianteDAO) {
        modelE.setRowCount(0);
        List<Estudiante> estudiantes = estudianteDAO.selectAllEstudiantes(session);
        for (Estudiante es : estudiantes) {
            Object[] filaE = {es.getIdestudiante(), es.getNombre(), es.getEdad()};
            modelE.addRow(filaE);
        }
    }

    //FUNCION RECARGAR TABLA CURSO:

    public static void recargarTablaCursos(DefaultTableModel modelC, Session session, CursoDAO cursoDAO) {
        modelC.setRowCount(0);
        List<Curso> cursos = cursoDAO.selectAllCursos(session);
        for (Curso cu : cursos) {
            Object[] filaC = {cu.getIdcurso(), cu.getNombre(), cu.getDuracion()};
            modelC.addRow(filaC);
        }
    }

    //FUNCION RECARGAR TABLA MATRICULA:

    public static void recargarTablaMatriculas(DefaultTableModel modelM, Session session, EstudianteDAO estudianteDAO) {
        modelM.setRowCount(0);
        List<Estudiante> estudiantes = estudianteDAO.selectAllEstudiantes(session);
        for (Estudiante es : estudiantes) {
            for (Curso cu : es.getCursos()) {
                Object[] filaM = {es.getIdestudiante(), cu.getIdcurso()};
                modelM.addRow(filaM);
            }
        }
    }

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

                //Conectar con el model:
                Estudiante estudiante = new Estudiante();
                Curso curso = new Curso();

                //Conectar con el dao:
                EstudianteDAO estudianteDAO = new EstudianteDAO();
                CursoDAO cursoDAO = new CursoDAO();

                //Conectar con la base de datos:
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction transaction = session.beginTransaction();

                try {

                    //INSERTAR ESTUDIANTE:
                    if (button.getText().equals("Insertar E")) {

                        String nombre = nombreEstudiante.getText();
                        String edadTexto = edadEstudiante.getText();

                        String comprobarNombre = "^[a-zA-Z]+$";
                        String comprobarEdad = "^\\d+$";

                        if (nombre.length()==0) {
                            JOptionPane.showMessageDialog(nombreEstudiante, "El nombre esta vacio");
                        } else if (edadTexto.length()==0) {
                            JOptionPane.showMessageDialog(edadEstudiante, "La edad esta vacia");
                        } else if (!nombre.matches(comprobarNombre)) {
                            JOptionPane.showMessageDialog(nombreEstudiante, "El nombre tiene que tener letras");
                        } else if (!edadTexto.matches(comprobarEdad)) {
                            JOptionPane.showMessageDialog(edadEstudiante, "La edad tiene que tener numeros");
                        } else {

                        int edad = Integer.parseInt(edadTexto);

                        estudiante = new Estudiante(nombre, edad);
                        estudianteDAO.insertarEstudiante(session, estudiante);

                        nombreEstudiante.setText("");
                        edadEstudiante.setText("");

                        recargarTablaEstudiantes(modelE, session, estudianteDAO);
                        }

                    //ACTUALIZAR ESTUDIANTE:
                    } else if (button.getText().equals("Actualizar E")) {

                        String idTexto = idEstudiante.getText();
                        String nombre = nombreEstudiante.getText();
                        String edadTexto = edadEstudiante.getText();

                        String comprobarNombre = "^[a-zA-Z]+$";
                        String comprobarEdad = "^\\d+$";

                        if (idTexto.length()==0) {
                            JOptionPane.showMessageDialog(idEstudiante, "El id esta vacio");
                        } else if (nombre.length()==0) {
                            JOptionPane.showMessageDialog(nombreEstudiante, "El nombre esta vacio");
                        } else if (edadTexto.length()==0) {
                            JOptionPane.showMessageDialog(edadEstudiante, "La edad esta vacia");
                        } else if (!nombre.matches(comprobarNombre)) {
                            JOptionPane.showMessageDialog(nombreEstudiante, "El nombre tiene que tener letras");
                        } else if (!edadTexto.matches(comprobarEdad)) {
                            JOptionPane.showMessageDialog(edadEstudiante, "La edad tiene que tener numeros");
                        } else {

                        int idE = Integer.parseInt(idTexto);
                        int edad = Integer.parseInt(edadTexto);

                        estudiante = estudianteDAO.selectEstudianteById(session, idE);

                        estudiante.setNombre(nombre);
                        estudiante.setEdad(edad);

                        estudianteDAO.actualizarEstudiante(session, estudiante);

                        idEstudiante.setText("");
                        nombreEstudiante.setText("");
                        edadEstudiante.setText("");

                        recargarTablaEstudiantes(modelE, session, estudianteDAO);
                        }

                    //BORRAR ESTUDIANTE:
                    } else if (button.getText().equals("Borrar E")) {

                         String idTexto = idEstudiante.getText();

                        if (idTexto.length()==0) {
                            JOptionPane.showMessageDialog(idEstudiante, "El id esta vacio");
                        } else {

                         int idE = Integer.parseInt(idTexto);

                         estudianteDAO.deleteEstudiante(session, idE);

                         idEstudiante.setText("");
                         nombreEstudiante.setText("");
                         edadEstudiante.setText("");

                         recargarTablaEstudiantes(modelE, session, estudianteDAO);

                         recargarTablaMatriculas(modelM, session, estudianteDAO);
                        }

                    //INSERTAR CURSO:
                    }  else if (button.getText().equals("Insertar C")) {

                         String nombre = nombreCurso.getText();
                         String duracionTexto = duracionCurso.getText();

                         String comprobarNombre = "^[a-zA-Z]+$";
                         String comprobarDuracion = "^\\d+$";

                        if (nombre.length()==0) {
                            JOptionPane.showMessageDialog(nombreCurso, "El nombre esta vacio");
                        } else if (duracionTexto.length()==0) {
                            JOptionPane.showMessageDialog(duracionCurso, "La duracion esta vacia");
                        } else if (!nombre.matches(comprobarNombre)) {
                            JOptionPane.showMessageDialog(nombreCurso, "El nombre tiene que tener letras");
                        } else if (!duracionTexto.matches(comprobarDuracion)) {
                            JOptionPane.showMessageDialog(duracionCurso, "La duracion tiene que tener numeros");
                        } else {

                         int duracion = Integer.parseInt(duracionTexto);

                         curso = new Curso(nombre, duracion);
                         cursoDAO.insertarCurso(session, curso);

                         nombreCurso.setText("");
                         duracionCurso.setText("");

                         recargarTablaCursos(modelC, session, cursoDAO);
                        }

                    //ACTUALIZAR CURSO:
                    } else if (button.getText().equals("Actualizar C")) {

                        String idTexto = idCurso.getText();
                        String nombre = nombreCurso.getText();
                        String duracionTexto = duracionCurso.getText();

                        String comprobarNombre = "^[a-zA-Z]+$";
                        String comprobarDuracion = "^\\d+$";

                        if (idTexto.length()==0) {
                            JOptionPane.showMessageDialog(idCurso, "El id esta vacio");
                        } else if (nombre.length()==0) {
                            JOptionPane.showMessageDialog(nombreCurso, "El nombre esta vacio");
                        } else if (duracionTexto.length()==0) {
                            JOptionPane.showMessageDialog(duracionCurso, "La duracion esta vacia");
                        } else if (!nombre.matches(comprobarNombre)) {
                            JOptionPane.showMessageDialog(nombreCurso, "El nombre tiene que tener letras");
                        } else if (!duracionTexto.matches(comprobarDuracion)) {
                            JOptionPane.showMessageDialog(duracionCurso, "La duracion tiene que tener numeros");
                        } else {

                        int idC = Integer.parseInt(idTexto);
                        int duracion = Integer.parseInt(duracionTexto);

                        curso = cursoDAO.selectCursoById(session, idC);

                        curso.setNombre(nombre);
                        curso.setDuracion(duracion);

                        cursoDAO.actualizarCurso(session, curso);

                        idCurso.setText("");
                        nombreCurso.setText("");
                        duracionCurso.setText("");

                        recargarTablaCursos(modelC, session, cursoDAO);
                        }

                    //BORRAR CURSO:
                    } else if (button.getText().equals("Borrar C")) {

                        String idTexto = idCurso.getText();

                        if (idTexto.length()==0) {
                            JOptionPane.showMessageDialog(idCurso, "El id esta vacio");
                        } else {

                        int idC = Integer.parseInt(idTexto);

                        cursoDAO.deleteCurso(session, idC);

                        idCurso.setText("");
                        nombreCurso.setText("");
                        duracionCurso.setText("");

                        recargarTablaCursos(modelC, session, cursoDAO);

                        session.clear();

                        recargarTablaMatriculas(modelM, session, estudianteDAO);
                        }

                    //INSERTAR MATRICULA:
                    } else if (button.getText().equals("Insertar M")) {

                        String idEMTexto = idEstudianteM.getText();
                        String idCMTexto = idCursoM.getText();

                        if (idEMTexto.length()==0) {
                            JOptionPane.showMessageDialog(idEstudianteM, "El id del estudiante esta vacio");
                        } else if (idCMTexto.length()==0) {
                            JOptionPane.showMessageDialog(idCursoM, "El id del curso esta vacio");
                        } else {

                        int idEM = Integer.parseInt(idEMTexto);
                        int idCM = Integer.parseInt(idCMTexto);

                        Estudiante estudianteElegido = estudianteDAO.selectEstudianteById(session, idEM);
                        Curso cursoElegido = cursoDAO.selectCursoById(session, idCM);

                        estudianteElegido.añadirCurso(cursoElegido);

                        transaction.commit();

                        idEstudianteM.setText("");
                        idCursoM.setText("");

                        recargarTablaMatriculas(modelM, session, estudianteDAO);
                        }

                    //BORRAR MATRICULA:
                    } else if (button.getText().equals("Borrar M")) {

                        String idEMTexto = idEstudianteM.getText();
                        String idCMTexto = idCursoM.getText();

                        if (idEMTexto.length()==0) {
                            JOptionPane.showMessageDialog(idEstudianteM, "El id del estudiante esta vacio");
                        } else if (idCMTexto.length()==0) {
                            JOptionPane.showMessageDialog(idCursoM, "El id del curso esta vacio");
                        } else {

                        int idEM = Integer.parseInt(idEMTexto);
                        int idCM = Integer.parseInt(idCMTexto);

                        Estudiante estudianteElegido = estudianteDAO.selectEstudianteById(session, idEM);
                        Curso cursoElegido = cursoDAO.selectCursoById(session, idCM);

                        estudianteElegido.quitarCurso(cursoElegido);

                        transaction.commit();

                        recargarTablaMatriculas(modelM, session, estudianteDAO);
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