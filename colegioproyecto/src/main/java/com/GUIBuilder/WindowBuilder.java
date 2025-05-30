package com.GUIBuilder;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.Color;
import java.awt.event.*;
import org.hibernate.Session;

import com.GUIBuilder.helper_classes.*;
import com.dao.CursoDAO;
import com.dao.EstudianteDAO;
import com.model.Estudiante;
import com.model.Curso;
import com.util.HibernateUtil;

public class WindowBuilder {
  public static void main(String[] args) {

    Session session = HibernateUtil.getSessionFactory().openSession();

     EstudianteDAO estudianteDAO = new EstudianteDAO();
     CursoDAO cursoDAO = new CursoDAO();

     JFrame frame = new JFrame("My Awesome Window");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(888, 479);
     JPanel panel = new JPanel();
     panel.setLayout(null);
     panel.setBackground(Color.decode("#f4c064"));

     JLabel el1 = new JLabel("Id:");
     el1.setBounds(46, 212, 106, 18);
     el1.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el1.setForeground(Color.decode("#000"));
     panel.add(el1);

     JLabel el2 = new JLabel("Nombre:");
     el2.setBounds(46, 240, 106, 18);
     el2.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el2.setForeground(Color.decode("#000"));
     panel.add(el2);

     JLabel el3 = new JLabel("Edad:");
     el3.setBounds(45, 267, 106, 18);
     el3.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el3.setForeground(Color.decode("#000"));
     panel.add(el3);

     JTextField idEstudiante = new JTextField("");
     idEstudiante.setBounds(126, 209, 134, 24);
     idEstudiante.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     idEstudiante.setBackground(Color.decode("#ffe7bf"));
     idEstudiante.setForeground(Color.decode("#73664e"));
     idEstudiante.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(idEstudiante, "idEstudiante", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(idEstudiante);

     JTextField nombreEstudiante = new JTextField("");
     nombreEstudiante.setBounds(126, 239, 134, 24);
     nombreEstudiante.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     nombreEstudiante.setBackground(Color.decode("#ffe7bf"));
     nombreEstudiante.setForeground(Color.decode("#73664e"));
     nombreEstudiante.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(nombreEstudiante, "nombreEstudiante", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(nombreEstudiante);

     JTextField edadEstudiante = new JTextField("");
     edadEstudiante.setBounds(125, 269, 134, 24);
     edadEstudiante.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     edadEstudiante.setBackground(Color.decode("#ffe7bf"));
     edadEstudiante.setForeground(Color.decode("#73664e"));
     edadEstudiante.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(edadEstudiante, "edadEstudiante", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(edadEstudiante);

     JButton insertarEstudiante = new JButton("Insertar");
     insertarEstudiante.setBounds(102, 305, 106, 30);
     insertarEstudiante.setBackground(Color.decode("#bca8e4"));
     insertarEstudiante.setForeground(Color.decode("#000"));
     insertarEstudiante.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     insertarEstudiante.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     insertarEstudiante.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(insertarEstudiante, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(insertarEstudiante);

     JButton actualizarEstudiante = new JButton("Actualizar");
     actualizarEstudiante.setBounds(101, 340, 106, 30);
     actualizarEstudiante.setBackground(Color.decode("#bca8e4"));
     actualizarEstudiante.setForeground(Color.decode("#000"));
     actualizarEstudiante.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     actualizarEstudiante.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     actualizarEstudiante.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(actualizarEstudiante, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(actualizarEstudiante);

     JButton borrarEstudiante = new JButton("Borrar");
     borrarEstudiante.setBounds(101, 375, 106, 30);
     borrarEstudiante.setBackground(Color.decode("#bca8e4"));
     borrarEstudiante.setForeground(Color.decode("#000"));
     borrarEstudiante.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     borrarEstudiante.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     borrarEstudiante.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(borrarEstudiante, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(borrarEstudiante);

     JLabel el4 = new JLabel("Id Estudiante:");
     el4.setBounds(302, 211, 106, 18);
     el4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el4.setForeground(Color.decode("#000"));
     panel.add(el4);

     JLabel el5 = new JLabel("Id Curso:");
     el5.setBounds(302, 239, 106, 18);
     el5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el5.setForeground(Color.decode("#000"));
     panel.add(el5);

     JTextField idEstudianteM = new JTextField("");
     idEstudianteM.setBounds(416, 209, 134, 24);
     idEstudianteM.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     idEstudianteM.setBackground(Color.decode("#ffe7bf"));
     idEstudianteM.setForeground(Color.decode("#73664e"));
     idEstudianteM.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(idEstudianteM, "idEstudiante", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(idEstudianteM);

     JTextField idCursoM = new JTextField("");
     idCursoM.setBounds(418, 239, 134, 24);
     idCursoM.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     idCursoM.setBackground(Color.decode("#ffe7bf"));
     idCursoM.setForeground(Color.decode("#73664e"));
     idCursoM.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(idCursoM, "idCurso", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(idCursoM);

     JButton insertarMatricula = new JButton("Insertar");
     insertarMatricula.setBounds(376, 311, 106, 30);
     insertarMatricula.setBackground(Color.decode("#bca8e4"));
     insertarMatricula.setForeground(Color.decode("#000"));
     insertarMatricula.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     insertarMatricula.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     insertarMatricula.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(insertarMatricula, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(insertarMatricula);

     JButton borrarMatricula = new JButton("Borrar");
     borrarMatricula.setBounds(374, 352, 106, 30);
     borrarMatricula.setBackground(Color.decode("#bca8e4"));
     borrarMatricula.setForeground(Color.decode("#000"));
     borrarMatricula.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     borrarMatricula.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     borrarMatricula.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(borrarMatricula, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(borrarMatricula);

     JLabel el6 = new JLabel("Id:");
     el6.setBounds(618, 208, 106, 18);
     el6.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el6.setForeground(Color.decode("#000"));
     panel.add(el6);

     JLabel el7 = new JLabel("Nombre:");
     el7.setBounds(618, 235, 106, 18);
     el7.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el7.setForeground(Color.decode("#000"));
     panel.add(el7);

     JLabel el8 = new JLabel("Duracion:");
     el8.setBounds(616, 266, 106, 18);
     el8.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el8.setForeground(Color.decode("#000"));
     panel.add(el8);

     JTextField idCurso = new JTextField("");
     idCurso.setBounds(687, 206, 134, 24);
     idCurso.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     idCurso.setBackground(Color.decode("#ffe7bf"));
     idCurso.setForeground(Color.decode("#73664e"));
     idCurso.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(idCurso, "idCurso", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(idCurso);

     JTextField nombreCurso = new JTextField("");
     nombreCurso.setBounds(686, 234, 134, 24);
     nombreCurso.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     nombreCurso.setBackground(Color.decode("#ffe7bf"));
     nombreCurso.setForeground(Color.decode("#73664e"));
     nombreCurso.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(nombreCurso, "nombreCurso", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(nombreCurso);

     JTextField duracionCurso = new JTextField("");
     duracionCurso.setBounds(687, 264, 134, 24);
     duracionCurso.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     duracionCurso.setBackground(Color.decode("#ffe7bf"));
     duracionCurso.setForeground(Color.decode("#73664e"));
     duracionCurso.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(duracionCurso, "duracionCurso", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(duracionCurso);

     JButton insertarCurso = new JButton("Insertar");
     insertarCurso.setBounds(663, 308, 106, 30);
     insertarCurso.setBackground(Color.decode("#bca8e4"));
     insertarCurso.setForeground(Color.decode("#000"));
     insertarCurso.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     insertarCurso.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     insertarCurso.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(insertarCurso, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(insertarCurso);

     JButton actualizarCurso = new JButton("Actualizar");
     actualizarCurso.setBounds(665, 344, 106, 30);
     actualizarCurso.setBackground(Color.decode("#bca8e4"));
     actualizarCurso.setForeground(Color.decode("#000"));
     actualizarCurso.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     actualizarCurso.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     actualizarCurso.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(actualizarCurso, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(actualizarCurso);

     JButton borrarCurso = new JButton("Borrar");
     borrarCurso.setBounds(663, 379, 106, 30);
     borrarCurso.setBackground(Color.decode("#bca8e4"));
     borrarCurso.setForeground(Color.decode("#000"));
     borrarCurso.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     borrarCurso.setBorder(new RoundedBorder(4, Color.decode("#3d364a"), 1));
     borrarCurso.setFocusPainted(false);
     OnClickEventHelper.setOnClickColor(borrarCurso, Color.decode("#7c6f97"), Color.decode("#bca8e4"));
     panel.add(borrarCurso);

    //TABLA ESTUDIANTE:

     // Crear el modelo de la tabla
DefaultTableModel modelE = new DefaultTableModel();
modelE.addColumn("ID");
modelE.addColumn("Nombre");
modelE.addColumn("Edad");

// Crear la tabla con el modelo
JTable tableE = new JTable(modelE);

// Añadir un listener para cuando se haga clic en una fila
tableE.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int indexE = tableE.getSelectedRow();
        TableModel modelE = tableE.getModel();

        // Usamos directamente el modelo ya declarado arriba
        idEstudiante.setText(modelE.getValueAt(indexE, 0).toString());
        nombreEstudiante.setText(modelE.getValueAt(indexE, 1).toString());
        edadEstudiante.setText(modelE.getValueAt(indexE, 2).toString());

        // También rellenamos el campo de matrícula
        idEstudianteM.setText(modelE.getValueAt(indexE, 0).toString());

       

    }
});

// Ajuste automático del tamaño de columnas
tableE.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

// Añadir la tabla a un JScrollPane
JScrollPane scrollPaneE = new JScrollPane(tableE);
scrollPaneE.setBounds(35, 27, 232, 164);

// Añadir el JScrollPane al frame
frame.getContentPane().add(scrollPaneE);

List<Estudiante> estudiantes = estudianteDAO.selectAllEstudiantes(session);

for(Estudiante es:estudiantes){
  Object[]filaE={es.getIdestudiante(), es.getNombre(), es.getEdad()};
  modelE.addRow(filaE);
}

//TABLA CURSO:

// Crear el modelo de la tabla
DefaultTableModel modelC = new DefaultTableModel();
modelC.addColumn("ID");
modelC.addColumn("Nombre");
modelC.addColumn("Duracion");

// Crear la tabla con el modelo
JTable tableC = new JTable(modelC);

// Añadir un listener para cuando se haga clic en una fila
tableC.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int indexC = tableC.getSelectedRow();

        // Usamos directamente el modelo ya declarado arriba
        idCurso.setText(modelC.getValueAt(indexC, 0).toString());
        nombreCurso.setText(modelC.getValueAt(indexC, 1).toString());
        duracionCurso.setText(modelC.getValueAt(indexC, 2).toString());

        // También rellenamos el campo de matrícula
        idCursoM.setText(modelC.getValueAt(indexC, 0).toString());
    }
});

// Ajuste automático del tamaño de columnas
tableC.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

// Añadir la tabla a un JScrollPane
JScrollPane scrollPaneC = new JScrollPane(tableC);
scrollPaneC.setBounds(602, 26, 232, 164);

// Añadir el JScrollPane al frame
frame.getContentPane().add(scrollPaneC);

List<Curso> cursos = cursoDAO.selectAllCursos(session);

for(Curso cu:cursos){
  Object[]filaC={cu.getIdcurso(), cu.getNombre(), cu.getDuracion()};
  modelC.addRow(filaC);
}

      //TABLA MATRICULA:

      // Crear el modelo de la tabla
DefaultTableModel modelM = new DefaultTableModel();
modelM.addColumn("ID Estudiante");
modelM.addColumn("ID Curso");

// Crear la tabla con el modelo
JTable tableM = new JTable(modelM);

// Añadir un listener para cuando se haga clic en una fila
tableM.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        int indexM = tableM.getSelectedRow();

        // Usamos directamente el modelo ya declarado arriba
        idEstudianteM.setText(modelM.getValueAt(indexM, 0).toString());
        idCursoM.setText(modelM.getValueAt(indexM, 1).toString());

    }
});

// Ajuste automático del tamaño de columnas
tableM.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

// Añadir la tabla a un JScrollPane
JScrollPane scrollPaneM = new JScrollPane(tableM);
scrollPaneM.setBounds(314, 27, 232, 164);

// Añadir el JScrollPane al frame
frame.getContentPane().add(scrollPaneM);

estudiantes = estudianteDAO.selectAllEstudiantes(session);
cursos = cursoDAO.selectAllCursos(session);

for(Estudiante es:estudiantes){
  for(Curso cu:cursos){
    Object[]filaM={es.getIdestudiante(), cu.getIdcurso()};
    modelM.addRow(filaM);
  }
}

    idEstudiante.setEditable(false);
    idEstudianteM.setEditable(false);
    idCurso.setEditable(false);
    idCursoM.setEditable(false);

     frame.add(panel);
     frame.setVisible(true);

  }
}