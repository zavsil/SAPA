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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author franciscoantonio
 */
public class InterfazConsultadeGrupos extends javax.swing.JFrame {

    /**
     * Creates new form InterfazConsultadeGrupo
     */
    public InterfazConsultadeGrupos() {
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

        jp1ConsultadeGrupo = new javax.swing.JPanel();
        jp2Grupo = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table1Grupo = new javax.swing.JTable();
        Boton1Consultar = new javax.swing.JButton();
        Boton2Salir = new javax.swing.JButton();
        menu1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mantenimiento de Grupos/Consulta de Grupos");

        jp1ConsultadeGrupo.setBackground(new java.awt.Color(253, 251, 251));

        jp2Grupo.setBackground(new java.awt.Color(253, 251, 251));
        jp2Grupo.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos del Grupo"));

        Table1Grupo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Grado", "Grupo"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table1Grupo);
        if (Table1Grupo.getColumnModel().getColumnCount() > 0) {
            Table1Grupo.getColumnModel().getColumn(0).setResizable(false);
            Table1Grupo.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jp2GrupoLayout = new javax.swing.GroupLayout(jp2Grupo);
        jp2Grupo.setLayout(jp2GrupoLayout);
        jp2GrupoLayout.setHorizontalGroup(
            jp2GrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2GrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp2GrupoLayout.setVerticalGroup(
            jp2GrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp2GrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        Boton1Consultar.setBackground(new java.awt.Color(255, 255, 51));
        Boton1Consultar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Boton1Consultar.setText("Consultar");
        Boton1Consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarGrupos(evt);
            }
        });

        Boton2Salir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Boton2Salir.setText("Salir");
        Boton2Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salir(evt);
            }
        });

        javax.swing.GroupLayout jp1ConsultadeGrupoLayout = new javax.swing.GroupLayout(jp1ConsultadeGrupo);
        jp1ConsultadeGrupo.setLayout(jp1ConsultadeGrupoLayout);
        jp1ConsultadeGrupoLayout.setHorizontalGroup(
            jp1ConsultadeGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1ConsultadeGrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp1ConsultadeGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jp1ConsultadeGrupoLayout.createSequentialGroup()
                        .addComponent(Boton1Consultar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(Boton2Salir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jp2Grupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jp1ConsultadeGrupoLayout.setVerticalGroup(
            jp1ConsultadeGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp1ConsultadeGrupoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jp1ConsultadeGrupoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jp2Grupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jp1ConsultadeGrupoLayout.createSequentialGroup()
                        .addComponent(Boton1Consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Boton2Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 267, Short.MAX_VALUE)))
                .addContainerGap())
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
            .addComponent(jp1ConsultadeGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, 438, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jp1ConsultadeGrupo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void limpiarCampos() {
        DefaultTableModel modelo = (DefaultTableModel) Table1Grupo.getModel();
        int total = Table1Grupo.getRowCount();
        for (int i = 0; i < total; i++) {
            modelo.removeRow(0);
        }

    }

    private void consultarGrupos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarGrupos

        limpiarCampos();
        ControlGrupo Cgrupo = new ControlGrupo();
        try {
            ResultSet obtenerGrupos = Cgrupo.obtenerGrupos();
            DefaultTableModel modelo = (DefaultTableModel) Table1Grupo.getModel();
            while (obtenerGrupos.next()) {
                modelo.addRow(new Object[]{obtenerGrupos.getObject(1).toString(), obtenerGrupos.getObject(2).toString()});
            }

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error al intentar obtener datos a la bd");
        }


    }//GEN-LAST:event_consultarGrupos

    private void salir(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salir
        int salir = JOptionPane.showConfirmDialog(rootPane, "SEGURO DESEA SALIR?");
        if (salir == 0) {
            limpiarCampos();
            this.setVisible(false);

        } else {
            limpiarCampos();
        }
    }//GEN-LAST:event_salir

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
            java.util.logging.Logger.getLogger(InterfazConsultadeGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InterfazConsultadeGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InterfazConsultadeGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InterfazConsultadeGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InterfazConsultadeGrupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton1Consultar;
    private javax.swing.JButton Boton2Salir;
    private javax.swing.JTable Table1Grupo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp1ConsultadeGrupo;
    private javax.swing.JPanel jp2Grupo;
    private javax.swing.JMenuBar menu1;
    // End of variables declaration//GEN-END:variables
}
