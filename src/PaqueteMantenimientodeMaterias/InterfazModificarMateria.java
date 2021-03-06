/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteMantenimientodeMaterias;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franciscoantonio
 */
public class InterfazModificarMateria extends javax.swing.JFrame {

    /**
     * Creates new form InterfazModificarMateria
     */
    public InterfazModificarMateria() {
        initComponents();

        //establece la posicion central de l ainterfaz
        this.setLocationRelativeTo(null);

        //coloca el icono 3en la interfaz
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
        //desactiva la opcion maximizar
        this.setResizable(false);
        //desactiva la opcion cerrar
        setDefaultCloseOperation(0);

        //establece el nombre de administrados en la interfaz
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

        jp3ConsultadeMaterias = new javax.swing.JPanel();
        boton1Consultar = new javax.swing.JButton();
        boton3Cancelar = new javax.swing.JButton();
        boton2Salir = new javax.swing.JButton();
        jp1Materia = new javax.swing.JPanel();
        lab1Materia = new javax.swing.JLabel();
        cbox1Materia = new javax.swing.JComboBox();
        jp2TemasMateria = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table1Temas = new javax.swing.JTable();
        boton5Agregar = new javax.swing.JButton();
        boton6Remover = new javax.swing.JButton();
        boton4Modificar = new javax.swing.JButton();
        menu1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento materia/Modificar materia");

        jp3ConsultadeMaterias.setBackground(new java.awt.Color(245, 245, 239));

        boton1Consultar.setBackground(new java.awt.Color(255, 255, 51));
        boton1Consultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton1Consultar.setText("Consultar");
        boton1Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultar(evt);
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

        boton2Salir.setBackground(new java.awt.Color(255, 255, 255));
        boton2Salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton2Salir.setText("Salir");
        boton2Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });

        jp1Materia.setBackground(new java.awt.Color(253, 251, 251));
        jp1Materia.setBorder(javax.swing.BorderFactory.createTitledBorder("Materia a registrar"));

        lab1Materia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab1Materia.setText("Materia:");

        cbox1Materia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbox1Materia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una opción" }));
        cbox1Materia.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buscarMateria(evt);
            }
        });

        javax.swing.GroupLayout jp1MateriaLayout = new javax.swing.GroupLayout(jp1Materia);
        jp1Materia.setLayout(jp1MateriaLayout);
        jp1MateriaLayout.setHorizontalGroup(
            jp1MateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1MateriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lab1Materia)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbox1Materia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp1MateriaLayout.setVerticalGroup(
            jp1MateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1MateriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp1MateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab1Materia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox1Materia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jp2TemasMateria.setBackground(new java.awt.Color(253, 251, 251));
        jp2TemasMateria.setBorder(javax.swing.BorderFactory.createTitledBorder("Temas de la materia"));

        Table1Temas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre del tema", "Grado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        Table1Temas.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(Table1Temas);

        boton5Agregar.setBackground(new java.awt.Color(255, 255, 255));
        boton5Agregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton5Agregar.setText("+");
        boton5Agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarRenglon(evt);
            }
        });

        boton6Remover.setBackground(new java.awt.Color(255, 255, 255));
        boton6Remover.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton6Remover.setText("-");
        boton6Remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerRenglon(evt);
            }
        });

        javax.swing.GroupLayout jp2TemasMateriaLayout = new javax.swing.GroupLayout(jp2TemasMateria);
        jp2TemasMateria.setLayout(jp2TemasMateriaLayout);
        jp2TemasMateriaLayout.setHorizontalGroup(
            jp2TemasMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2TemasMateriaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp2TemasMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp2TemasMateriaLayout.createSequentialGroup()
                        .addComponent(boton6Remover)
                        .addGap(6, 6, 6))
                    .addComponent(boton5Agregar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jp2TemasMateriaLayout.setVerticalGroup(
            jp2TemasMateriaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2TemasMateriaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jp2TemasMateriaLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(boton5Agregar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(boton6Remover)
                .addGap(22, 22, 22))
        );

        boton4Modificar.setBackground(new java.awt.Color(255, 255, 255));
        boton4Modificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        boton4Modificar.setText("Modificar");
        boton4Modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificar(evt);
            }
        });

        javax.swing.GroupLayout jp3ConsultadeMateriasLayout = new javax.swing.GroupLayout(jp3ConsultadeMaterias);
        jp3ConsultadeMaterias.setLayout(jp3ConsultadeMateriasLayout);
        jp3ConsultadeMateriasLayout.setHorizontalGroup(
            jp3ConsultadeMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3ConsultadeMateriasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp3ConsultadeMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(boton3Cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton2Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(boton1Consultar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                    .addComponent(boton4Modificar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp3ConsultadeMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp2TemasMateria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jp1Materia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jp3ConsultadeMateriasLayout.setVerticalGroup(
            jp3ConsultadeMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp3ConsultadeMateriasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp3ConsultadeMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jp1Materia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp3ConsultadeMateriasLayout.createSequentialGroup()
                        .addComponent(boton1Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(boton4Modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jp3ConsultadeMateriasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp2TemasMateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jp3ConsultadeMateriasLayout.createSequentialGroup()
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
            .addComponent(jp3ConsultadeMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp3ConsultadeMaterias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultar
        // TODO add your handling code here:
        ControlMateria cMateria = new ControlMateria();
        try {
            ResultSet obtenerTemas = cMateria.consultarTemas(cbox1Materia.getSelectedItem().toString());
            DefaultTableModel modelo = (DefaultTableModel) Table1Temas.getModel();
            while (obtenerTemas.next()) {
                modelo.addRow(new Object[]{
                    obtenerTemas.getObject(1),
                    obtenerTemas.getObject(2)
                });
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_consultar

    private void cancelar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelar
        limpiarCampos();
    }//GEN-LAST:event_cancelar

    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        int salir = JOptionPane.showConfirmDialog(rootPane, "SEGURO DESEA SALIR?");
        if (salir == 0) {
            limpiarCampos();
            this.setVisible(false);

        }
    }//GEN-LAST:event_salir

    public void limpiarCampos() {
        cbox1Materia.removeAllItems();
        cbox1Materia.addItem("Seleccione una opción");
        DefaultTableModel modelo = (DefaultTableModel) Table1Temas.getModel();
        int total = Table1Temas.getRowCount();
        for (int i = 0; i < total; i++) {
            modelo.removeRow(0);

        }

    }

    private void buscarMateria(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buscarMateria

        // TODO add your handling code here:
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
    }//GEN-LAST:event_buscarMateria

    private void agregarRenglon(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarRenglon
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) Table1Temas.getModel();

        modelo.addRow(new Object[]{
            "",
            ""
        });
    }//GEN-LAST:event_agregarRenglon

    private void removerRenglon(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerRenglon

        DefaultTableModel modelo = (DefaultTableModel) Table1Temas.getModel();
        try {
            modelo.removeRow(modelo.getRowCount() - 1);
        } catch (ArrayIndexOutOfBoundsException e) {
        }
    }//GEN-LAST:event_removerRenglon

    private void modificar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificar
        // TODO add your handling code here:
        if (cbox1Materia.getSelectedIndex() != 0) {

            int modificar = JOptionPane.showConfirmDialog(rootPane, "SEGURO DESEA MODIFICAR LA MATERIA?");
            if (modificar == 0) {

                ControlMateria cMateria = new ControlMateria();
                try {
                    cMateria.modificarMateria(cbox1Materia.getSelectedItem().toString(), Table1Temas);

                    JOptionPane.showMessageDialog(rootPane, "Materia modificada exitosamente", "Felicidades", JOptionPane.INFORMATION_MESSAGE);

                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println(ex);
                }

            }
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debes elegir una materia a modificar", "Alerta", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_modificar

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
            java.util.logging.Logger.getLogger(InterfazModificarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazModificarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazModificarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazModificarMateria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazModificarMateria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table1Temas;
    private javax.swing.JButton boton1Consultar;
    private javax.swing.JButton boton2Salir;
    private javax.swing.JButton boton3Cancelar;
    private javax.swing.JButton boton4Modificar;
    private javax.swing.JButton boton5Agregar;
    private javax.swing.JButton boton6Remover;
    private javax.swing.JComboBox cbox1Materia;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jp1Materia;
    private javax.swing.JPanel jp2TemasMateria;
    private javax.swing.JPanel jp3ConsultadeMaterias;
    private javax.swing.JLabel lab1Materia;
    private javax.swing.JMenuBar menu1;
    // End of variables declaration//GEN-END:variables
}
