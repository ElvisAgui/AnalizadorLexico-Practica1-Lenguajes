
package com.proyectoLenguajes.interfazG;

import com.proyectoLenguajes.analizador.Analizador;
import com.proyectoLenguajes.analizador.Sintactico.AnalizadorSintactico;
import com.proyectoLenguajes.analizador.Sintactico.Producciones;
import com.proyectoLenguajes.archivos.EscritorArchivo;
import com.proyectoLenguajes.archivos.LectorArchivo;
import com.proyectoLenguajes.principal.Busqueda;
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
    
    private Busqueda busqueda;
    private Analizador analizador;
    private ReporteError ventanaRpo = new ReporteError();
    private LectorArchivo lector = new LectorArchivo();
    private NumeroLinea numeroLinea;
    private Reportes reporteVentan = new Reportes();
    private MovimientoVentan movimiento = new MovimientoVentan();

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
        GuardarjButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

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
        AnalizarjButton3.setText("Movimientos");
        AnalizarjButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalizarjButton3ActionPerformed(evt);
            }
        });

        GuardarjButton.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        GuardarjButton.setForeground(new java.awt.Color(0, 0, 0));
        GuardarjButton.setText("Guardar");
        GuardarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarjButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(GuardarjButton, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SubirArchivojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnalizarjButton3)
                    .addComponent(reporteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnalizarjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(137, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(SubirArchivojButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnalizarjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(reporteJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnalizarjButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(GuardarjButton)
                .addContainerGap())
        );

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                    this.lector.leerFichero(fichero, jTextArea1);
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
            if (this.analizador.getReporteErrores().isExisteErrores()) {
                this.ventanaRpo.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Texto sin Errores");
            }

        }
    }//GEN-LAST:event_AnalizarjButton1ActionPerformed

    private void reporteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reporteJButtonActionPerformed
        try {
            if (!this.analizador.getReporteErrores().isExisteErrores()) {
                this.reporteVentan.setReportErrores(this.analizador.getReporte());
                this.reporteVentan.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Solucionar Errores Primero");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Debe Analizar Primero");

        }
//        
//        AnalizadorSintactico ana = new AnalizadorSintactico();
//        ana.prueba("INICIAR");

    }//GEN-LAST:event_reporteJButtonActionPerformed

   
    private void AnalizarjButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalizarjButton3ActionPerformed
        try {
            if (!this.analizador.getReporteErrores().isExisteErrores()) {
                this.movimiento.setAnalizador(analizador);
                this.movimiento.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Solucionar Errores Primero");
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "Debe Analizar Primero");
        }
    }//GEN-LAST:event_AnalizarjButton3ActionPerformed

    private void GuardarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarjButtonActionPerformed
        EscritorArchivo escritor = new EscritorArchivo();
        JFileChooser fileChosser = new JFileChooser();
        if (fileChosser.showDialog(null, "Guardar") == JFileChooser.APPROVE_OPTION) {
            escritor.escritorArchivo(fileChosser.getSelectedFile(), jTextArea1.getText());
        }
    }//GEN-LAST:event_GuardarjButtonActionPerformed

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
    private javax.swing.JButton GuardarjButton;
    private javax.swing.JButton SubirArchivojButton;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton reporteJButton;
    // End of variables declaration//GEN-END:variables
}
