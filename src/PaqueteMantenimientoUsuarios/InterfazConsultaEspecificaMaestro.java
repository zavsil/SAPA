/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteMantenimientoUsuarios;

import PaqueteLogin.InterfazLogin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author FRANCISCO ZAVALA SILVA
 */
public class InterfazConsultaEspecificaMaestro extends javax.swing.JFrame {

    String totaldeMaestros;

    /**
     * Creates new form InterfazConsultaEspecificaMaestro
     */
    public InterfazConsultaEspecificaMaestro() throws ClassNotFoundException, SQLException {
        initComponents();
        //establece la posicion central de la interfaz
        this.setLocationRelativeTo(null);

        //coloca el icono en la interfaz
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());

        //cuenta el total de maestros
        contarMaestros();

        //limpia los campos
        limpiarCampos();

        //desactivamos la opcion de maximizar y minimizar asi como la de cerrar
        this.setResizable(false);
        setDefaultCloseOperation(0);

        //asigna el nombre de administrador a la interfaz
        jMenu1.setText("Mi cuenta: ADMINISTRADOR");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp5EliminarMaestro = new javax.swing.JPanel();
        boton2Salir = new javax.swing.JButton();
        lab1TotaldeMaestros = new javax.swing.JLabel();
        boton1Buscar = new javax.swing.JButton();
        jp1IngresoDatosdelMaestro = new javax.swing.JPanel();
        lab2IngresoNumeroEmpleado = new javax.swing.JLabel();
        txt1IngresodeNumeroEmpleado = new javax.swing.JTextField();
        jp2DatosMaestro = new javax.swing.JPanel();
        txt5ApellidoMaterno = new javax.swing.JTextField();
        txt4ApellidoPaterno = new javax.swing.JTextField();
        txt3NombreMaestro = new javax.swing.JTextField();
        txt2NumeroEmpleado = new javax.swing.JTextField();
        lab4NumeroEmpleado = new javax.swing.JLabel();
        lab5NombreMaestro = new javax.swing.JLabel();
        lab6ApellidoPaterno = new javax.swing.JLabel();
        lab3ApellidoMaterno = new javax.swing.JLabel();
        jp3DatosGrupo = new javax.swing.JPanel();
        txt6Grado = new javax.swing.JTextField();
        lab8Grado = new javax.swing.JLabel();
        lab9Grupo = new javax.swing.JLabel();
        txt7Grupo = new javax.swing.JTextField();
        jp4DatosUsuario = new javax.swing.JPanel();
        txt9Contraseña = new javax.swing.JTextField();
        txt8Usuario = new javax.swing.JTextField();
        lab10Usuario = new javax.swing.JLabel();
        lab7Contraseña = new javax.swing.JLabel();
        boton3Cancelar = new javax.swing.JButton();
        menu1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento Usuario/Consulta Especifica/Consulta Especifica Maestro");
        setMinimumSize(new java.awt.Dimension(596, 534));
        setResizable(false);

        jp5EliminarMaestro.setBackground(new java.awt.Color(245, 245, 239));
        jp5EliminarMaestro.setToolTipText("");

