package concesionaria.entities;

public class Moto extends Vehiculo {
    private int cilindrada;
    public Moto(String marca, String modelo, double precio, int cilindrada){
        super(marca, modelo, precio);
        this.cilindrada = cilindrada;
    }
    @Override
    public String toString() {
        return super.toString() + "Cilindrada: " + this.getCilindrada() + "c // Precio: $" + this.getPrecioFormat() + ".";
    }
    public int getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}