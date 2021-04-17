package concesionaria.repositories;

import concesionaria.entities.Vehiculo;
import java.util.ArrayList;
import java.util.List;

public class VehiculoRepository implements I_VehiculoRepository {

    private List<Vehiculo> list;
    
    public VehiculoRepository(){
        this.list = new ArrayList();
    }
    @Override
    public void save(Vehiculo vehiculo) {
        list.add(vehiculo);
    }
    @Override
    public List<Vehiculo> getAll() {
        return list;
    }    
}