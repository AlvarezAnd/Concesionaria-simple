package concesionaria.entities;

import java.text.DecimalFormat;

public abstract class Vehiculo implements Comparable<Vehiculo> {
    
    private String marca;
    private String modelo;
    private double precio;
    
    public Vehiculo(String marca, String modelo, double precio){
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }
    @Override
    public String toString() {
        return "Marca: " + this.getMarca() + " // Modelo: " + this.getModelo() + " // ";
    }
    @Override
    public int compareTo(Vehiculo vehiculo) {
        String thisVehiculo = this.getMarca() + ", " + this.getModelo() + ", " + this.getPrecioFormat();
        String paraVehiculo = vehiculo.getMarca() + ", " + vehiculo.getModelo() + ", " + vehiculo.getPrecioFormat();
        return thisVehiculo.compareTo(paraVehiculo);
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public double getPrecio() {
        return precio;
    }
    public String getPrecioFormat(){
        DecimalFormat df = new DecimalFormat("###,###,###.00");
        return df.format(this.getPrecio());
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}