package swe.inc.repository;

import org.springframework.stereotype.Repository;
import swe.inc.entity.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = entityManager.createNamedQuery("Vehicle.findAll", Vehicle.class);
        return query.getResultList();

    }

    public Vehicle findOne(String vin) {
        return entityManager.find(Vehicle.class,vin);
    }

    public Vehicle create(Vehicle vehicle) {
        entityManager.persist(vehicle);
        return vehicle;
    }

    public Vehicle update(Vehicle vehicle) {

        return entityManager.merge(vehicle);
    }

    public void delete(Vehicle vehicle) {
        entityManager.remove(vehicle);
    }
}
