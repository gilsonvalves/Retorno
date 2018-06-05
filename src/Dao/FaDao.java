/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import factory.ConnectionFactory;
import modelo.fa;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class FaDao {
    
        private Connection connection; 
        
        
  public FaDao(){
        this.connection = new ConnectionFactory().getConnection();
    }
  
  public void adcionar(fa Fa){
      String sql = "INSERT INTO fa VALUES(?,?,?,?,?,?,?)";
      try { 
            PreparedStatement stmt = connection.prepareStatement(sql); 
            stmt.setInt(1, Fa.getItem());
            stmt.setString(2, Fa.getFa());
            stmt.setString(3, Fa.getNome());
            stmt.setString(4,Fa.getData());
            stmt.setString(5,Fa.getTecnicotriagem());
            stmt.setString(6,Fa.getHora());
            stmt.setString(7,Fa.getObs());
            stmt.execute();
            stmt.close();
                 
      }catch(SQLException p) { 
             throw new RuntimeException(p);
             
        } 
  }   
      public void excluir(fa Fa){
          
            String sql = "DELETE FROM fa_1 where fa ='"+Fa.getFa()+"'";
            
           try{
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.execute();
            stmt.close();
        
           }catch(SQLException u){
            
            throw new RuntimeException("erro ao excluir: "+u.getMessage());
        }
      }
      
       public void alterar(fa Fa){
          String  sql = "UPDATE fa set fa=, nome=, data=, tecnicotriagem=, hora=, obs= where item= ";
          try{
              
              PreparedStatement stmt = connection.prepareStatement(sql); 
              
            stmt.setString(1, Fa.getFa());
            stmt.setString(2, Fa.getNome());
            stmt.setString(3,Fa.getData());
            stmt.setString(4,Fa.getTecnicotriagem());
            stmt.setString(5,Fa.getHora());
            stmt.setString(6,Fa.getObs());
            stmt.setInt(7, Fa.getItem());  
             stmt.execute();
            stmt.close(); 
              
          }catch(SQLException u){
              throw new RuntimeException(u);
          }
          
          
      }
      
      
        public static void main(String[] args) throws SQLException{
             fa Fa = new fa();
            FaDao dao = new FaDao();
            dao.alterar(Fa);
                
    }
          
                
  
 }
    
      