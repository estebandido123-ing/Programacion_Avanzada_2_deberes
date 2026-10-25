package uce.edu.pa2.api.deberes;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.UUID;

@ApplicationScoped // Delego el control al contenedor
public class VentaService {

    private String id = UUID.randomUUID().toString();

    // -- Inyección de dependencias por atributo y Qualifiers
    @Inject
    @Named("regular")
    private CalculadoraDescuento descuentoRegular;

    @Inject
    @Named("vip")
    private CalculadoraDescuento descuentoVip;

    // -- Inyección de dependencias por constructor
    private Auditoria auditoria;

    @Inject
    public VentaService(Auditoria auditoria) {
        this.auditoria = auditoria;
    }

    public void procesarVenta(int numeroVenta, String tipoCliente, double monto) {
        CalculadoraDescuento calculadora;
        String porcentaje;

        if (tipoCliente.equals("VIP")) {
            calculadora = this.descuentoVip;
            porcentaje = "15 %";
        } else {
            calculadora = this.descuentoRegular;
            porcentaje = "5 %";
        }

        double descuento = calculadora.calcular(monto);
        double total = monto - descuento;

        System.out.println("--------------------------------------------------");
        System.out.println("Venta: " + numeroVenta);
        System.out.println("Tipo de cliente: " + tipoCliente + " (" + porcentaje + ")");
        System.out.println("Monto: $" + monto);
        System.out.println("Descuento: $" + descuento);
        System.out.println("Total final: $" + total);
        System.out.println("UUID VentaService (@ApplicationScoped): " + this.id);
        System.out.println("UUID Calculadora  (@ApplicationScoped): " + calculadora.getId());

        // Registro de auditoría en consola
        this.auditoria.registrar("Venta #" + numeroVenta + " procesada con éxito para cliente " + tipoCliente);
    }
}