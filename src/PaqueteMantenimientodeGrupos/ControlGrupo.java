/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteMantenimientodeGrupos;

import PaqueteMantenimientoUsuarios.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FRANCISCO ZAVALA SILVA
 */
public class ControlGrupo {

    /**
     * Metodo que permite registrar un maestro a un grupo en especifico
     */
    public void registrarGrupo(int grado, String grupo) throws SQLException, ClassNotFoundException {

        Statement instruccion = conectar();

        //inserccion a la base de datos
        instruccion.executeUpdate("INSERT INTO grupo(grado,grupo) values('" + grado + "','" + grupo + "'); ");

    }

    void eliminarGrupo(int grado, String grupo) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();

        ResultSet resultado = instruccion.executeQuery("SELECT idGrupo from grupo where grado=" + grado + " and grupo='" + grupo + "';");
        int idGrupo = 0;
        while (resultado.next()) {
            idGrupo = Integer.parseInt(resultado.getObject(1).toString());
        }

        //eliminación a la base de datos
        instruccion.executeUpdate("DELETE FROM grupo WHERE idGrupo=" + idGrupo + "; ");
    }

    /**
     * Metodo que regresa los grupos existentes
     */
    public ResultSet obtenerGrupos() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        //busca el total de maestros en la base de datos
        //obtiene el resultado del total de maestros
        ResultSet resultado = instruccion.executeQuery("select grado,grupo from grupo");
        return resultado;
    }

    /**
     * Metodo que regresa los grupos existentes
     */
    public ResultSet obtenerGrupos(int grado) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        ResultSet resultado = instruccion.executeQuery("select grupo from grupo where grado='" + grado + "';");
        return resultado;
    }

    /**
     * Metodo que permite modificar el grupo de un maestro en especifico
     */
    public void modificarGrupoMaestro(int grado, int grupo, String numeroEmpleado) throws SQLException, ClassNotFoundException {
        String[] grados = {"3", "4", "5", "6"};
        String[] grupos = {"A", "B", "C"};
        Statement instruccion = conectar();
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT idGrupo FROM grupo where grado='" + grados[grado - 1] + "'and grupo='" + grupos[grupo - 1] + "'; ");

        int idGrupo = 0;
        while (conjuntoResultados.next()) {
            idGrupo = Integer.parseInt(conjuntoResultados.getObject(1).toString());
        }

        //inserccion a la base de datos
        instruccion.executeUpdate("UPDATE `grupo_maestro` SET `grado`='" + grados[grado - 1] + "',`idGrupo`='" + idGrupo + "' WHERE `numeroEmpleado`='" + Integer.parseInt(numeroEmpleado) + "';");

    }

    /**
     * Metodo que permite modificar el grupo de un alumno en especifico
     */
    public void modificarGrupoAlumno(int grado, int grupo, String matricula) throws SQLException, ClassNotFoundException {
        String[] grados = {"3", "4", "5", "6"};
        String[] grupos = {"A", "B", "C"};
        Statement instruccion = conectar();
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT idGrupo FROM grupo where grado='" + grados[grado - 1] + "'and grupo='" + grupos[grupo - 1] + "'; ");

        int idGrupo = 0;
        while (conjuntoResultados.next()) {
            idGrupo = Integer.parseInt(conjuntoResultados.getObject(1).toString());
        }
        //inserccion a la base de datos
        instruccion.executeUpdate("UPDATE `grupo_alumno` SET `grado`='" + grados[grado - 1] + "',`idGrupo`='" + idGrupo + "' WHERE `matricula`='" + Integer.parseInt(matricula) + "';");

    }

    /**
     * Metodo que permite consultar el grupo de un maestro en especifico
     */
    public ResultSet consultarGrupodeMaestro(String numeroEmpleado) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos

        ResultSet resultado = instruccion.executeQuery("SELECT idGrupo from grupo_maestro where numeroEmpleado=" + Integer.parseInt(numeroEmpleado) + ";");
        int idGrupo = 0;
        while (resultado.next()) {
            idGrupo = Integer.parseInt(resultado.getObject(1).toString());
        }

        instruccion = conectar();
        ResultSet conjuntoResultados = instruccion.executeQuery("select grado, grupo from grupo where idGrupo=" + idGrupo + ";");
        return conjuntoResultados;
    }

    /**
     * Metodo que permite consultar el grupo de un alumno en especifico
     */
    public ResultSet consultarGrupodeAlumno(String matricula) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet resultado = instruccion.executeQuery("SELECT idGrupo from grupo_alumno where matricula=" + Integer.parseInt(matricula) + ";");
        int idGrupo = 0;
        while (resultado.next()) {
            idGrupo = Integer.parseInt(resultado.getObject(1).toString());
        }

        instruccion = conectar();

        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT grado,grupo  FROM grupo where idGrupo=" + idGrupo + ";");
        return conjuntoResultados;
    }

    /**
     * Metodo que permite eliminar un maestro de un grupo en especifico
     */
    public void eliminarMaestrodelGrupo(String numeroEmpleado) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //eliminacion a la base de datos
        instruccion.executeUpdate("DELETE FROM grupo_maestro WHERE numeroEmpleado=" + Integer.parseInt(numeroEmpleado) + "; ");

    }

    /**
     * Metodo que permite eliminar un alumno de un grupo en especifico
     */
    public void eliminarAlumnodelGrupo(String matricula) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //eliminacion a la base de datos
        instruccion.executeUpdate("DELETE FROM grupo_alumno WHERE matricula=" + Integer.parseInt(matricula) + "; ");

    }

    /**
     * Metodo que permite registrar un maestro a un grupo en especifico
     */
    public void registrarMaestroalGrupo(int grado, String grupo, String numeroEmpleado) throws SQLException, ClassNotFoundException {
       
        Statement instruccion = conectar();
        //registro de usuario
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT idGrupo FROM grupo where grado='" + grado + "'and grupo='" + grupo+ "'; ");

        int idGrupo = 0;
        while (conjuntoResultados.next()) {
            idGrupo = Integer.parseInt(conjuntoResultados.getObject(1).toString());
        }
        instruccion = conectar();
        //inserccion a la base de datos
        instruccion.executeUpdate("INSERT INTO grupo_maestro(grado,idGrupo,numeroEmpleado) values('" + grado + "','" + idGrupo + "','" + Integer.parseInt(numeroEmpleado) + "') ");

    }

    /**
     * Metodo que permite registrar un alumno a un grupo en especifico
     */
    public void registrarAlumnoalGrupo(int grado, String grupo, String matricula) throws SQLException, ClassNotFoundException {
       
        Statement instruccion = conectar();

        //registro de usuario
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT idGrupo FROM grupo where grado='" + grado + "'and grupo='" + grupo + "'; ");

        int idGrupo = 0;
        while (conjuntoResultados.next()) {
            idGrupo = Integer.parseInt(conjuntoResultados.getObject(1).toString());
        }
        instruccion = conectar();

        //inserccion a la base de datos
        instruccion.executeUpdate("INSERT INTO grupo_alumno(grado,idGrupo,matricula) values('" + grado + "','" + idGrupo + "','" + Integer.parseInt(matricula) + "') ");

    }

    /**
     * Metodo que regresa una cadena con el total de grupos existentes
     */
    public String contarTotalGrupos() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        //busca el total de maestros en la base de datos
        //obtiene el resultado del total de maestros
        ResultSet resultado = instruccion.executeQuery("select count(*) from grupo");

        //almacena el resultado en una cadena
        String totaldeRenglones = "";
        while (resultado.next()) {
            totaldeRenglones = resultado.getObject(1).toString();
        }

        return totaldeRenglones;
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

        //crea objetos Statement para consultarGrupodeMaestro la base de datos
        instruccion = conexion.createStatement();
        return instruccion;
    }

}
