/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class Conexion {
    
    private Connection conn;

    /**
     * Constructor de DbConnection
     */
    public Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/proyectopsp?&serverTimezone=UTC", "root", "");

        } catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Permite retornar la conexión
     * @return 
     */
    public Connection getConnection() {
        return conn;
    }

    /**
     * Permite desconectarse de la BD
     */
    public void desconectar() {
        conn = null;
    }
    
}
