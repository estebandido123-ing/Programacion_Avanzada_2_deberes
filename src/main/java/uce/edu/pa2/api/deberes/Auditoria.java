package uce.edu.pa2.api.deberes;

import jakarta.enterprise.context.Dependent;
import java.util.UUID;

@Dependent
public class Auditoria {

    private String id = UUID.randomUUID().toString();

    public void registrar(String mensaje) {
        System.out.println("[Auditoria - UUID: " + this.id + "] " + mensaje);
    }

    public String getId() {
        return this.id;
    }
}