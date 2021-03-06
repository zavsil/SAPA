/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteMantenimientodeGrupos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author franciscoantonio
 */
public class InterfazEliminarGrupo extends javax.swing.JFrame {

    /**
     * Creates new form InterfazBajadeGrupo
     */
    public InterfazEliminarGrupo() {
        initComponents();
        //establece la posicion central de la interfaz
        setLocationRelativeTo(null);

        //coloca el icono en la interfaz
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());

        //deasctiva el maximizar
        setResizable(false);
        //desactiva el cerrar
        setDefaultCloseOperation(0);

        //establece el nombre del administrador en la interfaz
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

        jp1BajadeGrupo = new javax.swing.JPanel();
        jp2Grupo = new javax.swing.JPanel();
        lab1Grado = new javax.swing.JLabel();
        cbox1Grado = new javax.swing.JComboBox();
        cbox2Grupo = new javax.swing.JComboBox();
        lab2Grupo = new javax.swing.JLabel();
        Boton1Eliminar = new javax.swing.JButton();
        Boton2Salir = new javax.swing.JButton();
        menu1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento de Grupos/Eliminar Grupo");

        jp1BajadeGrupo.setBackground(new java.awt.Color(253, 251, 251));

        jp2Grupo.setBackground(new java.awt.Color(253, 251, 251));
        jp2Grupo.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Grupo"));

        lab1Grado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab1Grado.setText("Grado:");

        cbox1Grado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbox1Grado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una opción" }));
        cbox1Grado.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                obtenerGrados(evt);
            }
        });
        cbox1Grado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obtenerGrupo(evt);
            }
        });

        cbox2Grupo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbox2Grupo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione una opción" }));

        lab2Grupo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lab2Grupo.setText("Grupo:");

        javax.swing.GroupLayout jp2GrupoLayout = new javax.swing.GroupLayout(jp2Grupo);
        jp2Grupo.setLayout(jp2GrupoLayout);
        jp2GrupoLayout.setHorizontalGroup(
            jp2GrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2GrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp2GrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp2GrupoLayout.createSequentialGroup()
                        .addComponent(lab1Grado)
                        .addGap(18, 18, 18)
                        .addComponent(cbox1Grado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp2GrupoLayout.createSequentialGroup()
                        .addComponent(lab2Grupo)
                        .addGap(18, 18, 18)
                        .addComponent(cbox2Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jp2GrupoLayout.setVerticalGroup(
            jp2GrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2GrupoLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jp2GrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab1Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox1Grado, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jp2GrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lab2Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbox2Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(178, Short.MAX_VALUE))
        );

        Boton1Eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Boton1Eliminar.setText("Eliminar");
        Boton1Eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarGrupo(evt);
            }
        });

        Boton2Salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Boton2Salir.setText("Salir");
        Boton2Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });

        javax.swing.GroupLayout jp1BajadeGrupoLayout = new javax.swing.GroupLayout(jp1BajadeGrupo);
        jp1BajadeGrupo.setLayout(jp1BajadeGrupoLayout);
        jp1BajadeGrupoLayout.setHorizontalGroup(
            jp1BajadeGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1BajadeGrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp1BajadeGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Boton1Eliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Boton2Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp2Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jp1BajadeGrupoLayout.setVerticalGroup(
            jp1BajadeGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1BajadeGrupoLayout.createSequentialGroup()
                .addGroup(jp1BajadeGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp1BajadeGrupoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jp2Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jp1BajadeGrupoLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(Boton1Eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Boton2Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addComponent(jp1BajadeGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp1BajadeGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * obtener y mostrar los grupos existentes
     */
    private void obtenerGrupo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obtenerGrupo
        cbox2Grupo.removeAllItems();
        cbox2Grupo.addItem("Seleccione una opción");
        ControlGrupo Cgrupo = new ControlGrupo();
        try {
            ResultSet obtenerGrupos = Cgrupo.obtenerGrupos(Integer.parseInt(cbox1Grado.getSelectedItem().toString()));
            System.out.println("seleccione: " + cbox1Grado.getSelectedItem().toString());
            String grupo = "";

            while (obtenerGrupos.next()) {
                grupo = obtenerGrupos.getObject(1).toString();
                this.cbox2Grupo.addItem(grupo);

            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al intentar obtener datos a la bd");
        } catch (NumberFormatException | NullPointerException ex) {
        }


    }//GEN-LAST:event_obtenerGrupo

    public void limpiarCampos() {
        cbox2Grupo.removeAllItems();
        cbox2Grupo.addItem("Seleccione una opción");

        cbox1Grado.removeAllItems();
        cbox1Grado.addItem("Seleccione una opción");
    }
    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        int salir = JOptionPane.showConfirmDialog(rootPane, "SEGURO DESEA SALIR?");
        if (salir == 0) {
            limpiarCampos();
            this.setVisible(false);

        } else {
            limpiarCampos();
        }
    }//GEN-LAST:event_salir
    private void eliminarGrupo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarGrupo
        if (cbox1Grado.getSelectedIndex() != 0 && cbox2Grupo.getSelectedIndex() != 0) {
            int salir = JOptionPane.showConfirmDialog(rootPane, "Seguro desea eliminar el grupo?");
            if (salir == 0) {

                ControlGrupo cgrupo = new ControlGrupo();

                try {
                    cgrupo.eliminarGrupo(Integer.parseInt(cbox1Grado.getSelectedItem().toString()), cbox2Grupo.getSelectedItem().toString());
                } catch (SQLException | ClassNotFoundException ex) {
                    Logger.getLogger(InterfazRegistrarGrupo.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(rootPane, "Grupo Eliminado exitosamente", "Felicidades", JOptionPane.INFORMATION_MESSAGE);

                obtenerGrupo(evt);
                cbox2Grupo.setSelectedIndex(0);
                cbox1Grado.setSelectedIndex(0);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione un Grado y Grupo", "Error", JOptionPane.OK_OPTION);
        }


    }//GEN-LAST:event_eliminarGrupo
    private void obtenerGrados(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_obtenerGrados
        // TODO add your handling code here:

        limpiarCampos();
        ControlGrupo Cgrupo = new ControlGrupo();
        try {
            ResultSet obtenerGrados = Cgrupo.obtenerGrupos();

            String grado = "";

            while (obtenerGrados.next()) {
                grado = obtenerGrados.getObject(1).toString();
                int totalGrado = cbox1Grado.getItemCount();
                int maximo = 0;

                for (int i = 0; i < totalGrado; i++) {
                    if (grado.compareTo(cbox1Grado.getItemAt(i).toString()) == 0) {
                        maximo++;

                    }
                }
                if (maximo == 0) {
                    this.cbox1Grado.addItem(grado);
                }

            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al intentar obtener datos a la bd");
        }

    }//GEN-LAST:event_obtenerGrados

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
            java.util.logging.Logger.getLogger(InterfazEliminarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazEliminarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazEliminarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazEliminarGrupo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazEliminarGrupo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton1Eliminar;
    private javax.swing.JButton Boton2Salir;
    private javax.swing.JComboBox cbox1Grado;
    private javax.swing.JComboBox cbox2Grupo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jp1BajadeGrupo;
    private javax.swing.JPanel jp2Grupo;
    private javax.swing.JLabel lab1Grado;
    private javax.swing.JLabel lab2Grupo;
    private javax.swing.JMenuBar menu1;
    // End of variables declaration//GEN-END:variables
}
