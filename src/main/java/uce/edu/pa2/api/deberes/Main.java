package uce.edu.pa2.api.deberes;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
 
@QuarkusMain
public class Main implements QuarkusApplication{
 
    @Inject
    private CitaService citaService;
 
    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }
 
    @Override
    public int run(String... args) {        
        System.out.println("Iniciando Aplicacion quarkus");

        CitaBarberia cita = new CitaBarberia("Juan Perez", "Corte de cabello", 20, "123456789");
        this.citaService.agendar(cita);
 
        
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
        return 0;
    }
 
}
