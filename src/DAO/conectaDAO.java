package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class conectaDAO{

    Connection conn;
    PreparedStatement st;
    ResultSet rs;
    
    private String url = "jdbc:mysql://localhost:3306/casaleilao";
    private String user = "root";
    private String pass = "admin";
    
    public boolean conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user, pass);
            return true;
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro ao conectar: " + ex.getMessage());
            return false;
            
        }
    }
    
    public void desconectar(){
            try {
                conn.close();

            } catch (SQLException ex) {
                //pode-se deixar vazio para evitar uma mensagem de erro desnecessária ao usuário
            }
        }
    
    public static Connection Conexao() throws SQLException{
        
        try{
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/casaleilao", "root", "admin");
        } catch (ClassNotFoundException e){
            throw new SQLException(e.getException());
        }
    }
        
}
