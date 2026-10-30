package uce.edu.pa2.api.deberes;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ConsultaService {

    @RegistroMedico
    public String registrar(ConsultaMedica consulta, String observacion) {

        System.out.println("Consulta registrada para el paciente: " + consulta.getPaciente());
        System.out.println("Especialidad: " + consulta.getEspecialidad());
        System.out.println("Costo: " + consulta.getCosto());
        System.out.println("WhatsApp: " + consulta.getNumeroWhatsapp());

        System.out.println("Consulta registrada con exito");

        return "Consulta registrada con exito";
    }
}