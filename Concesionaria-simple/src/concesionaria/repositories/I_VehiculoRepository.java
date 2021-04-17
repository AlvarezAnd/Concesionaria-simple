package concesionaria.repositories;

import concesionaria.entities.Vehiculo;
import java.util.List;

public interface I_VehiculoRepository {

    void save(Vehiculo vehiculo);
    List<Vehiculo> getAll();
    
    
}