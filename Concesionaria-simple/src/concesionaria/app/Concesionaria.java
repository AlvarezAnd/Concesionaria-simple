package concesionaria.app;

import concesionaria.entities.Auto;
import concesionaria.entities.Moto;
import concesionaria.entities.Vehiculo;
import concesionaria.repositories.I_VehiculoRepository;
import concesionaria.repositories.VehiculoRepository;
import java.util.Comparator;

public class Concesionaria {
    
    private static I_VehiculoRepository vr = new VehiculoRepository();
    
    public static void main(String[] args) {
        // Carga la lista de vehiculos.
        cargar();
        
        // Imprimir listado
        imprimir();
        
        // Separador
        separador();
        
        // Vehiculo mas caro.
        vehiculoMasCaro();
        
        // Vehiculo mas barato.
        vehiculoMasbarato();
        
        // Separador
        separador();
        
        // Vehiculo que contiene la letra Y en el modelo:
        vehiculoY();
        
        // Separador
        separador();
        
        // Vehiculos ordenados por precio (de mayor a menor):
        vehiculosOrdenadosPrecio();
        
        // Separador
        separador();
        
        // Vehículos ordenados por orden natural:
        vehiculosOrdenNatural();
        
        // Separador
        separador();
        
    }
    
    private static void vehiculosOrdenadosPrecio(){
        System.out.println("Vehículos ordenados por precio de mayor a menor: ");
        vr.getAll()
                .stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getPrecio).reversed())
                .forEach(v->System.out.println(v.getMarca() + " " + v.getModelo()));
    }
    
    private static void vehiculosOrdenNatural(){
        System.out.println("Vehículos ordenados por orden natural: ");
        vr.getAll()
                .stream()
                .sorted()
                .forEach(System.out::println);
    }
    
    private static void vehiculoY(){
        // Puede existir mas de un vehículo con el modelo que contenga "Y"
        
        // Opcion: solo Y mayúscula.
        /* 
        vr.getAll()
                .stream()
                .filter(v->v.getModelo().contains("Y"))
                .forEach(v->{
                    System.out.println("Vehículo que contiene en el modelo la letra 'Y': "
                            + v.getMarca() + " " + v.getModelo() + " $" + v.getPrecioFormat());
                        });
        */
        // Opcion: Y mayúscula o minúscula.
        vr.getAll()
                .stream()
                .filter(v->v.getModelo().toLowerCase().contains("y"))
                .forEach(v->{
                    System.out.println("Vehículo que contiene en el modelo la letra 'Y': "
                            + v.getMarca() + " " + v.getModelo() + " $" + v.getPrecioFormat());
                        });
                
    }

    private static void vehiculoMasCaro() {
        // Esta solucion no contempla que puede existir dos vehiculos o mas con el precio máximo.
        // Vehiculo vehiculoMaxPrecio = vr.getAll().stream().max(Comparator.comparingDouble(Vehiculo::getPrecio)).get();
        // System.out.println("Vehículo mas caro: " + vehiculoMaxPrecio.getMarca() + " " + vehiculoMaxPrecio.getModelo());
        
        // *********************************************************************
        
        // Lista de vehiculos con el precio mas caro
        // Esta solución contempla mas de un vehiculo con el precio maximo.
        double precioMaximo = vr.getAll()
                .stream()
                .max(Comparator.comparingDouble(Vehiculo::getPrecio))
                .get()
                .getPrecio();
        vr.getAll()
                .stream()
                .filter(v->v.getPrecio() == precioMaximo)
                .forEach(v->System.out.println("Vehiculo mas caro: " + v.getMarca() + " " + v.getModelo() + "."));
    }
    
    private static void vehiculoMasbarato(){
        // Solucion simple
        // Esta solucion no contempla que puede existir dos vehiculos o mas con el precio mínimo.
        //Vehiculo vehiculoMinPrecio = vr.getAll().stream().min(Comparator.comparingDouble(Vehiculo::getPrecio)).get();
        //System.out.println("Vehículo mas barato: " + vehiculoMinPrecio.getMarca() + " " + vehiculoMinPrecio.getModelo());
        
        // *********************************************************************
        
        // Lista de vehiculos con el precio mas barato
        // Esta solución contempla mas de un vehiculo con el precio maximo.
        double precioMinimo = vr.getAll()
                .stream()
                .min(Comparator.comparingDouble(Vehiculo::getPrecio))
                .get()
                .getPrecio();
        vr.getAll()
                .stream()
                .filter(v->v.getPrecio() == precioMinimo)
                .forEach(v->System.out.println("Vehiculo mas barato: " + v.getMarca() + " " + v.getModelo() + "."));
        
    }

    private static void imprimir() {
        // Imprimir listado.
        vr.getAll().forEach(System.out::println);
    }
    
    private static void cargar(){
        vr.save(new Auto("Peugeot"  , "206"     , 200000    , 2));
        vr.save(new Moto("Honda"    , "Titan"   , 60000     , 125));
        vr.save(new Auto("Peugeot"  , "208"     , 250000    , 5));
        vr.save(new Moto("Yamaha"   , "YBR"     , 80500.5   , 160));
//        vr.save(new Moto("Honda"    , "PCX"     , 250000    , 150));
//        vr.save(new Moto("Honda"    , "Wave"    , 60000     , 110));
//        vr.save(new Moto("Zanella"  , "Styler"  , 160000    , 160));
    }
    private static void separador(){
        System.out.println("\n=============================================\n");
    }
}