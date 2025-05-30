package com.GUIBuilder.helper_classes;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Scanner;

import javax.swing.JButton;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dao.CursoDAO;
import com.dao.EstudianteDAO;
import com.model.Curso;
import com.model.Estudiante;
import com.util.HibernateUtil;

public class OnClickEventHelper {

    public static void setOnClickColor(JButton button, Color pressedColor, Color originalColor) {
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
                   
                    if (button.getText().equals("insertarEstudiante")) {

                    } else if (button.getText().equals("actualizarEstudiante")) {

                    } else if (button.getText().equals("borrarEstudiante")) {

                    }  else if (button.getText().equals("insertarCurso")) {

                    } else if (button.getText().equals("actualizarCurso")) {

                    } else if (button.getText().equals("borrarCurso")) {

                    } else if (button.getText().equals("insertarMatricula")) {

                    } else if (button.getText().equals("borrarMatricula")) {

                    }
                   
                }catch (Exception ex) {
                    if (transaction != null) {
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