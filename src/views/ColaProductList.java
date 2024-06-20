package views;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import models.entities.Producto;
import services.ProductoService;
import services.impl.ProductoServiceImpl;

public class ColaProductList extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel();

    /**
     * Creates new form ColaProductList
     */
    public ColaProductList() {
        initComponents();
        CentrarVentana();
        CargarProductos();
    }

    private void CentrarVentana() {
        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        int height = pantalla.height;
        int width = pantalla.width;

        int x = (width / 2) - this.getWidth() / 2;
        int y = (height / 2) - this.getHeight() / 2;

        this.setLocation(x, y);

    }

    private void CargarProductos() {

        String[] headers = new String[]{"Producto", "Categoria", "Costo S/", "Precio S/", "Cantidad vendida"};
        dtm.setColumnIdentifiers(headers);
        tblProductos.setModel(dtm);
        
        ProductoService productoService = new ProductoServiceImpl();
        List<Producto> productos = productoService.listar();
        
        for (Integer count = 0; count < productos.size(); count++) {
            dtm.addRow(new Object[]{
                productos.get(count).getProducto_nombre(),
                productos.get(count).getCategoria_nombre(),
                productos.get(count).getProducto_costo(),
                productos.get(count).getProducto_precio(),
                productos.get(count).getProducto_cantvendida(),
            });
        }

    }

    private void tamaños() {
        tblProductos.getColumnModel().getColumn(0).setMaxWidth(450);
        tblProductos.getColumnModel().getColumn(0).setMinWidth(450);
        tblProductos.getColumnModel().getColumn(0).setPreferredWidth(450);

        tblProductos.getColumnModel().getColumn(1).setMaxWidth(200);
        tblProductos.getColumnModel().getColumn(1).setMinWidth(200);
        tblProductos.getColumnModel().getColumn(1).setPreferredWidth(200);

        tblProductos.getColumnModel().getColumn(2).setMaxWidth(80);
        tblProductos.getColumnModel().getColumn(2).setMinWidth(80);
        tblProductos.getColumnModel().getColumn(2).setPreferredWidth(80);

        tblProductos.getColumnModel().getColumn(3).setMaxWidth(80);
        tblProductos.getColumnModel().getColumn(3).setMinWidth(80);
        tblProductos.getColumnModel().getColumn(3).setPreferredWidth(80);

        tblProductos.getColumnModel().getColumn(4).setMaxWidth(120);
        tblProductos.getColumnModel().getColumn(4).setMinWidth(120);
        tblProductos.getColumnModel().getColumn(4).setPreferredWidth(120);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        lblitems = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Cola de productos");

        jLabel3.setText("N° items:");

        lblitems.setText("0");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDPRODUCTO", "NOMBRE", "PRECIO COSTO", "PRECIO VENTA", "VENDIDOS"
            }
        ));
        tblProductos.setName("tblProductos"); // NOI18N
        jScrollPane1.setViewportView(tblProductos);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COLA DE PRODUCTOS");

        jLabel2.setText("Prioridad");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cantidad vendida" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Atender cola");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)
                        .addGap(0, 760, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1093, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(lblitems)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblitems)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ColaPorCantidad();
    }//GEN-LAST:event_jButton1ActionPerformed
    private void ColaPorCantidad() {

        String nombre;
        String nombre_categoria;
        int id;
        int id_categoria;
        double costo;
        double precio;
        int cantvendida;
        Producto producto = new Producto();

        // COLA CON PRIORIDAD
        Queue<Producto> ColaConPrioridad = new PriorityQueue<>(producto.bycantidad);

        //SE LLENA LA COLA CON EL BUCLE
        for (int i = 0; i < tblProductos.getRowCount(); i++) {

            id = i;
            id_categoria = 0;
            nombre = tblProductos.getValueAt(i, 0).toString();
            nombre_categoria = tblProductos.getValueAt(i, 1).toString();
            costo = Double.parseDouble(tblProductos.getValueAt(i, 2).toString());
            precio = Double.parseDouble(tblProductos.getValueAt(i, 3).toString());
            cantvendida = Integer.parseInt(tblProductos.getValueAt(i, 4).toString());

            Producto prod = new Producto(nombre, id, id_categoria, costo, precio, cantvendida, nombre_categoria);
            ColaConPrioridad.add(prod);

        }
        // SE LIMPIA LA TABLA

        LimpiarTabla();

//          
        // SE VUELVE A LLENAR LA TABLA 
        String[] fila = new String[5];

        while (!ColaConPrioridad.isEmpty()) {

            Producto ColaAtendida = ColaConPrioridad.poll();

            fila[0] = ColaAtendida.getProducto_nombre();
            fila[1] = ColaAtendida.getCategoria_nombre();
            fila[2] = String.valueOf(ColaAtendida.getProducto_costo());
            fila[3] = String.valueOf(ColaAtendida.getProducto_precio());
            fila[4] = String.valueOf(ColaAtendida.getProducto_cantvendida());
            dtm.addRow(fila);

        }

        //UNA VEZ ATENDIDA LA COLA SE ELIMINA
        ColaConPrioridad.clear();

        lblitems.setText(String.valueOf(tblProductos.getRowCount()));
        JOptionPane.showMessageDialog(rootPane, "Cola atendida");
    }

    private void LimpiarTabla() {
        //se limpia la tabla para volver a llenar con la lista ordenada
        for (int i = tblProductos.getRowCount() - 1; i >= 0; i--) {
            dtm.removeRow(i);
        }
        lblitems.setText(String.valueOf(tblProductos.getRowCount()));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblitems;
    private javax.swing.JTable tblProductos;
    // End of variables declaration//GEN-END:variables
}
