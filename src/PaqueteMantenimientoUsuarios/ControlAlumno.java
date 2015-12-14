/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteMantenimientoUsuarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FRANCISCO ZAVALA SILVA
 */
public class ControlAlumno {

    /**
     * Metodo para registrar un alumno a la base de datos
     */
    public void registrar(String matricula, String nombre, String apellidoPaterno, String apellidoMaterno) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //inserccion a la base de datos
        instruccion.executeUpdate("INSERT INTO alumno(matricula,nombre,apellidoPaterno,apellidoMaterno) values('" + matricula + "','" + nombre + "','" + apellidoPaterno + "','" + apellidoMaterno + "') ");

    }

    /**
     * Metodo para regresa matricula, nombre, apellidos de la matricula
     * ingresada del alumno
     */
    public ResultSet consultar(String matricula) throws ClassNotFoundException, SQLException, NumberFormatException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT matricula,nombre,apellidoPaterno,apellidoMaterno  FROM alumno where matricula=" + Integer.parseInt(matricula) + "");
        return conjuntoResultados;
    }

    /**
     * Metodo para modificar a un alumno sus datos personales
     */
    public void modificar(String matricula, String nombre, String apellidoPaterno, String apellidoMaterno) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //inserccion a la base de datos
        instruccion.executeUpdate("UPDATE `alumno` SET `nombre`='" + nombre + "',`apellidoPaterno`='" + apellidoPaterno + "',`apellidoMaterno`='" + apellidoMaterno + "' WHERE `matricula`='" + Integer.parseInt(matricula) + "';");

    }

    /**
     * Metodo para eliminar un alumno a la base de datos
     */
    public void eliminar(String matricula) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //eliminacion a la base de datos
        instruccion.executeUpdate("DELETE FROM `alumno_evaluacion_calificacion` WHERE `matricula`=" + Integer.parseInt(matricula) + ";");
        instruccion.executeUpdate("DELETE FROM grupo_alumno WHERE matricula=" + Integer.parseInt(matricula) + " ;");
        instruccion.executeUpdate("DELETE FROM alumno WHERE matricula=" + Integer.parseInt(matricula) + " ;");
        instruccion.executeUpdate("DELETE FROM usuario WHERE idUsuario=" + Integer.parseInt(matricula) + " ;");

    }

    /**
     * Metodo que regresa una cadena con el total de alumnos registrados
     */
    public String contarTotalAlumnos() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        //busca el total de maestros en la base de datos
        //obtiene el resultado del total de alumnos
        ResultSet resultado = instruccion.executeQuery("select count(*) from alumno");

        //almacena el resultado en una cadena
        String totaldeRenglones = "";
        while (resultado.next()) {
            totaldeRenglones = resultado.getObject(1).toString();
        }

        return totaldeRenglones;
    }

    /**
     * Metodo que regresa la informacion general del alumno registrado
     */
    public ResultSet consultarAlumnoGrupoUsuario() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet conjuntoResultados = instruccion.executeQuery("select alumno.matricula,nombre,apellidoPaterno,apellidoMaterno,grupo_alumno.Grado,grupo.grupo,nombreUsuario,contrasena FROM alumno JOIN grupo_alumno on alumno.matricula=grupo_alumno.matricula JOIN usuario on usuario.idUsuario =alumno.matricula and tipo='ALUMNO' JOIN grupo on grupo_alumno.idGrupo=grupo.idGrupo;");
        return conjuntoResultados;
    }

    /**
     * Metodo para hacer la conexion a la base de datos
     */
    public Statement conectar() throws ClassNotFoundException, SQLException {
        String CONTROLADOR;
        CONTROLADOR = "com.mysql.jdbc.Driver";
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
