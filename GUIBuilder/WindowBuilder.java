import javax.swing.*;
import java.awt.Color;
import helper_classes.*;

public class WindowBuilder {
  public static void main(String[] args) {

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

     JLabel el4 = new JLabel("Id Curso:");
     el4.setBounds(302, 239, 106, 18);
     el4.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el4.setForeground(Color.decode("#000"));
     panel.add(el4);

     JTextField idEstudiante = new JTextField("");
     idEstudiante.setBounds(416, 209, 134, 24);
     idEstudiante.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     idEstudiante.setBackground(Color.decode("#ffe7bf"));
     idEstudiante.setForeground(Color.decode("#73664e"));
     idEstudiante.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(idEstudiante, "idEstudiante", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(idEstudiante);

     JTextField idCurso = new JTextField("");
     idCurso.setBounds(418, 239, 134, 24);
     idCurso.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     idCurso.setBackground(Color.decode("#ffe7bf"));
     idCurso.setForeground(Color.decode("#73664e"));
     idCurso.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(idCurso, "idCurso", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(idCurso);

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

     JLabel el5 = new JLabel("Id:");
     el5.setBounds(618, 208, 106, 18);
     el5.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el5.setForeground(Color.decode("#000"));
     panel.add(el5);

     JLabel el6 = new JLabel("Nombre:");
     el6.setBounds(618, 235, 106, 18);
     el6.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el6.setForeground(Color.decode("#000"));
     panel.add(el6);

     JLabel el7 = new JLabel("Duracion:");
     el7.setBounds(616, 266, 106, 18);
     el7.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     el7.setForeground(Color.decode("#000"));
     panel.add(el7);

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

     JTextArea mostrarEstudiantes = new JTextArea("");
     mostrarEstudiantes.setBounds(35, 27, 232, 164);
     mostrarEstudiantes.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     mostrarEstudiantes.setBackground(Color.decode("#ffe7bf"));
     mostrarEstudiantes.setForeground(Color.decode("#73664e"));
     mostrarEstudiantes.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(mostrarEstudiantes, "", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(mostrarEstudiantes);

     JTextArea mostrarMatriculas = new JTextArea("");
     mostrarMatriculas.setBounds(314, 27, 232, 164);
     mostrarMatriculas.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     mostrarMatriculas.setBackground(Color.decode("#ffe7bf"));
     mostrarMatriculas.setForeground(Color.decode("#73664e"));
     mostrarMatriculas.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(mostrarMatriculas, "", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(mostrarMatriculas);

     JTextArea mostrarCursos = new JTextArea("");
     mostrarCursos.setBounds(602, 26, 232, 164);
     mostrarCursos.setFont(CustomFontLoader.loadFont("./resources/fonts/Lexend.ttf", 14));
     mostrarCursos.setBackground(Color.decode("#ffe7bf"));
     mostrarCursos.setForeground(Color.decode("#73664e"));
     mostrarCursos.setBorder(new RoundedBorder(2, Color.decode("#000"), 1));
     OnFocusEventHelper.setOnFocusText(mostrarCursos, "", Color.decode("#000"),   Color.decode("#73664e"));
     panel.add(mostrarCursos);

     frame.add(panel);
     frame.setVisible(true);

  }
}