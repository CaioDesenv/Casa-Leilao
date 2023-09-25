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

public class listagemVIEW extends javax.swing.JFrame {
    ProdutosDTO DTO;
    conectaDAO dao;
    
    private PreparedStatement st;
    private ResultSet rs;
    
    public listagemVIEW() {
        initComponents();
        //colocando o metodo criado aqui, será então carregada a tabela inicialmente
        listaODBC();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        pnlListaProdutos = new javax.swing.JTable();
        lblLista = new javax.swing.JLabel();
        lblID = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtID = new javax.swing.JTextPane();
        btnVender = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnPesquisar = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnListarVendas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlListaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "id", "nome", "valor", "status"
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
        lblLista.setText("Lista de Produtos");

        lblID.setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        lblID.setText("Vender Produto (ID)");

        jScrollPane2.setViewportView(txtID);

        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar ");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

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
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVender))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(btnVoltar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btnListarVendas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPesquisar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)))))
                .addContainerGap(49, Short.MAX_VALUE))
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
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVender))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnListarVendas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPesquisar)
                    .addComponent(btnVoltar))
                .addGap(17, 17, 17))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        
        try {
            alteraStatus();
            consultaID();
        } catch (SQLException ex) {
            Logger.getLogger(listagemVIEW.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
       String id = txtID.getText();
        if(id.isEmpty()){
            listaODBC();
        }else{
            consultaID();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnListarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarVendasActionPerformed
        listarVendas();
    }//GEN-LAST:event_btnListarVendasActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listagemVIEW().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnListarVendas;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVender;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLista;
    private javax.swing.JTable pnlListaProdutos;
    private javax.swing.JTextPane txtID;
    // End of variables declaration//GEN-END:variables

    public void consultaID(){
        
        int idProduto = Integer.parseInt(txtID.getText());
        PreparedStatement st;
        ResultSet rs;
         
        try{
            Connection con = conectaDAO.Conexao();
            
            st = con.prepareStatement("select * from produtos WHERE id = ?");
            st.setInt(1, idProduto);
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
            
        } catch (SQLException e){
            e.printStackTrace();
        }
                
    }
    public void listaODBC(){
         
        try{
            Connection con = conectaDAO.Conexao();
            
            st = con.prepareStatement("select * from produtos");
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
    
    public void alteraStatus() throws SQLException{
        
        int idProduto = Integer.parseInt(txtID.getText());
        Connection con = conectaDAO.Conexao();
        
        PreparedStatement ps = null;
        String sql = "update produtos set status = 'Vendido' where id = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1,idProduto);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null,"Dados atualizados com sucesso");
            
            ps.close();
            con.close();
            
        } catch ( SQLException sqle ) {
            JOptionPane.showMessageDialog(null,"Erro ao tentar inserir dados");
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
