package com.edu.uce.barberia;

public class SmsService {
    public void enviar(String telefono, String cabecera, String mensaje){
        
        System.out.println("Enviando SMS al número: " + telefono);
        System.out.println("Cabecera: " + cabecera);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("SMS enviado con éxito");
    }
}
