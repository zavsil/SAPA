/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteMantenimientodeEvaluaciones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author FRANCISCO ZAVALA SILVA
 */
public class ControlReactivo {

    /**
     * Metodo para registrar un reactivo y sus respuestas
     */
    public void registrar(int idUsuario, String descripcion, String respuestaCorrecta, String respuestaIncorrecta1, String respuestaIncorrecta2, String tema, int grado, int idMateria) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //inserccion a la base de datos
        instruccion.executeUpdate("INSERT INTO reactivo(descripcion,respuestaCorrecta,respuestaIncorrecta1,respuestaIncorrecta2) values('" + descripcion + "','" + respuestaCorrecta + "','" + respuestaIncorrecta1 + "','" + respuestaIncorrecta2 + "'); ");
        instruccion = conectar();

        ResultSet resultadosReactivo = instruccion.executeQuery("SELECT idReactivo  FROM reactivo where descripcion='" + descripcion + "';");

        instruccion = conectar();
        System.out.println("tema: " + tema);
        System.out.println("grado: " + grado);
        ResultSet resultadosTema = instruccion.executeQuery("SELECT idTema  FROM tema where nombre='" + tema + "' AND grado=" + (grado + 2) + ";");

        String idTema = null;
        String idReactivo = null;
        while (resultadosReactivo.next()) {
            idReactivo = resultadosReactivo.getObject(1).toString();
            System.out.println("idReactivo= " + idReactivo);
        }

