/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia_semdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author muril
 */
public class Produto {
    
    private int id;
    private String descricao;
    private double preco;
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public double getPreco(){
        return preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public void cadastrar() throws SQLException, ClassNotFoundException{
        Connection con = getConexao();
        
        PreparedStatement comando = con.prepareStatement("insert into produto(descricao,preco) values(?,?)");
        
        comando.setString(1, descricao);
        comando.setDouble(2, preco);
        comando.execute();
        con.close();
    }
    
    
    public Connection getConexao(){
        try{
            //Método forName carrega e inicia o driver passado por parâmetro
            Class.forName("com.mysql.cj.jdbc.Driver");  //verificar em seu computador
            String URL = "jdbc:mysql://localhost:3306/aula_ioo";  //verificar em seu computador
            String USER = "root";  //verificar em seu computador7
            String PASSWORD = "";  //verificar no seu ocmputador
            
            //Estabelecendo conexão
            return DriverManager.getConnection(URL,USER,PASSWORD);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            return null;
        }
    }
    
    
    public Produto consultarById(Produto p1) throws SQLException, ClassNotFoundException{
        Connection con = getConexao();
        PreparedStatement comando = con.prepareStatement("Select * from produto where id = ?");
        comando.setInt(1,p1.getId());
        ResultSet resultado = comando.executeQuery();
        
        Produto prod = new Produto();
        if(resultado.next()) {
            prod.setId(resultado.getInt("id"));
            prod.setDescricao(resultado.getString("descricao"));
            prod.setPreco(resultado.getDouble("preco"));
            
            
        }
        
        return prod;
    }
    
}
