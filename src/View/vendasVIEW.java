
package View;

import Controller.ProdutosDTO;
import DAO.conectaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class vendasVIEW extends javax.swing.JFrame {
    ProdutosDTO DTO;
    conectaDAO dao;

    private PreparedStatement st;
    private ResultSet rs;
    
    public vendasVIEW() {
        initComponents();
        listarVendas();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVoltar = new javax.swing.JButton();
        btnListarVendas = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlListaProdutos = new javax.swing.JTable();
        lblLista = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtID = new javax.swing.JTextPane();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnListarVendas.setText("Listar Vendas");
        btnListarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarVendasActionPerformed(evt);
            }
        });

        pnlListaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(pnlListaProdutos);

        lblLista.setFont(new java.awt.Font("Lucida Fax", 0, 18)); // NOI18N
        lblLista.setText("Lista de Vendas");

        lblID.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        lblID.setText("Vendas Produto (ID)");

        jScrollPane2.setViewportView(txtID);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnVoltar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnListarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblLista)
                .addGap(193, 193, 193))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblID)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnListarVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnListarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarVendasActionPerformed
         String id = txtID.getText();
        if(id.isEmpty()){
            listarVendas();
        }else{
             try {
                 consultaID();
             } catch (SQLException ex) {
                 Logger.getLogger(vendasVIEW.class.getName()).log(Level.SEVERE, null, ex);
             }
        }
    }//GEN-LAST:event_btnListarVendasActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vendasVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListarVendas;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLista;
    private javax.swing.JTable pnlListaProdutos;
    private javax.swing.JTextPane txtID;
    // End of variables declaration//GEN-END:variables
    
    public void consultaID() throws SQLException{
        
        int idProduto = Integer.parseInt(txtID.getText());
        PreparedStatement st;
        ResultSet rs;
        boolean encontrouResultado = false;
        
        try{
            Connection con = conectaDAO.Conexao();
            
            st = con.prepareStatement("select * from produtos WHERE id = ? and status = 'Vendido'");
            st.setInt(1, idProduto);
            rs = st.executeQuery();
            
            DefaultTableModel  model = (DefaultTableModel) pnlListaProdutos.getModel();   
            model.setNumRows(0);
            
            while(rs.next()){
                encontrouResultado = true;
                model.addRow(new Object[]{
                rs.getString("id"),
                rs.getString("nome"),
                rs.getString("valor"), 
                rs.getString("status")
                });
            }
             rs.close();
             con.close();
            
            // Verifique se algum resultado foi encontrado
            if (!encontrouResultado) {
                // Se nenhum resultado foi encontrado, exiba o JPanel com a mensagem de erro
                JOptionPane.showMessageDialog(null,"O valor pesquisado não foi encontrado\n ou ainda não foi vendido");
                listarVendas();
            } 
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    public void listarVendas(){
        try{
            Connection con = conectaDAO.Conexao();
            
            st = con.prepareStatement("select * from produtos where status = 'Vendido'");
            rs = st.executeQuery();
            
            DefaultTableModel  model = (DefaultTableModel) pnlListaProdutos.getModel();   
            model.setNumRows(0);
            
            while(rs.next()){
                model.addRow(new Object[]{
                rs.getString("id"),
                rs.getString("nome"),
                rs.getString("valor"), 
                rs.getString("status")
                });
            }
            rs.close();
            con.close();
            
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
    
