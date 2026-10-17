import com.edu.uce.barberia.CitaBarberia;
import com.edu.uce.barberia.CitaService;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Iniciando sistema de reservas...");

        CitaBarberia cita = new CitaBarberia("Carlos Sanchez", "Corte Fade y Barba", 15, "0991234567");
        CitaService citaService = new CitaService();
        
        // cita = null;
        citaService.agendar(cita);
        // citaService = null;
    }
}
