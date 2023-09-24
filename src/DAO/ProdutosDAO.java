package DAO;

import Controller.ProdutosDTO;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutosDAO {

     Connection conn;
     PreparedStatement st;
     ResultSet rs;
    
    public int salvar (ProdutosDTO produtos){

            int status;

            try {
                st = conn.prepareStatement("INSERT INTO produtos VALUES(?,?,?,?)");
                //
                String query = "SELECT MAX(id) FROM produtos";

                ResultSet resultSet = st.executeQuery(query);

                int lastId = 0;
                if (resultSet.next()) {
                    lastId = resultSet.getInt(1);
                }
                int nextId = lastId + 1;

                st.setInt(1, nextId);
                st.setString(2, produtos.getNome());
                st.setInt(3, produtos.getValor());
                st.setString(4, produtos.getStatus());

                status = st.executeUpdate();
                return status; //retornar 1

            } catch (SQLException ex) {
                System.out.println("Erro ao conectar: " + ex.getMessage());
                return ex.getErrorCode();

            }
        }
     
}

