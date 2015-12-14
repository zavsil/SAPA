/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteMantenimientodeReactivos;

import PaqueteMantenimientoUsuarios.ControlGrupo;
import PaqueteMantenimientodeMaterias.ControlMateria;
import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
import java.awt.Color;
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
public class InterfazAltaDeReactivos extends javax.swing.JFrame {

    public int idUsuario;
    public String nombre;
    boolean materiaSeleccionada = false;
    boolean gradoSeleccionado = false;

    /**
     * Creates new form InterfazAltaDeReactivos
     */
    public InterfazAltaDeReactivos() {
        initComponents();

        //verifica la ortografia ingresada en los soguientes campos
        SpellChecker.setUserDictionaryProvider(new FileUserDictionary());
        SpellChecker.registerDictionaries(null, null);
        SpellChecker.register(txta1Reactivo);
        SpellChecker.register(txt1RespuestaCorrecta);
        SpellChecker.register(txt2RespuestaIncorrecta1);
        SpellChecker.register(txt3RespuestaIncorrecta2);

        //establece la posicion central de l ainterfaz
        this.setLocationRelativeTo(null);

        //coloca el icono 3en la interfaz
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
        //desactiva la opcion maximizar
        this.setResizable(false);
        //desactiva la opcion cerrar
        setDefaultCloseOperation(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jp3AltaReactivos = new javax.swing.JPanel();
        jp1DatosReactivo = new javax.swing.JPanel();
        lab1Materia = new javax.swing.JLabel();
        lab2Grado = new javax.swing.JLabel();
        lab3Tema = new javax.swing.JLabel();
        cbox1Materia = new javax.swing.JComboBox();
        cbox2Grado = new javax.swing.JComboBox();
        cbox3Tema = new javax.swing.JComboBox();
        lab4TotalReactivos = new javax.swing.JLabel();
        jp2DescripcionReactivo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta1Reactivo = new javax.swing.JTextArea();
        lab7RespuestaCorrecta = new javax.swing.JLabel();
        lab8RespuestaIncorrecta1 = new javax.swing.JLabel();
        lab9RespuestaIncorrecta2 = new javax.swing.JLabel();
        txt1RespuestaCorrecta = new javax.swing.JTextField();
        txt2RespuestaIncorrecta1 = new javax.swing.JTextField();
        txt3RespuestaIncorrecta2 = new javax.swing.JTextField();
        lab5MaximoCaracteres = new javax.swing.JLabel();
        lab6CaracteresTotales = new javax.swing.JLabel();
        boton1Registrar = new javax.swing.JButton();
        boton2Salir = new javax.swing.JButton();
        boton3Cancelar = new javax.swing.JButton();
        menu1 = new javax.swing.JMenuBar();
        jmenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MantenimientoDeReactivos/AltaDeReactivos");
        setMinimumSize(new java.awt.Dimension(761, 575));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                personalizarInterfaz(evt);
            }
        });

        jp3AltaReactivos.setBackground(new java.awt.Color(245, 245, 239));

        jp1DatosReactivo.setBackground(new java.awt.Color(253, 251, 251));
        jp1DatosReactivo.setBorder(javax.swing.BorderFactory.createTitledBorder("Información del reactivo"));

        lab1Materia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab1Materia.setText("Materia:");

        lab2Grado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab2Grado.setText("Grado:");

        lab3Tema.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab3Tema.setText("Tema:");

        cbox1Materia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbox1Materia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una opción" }));
        cbox1Materia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscarMaterias(evt);
            }
        });
        cbox1Materia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                materiaSeleccionada(evt);
            }
        });

        cbox2Grado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbox2Grado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una opción" }));
        cbox2Grado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                obtenerGrados(evt);
            }
        });
        cbox2Grado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gradoSeleccionado(evt);
            }
        });

        cbox3Tema.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbox3Tema.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una opción" }));
        cbox3Tema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contarReactivos(evt);
            }
        });

        lab4TotalReactivos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab4TotalReactivos.setText("Total de reactivos: #0");

        javax.swing.GroupLayout jp1DatosReactivoLayout = new javax.swing.GroupLayout(jp1DatosReactivo);
        jp1DatosReactivo.setLayout(jp1DatosReactivoLayout);
        jp1DatosReactivoLayout.setHorizontalGroup(
            jp1DatosReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1DatosReactivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp1DatosReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp1DatosReactivoLayout.createSequentialGroup()
                        .addGroup(jp1DatosReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lab1Materia)
                            .addComponent(lab2Grado)
                            .addComponent(lab3Tema))
                        .addGap(18, 18, 18)
                        .addGroup(jp1DatosReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp1DatosReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbox1Materia, 0, 174, Short.MAX_VALUE)
                                .addComponent(cbox2Grado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(cbox3Tema, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(lab4TotalReactivos))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jp1DatosReactivoLayout.setVerticalGroup(
            jp1DatosReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1DatosReactivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp1DatosReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab1Materia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox1Materia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp1DatosReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab2Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox2Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp1DatosReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab3Tema, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox3Tema, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lab4TotalReactivos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jp2DescripcionReactivo.setBackground(new java.awt.Color(253, 251, 251));
        jp2DescripcionReactivo.setBorder(javax.swing.BorderFactory.createTitledBorder("Descripción del reactivo"));

        txta1Reactivo.setColumns(20);
        txta1Reactivo.setRows(5);
        txta1Reactivo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contarCaracteres(evt);
            }
        });
        jScrollPane1.setViewportView(txta1Reactivo);

        lab7RespuestaCorrecta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab7RespuestaCorrecta.setText("Respuesta Correcta:");

        lab8RespuestaIncorrecta1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab8RespuestaIncorrecta1.setText("Respuesta Incorrecta 1:");

        lab9RespuestaIncorrecta2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab9RespuestaIncorrecta2.setText("Respuesta Incorrecta 2:");

        txt1RespuestaCorrecta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txt2RespuestaIncorrecta1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        txt3RespuestaIncorrecta2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lab5MaximoCaracteres.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab5MaximoCaracteres.setText("maximo 150 caracteres");

        lab6CaracteresTotales.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab6CaracteresTotales.setText("Caracteres: 0");

        javax.swing.GroupLayout jp2DescripcionReactivoLayout = new javax.swing.GroupLayout(jp2DescripcionReactivo);
        jp2DescripcionReactivo.setLayout(jp2DescripcionReactivoLayout);
        jp2DescripcionReactivoLayout.setHorizontalGroup(
            jp2DescripcionReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2DescripcionReactivoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp2DescripcionReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jp2DescripcionReactivoLayout.createSequentialGroup()
                        .addGroup(jp2DescripcionReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jp2DescripcionReactivoLayout.createSequentialGroup()
                                .addGroup(jp2DescripcionReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lab8RespuestaIncorrecta1)
                                    .addComponent(lab9RespuestaIncorrecta2)
                                    .addComponent(lab7RespuestaCorrecta))
                                .addGap(34, 34, 34)
                                .addGroup(jp2DescripcionReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt1RespuestaCorrecta)
                                    .addComponent(txt2RespuestaIncorrecta1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                                    .addComponent(txt3RespuestaIncorrecta2)))
                            .addComponent(lab5MaximoCaracteres)
                            .addComponent(lab6CaracteresTotales))
                        .addGap(0, 128, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jp2DescripcionReactivoLayout.setVerticalGroup(
            jp2DescripcionReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2DescripcionReactivoLayout.createSequentialGroup()
                .addComponent(lab5MaximoCaracteres, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lab6CaracteresTotales, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jp2DescripcionReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab7RespuestaCorrecta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt1RespuestaCorrecta, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp2DescripcionReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab8RespuestaIncorrecta1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt2RespuestaIncorrecta1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp2DescripcionReactivoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab9RespuestaIncorrecta2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt3RespuestaIncorrecta2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
        );

        boton1Registrar.setBackground(new java.awt.Color(51, 204, 0));
        boton1Registrar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton1Registrar.setText("Registrar");
        boton1Registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrar(evt);
            }
        });

        boton2Salir.setBackground(new java.awt.Color(255, 255, 255));
        boton2Salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton2Salir.setText("Salir");
        boton2Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });

        boton3Cancelar.setBackground(new java.awt.Color(255, 255, 255));
        boton3Cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton3Cancelar.setText("Cancelar");
        boton3Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelar(evt);
            }
        });

        javax.swing.GroupLayout jp3AltaReactivosLayout = new javax.swing.GroupLayout(jp3AltaReactivos);
        jp3AltaReactivos.setLayout(jp3AltaReactivosLayout);
        jp3AltaReactivosLayout.setHorizontalGroup(
            jp3AltaReactivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp3AltaReactivosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp3AltaReactivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton1Registrar, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                    .addComponent(boton2Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton3Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp3AltaReactivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp2DescripcionReactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jp1DatosReactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76))
        );
        jp3AltaReactivosLayout.setVerticalGroup(
            jp3AltaReactivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3AltaReactivosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp3AltaReactivosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp1DatosReactivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp3AltaReactivosLayout.createSequentialGroup()
                        .addComponent(boton1Registrar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton3Cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton2Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp2DescripcionReactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        menu1.setBackground(new java.awt.Color(255, 255, 255));

        jmenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/mi cuenta.png"))); // NOI18N
        jmenu1.setToolTipText("");
        menu1.add(jmenu1);

        setJMenuBar(menu1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jp3AltaReactivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp3AltaReactivos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //[12] cierra la interfaz
    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        // TODO add your handling code here:
        int salir = JOptionPane.showConfirmDialog(rootPane, "SEGURO DESEA SALIR?");
        if (salir == 0) {
            limpiarCampos();
            this.setVisible(false);

        }
    }//GEN-LAST:event_salir

    //[3]indica si se ha seleccionado el grado
    private void gradoSeleccionado(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gradoSeleccionado
        // TODO add your handling code here:

        if (cbox2Grado.getSelectedIndex() != 0) {
            gradoSeleccionado = true;
            obtenerTemas();
            contarReactivos(evt);
        } else {
            gradoSeleccionado = false;
            obtenerTemas();
        }
    }//GEN-LAST:event_gradoSeleccionado

    //[2]indica si se ha seleccionado la materia
    private void materiaSeleccionada(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_materiaSeleccionada

        // TODO add your handling code here:
        if (cbox1Materia.getSelectedIndex() != 0) {
            materiaSeleccionada = true;
            obtenerTemas();
            contarReactivos(evt);

        } else {
            materiaSeleccionada = false;
            obtenerTemas();
        }

    }//GEN-LAST:event_materiaSeleccionada

    //[7]registra la informacion  a la base de datos
    private void registrar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrar
        // TODO add your handling code here:
        if (materiaSeleccionada && gradoSeleccionado && (txta1Reactivo.getText().length() >= 5)
                && (txt1RespuestaCorrecta.getText().length() > 0)
                && (txt2RespuestaIncorrecta1.getText().length() > 0)
                && (txt3RespuestaIncorrecta2.getText().length() > 0)
                && hayEspaciosEnBlanco(txta1Reactivo.getText()) == false
                && hayEspaciosEnBlanco(txt1RespuestaCorrecta.getText()) == false
                && hayEspaciosEnBlanco(txt2RespuestaIncorrecta1.getText()) == false
                && hayEspaciosEnBlanco(txt3RespuestaIncorrecta2.getText()) == false
                && (cbox3Tema.getSelectedItem().toString().length() > 0 && cbox3Tema.getSelectedIndex() > 0)) {
            if ((txta1Reactivo.getText().length() <= 150)) {

                ControlReactivo reactivoC = new ControlReactivo();

                try {
                    int resultadoConfirmacion = JOptionPane.showConfirmDialog(rootPane, "TODO ESTA CORRECTO?", "ALERTA", JOptionPane.OK_CANCEL_OPTION);
                    System.out.println("r:" + resultadoConfirmacion);
                    if (resultadoConfirmacion == 0) {

                        boolean existe = reactivoC.existeReactivo(txta1Reactivo.getText(), txt1RespuestaCorrecta.getText(), txt2RespuestaIncorrecta1.getText(), txt3RespuestaIncorrecta2.getText());

                        if (existe == false) {

                            reactivoC.registrar(idUsuario, txta1Reactivo.getText(), txt1RespuestaCorrecta.getText(), txt2RespuestaIncorrecta1.getText(), txt3RespuestaIncorrecta2.getText(), (String) cbox3Tema.getItemAt(cbox3Tema.getSelectedIndex()), cbox2Grado.getSelectedIndex(), cbox1Materia.getSelectedIndex());
                            JOptionPane.showMessageDialog(rootPane, "REACTIVO REGISTRADO EXITOSAMENTE ", "FELICIDADES", JOptionPane.WARNING_MESSAGE);

                            txta1Reactivo.setText("");
                            txt1RespuestaCorrecta.setText("");
                            txt2RespuestaIncorrecta1.setText("");
                            txt3RespuestaIncorrecta2.setText("");
                            lab6CaracteresTotales.setText("Caracteres: 0");

                            contarReactivos(evt);

                        } else {
                            JOptionPane.showMessageDialog(rootPane, "EL REACTIVO YA EXISTE", "ERROR", JOptionPane.ERROR_MESSAGE);
                        }

                    }

                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(InterfazAltaDeReactivos.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {
                JOptionPane.showMessageDialog(rootPane, "EL REACTIVO TIENE MAS DE 150 CARACTERES", "ERROR", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            String mensaje = "";
            mensaje = datosPorIngresar();
            JOptionPane.showMessageDialog(rootPane, "NO DEJES CAMPOS VACIOS\n INGRESE LOS SIGUIENTES CAMPOS:\n" + mensaje + "", "ERROR", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_registrar

    //[8]limpia los campos de la interfaz
    public void limpiarCampos() {

        cbox1Materia.removeAllItems();
        cbox1Materia.addItem("Seleccione una opción");

        cbox2Grado.removeAllItems();
        cbox2Grado.addItem("Seleccione una opción");

        cbox3Tema.removeAllItems();
        cbox3Tema.addItem("Seleccione una opción");

        txta1Reactivo.setText("");
        txt1RespuestaCorrecta.setText("");
        txt2RespuestaIncorrecta1.setText("");
        txt3RespuestaIncorrecta2.setText("");
        lab6CaracteresTotales.setText("Caracteres: 0");

    }

    //[10] identifica si hay espacios en blanco en el texto ingresado
    public boolean hayEspaciosEnBlanco(String texto) {
        boolean resultado = false;

        for (int i = 0; i < texto.length(); i++) {

            if ((int) texto.charAt(i) == 32) {
                resultado = true;
            } else {
                return false;
            }

        }

        return resultado;
    }

    //[6]cuenta si los caracteres son mayor o igual a 150
    private void contarCaracteres(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contarCaracteres
        // TODO add your handling code here:
        int totaldeCaracteres = txta1Reactivo.getText().length();
        lab6CaracteresTotales.setText("Caracteres: " + totaldeCaracteres);
        if (totaldeCaracteres > 150) {
            lab6CaracteresTotales.setForeground(Color.red);

        } else {
            lab6CaracteresTotales.setForeground(Color.black);
        }
    }//GEN-LAST:event_contarCaracteres

    //[1]estabelce en nombre y el id del usuario
    private void personalizarInterfaz(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_personalizarInterfaz
        // TODO add your handling code here:
        jmenu1.setText("Mi cuenta: " + nombre + " : " + idUsuario);
    }//GEN-LAST:event_personalizarInterfaz

    //[11]limpia los componentes de la interfaz
    private void cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar
        limpiarCampos();
    }//GEN-LAST:event_cancelar

    //[5]consulta y muestra el total de reactivos
    private void contarReactivos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contarReactivos
        ControlReactivo reactivo = new ControlReactivo();

        String contarTotalReactivos;
        try {
            contarTotalReactivos = reactivo.contarTotalReactivos(cbox1Materia.getSelectedIndex(), cbox3Tema.getSelectedItem().toString(), Integer.parseInt(cbox2Grado.getSelectedItem().toString()));
            lab4TotalReactivos.setText("Total de reactivos: #" + contarTotalReactivos);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(InterfazAltaDeReactivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException | NullPointerException e) {
        }
    }//GEN-LAST:event_contarReactivos

    private void obtenerGrados(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_obtenerGrados
        ControlGrupo Cgrupo = new ControlGrupo();
        try {
            ResultSet obtenerGrados = Cgrupo.obtenerGrupos();

            String grado = "";

            while (obtenerGrados.next()) {
                grado = obtenerGrados.getObject(1).toString();
                int totalGrado = cbox2Grado.getItemCount();
                int maximo = 0;

                for (int i = 0; i < totalGrado; i++) {
                    if (grado.compareTo(cbox2Grado.getItemAt(i).toString()) == 0) {
                        maximo++;

                    }
                }
                if (maximo == 0) {
                    this.cbox2Grado.addItem(grado);
                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al intentar obtener datos a la bd");
        }


    }//GEN-LAST:event_obtenerGrados

    private void buscarMaterias(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarMaterias

        limpiarCampos();
        ControlMateria cMateria = new ControlMateria();
        try {
            ResultSet obtenerMaterias = cMateria.obtenerMaterias();

            while (obtenerMaterias.next()) {
                cbox1Materia.addItem(obtenerMaterias.getObject(1));
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }


    }//GEN-LAST:event_buscarMaterias

    //[9] indica los datos que faltan por ingresar
    public String datosPorIngresar() {
        String mensaje = "";
        if (materiaSeleccionada && !gradoSeleccionado) {

            mensaje = mensaje + "-Grado\n";
            mensaje = mensaje + "-Tema\n";
            //borramos los temas
            cbox3Tema.removeAllItems();
            cbox3Tema.addItem("Seleccione una opción");

        } else if (!materiaSeleccionada && gradoSeleccionado) {

            mensaje = mensaje + "-Materia\n";
            mensaje = mensaje + "-Tema\n";
            cbox3Tema.removeAllItems();
            cbox3Tema.addItem("Seleccione una opción");

        } else if (!materiaSeleccionada && !gradoSeleccionado) {

            mensaje = mensaje + "-Materia\n";
            mensaje = mensaje + "-Grado\n";
            mensaje = mensaje + "-Tema\n";
            cbox3Tema.removeAllItems();
            cbox3Tema.addItem("Seleccione una opción");

        }
        if (txta1Reactivo.getText().length() <= 0 || hayEspaciosEnBlanco(txta1Reactivo.getText()) || txta1Reactivo.getText().length() <= 5) {
            mensaje = mensaje + "-Descripción del reactivo muy corta\n";
        }
        if (txt1RespuestaCorrecta.getText().length() <= 0 || hayEspaciosEnBlanco(txt1RespuestaCorrecta.getText())) {
            mensaje = mensaje + "-RespuestaCorrecta\n";
        }
        if (txt2RespuestaIncorrecta1.getText().length() <= 0 || hayEspaciosEnBlanco(txt2RespuestaIncorrecta1.getText())) {
            mensaje = mensaje + "-RespuestaIncorrecta1\n";
        }
        if (txt3RespuestaIncorrecta2.getText().length() <= 0 || hayEspaciosEnBlanco(txt3RespuestaIncorrecta2.getText())) {
            mensaje = mensaje + "-RespuestaIncorrecta2\n";
        }
        return mensaje;
    }

    //[4] obtiene y muestra los temas relacionados con la materia y grado
    public void obtenerTemas() {
        java.awt.event.ActionEvent evt = null;
        contarReactivos(evt);
        cbox3Tema.removeAllItems();
        cbox3Tema.addItem("Seleccione una opción");

        ControlTema temaC = new ControlTema();
        if (materiaSeleccionada && gradoSeleccionado) {
            try {
                ResultSet resultado = temaC.consultarTemas((cbox1Materia.getSelectedIndex()), (cbox2Grado.getSelectedIndex() + 2));

                while (resultado.next()) {

                    cbox3Tema.addItem(resultado.getObject(1).toString());

                }
                contarReactivos(evt);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(InterfazAltaDeReactivos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            cbox3Tema.removeAllItems();
            cbox3Tema.addItem("Seleccione una opción");
        }

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
            java.util.logging.Logger.getLogger(InterfazAltaDeReactivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazAltaDeReactivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazAltaDeReactivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazAltaDeReactivos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazAltaDeReactivos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton1Registrar;
    private javax.swing.JButton boton2Salir;
    private javax.swing.JButton boton3Cancelar;
    private javax.swing.JComboBox cbox1Materia;
    private javax.swing.JComboBox cbox2Grado;
    private javax.swing.JComboBox cbox3Tema;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu jmenu1;
    private javax.swing.JPanel jp1DatosReactivo;
    private javax.swing.JPanel jp2DescripcionReactivo;
    private javax.swing.JPanel jp3AltaReactivos;
    private javax.swing.JLabel lab1Materia;
    private javax.swing.JLabel lab2Grado;
    private javax.swing.JLabel lab3Tema;
    private javax.swing.JLabel lab4TotalReactivos;
    private javax.swing.JLabel lab5MaximoCaracteres;
    private javax.swing.JLabel lab6CaracteresTotales;
    private javax.swing.JLabel lab7RespuestaCorrecta;
    private javax.swing.JLabel lab8RespuestaIncorrecta1;
    private javax.swing.JLabel lab9RespuestaIncorrecta2;
    private javax.swing.JMenuBar menu1;
    private javax.swing.JTextField txt1RespuestaCorrecta;
    private javax.swing.JTextField txt2RespuestaIncorrecta1;
    private javax.swing.JTextField txt3RespuestaIncorrecta2;
    private javax.swing.JTextArea txta1Reactivo;
    // End of variables declaration//GEN-END:variables
}