        boton2Salir.setBackground(new java.awt.Color(255, 255, 255));
        boton2Salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton2Salir.setText("Salir");
        boton2Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });

        lab1TotaldeMaestros.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab1TotaldeMaestros.setText("Total de maestros registrados: #00");

        boton1Buscar.setBackground(new java.awt.Color(255, 255, 51));
        boton1Buscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton1Buscar.setText("Buscar");
        boton1Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscar(evt);
            }
        });

        jp1IngresoDatosdelMaestro.setBackground(new java.awt.Color(253, 251, 251));
        jp1IngresoDatosdelMaestro.setBorder(javax.swing.BorderFactory.createTitledBorder("Número de empleado"));

        lab2IngresoNumeroEmpleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab2IngresoNumeroEmpleado.setText("Ingrese el número de empleado del maestro:");

        txt1IngresodeNumeroEmpleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jp1IngresoDatosdelMaestroLayout = new javax.swing.GroupLayout(jp1IngresoDatosdelMaestro);
        jp1IngresoDatosdelMaestro.setLayout(jp1IngresoDatosdelMaestroLayout);
        jp1IngresoDatosdelMaestroLayout.setHorizontalGroup(
            jp1IngresoDatosdelMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1IngresoDatosdelMaestroLayout.createSequentialGroup()
                .addComponent(lab2IngresoNumeroEmpleado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt1IngresodeNumeroEmpleado)
                .addGap(4, 4, 4))
        );
        jp1IngresoDatosdelMaestroLayout.setVerticalGroup(
            jp1IngresoDatosdelMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1IngresoDatosdelMaestroLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jp1IngresoDatosdelMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab2IngresoNumeroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1IngresodeNumeroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jp2DatosMaestro.setBackground(new java.awt.Color(253, 251, 251));
        jp2DatosMaestro.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del maestro"));

        txt5ApellidoMaterno.setEditable(false);

        txt4ApellidoPaterno.setEditable(false);

        txt3NombreMaestro.setEditable(false);

        txt2NumeroEmpleado.setEditable(false);

        lab4NumeroEmpleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab4NumeroEmpleado.setText("Número de empleado:");

        lab5NombreMaestro.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab5NombreMaestro.setText("Nombre del maestro:");

        lab6ApellidoPaterno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab6ApellidoPaterno.setText("Apellido paterno:");

        lab3ApellidoMaterno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab3ApellidoMaterno.setText("Apellido materno:");

        javax.swing.GroupLayout jp2DatosMaestroLayout = new javax.swing.GroupLayout(jp2DatosMaestro);
        jp2DatosMaestro.setLayout(jp2DatosMaestroLayout);
        jp2DatosMaestroLayout.setHorizontalGroup(
            jp2DatosMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2DatosMaestroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp2DatosMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jp2DatosMaestroLayout.createSequentialGroup()
                        .addComponent(lab4NumeroEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt2NumeroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp2DatosMaestroLayout.createSequentialGroup()
                        .addGroup(jp2DatosMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lab6ApellidoPaterno)
                            .addComponent(lab5NombreMaestro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jp2DatosMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt3NombreMaestro)
                            .addComponent(txt4ApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jp2DatosMaestroLayout.createSequentialGroup()
                        .addComponent(lab3ApellidoMaterno)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt5ApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jp2DatosMaestroLayout.setVerticalGroup(
            jp2DatosMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2DatosMaestroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp2DatosMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab4NumeroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2NumeroEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp2DatosMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab5NombreMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3NombreMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp2DatosMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab6ApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt4ApellidoPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp2DatosMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab3ApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt5ApellidoMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jp3DatosGrupo.setBackground(new java.awt.Color(253, 251, 251));
        jp3DatosGrupo.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Grupo"));

        txt6Grado.setEditable(false);

        lab8Grado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab8Grado.setText("Grado Asignado:");

        lab9Grupo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab9Grupo.setText("Grupo Asignado:");

        txt7Grupo.setEditable(false);

        javax.swing.GroupLayout jp3DatosGrupoLayout = new javax.swing.GroupLayout(jp3DatosGrupo);
        jp3DatosGrupo.setLayout(jp3DatosGrupoLayout);
        jp3DatosGrupoLayout.setHorizontalGroup(
            jp3DatosGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3DatosGrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp3DatosGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lab8Grado)
                    .addComponent(lab9Grupo))
                .addGap(38, 38, 38)
                .addGroup(jp3DatosGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt7Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp3DatosGrupoLayout.setVerticalGroup(
            jp3DatosGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3DatosGrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp3DatosGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab8Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt6Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp3DatosGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab9Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt7Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jp4DatosUsuario.setBackground(new java.awt.Color(253, 251, 251));
        jp4DatosUsuario.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del usuario"));

        txt9Contraseña.setEditable(false);

        txt8Usuario.setEditable(false);

        lab10Usuario.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab10Usuario.setText("Usuario:");

        lab7Contraseña.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab7Contraseña.setText("Contraseña:");

        javax.swing.GroupLayout jp4DatosUsuarioLayout = new javax.swing.GroupLayout(jp4DatosUsuario);
        jp4DatosUsuario.setLayout(jp4DatosUsuarioLayout);
        jp4DatosUsuarioLayout.setHorizontalGroup(
            jp4DatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp4DatosUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp4DatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp4DatosUsuarioLayout.createSequentialGroup()
                        .addComponent(lab10Usuario)
                        .addGap(93, 93, 93)
                        .addComponent(txt8Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp4DatosUsuarioLayout.createSequentialGroup()
                        .addComponent(lab7Contraseña)
                        .addGap(68, 68, 68)
                        .addComponent(txt9Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp4DatosUsuarioLayout.setVerticalGroup(
            jp4DatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp4DatosUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp4DatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab10Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt8Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp4DatosUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab7Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt9Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        boton3Cancelar.setBackground(new java.awt.Color(255, 255, 255));
        boton3Cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton3Cancelar.setText("Cancelar");
        boton3Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        javax.swing.GroupLayout jp5EliminarMaestroLayout = new javax.swing.GroupLayout(jp5EliminarMaestro);
        jp5EliminarMaestro.setLayout(jp5EliminarMaestroLayout);
        jp5EliminarMaestroLayout.setHorizontalGroup(
            jp5EliminarMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp5EliminarMaestroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp5EliminarMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jp5EliminarMaestroLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lab1TotaldeMaestros))
                    .addGroup(jp5EliminarMaestroLayout.createSequentialGroup()
                        .addGroup(jp5EliminarMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boton2Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boton1Buscar, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                            .addComponent(boton3Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jp5EliminarMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jp4DatosUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp3DatosGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp2DatosMaestro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jp1IngresoDatosdelMaestro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(11, 11, 11)))
                .addGap(58, 58, 58))
        );
        jp5EliminarMaestroLayout.setVerticalGroup(
            jp5EliminarMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp5EliminarMaestroLayout.createSequentialGroup()
                .addComponent(lab1TotaldeMaestros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(jp5EliminarMaestroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp5EliminarMaestroLayout.createSequentialGroup()
                        .addComponent(jp1IngresoDatosdelMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp2DatosMaestro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jp3DatosGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jp4DatosUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp5EliminarMaestroLayout.createSequentialGroup()
                        .addComponent(boton1Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton3Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton2Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menu1.setBackground(new java.awt.Color(255, 255, 255));

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mi cuenta.png"))); // NOI18N
        jMenu1.setText("Mi cuenta");
        jMenu1.setToolTipText("");
        menu1.add(jMenu1);

        setJMenuBar(menu1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp5EliminarMaestro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp5EliminarMaestro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //[5] cierra la interfaz
    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        int salir = JOptionPane.showConfirmDialog(rootPane, "SEGURO DESEA SALIR?");
        if (salir == 0) {
            limpiarCampos();
            this.setVisible(false);

        }
    }//GEN-LAST:event_salir

    //[3] obtiene los datos del maestro segun el numero de empleado
    private void buscar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscar
        //variables para poder saber si todo esta correcto
        boolean numeroEmpleadoCorrecto = false;
        if (txt1IngresodeNumeroEmpleado.getText().length() != 0) {

            //identificar si el numero del maestro es correcto
            try {
                if (Integer.parseInt(txt1IngresodeNumeroEmpleado.getText()) > 0) {
                    numeroEmpleadoCorrecto = true;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(rootPane, "EL NUMERO DE EMPELADO ES INCORRECTO", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

            if (numeroEmpleadoCorrecto == true) {

                ControlMaestro maestroC = new ControlMaestro();
                ControlGrupo grupoC = new ControlGrupo();
                ControlUsuario usuarioC = new ControlUsuario();
                try {

                    //obtener de maestro
                    ResultSet resultadodeConsultar = maestroC.consultar(txt1IngresodeNumeroEmpleado.getText());

                    while (resultadodeConsultar.next()) {

                        txt2NumeroEmpleado.setText(resultadodeConsultar.getObject(1).toString());
                        txt3NombreMaestro.setText(resultadodeConsultar.getObject(2).toString());
                        txt4ApellidoPaterno.setText(resultadodeConsultar.getObject(3).toString());
                        txt5ApellidoMaterno.setText(resultadodeConsultar.getObject(4).toString());

                    }//find el while

                    //cuando no se ha encontrado al maestro
                    if (txt2NumeroEmpleado.getText().length() <= 0
                            && txt3NombreMaestro.getText().length() <= 0
                            && txt4ApellidoPaterno.getText().length() <= 0
                            && txt5ApellidoMaterno.getText().length() <= 0) {
                        JOptionPane.showMessageDialog(rootPane, "NUMERO DE EMPELADO NO SE ENCUENTRA", "ERROR", JOptionPane.ERROR_MESSAGE);

                    }

                    //obtener informacion del Grupo
                    resultadodeConsultar = grupoC.consultarGrupodeMaestro(txt1IngresodeNumeroEmpleado.getText());
                    while (resultadodeConsultar.next()) {
                        txt6Grado.setText(resultadodeConsultar.getObject(1).toString());
                        txt7Grupo.setText(resultadodeConsultar.getObject(2).toString());
                    }//find el while

                    //obtener informacion del usuario
                    resultadodeConsultar = usuarioC.consultar(txt1IngresodeNumeroEmpleado.getText(), "maestro");
                    while (resultadodeConsultar.next()) {
                        txt8Usuario.setText(resultadodeConsultar.getObject(1).toString());
                        txt9Contraseña.setText(resultadodeConsultar.getObject(2).toString());
                    }//find el while

                } catch (SQLException ex) {

                    Logger.getLogger(InterfazConsultaEspecificaMaestro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {

                    Logger.getLogger(InterfazConsultaEspecificaMaestro.class.getName()).log(Level.SEVERE, null, ex);
                }

                //contar el actualizado de maestros
                try {
                    contarMaestros();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InterfazConsultaEspecificaMaestro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazConsultaEspecificaMaestro.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        } else {
            String mensaje = "";

            if (txt1IngresodeNumeroEmpleado.getText().length() <= 0) {
                mensaje = "-Numero de empleado\n";
            }

            JOptionPane.showMessageDialog(rootPane, "INGRESE EL SIGUIENTE CAMPO:\n" + mensaje + "", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_buscar

    //[4] limpia todos los campos de la interfaz
    private void cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar
        limpiarCampos();
    }//GEN-LAST:event_cancelar

    //[2] limpia cada campo de la interfaz
    public void limpiarCampos() {
        txt2NumeroEmpleado.setText("");
        txt3NombreMaestro.setText("");
        txt4ApellidoPaterno.setText("");
        txt5ApellidoMaterno.setText("");
        txt6Grado.setText("");
        txt7Grupo.setText("");
        txt8Usuario.setText("");
        txt9Contraseña.setText("");
        txt1IngresodeNumeroEmpleado.setText("");
    }

    //[1] consulta el total de maestros existentes en la base de datos
    public void contarMaestros() throws ClassNotFoundException, SQLException {
        ControlMaestro maestro = new ControlMaestro();
        totaldeMaestros = maestro.contarTotalMaestros();
        lab1TotaldeMaestros.setText("Total de maestros registrados: #" + (totaldeMaestros));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InterfazConsultaEspecificaMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazConsultaEspecificaMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazConsultaEspecificaMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazConsultaEspecificaMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InterfazConsultaEspecificaMaestro().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(InterfazConsultaEspecificaMaestro.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(InterfazConsultaEspecificaMaestro.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton1Buscar;
    private javax.swing.JButton boton2Salir;
    private javax.swing.JButton boton3Cancelar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jp1IngresoDatosdelMaestro;
    private javax.swing.JPanel jp2DatosMaestro;
    private javax.swing.JPanel jp3DatosGrupo;
    private javax.swing.JPanel jp4DatosUsuario;
    private javax.swing.JPanel jp5EliminarMaestro;
    private javax.swing.JLabel lab10Usuario;
    private javax.swing.JLabel lab1TotaldeMaestros;
    private javax.swing.JLabel lab2IngresoNumeroEmpleado;
    private javax.swing.JLabel lab3ApellidoMaterno;
    private javax.swing.JLabel lab4NumeroEmpleado;
    private javax.swing.JLabel lab5NombreMaestro;
    private javax.swing.JLabel lab6ApellidoPaterno;
    private javax.swing.JLabel lab7Contraseña;
    private javax.swing.JLabel lab8Grado;
    private javax.swing.JLabel lab9Grupo;
    private javax.swing.JMenuBar menu1;
    private javax.swing.JTextField txt1IngresodeNumeroEmpleado;
    private javax.swing.JTextField txt2NumeroEmpleado;
    private javax.swing.JTextField txt3NombreMaestro;
    private javax.swing.JTextField txt4ApellidoPaterno;
    private javax.swing.JTextField txt5ApellidoMaterno;
    private javax.swing.JTextField txt6Grado;
    private javax.swing.JTextField txt7Grupo;
    private javax.swing.JTextField txt8Usuario;
    private javax.swing.JTextField txt9Contraseña;
    // End of variables declaration//GEN-END:variables
}
