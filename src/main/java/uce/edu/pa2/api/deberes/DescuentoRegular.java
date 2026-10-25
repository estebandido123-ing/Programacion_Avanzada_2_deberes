package uce.edu.pa2.api.deberes;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import java.util.UUID;

@ApplicationScoped
@Named("regular")
public class DescuentoRegular implements CalculadoraDescuento {

    private String id = UUID.randomUUID().toString();

    @Override
    public double calcular(double monto) {
        return monto * 0.05; // 5% de descuento
    }

    @Override
    public String getId() {
        return this.id;
    }
}