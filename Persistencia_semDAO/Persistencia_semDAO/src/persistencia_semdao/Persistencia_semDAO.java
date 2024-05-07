/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package persistencia_semdao;

import java.sql.SQLException;

/**
 *
 * @author muril
 */
public class Persistencia_semDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Produto p = new Produto();
        p.setDescricao("Mouse com fio");
        p.setPreco(30);
        
        try{
            p.cadastrar();
            System.out.println("Cadastrado com sucesso");
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERRO" + ex.getMessage());
        }
        
        
        Produto p1 = new Produto();
            p.setId(3);
            try{
                p1 = p1.consultarById(p);
                if (p1.getDescricao() != null) {
                    System.out.println("Id...:" + p1.getId());
                    System.out.println("Descrição]:" + p1.getDescricao());
                    System.out.println("Preço...:" + p1.getPreco());
                } else {
                    System.out.println("ID não encontrado!");
                }
            } catch (SQLException | ClassNotFoundException ex) {
                System.out.println("ERRO:" + ex.getMessage());
            } 
       
    }
    
}
