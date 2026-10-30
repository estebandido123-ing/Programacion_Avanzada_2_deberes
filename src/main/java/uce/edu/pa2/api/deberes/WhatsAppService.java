package uce.edu.pa2.api.deberes;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Named;

@Dependent
@Named("whatsapp")
public class WhatsAppService implements Recordatorio {

    private Integer cantidad = 0;
    private String nombre;

    @Override
    public void enviar(String destino, String mensaje) {

        System.out.println("Enviando WhatsApp a: " + destino);
        System.out.println("mensaje: " + mensaje);

        System.out.println("WhatsApp enviado con exito");
        System.out.println("Fin del envio de WhatsApp");
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}