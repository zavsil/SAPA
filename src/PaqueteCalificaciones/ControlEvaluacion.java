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
public class ControlEvaluacion {

    /**
     * Metodo que registra la evalaución en la base de datos
     */
    public void registrar(int idUsuario, int totalReactivos[], int idMateria, String nombreMateria, int grado, float puntaje[]) throws SQLException, ClassNotFoundException {

        //alistando la conexion a la base de datos
        Statement instruccion = conectar();

        //inserccion a la base de datos
        instruccion.executeUpdate("INSERT INTO evaluacion_reactivos (idReactivo1,idReactivo2,idReactivo3,idReactivo4,idReactivo5,idReactivo6,idReactivo7,idReactivo8,idReactivo9,idReactivo10,idReactivo11,idReactivo12,idReactivo13,idReactivo14,idReactivo15,idReactivo16,idReactivo17,idReactivo18,idReactivo19,idReactivo20) VALUES ('" + totalReactivos[0] + "','" + totalReactivos[1] + "', '" + totalReactivos[2] + "','" + totalReactivos[3] + "', '" + totalReactivos[4] + "','" + totalReactivos[5] + "', '" + totalReactivos[6] + "','" + totalReactivos[7] + "', '" + totalReactivos[8] + "','" + totalReactivos[9] + "', '" + totalReactivos[10] + "','" + totalReactivos[11] + "', '" + totalReactivos[12] + "','" + totalReactivos[13] + "', '" + totalReactivos[14] + "','" + totalReactivos[15] + "', '" + totalReactivos[16] + "','" + totalReactivos[17] + "', '" + totalReactivos[18] + "','" + totalReactivos[19] + "');");
        instruccion = conectar();
        ResultSet resultadosReactivo = instruccion.executeQuery("select idReactivosRelacionados from evaluacion_reactivos where idReactivo1='" + totalReactivos[0] + "' and idReactivo2='" + totalReactivos[1] + "' and idReactivo3='" + totalReactivos[2] + "' and idReactivo4='" + totalReactivos[3] + "' and idReactivo5='" + totalReactivos[4] + "' and idReactivo6='" + totalReactivos[5] + "' and idReactivo7='" + totalReactivos[6] + "' and idReactivo8='" + totalReactivos[7] + "' and idReactivo9='" + totalReactivos[8] + "' and idReactivo10='" + totalReactivos[9] + "' and idReactivo11='" + totalReactivos[10] + "' and idReactivo12='" + totalReactivos[11] + "' and idReactivo13='" + totalReactivos[12] + "' and idReactivo14='" + totalReactivos[13] + "' and idReactivo15='" + totalReactivos[14] + "' and idReactivo16='" + totalReactivos[15] + "' and idReactivo17='" + totalReactivos[16] + "' and idReactivo18='" + totalReactivos[17] + "' and idReactivo19='" + totalReactivos[18] + "' and idReactivo20='" + totalReactivos[19] + "';");
        int idEvaluacion = -1;
        while (resultadosReactivo.next()) {
            idEvaluacion = Integer.parseInt(resultadosReactivo.getObject(1).toString());
        }

        //contar cuantos reactivos se han ingresado
        int contadorReactivos = 0;
        for (int i = 0; i < totalReactivos.length; i++) {
            if (totalReactivos[i] != 0) {
                contadorReactivos++;
            }
        }
        System.out.println("IDEVALUACION:" + idEvaluacion);
        if (idEvaluacion != -1) {

            //generando el nombre de la evaluacion
            String nombre = nombreMateria + "-" + grado + "Grado-Evaluacion-" + idEvaluacion + "-Reactivos-" + contadorReactivos;

            //alistando la conexion a la base de datos
            instruccion = conectar();
            //inserccion a la base de datos
            instruccion.executeUpdate("INSERT INTO evaluacion (idEvaluacion,nombre,idMateria,grado,totalReactivos,idReactivosRelacionados,fechadeCreacion) VALUES ( '" + idEvaluacion + "','" + nombre + "','" + idMateria + "', '" + grado + "','" + contadorReactivos + "', '" + idEvaluacion + "',curdate());");

            instruccion = conectar();
            ResultSet resultadoEvaluacion = instruccion.executeQuery("select idEvaluacion from evaluacion where nombre='" + nombre + "';");

            int idEvaluacionObtenida = 0;
            while (resultadoEvaluacion.next()) {
                idEvaluacionObtenida = Integer.parseInt(resultadoEvaluacion.getObject(1).toString());
            }

            //alistando la conexion a la base de datos
            instruccion = conectar();
            //inserccion a la base de datos
            instruccion.executeUpdate("INSERT INTO evaluacion_reactivos_puntaje (idEvaluacion_Reactivos_P,puntuaje1,puntuaje2,puntuaje3,puntuaje4,puntuaje5,puntuaje6,puntuaje7,puntuaje8,puntuaje9,puntuaje10,puntuaje11,puntuaje12,puntuaje13,puntuaje14,puntuaje15,puntuaje16,puntuaje17,puntuaje18,puntuaje19,puntuaje20) VALUES ('" + puntaje[0] + "','" + puntaje[1] + "','" + puntaje[2] + "','" + puntaje[3] + "','" + puntaje[4] + "','" + puntaje[5] + "','" + puntaje[6] + "','" + puntaje[7] + "','" + puntaje[8] + "','" + puntaje[9] + "','" + puntaje[10] + "','" + puntaje[11] + "','" + puntaje[12] + "','" + puntaje[13] + "','" + puntaje[14] + "','" + puntaje[15] + "','" + puntaje[16] + "','" + puntaje[17] + "','" + puntaje[18] + "','" + puntaje[19] + "');");

            //alistando la conexion a la base de datos
            instruccion = conectar();
            //inserccion a la base de datos
            instruccion.executeUpdate("INSERT INTO maestro_evaluacion (numeroEmpleado,idEvaluacion) VALUES ('" + idUsuario + "','" + idEvaluacionObtenida + "');");

        } else {
            System.out.println("no se pudo insertar");
        }
    }

