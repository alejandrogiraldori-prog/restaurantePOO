package com.restaurante.domain;

import java.util.Scanner;

/**
 * maneja los productos que pide el cliente y el estado en el que va el pedido
 */

public class Pedido {
    private static int contarPedidos=1;
    private int idPedido;
    private String pedido;
    private String estado;
    
    public Pedido(int idPedido, String pedido, String estado) {
        this.idPedido = contarPedidos++;
        this.pedido = pedido;
        this.estado = estado;
    }

    /**
     * muestra un menu para que el usuario elija sus productos
     */
    public static void seleccionarProductos(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("digite una opcion");
            System.out.println("1.pasta carbonara");
            System.out.println("2.lasagna");
            System.out.println("3.pan focaccia con pesto");
            System.out.println("4.finalizar seleccion");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("pasta carbonara seleccionada");
                    break;
                case 2:
                    System.out.println("lasagna seleccionada");
                    break;
                case 3:
                    System.out.println("pan focaccia con pesto seleccionado");
                    break;
                default:
                    break;
            }
        } while (opcion>=1 && opcion<=3);
    }

    /**
     * muestra cómo va el pedido actualmente
     */
    public static void estadoPedido(Pedido pedido)
    {
        System.out.println("numero de pedido: " + pedido.getIdPedido());
        System.out.println("pedido: " + pedido.getPedido());
        System.out.println("estado actual: " + pedido.getEstado());
    }
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    
}
