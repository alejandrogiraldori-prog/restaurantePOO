package com.restaurante;

import com.restaurante.domain.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Mesa> listaMesas = new ArrayList<>();
        List<Pedido> listaPedidos = new ArrayList<>();
        List<Reserva> listaReservas = new ArrayList<>();

        int opcion;
        do {
            System.out.println("dijite una opcion:");
            System.out.println("1.iniciar Sesion");
            System.out.println("2.Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            if (opcion == 1) {
                if (Usuario.iniciarSesion()) {
                    System.out.println("digite su rol:");
                    System.out.println("1.cliente");
                    System.out.println("2.personal");
                    int rol = sc.nextInt();
                    sc.nextLine();

                    if (rol == 1) {
                        int opC;
                        do {
                            System.out.println("dijits una opcion:");
                            System.out.println("1.consultar mesa");
                            System.out.println("2.hacer reserva");
                            System.out.println("3.hacer pedido");
                            System.out.println("4.cancelar reserva");
                            System.out.println("5.ver estado pedido");
                            System.out.println("6.cerrar sesion");
                            opC = sc.nextInt();
                            sc.nextLine();

                            switch (opC) {
                                case 1:
                                    new Cliente("", "", "").consultarMesa(listaMesas);
                                    break;
                                case 2:
                                    Reserva res = Reserva.hacerReserva(listaMesas);
                                    if (res != null) {
                                        listaReservas.add(res);
                                    }
                                    break;
                                case 3:
                                    Pedido.seleccionarProductos();
                                    Pedido nuevoPedido = new Pedido(0, "pedido en curso", "pendiente");
                                    listaPedidos.add(nuevoPedido);
                                    break;
                                case 4:
                                    if (!listaReservas.isEmpty()) {
                                        listaReservas.get(0).cancelarReserva();
                                    } else {
                                        System.out.println("no hay reservas activas");
                                    }
                                    break;
                                case 5:
                                    if (!listaPedidos.isEmpty()) {
                                        Pedido.estadoPedido(listaPedidos.get(0));
                                    } else {
                                        System.out.println("no hay pedidos registrados");
                                    }
                                    break;
                                case 6:
                                    new Cliente("", "", "").cerrarSesion();
                                    break;
                            }
                        } while (opC != 6);

                    } else if (rol == 2) {
                        int opP;
                        do {
                            System.out.println("dijite una opcion:");
                            System.out.println("1.registrar mesa");
                            System.out.println("2.ver pedido");
                            System.out.println("3.actualizar pedido");
                            System.out.println("4.cerrar sesion");
                            opP = sc.nextInt();
                            sc.nextLine();

                            switch (opP) {
                                case 1:
                                    Mesa m = new Personal("", "", "").registrarMesa();
                                    if (m != null) {
                                        listaMesas.add(m);
                                    }
                                    break;
                                case 2:
                                    if (!listaPedidos.isEmpty()) {
                                        new Personal("", "", "").verPedido(listaPedidos.get(0));
                                    } else {
                                        System.out.println("no hay pedidos para ver");
                                    }
                                    break;
                                case 3:
                                    if (!listaPedidos.isEmpty()) {
                                        new Personal("", "", "").actualizarPedido(listaPedidos.get(0));
                                    } else {
                                        System.out.println("no hay pedidos para actualizar");
                                    }
                                    break;
                                case 4:
                                    new Personal("", "", "").cerrarSesion();
                                    break;
                            }
                        } while (opP != 4);
                    }
                }
            }
        } while (opcion != 2);
        
        sc.close();
    }
}