        while (resultadosTema.next()) {
            idTema = resultadosTema.getObject(1).toString();
            System.out.println("idTema= " + idTema);
        }
        System.out.println("idTema: " + idTema + "idReactivo: " + idReactivo);
        if (Integer.parseInt(idTema) != 0 && Integer.parseInt(idReactivo) != 0 && idUsuario != 0) {
            instruccion = conectar();
            instruccion.executeUpdate("INSERT INTO reactivo_materia_tema(idReactivo,idMateria,idTema) values('" + Integer.parseInt(idReactivo) + "','" + idMateria + "','" + Integer.parseInt(idTema) + "'); ");

            instruccion = conectar();
            instruccion.executeUpdate("INSERT INTO reactivo_tema(idReactivo,idTema) values('" + Integer.parseInt(idReactivo) + "','" + Integer.parseInt(idTema) + "'); ");

            instruccion = conectar();
            instruccion.executeUpdate("INSERT INTO maestro_reactivo(numeroEmpleado,idReactivo) values('" + idUsuario + "','" + Integer.parseInt(idReactivo) + "'); ");

        } else {
            System.out.println("no sepudo insertar");
        }

    }

    /**
     * Metodo para obtener reactivo y sus respuestas conociendo el id del
     * reactivo
     */
    public ResultSet consultar(int idReactivo) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        ResultSet resultado = instruccion.executeQuery("select descripcion,respuestaCorrecta,respuestaIncorrecta1,respuestaIncorrecta2 from reactivo where idReactivo=" + idReactivo + ";");

        return resultado;
    }

    /**
     * Metodo para obtener la puntuacion de los reactivos de la evaluacion
     *
     */
    public ResultSet consultarPuntuacion(int idEvaluacion) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        ResultSet resultado = instruccion.executeQuery("select * from evaluacion_reactivos_puntaje where idEvaluacion_Reactivos_P='" + idEvaluacion + "';");

        return resultado;
    }

    /**
     * Metodo para obtener el total de reactivos existentes en la base de datos
     *
     */
    public String contarTotalReactivosExistentes() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        //busca el total de maestros en la base de datos
        //obtiene el resultado del total de maestros
        ResultSet resultado = instruccion.executeQuery("select count(*) from reactivo");

        //almacena el resultado en una cadena
        String totaldeRenglones = "";
        while (resultado.next()) {
            totaldeRenglones = resultado.getObject(1).toString();
        }

        return totaldeRenglones;
    }

    /**
     * Metodo para obtener el total de reactivos existentes en la base de datos
     * pero que coincidan con la materia, tema y grado
     */
    public String contarTotalReactivos(int materia, int tema) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        //busca el total de maestros en la base de datos
        //obtiene el resultado del total de maestros
        ResultSet resultado = instruccion.executeQuery("select count(*) from reactivo_materia_tema where idMateria='" + materia + "' and idTema='" + tema + "'");

        //almacena el resultado en una cadena
        String totaldeRenglones = "";
        while (resultado.next()) {
            totaldeRenglones = resultado.getObject(1).toString();
        }

        return totaldeRenglones;
    }

    /**
     * Metodo que regresa true si el reactivo y sus respuestas comparadas
     * existen ya en la base de datos y regresa false si no son iguales a las
     * comparadas
     */
    public boolean existeReactivo(String descripcion, String respuestaCorrecta, String respuestaIncorrecta1, String respuestaIncorrecta2) throws SQLException, ClassNotFoundException {
        boolean existe = false;
        Statement instruccion = conectar();

        ResultSet resultadosReactivo = instruccion.executeQuery("SELECT idReactivo  FROM reactivo where descripcion='" + descripcion + "' and respuestaCorrecta='" + respuestaCorrecta + "' and respuestaIncorrecta1='" + respuestaIncorrecta1 + "' and respuestaIncorrecta2='" + respuestaIncorrecta2 + "';");
        while (resultadosReactivo.next()) {
            if (Integer.parseInt(resultadosReactivo.getObject(1).toString()) > 0) {
                existe = true;
            } else {
                existe = false;
            }
        }

        return existe;
    }

    /**
     * Metodo que regresa el id del usuario quien registro el reactivo a buscar
     */
    public int obtenerCreadordelReactivo(String descripcion, String respuestaCorrecta, String respuestaIncorrecta1, String respuestaIncorrecta2) throws SQLException, ClassNotFoundException {
        int idUsuario = 0;

        Statement instruccion = conectar();
        ResultSet resultadoRactivo = instruccion.executeQuery("select maestro_reactivo.numeroEmpleado from maestro_reactivo join reactivo on maestro_reactivo.idReactivo=reactivo.idReactivo where reactivo.descripcion='" + descripcion + "' and reactivo.respuestaCorrecta='" + respuestaCorrecta + "' and reactivo.respuestaIncorrecta1='" + respuestaIncorrecta1 + "' and reactivo.respuestaIncorrecta2='" + respuestaIncorrecta2 + "';");

        while (resultadoRactivo.next()) {
            idUsuario = Integer.parseInt(resultadoRactivo.getObject(1).toString());
        }

        return idUsuario;
    }

    /**
     * Metodo para modificar un reactivo y sus respuestas
     */
    public void modificar(int idUsuario, String descripcion, String respuestaCorrecta, String respuestaIncorrecta1, String respuestaIncorrecta2, String nuevaDescripcion, String nuevaRespuestaCorrecta, String nuevaRespuestaIncorrecta1, String nuevaRespuestaIncorrecta2) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        ResultSet resultadoRactivo = instruccion.executeQuery("select reactivo.idReactivo from reactivo join maestro_reactivo on maestro_reactivo.idReactivo=reactivo.idReactivo where maestro_reactivo.numeroEmpleado='" + idUsuario + "' and reactivo.descripcion='" + descripcion + "' and reactivo.respuestaCorrecta='" + respuestaCorrecta + "' and reactivo.respuestaIncorrecta1='" + respuestaIncorrecta1 + "' and reactivo.respuestaIncorrecta2='" + respuestaIncorrecta2 + "';");

        int idReactivo = 0;
        while (resultadoRactivo.next()) {
            idReactivo = Integer.parseInt(resultadoRactivo.getObject(1).toString());
        }

        //inserccion a la base de datos
        instruccion.executeUpdate("UPDATE `reactivo` SET `descripcion`='" + nuevaDescripcion + "',`respuestaCorrecta`='" + nuevaRespuestaCorrecta + "' ,`respuestaIncorrecta1`='" + nuevaRespuestaIncorrecta1 + "',`respuestaIncorrecta2`='" + nuevaRespuestaIncorrecta2 + "' WHERE `idReactivo`='" + idReactivo + "';");

    }

    /**
     * Metodo para obtener reactivo y sus respuestas conociendo el id de la
     * materia, tema y grado
     */
    public ResultSet consultarReactivos(int materia, String tema, int grado) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet idTema = instruccion.executeQuery("select idTema from tema where grado='" + grado + "' and nombre='" + tema + "';");
        boolean next = idTema.next();
        ResultSet conjuntoResultados = instruccion.executeQuery("select descripcion, respuestaCorrecta,respuestaIncorrecta1,respuestaIncorrecta2 from reactivo inner join reactivo_materia_tema on reactivo_materia_tema.idReactivo=reactivo.idReactivo where reactivo_materia_tema.idMateria='" + materia + "' and reactivo_materia_tema.idTema='" + Integer.parseInt(idTema.getObject(1).toString()) + "'");
        return conjuntoResultados;
    }

    /**
     * Metodo que regresa el id del reactivo
     */
    public int consultarId(String descripcion, String respuestaCorrecta, String respuestaIncorrecta1, String respuestaIncorrecta2) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet conjuntoResultados = instruccion.executeQuery("select idReactivo from reactivo where descripcion='" + descripcion + "' and respuestaCorrecta='" + respuestaCorrecta + "' and respuestaIncorrecta1='" + respuestaIncorrecta1 + "' and respuestaIncorrecta2='" + respuestaIncorrecta2 + "';");
        int idReactivo = -1;
        while (conjuntoResultados.next()) {
            idReactivo = Integer.parseInt(conjuntoResultados.getObject(1).toString());
        }

        return idReactivo;
    }

    /**
     * Metodo para eliminar un reactivo en especifico
     */
    public void eliminar(String descripcion) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //eliminacion a la base de datos
        ResultSet resultadoSelect = instruccion.executeQuery("select idReactivo from reactivo where descripcion='" + descripcion + "';");

        int idReactivo = 0;
        while (resultadoSelect.next()) {
            idReactivo = Integer.parseInt(resultadoSelect.getObject(1).toString());
        }

        instruccion.executeUpdate("delete from reactivo_tema where idReactivo=" + idReactivo + " ");
        instruccion.executeUpdate("delete from reactivo_materia_tema where idReactivo=" + idReactivo + " ");
        instruccion.executeUpdate("delete from reactivo_comentario where idReactivo=" + idReactivo + " ");
        instruccion.executeUpdate("delete from maestro_reactivo where idReactivo=" + idReactivo + " ");
        instruccion.executeUpdate("delete from reactivo where idReactivo=" + idReactivo + " ");

        instruccion = conectar();
        //obtiene el id de los comentarios para poder eliminarlos
        ResultSet resultados = instruccion.executeQuery("select idComentario from reactivo_comentario where idreactivo='" + idReactivo + "';");

        while (resultados.next()) {
            instruccion.executeUpdate("delete from maestro_comentario where idComentario=" + Integer.parseInt(resultados.getObject(1).toString()) + " ");
            instruccion.executeUpdate("delete from comentario where idComentario=" + Integer.parseInt(resultados.getObject(1).toString()) + " ");
        }

        //cuenta el total de evaluaciones para asignar null a la evaluacion donde exista el reactivo a eliminar.
        ResultSet resultado = instruccion.executeQuery("select count(*) from evaluacion_reactivos;");
        //almacena el resultado en una cadena
        String totaldeEvaluaciones = "";
        while (resultado.next()) {
            totaldeEvaluaciones = resultado.getObject(1).toString();
        }

        try {
            instruccion = conectar();
            ResultSet consultarResultados = instruccion.executeQuery("SELECT * FROM evaluacion_reactivos;");

            while (consultarResultados.next()) {
                for (int i = 0; i < Integer.parseInt(totaldeEvaluaciones); i++) {

                    // if (Integer.parseInt(resultados.getObject((i+2)).toString()) == idReactivo) {
                    String modificar = "idReactivo" + (i + 1);
                    instruccion.executeUpdate("UPDATE `evaluacion_reactivos` SET `" + modificar + "`='0'  WHERE `" + modificar + "`='" + idReactivo + "';");

                    //}
                }

            }
        } catch (SQLException e) {
            System.out.println("no existe en ninguna evaluacion");
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

    /**
     * Metodo para obtener el total de reactivos existentes en la base de datos
     * pero que coincidan con la materia, tema y grado
     */
    public String contarTotalReactivos(int materia, String tema, int grado) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        ResultSet resultados = instruccion.executeQuery("select idTema from tema where nombre='" + tema + "' and grado='" + grado + "';");
        int idTema = 0;
        while (resultados.next()) {
            idTema = Integer.parseInt(resultados.getObject(1).toString());
        }
        System.out.println("tema: " + tema + " grado: " + grado + " Materia: " + materia + " Idtema: " + idTema);
        //busca el total de maestros en la base de datos
        //obtiene el resultado del total de maestros
        ResultSet resultado = instruccion.executeQuery("select count(*) from reactivo_materia_tema where idMateria='" + materia + "' and idTema='" + idTema + "';");

        //almacena el resultado en una cadena
        String totaldeRenglones = "";
        while (resultado.next()) {
            totaldeRenglones = resultado.getObject(1).toString();
        }

        return totaldeRenglones;
    }

    /**
     * Metodo para registrar un reactivo y sus respuestas
     */
    public void registrar(String descripcion, String respuestaCorrecta, String respuestaIncorrecta1, String respuestaIncorrecta2, String tema, int grado, int idMateria) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        //inserccion a la base de datos
        instruccion.executeUpdate("INSERT INTO reactivo(descripcion,respuestaCorrecta,respuestaIncorrecta1,respuestaIncorrecta2) values('" + descripcion + "','" + respuestaCorrecta + "','" + respuestaIncorrecta1 + "','" + respuestaIncorrecta2 + "'); ");
        instruccion = conectar();

        ResultSet resultadosReactivo = instruccion.executeQuery("SELECT idReactivo  FROM reactivo where descripcion='" + descripcion + "';");

        instruccion = conectar();
        System.out.println("tema: " + tema);
        System.out.println("grado: " + grado);
        ResultSet resultadosTema = instruccion.executeQuery("SELECT idTema  FROM tema where nombre='" + tema + "' AND grado=" + (grado + 2) + ";");

        String idTema = null;
        String idReactivo = null;
        while (resultadosReactivo.next()) {
            idReactivo = resultadosReactivo.getObject(1).toString();
            System.out.println("idReactivo= " + idReactivo);
        }

        while (resultadosTema.next()) {
            idTema = resultadosTema.getObject(1).toString();
            System.out.println("idTema= " + idTema);
        }
        System.out.println("idTema: " + idTema + "idReactivo: " + idReactivo);
        if (Integer.parseInt(idTema) != 0 && Integer.parseInt(idReactivo) != 0) {
            instruccion = conectar();
            instruccion.executeUpdate("INSERT INTO reactivo_materia_tema(idReactivo,idMateria,idTema) values('" + Integer.parseInt(idReactivo) + "','" + idMateria + "','" + Integer.parseInt(idTema) + "') ");

            instruccion = conectar();
            instruccion.executeUpdate("INSERT INTO reactivo_tema(idReactivo,idTema) values('" + Integer.parseInt(idReactivo) + "','" + Integer.parseInt(idTema) + "') ");

        } else {
            System.out.println("no sepudo insertar");
        }

    }

}
