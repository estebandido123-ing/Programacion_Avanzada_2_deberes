package uce.edu.pa2.api.deberes;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;

@QuarkusMain
public class Main implements QuarkusApplication {

    @Inject
    private ConsultaService consultaService;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando Aplicacion quarkus");

        ConsultaMedica consulta = new ConsultaMedica("Ana Gomez", "Cardiologia", 50, "0912345678");
        consulta.setUsuarioTelegram("@anagomez");
        this.consultaService.registrar(consulta, null);

        CitaMedica cita = new CitaMedica("Carlos Perez", "Odontologia", 35, "0987654321");
        cita.setUsuarioTelegram("@carlosperez");

        return 0;
    }
}
