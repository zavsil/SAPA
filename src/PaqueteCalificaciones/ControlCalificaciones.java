/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteCalificaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FRANCISCO ZAVALA SILVA
 */
public class ControlCalificaciones {

    /**
     * Metodo para consultar a todos los alumnos que ya han contestado la
     * evaluacion
     */
    public ResultSet consultar(String nombreEvaluacion, int grado, String grupo) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        ResultSet resultadosReactivo = instruccion.executeQuery("select *from alumno natural join(select matricula, calificacion from alumno_evaluacion_calificacion natural join (select matricula from grupo_alumno where grupo_alumno.idGrupo=(select idGrupo from grupo where grado='" + grado + "' and grupo='" + grupo + "'))=r1 where idEvaluacion=(select idEvaluacion from evaluacion where nombre='" + nombreEvaluacion + "'))r2;");
        return resultadosReactivo;
    }

    /**
     * Metodo para registrar la calificacion al alumno que ya ha contestado la
     * evaluacion
     */
    public void registrar(String nombreEvaluacion, int grado, String grupo, float calificacion) throws ClassNotFoundException, SQLException {

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
