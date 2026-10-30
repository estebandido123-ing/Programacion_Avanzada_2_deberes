package uce.edu.pa2.api.deberes;

public interface Recordatorio {

    public void enviar(String destino, String mensaje);

    public Integer getCantidad();

    public void setCantidad(Integer cantidad);

    public String getNombre();

    public void setNombre(String nombre);
}
