/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FRANCISCO ZAVALA SILVA
 */
public class ControlUsuario {

    /**
     * Metodo regresa el nombre y apellido del usuario al que se busca
     */
    public ResultSet consultarNombreUsuario(String nombreUsuario) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT nombreUsuario  FROM usuario where nombreUsuario='" + nombreUsuario + "'");
        return conjuntoResultados;
    }

    /**
     * Metodo registra a usuario tipo maestro
     */
    public void registrarUsuarioMaestro(String idUsuario, String nombreUsuario, String contraseña) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //inserccion a la base de datos
        instruccion.executeUpdate("INSERT INTO usuario(idUsuario,tipo,nombreUsuario,contraseña) values('" + Integer.parseInt(idUsuario) + "','MAESTRO ','" + nombreUsuario + "','" + contraseña + "') ");

    }

    /**
     * Metodo modifica a usuario tipo maestro 
     */
    public void modificarUsuarioMaestro(String idUsuario, String nombreUsuario, String contraseña) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //inserccion a la base de datos
        instruccion.executeUpdate("UPDATE `usuario` SET `nombreUsuario`='" + nombreUsuario + "',`contraseña`='" + contraseña + "' WHERE `idUsuario`='" + Integer.parseInt(idUsuario) + "'");

    }

    /**
     * Metodo que envia el todo sobre lo que contiene la tabla usuario
     */
    public ResultSet consultarGeneral() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT *  FROM usuario;");
        return conjuntoResultados;
    }

    /**
     * Metodo que envia el nombre de usuario y contraseña que coincida con el id
     * del usuario
     */
    public ResultSet consultarDatosUsuario(String idUsuario) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT nombreUsuario,contraseña  FROM usuario where idUsuario=" + Integer.parseInt(idUsuario) + "");
        return conjuntoResultados;
    }

    /**
     * Metodo que envia el nombre de usuario y contraseña que coincida con el id
     * del usuario y tipo dado
     */
    public ResultSet consultar(String idUsuario, String tipo) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT nombreUsuario,contraseña  FROM usuario where idUsuario=" + Integer.parseInt(idUsuario) + " AND tipo='" + tipo + "'");
        return conjuntoResultados;
    }

    /**
     * Metodo que elimina a un usuario especifico registrado en la base de datos
     */
    public void eliminar(String idUsuario) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //eliminacion a la base de datos
        instruccion.executeUpdate("DELETE FROM usuario WHERE idUsuario=" + Integer.parseInt(idUsuario) + " ");

    }

    /**
     * Metodo que regresa una cadena con el total de usuarios registrados en la
     * base de datos
     */
    public String contarTotalUsuarios() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        //busca el total de maestros en la base de datos
        //obtiene el resultado del total de maestros
        ResultSet resultado = instruccion.executeQuery("select count(*) from usuario");

        //almacena el resultado en una cadena
        String totaldeRenglones = "";
        while (resultado.next()) {
            totaldeRenglones = resultado.getObject(1).toString();
        }

        return totaldeRenglones;
    }

    /**
     * Metodo que envia una cadena con el nombre completo del usuario
     */
    public String consultarNombreCompleto(int idUsuario, String tipoUsuario) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        String nombreCompleto = "";
        if (tipoUsuario.compareTo("ALUMNO") == 1) {
            ResultSet conjuntoResultados = instruccion.executeQuery("SELECT *  FROM alumno where matricula=" + idUsuario + ";");
            while (conjuntoResultados.next()) {
                nombreCompleto = conjuntoResultados.getObject(2).toString() + " " + conjuntoResultados.getObject(3).toString() + " " + conjuntoResultados.getObject(4).toString();
            }

        } else if (tipoUsuario.compareTo("MAESTRO") == 1) {
            ResultSet conjuntoResultados = instruccion.executeQuery("select * from maestro where numeroEmpleado=" + idUsuario + ";");
            while (conjuntoResultados.next()) {
                nombreCompleto = conjuntoResultados.getObject(2).toString() + " " + conjuntoResultados.getObject(3).toString() + " " + conjuntoResultados.getObject(4).toString();
            }
        }
        return nombreCompleto;
    }

    /**
     * Metodo que registra a un usuario tipo alumno
     */
    public void registrarUsuarioAlumno(String idUsuario, String nombreUsuario, String contraseña) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //inserccion a la base de datos
        instruccion.executeUpdate("INSERT INTO usuario(idUsuario,tipo,nombreUsuario,contraseña) values('" + Integer.parseInt(idUsuario) + "','ALUMNO ','" + nombreUsuario + "','" + contraseña + "') ");

    }

    /**
     * Metodo que modifica a un usuario tipo alumno
     */
    public void modificarUsuarioAlumno(String idUsuario, String nombreUsuario, String contraseña) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //inserccion a la base de datos
        instruccion.executeUpdate("UPDATE `usuario` SET `nombreUsuario`='" + nombreUsuario + "',`contraseña`='" + contraseña + "' WHERE `idUsuario`='" + Integer.parseInt(idUsuario) + "'");

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
