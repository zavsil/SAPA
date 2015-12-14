/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteMantenimientodeEvaluaciones;

import PaqueteMantenimientodeMaterias.*;
import PaqueteMantenimientoUsuarios.*;
import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author FRANCISCO ZAVALA SILVA
 */
public class ControlMateria {

    Component rootPane = null;

    /**
     * Metodo que permite registrar una materia
     */
    public String registrarMateria(String nombreMateria, JTable temas) throws ClassNotFoundException, SQLException {
        String error = "";
        String temasIngresados = "";
        int total = 0;
        try {

            if (nombreMateria.length() > 0 &&nombreMateria.length() > 3) {
                //valida que el nombre de la materia no exista para poder registrar. 
                if (!existeMateria(nombreMateria)) {
                    for (int i = 0; i < temas.getRowCount(); i++) {
                        if (temas.getValueAt(i, 0).toString().length() > 3 && temas.getValueAt(i, 1).toString().length() > 0) {

                            if (Integer.parseInt(temas.getValueAt(i, 1).toString()) >= 3 && Integer.parseInt(temas.getValueAt(i, 1).toString()) <= 6) {

                                Statement instruccion = conectar();

                                if (i == 0) {
                                    //obtenemos el total de materias registradas y lo utilizaremos como id de entrada para registrar la materia
                                    ResultSet resultado = instruccion.executeQuery("SELECT idMateria from Materia;");

                                    while (resultado.next()) {

                                        total = (Integer.parseInt(resultado.getObject(1).toString()));

                                    }//find el while
                                    System.out.println("Ingresare: " + nombreMateria + " con id: " + (total + 1));

                                    //inserccion a la base de datos
                                    instruccion.executeUpdate("INSERT INTO materia(idMateria,nombre) values(" + (total + 1) + ",'" + nombreMateria + "'); ");

                                }

                                //inserccion a la base de datos
                                instruccion.executeUpdate("INSERT INTO tema(nombre,grado) values('" + temas.getValueAt(i, 0) + "'," + temas.getValueAt(i, 1) + "); ");
                                ResultSet resultado2 = instruccion.executeQuery(" SELECT idTema from tema where nombre='" + temas.getValueAt(i, 0) + "' and grado=" + temas.getValueAt(i, 1) + "  ;");
                                int idTema = 0;
                                while (resultado2.next()) {

                                    idTema = (Integer.parseInt(resultado2.getObject(1).toString()));

                                }//find el while
                                temasIngresados = temasIngresados + "\nTema:" + temas.getValueAt(i, 0) + " Grado: " + temas.getValueAt(i, 1);
                                instruccion.executeUpdate("INSERT INTO materia_tema(idMateria,idTema) values(" + (total + 1) + "," + idTema + "); ");

                            } else {
                                System.out.println("Error el grado debe ser de 3-6 en la posición [" + (i + 1) + ",2]");
                            }

                        } else {
                            if (temas.getValueAt(i, 0).toString().length() < 3) {
                                error = error + "\nTema demasiado corto en la posición [" + (i + 1) + ",1]";
                            }
                            if (temas.getValueAt(i, 1).toString().length() < 1) {
                                error = error + "\nFalta poner grado en la posición [" + (i + 1) + ",2]";
                            }
                            System.out.println(error);
                            JOptionPane.showMessageDialog(rootPane, error, "Error", JOptionPane.ERROR_MESSAGE);

                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "La materia ya existe en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Nombre de la materia demasiado corto", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NullPointerException e) {
            System.out.println(e.toString());
        }
        return temasIngresados;
    }

    /**
     * Metodo que permite conocer si la materia a consultar ya existe
     */
    public boolean existeMateria(String materia) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        String cadenaAcomparar = "";
        boolean existe = false;
        ResultSet resultado = instruccion.executeQuery("SELECT nombre from materia where nombre='" + materia + "';");

        while (resultado.next()) {

            cadenaAcomparar = (resultado.getObject(1).toString());

        }//find el while

        if (cadenaAcomparar.length() > 0) {
            existe = true;
        }

        return existe;
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
     * Metodo que permite consultar los temas de la materia en especifico
     */
    public ResultSet consultarTemas(String materia) throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();
        //instruccion para obtener informacion
        //consulta la base de datos
        ResultSet resultado = instruccion.executeQuery("select tema.nombre, tema.grado from  tema, materia_tema,materia where tema.idTema=materia_tema.idTema and  materia.idMateria=materia_tema.idMateria and materia.nombre='" + materia + "';");
        return resultado;
    }

    public void modificarMateria(String materia, JTable temas) throws ClassNotFoundException, SQLException {
        eliminarMateria(materia);
        registrarMateria(materia, temas);
    }

    void eliminarMateria(String materia) throws SQLException, ClassNotFoundException {
        Statement instruccion = conectar();

        ResultSet resultado = instruccion.executeQuery("select idMateria from materia where nombre='" + materia + "';");
        int idMateria = 0;
        while (resultado.next()) {
            idMateria = Integer.parseInt(resultado.getObject(1).toString());
        }

        ResultSet resultado2 = instruccion.executeQuery("select materia_tema.idTema from  tema, materia_tema,materia where tema.idTema=materia_tema.idTema and  materia.idMateria=materia_tema.idMateria and materia.nombre='" + materia + "';");

        int total = 0;
        while (resultado2.next()) {
            total++;
        }

        int[] idTemas = new int[total];
        resultado2.beforeFirst();
        int posicion = 0;
        while (resultado2.next()) {

            idTemas[posicion] = Integer.parseInt(resultado2.getObject(1).toString());
            posicion++;

        }

        //eliminación a la base de datos
        instruccion.executeUpdate("DELETE FROM materia_tema WHERE idMateria=" + idMateria + "; ");

        for (int i = 0; i < idTemas.length; i++) {
            //eliminación a la base de datos
            instruccion.executeUpdate("DELETE FROM tema WHERE idTema=" + idTemas[i] + "; ");
        }

        //eliminación a la base de datos
        instruccion.executeUpdate("DELETE FROM materia WHERE idMateria=" + idMateria + "; ");

    }

    /**
     * Metodo que regresa una cadena con el total de materias existentes
     */
    public String contarTotalMaterias() throws ClassNotFoundException, SQLException {
        Statement instruccion = conectar();

        //busca el total de maestros en la base de datos
        //obtiene el resultado del total de materias
        ResultSet resultado = instruccion.executeQuery("select count(*) from materia;");

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
