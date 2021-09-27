/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyectoLenguajes.interfazG;

import com.proyectoLenguajes.analizador.Analizador;
import com.proyectoLenguajes.archivos.LectorArchivo;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author elvis_agui
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    Analizador analizador;
    ReporteError ventanaRpo = new ReporteError();
    LectorArchivo lector = new LectorArchivo();
    NumeroLinea numeroLinea;
    Reportes reporteVentan = new Reportes();
    
    public VentanaPrincipal() {
        initComponents();
        this.numeroLinea = new NumeroLinea(jTextArea1);
        jScrollPane2.setRowHeaderView(numeroLinea);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new FondoMenu();
        SubirArchivojButton = new javax.swing.JButton();
        AnalizarjButton1 = new javax.swing.JButton();
        reporteJButton = new javax.swing.JButton();
        AnalizarjButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        AnalizarjButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("IDENTIFICADOR");
        setExtendedState(6);

        SubirArchivojButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        SubirArchivojButton.setForeground(new java.awt.Color(0, 0, 0));
        SubirArchivojButton.setText("Subir Archivo");
        SubirArchivojButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubirArchivojButtonActionPerformed(evt);
            }
        });

        AnalizarjButton1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AnalizarjButton1.setForeground(new java.awt.Color(0, 0, 0));
        AnalizarjButton1.setText("Analizar");
        AnalizarjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarjButton1ActionPerformed(evt);
            }
        });

        reporteJButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        reporteJButton.setForeground(new java.awt.Color(0, 0, 0));
        reporteJButton.setText("Reporte");
        reporteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reporteJButtonActionPerformed(evt);
            }
        });

        AnalizarjButton3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AnalizarjButton3.setForeground(new java.awt.Color(0, 0, 0));
        AnalizarjButton3.setText("Tabla estados");
        AnalizarjButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarjButton3ActionPerformed(evt);
            }
        });

        jTextField1.setText("Busquda patrones");

        AnalizarjButton4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        AnalizarjButton4.setForeground(new java.awt.Color(0, 0, 0));
        AnalizarjButton4.setText("Buscar");
        AnalizarjButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarjButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(AnalizarjButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(119, 119, 119))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AnalizarjButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reporteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AnalizarjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubirArchivojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(295, 295, 295)
                .addComponent(SubirArchivojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AnalizarjButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnalizarjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reporteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnalizarjButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setText("Area de Texto");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(10, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 660, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubirArchivojButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubirArchivojButtonActionPerformed
       
        try {
            JFileChooser fileChosser = new JFileChooser();
            int seleccion = fileChosser.showOpenDialog(this);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File fichero = fileChosser.getSelectedFile();
                try {
                    this.lector.leerFichero(fichero,jTextArea1);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error al leer el archivo");
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "completado");

        }
    }//GEN-LAST:event_SubirArchivojButtonActionPerformed

    private void AnalizarjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarjButton1ActionPerformed
        this.analizador = new Analizador(jTextArea1);
        if (jTextArea1.getText() != null) {
           this.analizador.anlaizar();
           this.ventanaRpo.setReportErrores(this.analizador.getReporteErrores());
           this.ventanaRpo.setVisible(true);
        }
    }//GEN-LAST:event_AnalizarjButton1ActionPerformed

    private void reporteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteJButtonActionPerformed
        if(!this.analizador.getReporteErrores().isExisteErrores()){
            this.reporteVentan.setReportErrores(this.analizador.getReporte());
            this.reporteVentan.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this, "Solucionar Errores Primero");
        }
        
    }//GEN-LAST:event_reporteJButtonActionPerformed

    private void AnalizarjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarjButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnalizarjButton3ActionPerformed

    private void AnalizarjButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarjButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnalizarjButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    
    
    class FondoMenu extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/subMenu.png")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }
    class FondoCont extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/fondo.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AnalizarjButton1;
    private javax.swing.JButton AnalizarjButton3;
    private javax.swing.JButton AnalizarjButton4;
    private javax.swing.JButton SubirArchivojButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton reporteJButton;
    // End of variables declaration//GEN-END:variables
}
