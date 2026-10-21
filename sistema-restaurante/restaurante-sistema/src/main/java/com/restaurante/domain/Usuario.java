package com.restaurante.domain;

import java.util.Scanner;

/**
 * clase para manejar los datos de los usuarios
 */

public class Usuario {
    protected String nombre;
    protected String correo;


    public Usuario(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    /**
     * es un metodo para iniciar sesión para cualquiera de los dos tipos
     */
    public static boolean iniciarSesion(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite una opcion");
        System.out.println("1.Cliente");
        System.out.println("2.personal");

        int tipoUsuario = sc.nextInt();
        sc.nextLine();

        if(tipoUsuario ==1){
            System.out.println("Digite su nombre");
            String nombre = sc.nextLine();
            System.out.println("Digite su correo");
            String correo = sc.nextLine();
            System.out.println("Digite su numero de telefono");
            String telefono = sc.nextLine();

            Cliente cliente = new Cliente(nombre, correo, telefono);
            System.out.println("Registrado");  
        }else if(tipoUsuario==2){
            System.out.println("Digite su nombre");
            String nombre = sc.nextLine();
            System.out.println("Digite su corrreo");
            String correo = sc.nextLine();
            System.out.println("Digite su contrasena");
            String contrasena = sc.nextLine();

            Personal personal = new Personal(nombre, correo, contrasena);
            System.out.println("Bienvenido");
        }
     return true;
    }   

    /**
     * cierra la sesión del usuario
     */
    public void cerrarSesion(){
        System.out.println("Sesion cerrada");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    
}


