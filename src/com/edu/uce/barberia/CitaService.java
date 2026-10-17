package com.edu.uce.barberia;


public class CitaService {

    public void agendar(CitaBarberia cita){
        System.out.println("Cita agendada para el cliente: " + cita.getCliente());
        System.out.println("Tipo de corte: " + cita.getCorte());
        System.out.println("Costo total: " + cita.getCosto());
        System.out.println("Teléfono: " + cita.getTelefono());

        System.out.println("Cita registrada con éxito");

        // Instanciación directa (Fuerte acoplamiento, igual que en tu ejemplo original)
        SmsService smsService = new SmsService();
        String cabecera = "Confirmación de cita";
        String mensaje = "Estimado " + cita.getCliente() + ", su cita para un " 
        + cita.getCorte() + " por un valor de $ " + cita.getCosto() 
        + " ha sido agendada con éxito.";

        smsService.enviar(cita.getTelefono(), cabecera, mensaje);
        smsService = null;
    }
}