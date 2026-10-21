package com.restaurante.domain;

import java.util.List;
import java.util.Scanner;

/**
 * son las reservas de las mesas hechas por los clientes
 */
public class Reserva {
    private static int contarReserva=1;
    private int idReserva;
    private String fecha;
    private String hora;
    private int numeroPersonas;
    
    public Reserva(String fecha, String hora, int numeroPersonas) {
        this.idReserva = contarReserva++;
        this.fecha = fecha;
        this.hora = hora;
        this.numeroPersonas = numeroPersonas;
    }

    /**
     * es para seleccionar una mesa disponible y armar una nueva reserva
     */
    public static Reserva hacerReserva(List<Mesa> mesas){
    Scanner sc = new Scanner(System.in);

      if(mesas.isEmpty()) return null;

      for(Mesa m : mesas){
         m.estadoMesa();
        }

      System.out.println("Digite el numero de mesa que queire reservar");
      int buscarMesa= sc.nextInt();
      sc.nextLine();

       Mesa mesaescogida = null;
       for (Mesa m:mesas){
       if(m.getIdMesa()==buscarMesa){
          mesaescogida=m;
          break;
         }
        }

        if (mesaescogida==null) {
            System.out.println("mesa no disponible");
            return null;
        }

        if(!mesaescogida.getEstado().equalsIgnoreCase("disponible")){
            System.out.println("mesa ocupada");
            return null;
        }

        System.out.println("Digite la fecha");
        String fecha = sc.nextLine();
        System.out.println("Digite la hora");
        String hora = sc.nextLine();
        System.out.println("Digite cuntas personas");
        int numeroPersonas = sc.nextInt();
        sc.nextLine();

        mesaescogida.setEstado("reservada");

        Reserva reserva = new Reserva(fecha, hora, numeroPersonas);
        System.out.println("mesa reservada");
        return reserva;
    }

    /**
     * cancela la reserva actual y deja libre la mesa
     */
    public void cancelarReserva(){
        Scanner sc = new Scanner(System.in);
        System.out.println("quiere cancelar la reserva?(si/no)");
        String cancelacion = sc.nextLine();

        if(cancelacion.equalsIgnoreCase("si")){
            this.fecha = "cancelada";
            this.hora = "cancelada";
            this.numeroPersonas = 0;
            System.out.println("la reserva se cancelo");
        }else{
            System.out.println("no se puede cancelar");
        }
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getNumeroPersonas() {
        return numeroPersonas;
    }

    public void setNumeroPersonas(int numeroPersonas) {
        this.numeroPersonas = numeroPersonas;
    }

    
}
