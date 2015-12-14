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
public class ControlComentario {

    /**
     * Metodo que regresa un vector con la informacion del comentario en
     * relacion a un reactivo
     */
    public ResultSet[] consultar(String reactivo) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet resultadoidReactivo = instruccion.executeQuery("select idReactivo from reactivo where descripcion='" + reactivo + "';");
        int idReactivo = 0;
        while (resultadoidReactivo.next()) {
            idReactivo = Integer.parseInt(resultadoidReactivo.getObject(1).toString());

        }
        instruccion = conectar();
        ResultSet resultadoReactivo = instruccion.executeQuery("select descripcion,fecha from reactivo_comentario inner join comentario on reactivo_comentario.idComentario=comentario.idComentario and reactivo_comentario.idReactivo=" + idReactivo + " order by reactivo_comentario.idComentario asc;");
        instruccion = conectar();
        ResultSet resultadoEmpleado = instruccion.executeQuery("select  numeroEmpleado from reactivo_comentario join maestro_comentario on maestro_comentario.idComentario=reactivo_comentario.idComentario and reactivo_comentario.idReactivo=" + idReactivo + " order by reactivo_comentario.idComentario asc;");

        ResultSet resultados[] = new ResultSet[2];
        resultados[0] = resultadoReactivo;
        resultados[1] = resultadoEmpleado;
        return resultados;
    }

    /**
     * Metodo para registrar un comentario en la base de datos
     */
    public void registrar(String descripcion, String reactivo, int idUsuario) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();

        if (reactivo.length() > 0) {
            instruccion = conectar();
            instruccion.executeUpdate("INSERT INTO comentario(descripcion,fecha) values('" + descripcion + "',curdate());");

            instruccion = conectar();
            ResultSet resultadosComentario = instruccion.executeQuery("SELECT idComentario  FROM comentario where descripcion='" + descripcion + "';");

            int idComentario = 0;
            try {
                while (resultadosComentario.next()) {
                    idComentario = Integer.parseInt(resultadosComentario.getObject(1).toString());
                }
            } catch (NumberFormatException e) {
            }

            instruccion = conectar();
            ResultSet resultadosReactivo = instruccion.executeQuery("SELECT idReactivo  FROM reactivo where descripcion='" + reactivo + "';");

            int idReactivo = 0;
            try {
                while (resultadosReactivo.next()) {
                    idReactivo = Integer.parseInt(resultadosReactivo.getObject(1).toString());
                }
            } catch (NumberFormatException e) {
            }

            instruccion = conectar();
            instruccion.executeUpdate("INSERT INTO maestro_comentario(numeroEmpleado,idComentario) values('" + idUsuario + "','" + idComentario + "'); ");

            instruccion = conectar();
            instruccion.executeUpdate("INSERT INTO reactivo_comentario(idReactivo,idComentario) values('" + idReactivo + "','" + idComentario + "'); ");

        } else {
            System.out.println("no sepuede insertar");
        }

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
