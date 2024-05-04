/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package is2;

/**
 *
 * @author stele
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public NewJFrame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fieldBuscar = new javax.swing.JTextField();
        botonBuscar = new javax.swing.JButton();
        botonAlta = new javax.swing.JButton();
        botonConsulta = new javax.swing.JButton();
        panel2cosas = new javax.swing.JPanel();
        textoBuscar = new javax.swing.JLabel();
        panelTabs = new javax.swing.JTabbedPane();
        panel4cosas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        textoApellido = new javax.swing.JTextField();
        textoDNI = new javax.swing.JTextField();
        textoCorreo = new javax.swing.JTextField();
        botonGuardar = new javax.swing.JButton();
        botonCerrar = new javax.swing.JButton();
        panel4cosas1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textoNombre1 = new javax.swing.JTextField();
        textoApellido1 = new javax.swing.JTextField();
        textoDNI1 = new javax.swing.JTextField();
        textoCorreo1 = new javax.swing.JTextField();
        botonGuardar1 = new javax.swing.JButton();
        botonCerrar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 750));
        setResizable(false);

        fieldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldBuscarActionPerformed(evt);
            }
        });

        botonBuscar.setText("Buscar");
        botonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonBuscarActionPerformed(evt);
            }
        });

        botonAlta.setText("Alta");
        botonAlta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAltaMouseClicked(evt);
            }
        });
        botonAlta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAltaActionPerformed(evt);
                botonAltaActionPerformed1(evt);
            }
        });

        botonConsulta.setText("Consulta");
        botonConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2cosasLayout = new javax.swing.GroupLayout(panel2cosas);
        panel2cosas.setLayout(panel2cosasLayout);
        panel2cosasLayout.setHorizontalGroup(
            panel2cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 186, Short.MAX_VALUE)
        );
        panel2cosasLayout.setVerticalGroup(
            panel2cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 31, Short.MAX_VALUE)
        );

        textoBuscar.setText("Buscar:");
        textoBuscar.setToolTipText("Buscar:");

        panelTabs.setVisible(false);

        jLabel2.setText("Nombre:");

        jLabel3.setText("Apellido:");

        jLabel4.setText("DNI:");

        jLabel5.setText("Correo:");

        textoNombre.setMinimumSize(new java.awt.Dimension(68, 65));
        textoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNombreActionPerformed(evt);
            }
        });

        textoApellido.setMaximumSize(new java.awt.Dimension(32767, 32767));
        textoApellido.setMinimumSize(new java.awt.Dimension(68, 65));

        textoDNI.setMaximumSize(new java.awt.Dimension(32767, 32767));
        textoDNI.setMinimumSize(new java.awt.Dimension(68, 65));
        textoDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoDNIActionPerformed(evt);
            }
        });

        textoCorreo.setMaximumSize(new java.awt.Dimension(32767, 32767));
        textoCorreo.setMinimumSize(new java.awt.Dimension(68, 65));
        textoCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCorreoActionPerformed(evt);
            }
        });

        botonGuardar.setText("Guardar");
        botonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardarActionPerformed(evt);
            }
        });

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel4cosasLayout = new javax.swing.GroupLayout(panel4cosas);
        panel4cosas.setLayout(panel4cosasLayout);
        panel4cosasLayout.setHorizontalGroup(
            panel4cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4cosasLayout.createSequentialGroup()
                .addComponent(botonGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(botonCerrar))
            .addGroup(panel4cosasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(panel4cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textoCorreo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoDNI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textoNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panel4cosasLayout.setVerticalGroup(
            panel4cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4cosasLayout.createSequentialGroup()
                .addGroup(panel4cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(panel4cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(panel4cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(panel4cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(textoCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panel4cosasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar)
                    .addComponent(botonCerrar)))
        );

        panel4cosasLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel4, jLabel5, textoApellido, textoCorreo, textoDNI, textoNombre});

        panelTabs.addTab("Profesor", panel4cosas);
        panel4cosas.setVisible(false);

        panel4cosas1.setToolTipText("");
        panel4cosas1.setPreferredSize(new java.awt.Dimension(227, 340));

        jLabel6.setText("Nombre:");
        jLabel6.setAlignmentX(0.5F);
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel7.setText("Apellido:");
        jLabel7.setAlignmentX(0.5F);
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel8.setText("DNI:");
        jLabel8.setAlignmentX(0.5F);
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel9.setText("Correo:");
        jLabel9.setAlignmentX(0.5F);
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textoNombre1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoNombre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNombre1ActionPerformed(evt);
            }
        });

        textoApellido1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        textoDNI1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoDNI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoDNI1ActionPerformed(evt);
            }
        });

        textoCorreo1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textoCorreo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoCorreo1ActionPerformed(evt);
            }
        });

        botonGuardar1.setText("Guardar");
        botonGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonGuardar1ActionPerformed(evt);
            }
        });

        botonCerrar1.setText("Cerrar");
        botonCerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel4cosas1Layout = new javax.swing.GroupLayout(panel4cosas1);
        panel4cosas1.setLayout(panel4cosas1Layout);
        panel4cosas1Layout.setHorizontalGroup(
            panel4cosas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4cosas1Layout.createSequentialGroup()
                .addComponent(botonGuardar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(botonCerrar1))
            .addGroup(panel4cosas1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panel4cosas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel4cosas1Layout.createSequentialGroup()
                        .addGroup(panel4cosas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(26, 26, 26)
                        .addGroup(panel4cosas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textoDNI1)
                            .addComponent(textoCorreo1)))
                    .addGroup(panel4cosas1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(textoNombre1))
                    .addGroup(panel4cosas1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(textoApellido1)))
                .addContainerGap())
        );
        panel4cosas1Layout.setVerticalGroup(
            panel4cosas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel4cosas1Layout.createSequentialGroup()
                .addGroup(panel4cosas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(textoNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(panel4cosas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(textoApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(panel4cosas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(textoDNI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(panel4cosas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textoCorreo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(panel4cosas1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonGuardar1)
                    .addComponent(botonCerrar1)))
        );

        panelTabs.addTab("Alumno", panel4cosas1);
        panel4cosas.setVisible(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonAlta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonConsulta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel2cosas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelTabs, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 242, Short.MAX_VALUE)
                .addComponent(panel2cosas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botonBuscar)
                    .addComponent(botonAlta)
                    .addComponent(botonConsulta)
                    .addComponent(textoBuscar)))
        );

        this.setVisible(false);
        this.setVisible(false);
        panel2cosas.setVisible(false);
        this.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldBuscarActionPerformed

    private void botonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonBuscarActionPerformed

    private void botonConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonConsultaActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botonConsultaActionPerformed

    private void botonAltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonAltaActionPerformed

    private void botonAltaActionPerformed1(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAltaActionPerformed1
        
    }//GEN-LAST:event_botonAltaActionPerformed1

    private void botonAltaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAltaMouseClicked
        if (panelTabs.isVisible() == true){
            panelTabs.setVisible(false);
        }
        else {
                    panelTabs.setVisible(true);

        }
    }//GEN-LAST:event_botonAltaMouseClicked

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        // TODO add your handling code here:
        if (panelTabs.isVisible() == true){
            panelTabs.setVisible(false);
        }
        else {
            panelTabs.setVisible(true);

        }

    }//GEN-LAST:event_botonCerrarActionPerformed

    private void botonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardarActionPerformed
        // TODO add your handling code here:
        if (panelTabs.isVisible() == true){
            panelTabs.setVisible(false);
        }
        else {
            panelTabs.setVisible(true);

        }
    }//GEN-LAST:event_botonGuardarActionPerformed

    private void textoCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCorreoActionPerformed

    private void textoDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoDNIActionPerformed

    private void textoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNombreActionPerformed

    private void botonCerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrar1ActionPerformed
        // TODO add your handling code here:
        if (panelTabs.isVisible() == true){
            panelTabs.setVisible(false);
        }
        else {
            panelTabs.setVisible(true);

        }
    }//GEN-LAST:event_botonCerrar1ActionPerformed

    private void botonGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonGuardar1ActionPerformed
        // TODO add your handling code here:
        if (panelTabs.isVisible() == true){
            panelTabs.setVisible(false);
        }
        else {
            panelTabs.setVisible(true);

        }
    }//GEN-LAST:event_botonGuardar1ActionPerformed

    private void textoCorreo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoCorreo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoCorreo1ActionPerformed

    private void textoDNI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoDNI1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoDNI1ActionPerformed

    private void textoNombre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNombre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoNombre1ActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAlta;
    private javax.swing.JButton botonBuscar;
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton botonCerrar1;
    private javax.swing.JButton botonConsulta;
    private javax.swing.JButton botonGuardar;
    private javax.swing.JButton botonGuardar1;
    private javax.swing.JTextField fieldBuscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel panel2cosas;
    private javax.swing.JPanel panel4cosas;
    private javax.swing.JPanel panel4cosas1;
    private javax.swing.JTabbedPane panelTabs;
    private javax.swing.JTextField textoApellido;
    private javax.swing.JTextField textoApellido1;
    private javax.swing.JLabel textoBuscar;
    private javax.swing.JTextField textoCorreo;
    private javax.swing.JTextField textoCorreo1;
    private javax.swing.JTextField textoDNI;
    private javax.swing.JTextField textoDNI1;
    private javax.swing.JTextField textoNombre;
    private javax.swing.JTextField textoNombre1;
    // End of variables declaration//GEN-END:variables
}
