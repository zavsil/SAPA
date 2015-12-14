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
public class ControlMaestro {

    /**
     * Metodo para modificar un maestro a la base de datos
     */
    public void modificar(String numeroEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //inserccion a la base de datos
        instruccion.executeUpdate("UPDATE `maestro` SET `nombre`='" + nombre + "',`apellidoPaterno`='" + apellidoPaterno + "',`apellidoMaterno`='" + apellidoMaterno + "' WHERE `numeroEmpleado`='" + Integer.parseInt(numeroEmpleado) + "';");

    }

    /**
     * Metodo para registrar un maestro a la base de datos
     */
    public void registrar(String numeroEmpleado, String nombre, String apellidoPaterno, String apellidoMaterno) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //inserccion a la base de datos
        instruccion.executeUpdate("INSERT INTO Maestro(numeroEmpleado,nombre,apellidoPaterno,apellidoMaterno) values('" + numeroEmpleado + "','" + nombre + "','" + apellidoPaterno + "','" + apellidoMaterno + "') ");

    }

    /**
     * Metodo para regresa numero de empleado, nombre, apellidos del maestro a
     * buscar
     */
    public ResultSet consultar(String numeroEmpleado) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT numeroEmpleado,nombre,apellidoPaterno,apellidoMaterno  FROM maestro where numeroEmpleado=" + Integer.parseInt(numeroEmpleado) + "");
        return conjuntoResultados;
    }

    /**
     * Metodo para regresa numero de empleado, nombre, apellidos de los maestros
     */
    public ResultSet consultaGeneral() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet conjuntoResultados = instruccion.executeQuery("SELECT *  FROM maestro;");
        return conjuntoResultados;
    }

    /**
     * Metodo que regresa la informacion general del maestro registrado
     */
    public ResultSet consultarMaestroGrupoUsuario() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet conjuntoResultados = instruccion.executeQuery("select maestro.numeroEmpleado,nombre,apellidoPaterno,apellidoMaterno,grupo_maestro.Grado,grupo.grupo,nombreUsuario,contrasena FROM maestro JOIN grupo_maestro on maestro.numeroEmpleado=grupo_maestro.numeroEmpleado JOIN usuario on usuario.idUsuario =maestro.numeroEmpleado and tipo='MAESTRO'JOIN grupo on grupo_maestro.idGrupo=grupo.idGrupo;");
        return conjuntoResultados;
    }

    /**
     * Metodo para eliminar un maestro a la base de datos
     */
    public void eliminar(String numeroEmpleado) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //eliminacion a la base de datos
        instruccion.executeUpdate("DELETE FROM grupo_maestro WHERE numeroEmpleado=" + Integer.parseInt(numeroEmpleado) + "; ");
        instruccion.executeUpdate("UPDATE `maestro_evaluacion` SET `numeroEmpleado`='777777' WHERE `numeroEmpleado`=" + Integer.parseInt(numeroEmpleado) + ";");
        instruccion.executeUpdate("UPDATE `maestro_reactivo` SET `numeroEmpleado`='777777' WHERE `numeroEmpleado`=" + Integer.parseInt(numeroEmpleado) + ";");
        instruccion.executeUpdate("UPDATE `maestro_comentario` SET `numeroEmpleado`='777777' WHERE `numeroEmpleado`=" + Integer.parseInt(numeroEmpleado) + ";");

        instruccion.executeUpdate("DELETE FROM Maestro WHERE numeroEmpleado=" + Integer.parseInt(numeroEmpleado) + "; ");
        instruccion.executeUpdate("DELETE FROM usuario WHERE idUsuario=" + Integer.parseInt(numeroEmpleado) + "; ");

    }

    /**
     * Metodo que regresa una cadena con el total de maestros registrados
     */
    public String contarTotalMaestros() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        //busca el total de maestros en la base de datos
        //obtiene el resultado del total de maestros
        ResultSet resultado = instruccion.executeQuery("select count(*) from maestro");

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

        //crea objetos Statement para consultar la base de datos
        instruccion = conexion.createStatement();
        return instruccion;
    }

}
