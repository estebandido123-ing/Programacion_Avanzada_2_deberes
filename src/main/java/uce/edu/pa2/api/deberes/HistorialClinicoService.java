package uce.edu.pa2.api.deberes;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class HistorialClinicoService {

    public void guardarEnLaBaseDeDatos(String paciente, double costo, String whatsapp) {
        System.out.println("Guardando en la base de datos: " + paciente + ", " + costo + ", " + whatsapp);
        System.out.println("Con la fecha y hora actual: " + java.time.LocalDateTime.now());
    }
}