package com.restaurante.domain;

import java.util.List;
import java.util.Scanner;

/**
 * representa a un cliente del restaurante, heredando de Usuario
 */
public class Cliente extends Usuario {
    private static int contarClientes=1;
    private int idCliente;
    private String telefono;

    public Cliente(String nombre, String correo, String telefono) {
        super(nombre, correo);
        this.idCliente = contarClientes++;
        this.telefono = telefono;
    }

    /**
     * muestra las mesas disponibles y su estado actual 
     */
    public void consultarMesa(List<Mesa> mesas){
        if(mesas.isEmpty()){
            System.out.println("No hay mesas registradas");
            return;
        }

        for(Mesa mesa:mesas){
            mesa.estadoMesa();
        }
    }
    /**
     * es para que el cliente arme su pedido escribiendo los productos que quiere
     */
    public void hacerPedido(){
        Scanner sc = new Scanner(System.in);

        System.out.println("confirme su pedido");
        String pedido = sc.nextLine();

        System.out.println("pedido hecho");

        Pedido pedidonuevo = new Pedido(0, pedido, "pendiente");
    }
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
 
}
