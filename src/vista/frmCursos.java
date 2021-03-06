/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import gestorArchivos.gestorCursos;
import controlador.controlMateriasCola;
import controlador.controlMateriasCola.nodoCola;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.cursos;

/**
 *
 * @author ferna
 */
public class frmCursos extends javax.swing.JFrame {

    DefaultTableModel modelo;
    String[] cabecera = {"N°", "CODIGO", "NOMBRE", "DURACION", "CANTIDAD", "PAGO", "DESCUENTO 20%", "TOTAL"};
    String[][] data = {};
    int num = 0;
    gestorCursos gestor = new gestorCursos();
    String FileName = "Carreras.bin";
    controlMateriasCola lista = new controlMateriasCola();
    controlMateriasCola.nodoCola nodo;

    /**
     * Creates new form frmCursos
     */
    public frmCursos() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("REGISTRO DE CARRERAS");
        this.setResizable(false);
        tablaDatos.setEnabled(false);
        gestor.AbrirArchivo(FileName, lista);
        modelo = new DefaultTableModel(data, cabecera);
        tablaDatos.setModel(modelo);
        verdatos();
        tablaDatos.setEnabled(false);

    }

    //METODOS
    private void mensaje(String data) {
        StringTokenizer st = new StringTokenizer(data, ",");
        String co = st.nextToken();
        String x1 = st.nextToken();
        String n = st.nextToken();
        String a1 = st.nextToken();
        String d = st.nextToken();
        String cas = st.nextToken();
        String ce = st.nextToken();

        String datos = "DETALLES DE DATO ELIMINADO:\n"
                + "CODIGO: " + co + "\n"
                + "NOMBRE: " + x1 + "\n"
                + "DURACION: " + n + "\n"
                + "CANTIDAD: " + a1 + "\n"
                + "PAGO: " + d + "\n"
                + "DESCUENTO 20%: " + cas + "\n"
                + "TOTAL: " + ce + "\n";
        JOptionPane.showMessageDialog(this, datos);
    }

    void vaciartabla() {
        int filas = tablaDatos.getRowCount();
        for (int i = 0; i < filas; i++) {
            modelo.removeRow(0);
        }
    }

    void verdatos() {
        String cod, nomb, dura;
        double des, tot;
        int canti, pag;
        nodoCola aux = lista.inicio;
        vaciartabla();
        num = 0;
        while (aux != null) {
            cod = aux.getMat().getCodigoCa();
            nomb = aux.getMat().getNombreCa();
            dura = aux.getMat().getDuracionCa();
            canti = aux.getMat().getCantidadMaterias();
            pag = aux.getMat().getPago();
            des = aux.getMat().getDescuento();
            tot = aux.getMat().getPago_total();
            num++;
            Object[] fila = {num, cod, nomb, dura, canti, pag, des, tot};
            modelo.addRow(fila);
            aux = aux.getSig();
        }
    }

    void habilitar() {
        btnagregar.setEnabled(false);
    }

    void deshabilitar() {
        btnagregar.setEnabled(true);
    }

    void limpiarentradas() {
        txtcodigoCarrera.setText("");
        txtnombreCarrera.setText("");
        txtduracionCarrera.setText("");
        txtcostoCarrera.setText("");
        txtcodigoCarrera.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtcodigoCarrera = new javax.swing.JTextField();
        txtnombreCarrera = new javax.swing.JTextField();
        txtduracionCarrera = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtcostoCarrera = new javax.swing.JTextField();
        btnagregar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnbuscar = new javax.swing.JButton();
        btnatras = new javax.swing.JButton();
        txtcantidad = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDatos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(14, 62, 14));

        jLabel1.setFont(new java.awt.Font("Eras Light ITC", 3, 36)); // NOI18N
        jLabel1.setText("REGISTRO DE CARRERAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(275, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(194, 194, 194))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Eras Light ITC", 3, 14), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Eras Light ITC", 3, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CODIGO CARRERA:");

        jLabel3.setFont(new java.awt.Font("Eras Light ITC", 3, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("NOMBRE CARRERA:");

        jLabel4.setFont(new java.awt.Font("Eras Light ITC", 3, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("DURACION CARRERA:");

        txtcodigoCarrera.setBackground(new java.awt.Color(255, 255, 255));
        txtcodigoCarrera.setFont(new java.awt.Font("Eras Light ITC", 3, 16)); // NOI18N
        txtcodigoCarrera.setForeground(new java.awt.Color(0, 0, 0));

        txtnombreCarrera.setBackground(new java.awt.Color(255, 255, 255));
        txtnombreCarrera.setFont(new java.awt.Font("Eras Light ITC", 3, 16)); // NOI18N
        txtnombreCarrera.setForeground(new java.awt.Color(0, 0, 0));

        txtduracionCarrera.setBackground(new java.awt.Color(255, 255, 255));
        txtduracionCarrera.setFont(new java.awt.Font("Eras Light ITC", 3, 16)); // NOI18N
        txtduracionCarrera.setForeground(new java.awt.Color(0, 0, 0));

        jLabel5.setFont(new java.awt.Font("Eras Light ITC", 3, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("CANTIDAD MATERIAS:");

        jLabel6.setFont(new java.awt.Font("Eras Light ITC", 3, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("COSTO:");

        txtcostoCarrera.setBackground(new java.awt.Color(255, 255, 255));
        txtcostoCarrera.setFont(new java.awt.Font("Eras Light ITC", 3, 16)); // NOI18N
        txtcostoCarrera.setForeground(new java.awt.Color(0, 102, 0));

        btnagregar.setBackground(new java.awt.Color(255, 255, 255));
        btnagregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addM.png"))); // NOI18N
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/removeM.png"))); // NOI18N
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnbuscar.setBackground(new java.awt.Color(255, 255, 255));
        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search_102938.png"))); // NOI18N
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        btnatras.setBackground(new java.awt.Color(255, 255, 255));
        btnatras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/arrowback_257.png"))); // NOI18N
        btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrasActionPerformed(evt);
            }
        });

        txtcantidad.setBackground(new java.awt.Color(255, 255, 255));
        txtcantidad.setFont(new java.awt.Font("Eras Light ITC", 3, 16)); // NOI18N
        txtcantidad.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtcodigoCarrera, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                            .addComponent(txtduracionCarrera)
                            .addComponent(txtcostoCarrera))
                        .addGap(95, 95, 95)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnatras, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtnombreCarrera, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtcodigoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtduracionCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtnombreCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcostoCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnatras, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(btnagregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        tablaDatos.setBackground(new java.awt.Color(255, 255, 255));
        tablaDatos.setFont(new java.awt.Font("Eras Light ITC", 3, 14)); // NOI18N
        tablaDatos.setForeground(new java.awt.Color(0, 0, 0));
        tablaDatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "NOMBRE CARRERA", "DURACION", "CANTIDAD MATERIAS", "PAGO", "DESCUENTO 20%", "PAGO TOTAL"
            }
        ));
        tablaDatos.setGridColor(new java.awt.Color(0, 0, 0));
        tablaDatos.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tablaDatos);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
        frmRegistroCarrera ty = new frmRegistroCarrera();
        ty.setVisible(true);
        ty.toFront();
    }//GEN-LAST:event_btnatrasActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed
        // TODO add your handling code here:
        String cod = txtcodigoCarrera.getText().toUpperCase();
        String nomb = txtnombreCarrera.getText().toUpperCase();
        String durac = txtduracionCarrera.getText().toUpperCase();
        String canti = txtcantidad.getText().toUpperCase();
        String mon1 = txtcostoCarrera.getText().toUpperCase();
        String des1 = txtcostoCarrera.getText().toUpperCase();
        String tot1 = txtcostoCarrera.getText().toUpperCase();
        lista.nodo2 = lista.buscar2(lista.inicio, nomb);
        if (cod.isEmpty() || nomb.isEmpty() || durac.isEmpty() || canti.isEmpty() || mon1.isEmpty() || des1.isEmpty() || tot1.isEmpty()) {
            JOptionPane.showMessageDialog(this, "¡RELLENE TODOS LOS CAMPOS!", "ALERTA", JOptionPane.WARNING_MESSAGE);
        } else {
            lista.nodo1 = lista.buscar(lista.inicio, cod);
            if (lista.nodo1 != null) {
                lista.nodo1 = lista.buscar2(lista.inicio, nomb);
                if (lista.nodo1 != null) {
                    JOptionPane.showMessageDialog(this, "¡EL CODIGO Y MATERIA YA REGISTRADOS!", "ALERTA", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "¡CODIGO YA REGISTRADO, INGRESE OTRO!", "ALERTA", JOptionPane.WARNING_MESSAGE);
                    txtcodigoCarrera.requestFocus();
                }
            } else if (lista.nodo2 != null) {
                JOptionPane.showMessageDialog(this, "¡LA MATERIA YA ESTA REGISTRADA, INGRESE OTRA!", "ALERTA", JOptionPane.WARNING_MESSAGE);
            } else {
                int mon = Integer.parseInt(mon1);
                double des = Integer.parseInt(des1);
                double tot = Integer.parseInt(tot1);
                lista.encolar(new cursos(new Object[]{cod, nomb, durac, canti, mon, des, tot}));
                try {
                    StringBuffer materias = new StringBuffer(txtnombreCarrera.getText().trim() + "\t");
                    gestorCursos.EscribeTxtCarrera(materias);
                } catch (Exception e) {
                }
                limpiarentradas();
                verdatos();
                gestor.GrabarArchivo(FileName, lista);

            }
        }
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        if (lista.inicio == null) {
            JOptionPane.showMessageDialog(this, "¡COLA VACIA!", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            txtcodigoCarrera.requestFocus();
        } else {
            String dato = lista.eliminar();
            mensaje(dato);
            gestor.GrabarArchivo(FileName, lista);
            verdatos();
            limpiarentradas();
            if (lista.inicio == null) {
                JOptionPane.showMessageDialog(this, "¡COLA VACIA!", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
            }
            deshabilitar();

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
        String cod = txtcodigoCarrera.getText();
        if (cod.equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(this, "INGRESE UN CODIGO EN EL CAMPO CODIGO", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        } else {
            lista.nodo1 = lista.buscar(lista.inicio, cod);
            if (lista.nodo1 != null) {
                txtnombreCarrera.setText(lista.nodo1.getMat().getNombreCa());
                txtcostoCarrera.setText(String.valueOf(lista.nodo1.getMat().getPago()));
                habilitar();
            } else {
                JOptionPane.showMessageDialog(this, "EL CODIGO: " + cod + " NO ESTA EN LA COLA", "ALERTA", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(frmCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCursos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmCursos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    private javax.swing.JButton btnatras;
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btneliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaDatos;
    private javax.swing.JTextField txtcantidad;
    private javax.swing.JTextField txtcodigoCarrera;
    private javax.swing.JTextField txtcostoCarrera;
    private javax.swing.JTextField txtduracionCarrera;
    private javax.swing.JTextField txtnombreCarrera;
    // End of variables declaration//GEN-END:variables
}
