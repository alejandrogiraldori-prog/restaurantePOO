package com.restaurante.domain;

import java.util.Scanner;


/**
 * representa al personal del restaurante (chef o administradores), heredando de Usuario
 */
public class Personal extends Usuario {
    private static int contarPersonal=1;
    private int idPersonal;
    private String contrasena;
    
    public Personal(String nombre, String correo, String contrasena) {
        super(nombre, correo);
        this.idPersonal = contarPersonal++;
        this.contrasena = contrasena;
    }

    /**
     * Registra una nueva mesa pidiendo su ubicación y estado al usuario
     */
    public Mesa registrarMesa(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite la ubicacion de la mesa");
        String ubicacion = sc.nextLine();
        System.out.println("Digite el estado");
        String estado = sc.nextLine();

        Mesa mesa = new Mesa(ubicacion, estado);
        System.out.println("Registrada");

        return mesa;
    }
    /**
     * muestra los detalles de un pedido que hizo el cliente
     */
    public void verPedido(Pedido pedido){
        System.out.println("numero de pedido: " + pedido.getIdPedido());
        System.out.println("pedido: " + pedido.getPedido());
        System.out.println("estado: " + pedido.getEstado());
    }
    /**
     * cambiaa el estado de un pedido (pendiente o listo)
     */
    public void actualizarPedido(Pedido pedido){
        Scanner sc = new Scanner(System.in);

        System.out.println("Estado del pedido: " + pedido.getEstado());
        System.out.println("Digite el nuevo estado");
        String nuevoEstado = sc.nextLine();

        pedido.setEstado(nuevoEstado);

        System.out.println("pedido actualizado");
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    } 
}
