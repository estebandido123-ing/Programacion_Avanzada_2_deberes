package uce.edu.pa2.api.deberes;

public class CitaMedica {

    private String paciente;
    private String especialidad;
    private double costo;
    private String numeroWhatsapp;
    private String usuarioTelegram;

    public CitaMedica(String paciente, String especialidad, int costo, String numeroWhatsapp) {
        this.paciente = paciente;
        this.especialidad = especialidad;
        this.costo = costo;
        this.numeroWhatsapp = numeroWhatsapp;
    }

    public String getUsuarioTelegram() {
        return usuarioTelegram;
    }

    public void setUsuarioTelegram(String usuarioTelegram) {
        this.usuarioTelegram = usuarioTelegram;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getNumeroWhatsapp() {
        return numeroWhatsapp;
    }

    public void setNumeroWhatsapp(String numeroWhatsapp) {
        this.numeroWhatsapp = numeroWhatsapp;
    }
}