    /**
     * Metodo que aplica la evaluación en la base de datos para poder ser
     * realizada
     */
    public void aplicarEvaluacion(int idEvaluacion, int grado, String grupo, int materia) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        //inserccion a la base de datos
        instruccion.executeUpdate("INSERT INTO evaluacion_grupo (idEvaluacion,grado,grupo,materia) VALUES ('" + idEvaluacion + "', '" + grado + "', '" + grupo + "', '" + materia + "');");
    }

    /**
     * Metodo que devuelve el nombre de la evalaución y el id de los reactivos a
     * los que esta relacionados a través del id de la materia(1,2) y el grado
     */
    public ResultSet consultarNombreEvaluacion(int idMateria, int grado) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        ResultSet resultadosReactivo = instruccion.executeQuery("select nombre,idReactivosRelacionados from evaluacion where idMateria='" + idMateria + "' and grado='" + grado + "';");
        return resultadosReactivo;
    }

    /**
     * Metodo que devuelve el nombre de la evalaución a través del id de la
     * materia(1,2) del grupo y el grado
     */
    public ResultSet consultarNombre(int idMateria, String grupo, int grado) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        ResultSet resultadosReactivo = instruccion.executeQuery("select nombre from evaluacion natural join (select idEvaluacion from evaluacion_grupo where idGrupo=(select idGrupo from grupo where grado='" + grado + "' and grupo='" + grupo + "'))r where idMateria='" + idMateria + "';");
        return resultadosReactivo;
    }

    /**
     * Metodo que devuelve el id de la evalaución a través del nombre de la
     * evalaución
     */
    public ResultSet consultarIdEvaluacion(String nombre) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        ResultSet resultadosReactivo = instruccion.executeQuery("select idEvaluacion from evaluacion where nombre='" + nombre + "';");
        return resultadosReactivo;
    }

    /**
     * Metodo que devuelve el id de la evalaución a través del nombre de la
     * evalaución
     */
    public ResultSet consultarIdMateriadeEvaluacion(String nombre) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        ResultSet resultadosReactivo = instruccion.executeQuery("select idMateria from materia where nombre='" + nombre + "';");
        return resultadosReactivo;
    }

    /**
     * Metodo que regresa un numero indicando el total de evalauciones
     * existentes relacionadas a una materia y grado
     */
    public int contarEvaluaciones(int idMateria, int grado) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        ResultSet resultadosReactivo = instruccion.executeQuery("select count(*) from evaluacion where idMateria='" + idMateria + "' and grado='" + grado + "';");
        int totaEevaluaciones = 0;
        while (resultadosReactivo.next()) {
            totaEevaluaciones = Integer.parseInt(resultadosReactivo.getObject(1).toString());
        }

        return totaEevaluaciones;
    }

    /**
     * Metodo que regresa el contenido de la evaluacion indicada
     */
    public ResultSet consultarContenido(String nombreReactivo) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        ResultSet resultadosReactivo = instruccion.executeQuery("select * from evaluacion inner join evaluacion_reactivos  on evaluacion.idReactivosRelacionados=evaluacion_reactivos.idReactivosRelacionados and evaluacion.nombre='" + nombreReactivo + "';");
        return resultadosReactivo;
    }

    /**
     * Metodo que regresa el contenido de la evaluacion indicada
     */
    public ResultSet consultarDatosyContenido(String nombreEvaluacion) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        ResultSet resultadosReactivo = instruccion.executeQuery("select * from evaluacion inner join evaluacion_reactivos  on evaluacion.idReactivosRelacionados=evaluacion_reactivos.idReactivosRelacionados and evaluacion.nombre='" + nombreEvaluacion + "';");
        return resultadosReactivo;
    }

    /**
     * Metodo que califica la evaluacion realizada
     */
    public void calificar(int matricula, int idEvaluacion, float calificacion) throws SQLException, ClassNotFoundException {
        //alistando la conexion a la base de datos
        Statement instruccion = conectar();
        instruccion.executeUpdate("INSERT INTO alumno_evaluacion_calificacion (matricula, idEvaluacion, calificacion) VALUES ('" + matricula + "', '" + idEvaluacion + "', '" + calificacion + "');");

    }

  
    /**
     * Metodo que devuelve true si la evaluacion ya se ha contestado por parte
     * de un alumno en especifico y regresa false si no ha contestado la
     * evaluacion el mismo alumno
     */
    public boolean consultarDisponibilidad(int matricula, String nombreEvaluacion) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();
        ResultSet resultado = instruccion.executeQuery("select idEvaluacion from evaluacion where nombre='" + nombreEvaluacion + "';");
        int idEvaluacion = 0;
        while (resultado.next()) {
            idEvaluacion = Integer.parseInt(resultado.getObject(1).toString());
        }
        instruccion = conectar();
        ResultSet resultados = instruccion.executeQuery("select matricula from alumno_evaluacion_calificacion where idEvaluacion='" + idEvaluacion + "';");
        boolean existe = false;
        while (resultados.next()) {
            if (Integer.parseInt(resultados.getObject(1).toString()) == matricula) {
                existe = true;
            } else {
                existe = false;
            }

        }
        return existe;
    }

    /**
     * Metodo que modifica la evaluacion indicada
     */
    void modificar(String nombreEvaluacion, int[] reactivosdeEvaluacion, String materia, int grado, float puntaje[]) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //se solicita el id que relaciona a la evaluacion con su contenido
        ResultSet resultado = instruccion.executeQuery("select idReactivosRelacionados from evaluacion where nombre='" + nombreEvaluacion + "';");
        int idReactivosEvaluacion = 0;
        while (resultado.next()) {
            idReactivosEvaluacion = Integer.parseInt(resultado.getObject(1).toString());
        }

        //contar cuantos reactivos se han ingresado en total
        int contadorReactivos = 0;
        for (int i = 0; i < reactivosdeEvaluacion.length; i++) {
            if (reactivosdeEvaluacion[i] != 0) {
                contadorReactivos++;
            }
        }

        //generando el nombre de la evaluacion
        String nombre = materia + "-" + grado + "Grado-Evaluacion-" + idReactivosEvaluacion + "-Reactivos-" + contadorReactivos;

        //modifica el total de reactivos
        instruccion.executeUpdate("UPDATE `evaluacion` SET `totalReactivos`='" + contadorReactivos + "' WHERE `idReactivosRelacionados`='" + idReactivosEvaluacion + "';");
        //modifica los reactivos
        instruccion.executeUpdate("UPDATE `evaluacion_reactivos` SET `idReactivo1`=" + reactivosdeEvaluacion[0] + ",`idReactivo2`=" + reactivosdeEvaluacion[1] + ",`idReactivo3`=" + reactivosdeEvaluacion[2] + ",`idReactivo4`=" + reactivosdeEvaluacion[3] + ",`idReactivo5`=" + reactivosdeEvaluacion[4] + ",`idReactivo6`=" + reactivosdeEvaluacion[5] + ",`idReactivo7`=" + reactivosdeEvaluacion[6] + ",`idReactivo8`=" + reactivosdeEvaluacion[7] + ",`idReactivo9`=" + reactivosdeEvaluacion[8] + ",`idReactivo10`=" + reactivosdeEvaluacion[9] + ",`idReactivo11`=" + reactivosdeEvaluacion[10] + ",`idReactivo12`=" + reactivosdeEvaluacion[11] + ",`idReactivo13`=" + reactivosdeEvaluacion[12] + ",`idReactivo14`=" + reactivosdeEvaluacion[13] + ",`idReactivo15`=" + reactivosdeEvaluacion[14] + ",`idReactivo16`=" + reactivosdeEvaluacion[15] + ",`idReactivo17`=" + reactivosdeEvaluacion[16] + ",`idReactivo18`=" + reactivosdeEvaluacion[17] + ",`idReactivo19`=" + reactivosdeEvaluacion[18] + ",`idReactivo20`=" + reactivosdeEvaluacion[19] + " WHERE `idReactivosRelacionados`='" + idReactivosEvaluacion + "';");
        //modifica el nombre de la evaluacion
        instruccion.executeUpdate(" UPDATE `evaluacion` SET `nombre`='" + nombre + "' WHERE `idEvaluacion`='" + idReactivosEvaluacion + "';");
        //modifica la puntuacion
        instruccion.executeUpdate("UPDATE `evaluacion_reactivos_puntaje` SET `puntuaje1`=" + puntaje[0] + ",`puntuaje2`=" + puntaje[1] + ",`puntuaje3`=" + puntaje[2] + ",`puntuaje4`=" + puntaje[3] + ",`puntuaje5`=" + puntaje[4] + ",`puntuaje6`=" + puntaje[5] + ",`puntuaje7`=" + puntaje[6] + ",`puntuaje8`=" + puntaje[7] + ",`puntuaje9`=" + puntaje[8] + ",`puntuaje10`=" + puntaje[9] + ",`puntuaje11`=" + puntaje[10] + ",`puntuaje12`=" + puntaje[11] + ",`puntuaje13`=" + puntaje[12] + ",`puntuaje14`=" + puntaje[13] + ",`puntuaje15`=" + puntaje[14] + ",`puntuaje16`=" + puntaje[15] + ",`puntuaje17`=" + puntaje[16] + ",`puntuaje18`=" + puntaje[17] + ",`puntuaje19`=" + puntaje[18] + ",`puntuaje20`=" + puntaje[19] + " WHERE `idEvaluacion_Reactivos_P`='" + idReactivosEvaluacion + "';");

    }

    /**
     * Metodo que regresa las materias existentes
     */
    public ResultSet obtenerMaterias() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        ResultSet resultado = instruccion.executeQuery("select nombre from materia;");
        return resultado;
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
