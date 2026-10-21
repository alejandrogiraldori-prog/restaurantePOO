package com.restaurante.domain;

/**
 * controla la información de las mesas del restaurante y su estado actual
 */
public class Mesa {
    private static int contarMesas=1;
    private int idMesa;
    private String ubicacion;
    private String estado;
    
    public Mesa(String ubicacion, String estado) {
        this.idMesa = contarMesas++;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }
    /**
     * muestra el número, ubicación y estado de la mesa
     */
    public void estadoMesa(){
        System.out.println("numero de mesa: "+idMesa+"ubicacion de la mesa: "+ubicacion+"estado de la mesa: "+estado);
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
