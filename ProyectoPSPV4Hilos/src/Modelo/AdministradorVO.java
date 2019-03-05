/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author David Camacho, Beatriz Abad y Daniel Villegas
 */
public class AdministradorVO {

    private int id;
    private String nombre;

    /**
     * Método que devuelve la id del administrador
     *
     * @return devuelve id de tipo int
     */
    public int getId() {
        return id;
    }

    /**
     * Método que devuelve el nombre del administrador
     *
     * @return devuelve nombre de tipo String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método que sirve para modificar la id
     *
     * @param id parámetro id que será modificado
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Método que sirve para modificar el nombre
     *
     * @param nombre parámetro nombre que será modificado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
