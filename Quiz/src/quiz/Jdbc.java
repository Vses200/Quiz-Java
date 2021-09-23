/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author admin
 */

public class Jdbc {
      
    
        private String url = "jdbc:mysql://localhost:3306/tanuja";
        private String uname="root";
        private String pass="1**1aezakmi";
        public Connection con = null;
        public ResultSet  rs = null;
        public int count = 0;
        public int counts = 0;
        ArrayList<String> playernames = new ArrayList<String>();
        public Jdbc(){
            
      
         
         try{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url,uname,pass);
         }catch(Exception e){}
         
         /*
          String query1= "Create Table QuizScores (name varchar(30),score number)";
            
            try{
                PreparedStatement st = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                st.executeUpdate();
            }catch(Exception e){
                
            }
         */
     
        
}
       
        
        public ResultSet fetch(int num){
            String query="Delete from QuizScores";
            String query2= "Select * from QuizScores  order by score DESC LIMIT 5";
            
            try{
                PreparedStatement st = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                st.executeUpdate();
                Statement st2 = con.createStatement();
                rs = st2.executeQuery(query2);
            }catch(Exception e){
                
            }
            return rs;
        }
      
        
        
        public ResultSet fetch(){
            String query = "Select * from QuizScores  order by score DESC LIMIT 5";
        
            try{
            Statement st = con.createStatement();
            rs = st.executeQuery(query);
                     

                
            }catch(Exception e){}
            
            
            return rs;
        }
        
        public void insert(String username,String score){
            
            String query = "Insert into QuizScores (name,score) values(?,?)";
        
             try{
                    PreparedStatement st = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                    st.setString(1, username);
                    st.setString(2, (""+score));
                    count = st.executeUpdate();
                    
                 }catch(Exception e){}
             
        }
        
        public void update(String username,String score){
            String query = "Update QuizScores set score=? where name = ?";
        
             try{
                    PreparedStatement st = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                    st.setString(1, (""+score));
                    st.setString(2, username);
                    counts = st.executeUpdate();
                    
                 }catch(Exception e){}
             
        }
        
    
}
