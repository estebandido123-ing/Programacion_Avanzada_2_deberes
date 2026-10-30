package uce.edu.pa2.api.deberes;
import java.lang.reflect.Parameter;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@RegistroMedico
@Interceptor
public class RegistroMedicoInterceptor {

    @Inject
    private HistorialClinicoService historialClinicoService;

    @AroundInvoke
    public Object interceptar(InvocationContext context) throws Exception {
        System.out.println("Interceptando el metodo: " + context.getMethod().getName());
        System.out.println("Ejecuto todo lo que quiero que haga el interceptor antes de ejecutar el metodo");

        Parameter[] parametros = context.getMethod().getParameters();

        for (Parameter parametro : parametros) {
            System.out.println("Parametro: " + parametro.getName());
        }

        Object[] valores = context.getParameters();

        ConsultaMedica consulta = (ConsultaMedica) valores[0];

        String paciente = consulta.getPaciente();
        double costo = consulta.getCosto();
        String whatsapp = consulta.getNumeroWhatsapp();

        this.historialClinicoService.guardarEnLaBaseDeDatos(paciente, costo, whatsapp);

        Object resultado = context.proceed(); // ejecuta el metodo interceptado
        System.out.println("Mensaje luego de ejecutar el metodo: " + resultado);
        System.out.println("Retornando el resultado del metodo interceptado: " + resultado);

        return resultado;
    }
}