/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basededatos;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConexionBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        String usuario = "root";
        String password = "M1143237233t";
        String url = "jdbc:mysql://localhost:3306/bd_parking";
        Connection conexion;
        Statement statement;
        ResultSet rs;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try { 
            conexion = DriverManager.getConnection(url,usuario,password);
            statement = conexion.createStatement();
            statement.executeUpdate("INSERT INTO INGRESOPLACA(PLACA,TIPOVEHICULO,TELEFONO)VALUES('AAA','Carro','3000000000')");
            rs = statement.executeQuery("SELECT * FROM INGRESOPLACA");
            rs.next();
            do{
                System.out.println(rs.getInt("idplaca")+":"+rs.getString("placa") +":" +rs.getString("tipovehiculo")+ ":" +rs.getString("telefono"));
            }while(rs.next());
            
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.println("No se encuentra la base de datos: ");
        }
    }
    
}

