package com.edu.uce.barberia;


public class CitaBarberia {

    private String cliente;
    private String corte;
    private double costo;
    private String telefono;

    public CitaBarberia(String cliente, String corte, int costo, String telefono) {
        this.cliente = cliente;
        this.corte = corte;
        this.costo = costo;
        this.telefono = telefono;
    }

    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    public String getCorte() {
        return corte;
    }
    public void setCorte(String corte) {
        this.corte = corte;
    }
    public double getCosto() {
        return costo;
    }
    public void setCosto(double costo) {
        this.costo = costo;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
