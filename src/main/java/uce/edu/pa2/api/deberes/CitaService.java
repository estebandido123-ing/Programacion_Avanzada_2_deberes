package uce.edu.pa2.api.deberes;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
public class CitaService {

    @Inject
    @Named("whatsapp")
    private Recordatorio recordatorioWhatsapp;

    public void agendar(CitaMedica cita) {

        System.out.println("Cita agendada para el paciente: " + cita.getPaciente());
        System.out.println("Especialidad: " + cita.getEspecialidad());
        System.out.println("Costo: " + cita.getCosto());
        System.out.println("WhatsApp: " + cita.getNumeroWhatsapp());

        // Notificacion de cita por WhatsApp
        this.recordatorioWhatsapp.enviar(cita.getNumeroWhatsapp(), "Cita medica agendada con exito");
        this.recordatorioWhatsapp.setCantidad(this.recordatorioWhatsapp.getCantidad() + 1);
        System.out.println("Cantidad de WhatsApps enviados: " + this.recordatorioWhatsapp.getCantidad());

        System.out.println("Nombre: " + this.recordatorioWhatsapp.getNombre());
    }
}
