/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteMantenimientodeReactivos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FRANCISCO ZAVALA SILVA
 */
public class ControlTema {

    /**
     * Metodo que regresa el nombre del tema a partir del id de la materia y el
     * grado
     */
    public ResultSet consultarTemas(int idMateria, int grado) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT nombre  FROM tema inner join materia_tema on materia_tema.idTema=tema.idTema and materia_tema.idMateria=" + idMateria + " AND tema.grado='" + grado + "'");
        return conjuntoResultados;
    }

    /**
     * Metodo para hacer la conexion a la base de datos
     */
    public Statement conectar() throws ClassNotFoundException, SQLException {
        //nombre del controlador JDBC y URL de la base de datos
        String CONTROLADOR = "com.mysql.jdbc.Driver";
        String URL_BASEDATOS = "jdbc:mysql://localhost/proy_sapa";
        Connection conexion = null;//maneja la conexion
        Statement instruccion = null;//instruccion de consulta
        Class.forName(CONTROLADOR);

        //establece la conexion con la base de datos
        conexion = DriverManager.getConnection(URL_BASEDATOS, "root", "8129");

        //crea objetos Statement para consultar la base de datos
        instruccion = conexion.createStatement();
        return instruccion;
    }

}
