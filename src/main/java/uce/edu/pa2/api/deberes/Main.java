package uce.edu.pa2.api.deberes;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import jakarta.inject.Inject;
 
@QuarkusMain
public class Main implements QuarkusApplication{
 
    @Inject
    private VentaService ventaService;

    @Inject
    private Auditoria auditoriaMain;

    public static void main(String[] args) {
        Quarkus.run(Main.class, args);
    }

    @Override
    public int run(String... args) {
        System.out.println("Iniciando Aplicacion Quarkus - Simulador de Descuentos");
        this.auditoriaMain.registrar("Inicio de la aplicación desde Main");

        // Ejecución de las 4 ventas predefinidas
        this.ventaService.procesarVenta(1, "REGULAR", 100.00);
        this.ventaService.procesarVenta(2, "VIP", 200.00);
        this.ventaService.procesarVenta(3, "REGULAR", 300.00);
        this.ventaService.procesarVenta(4, "VIP", 500.00);

        System.out.println("--------------------------------------------------");
        this.auditoriaMain.registrar("Fin de la ejecución de ventas");

        // El ámbito: es el tiempo de vida de los componentes
        // El contexto: es la situación en la que se encuentra el componente

        return 0;
    }
 
}
