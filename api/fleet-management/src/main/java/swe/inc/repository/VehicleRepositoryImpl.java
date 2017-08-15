package swe.inc.repository;

import org.springframework.stereotype.Repository;
import swe.inc.entity.Vehicle;

import java.util.Arrays;
import java.util.List;

@Repository
public class VehicleRepositoryImpl implements VehicleRepository{

    public List<Vehicle> findAll() {
        Vehicle v1 = new Vehicle();
        v1.setVin("1HGCR2F3XFA027534");
        v1.setMake("HONDA");
        v1.setModel("ACCORD");
        v1.setYear(2015);
        v1.setRedlineRpm(5500);
        v1.setMaxFuelVolume(15);
        v1.setLastServiceDate("2017-05-25T17:31:25.268Z");

        Vehicle v2 = new Vehicle();
        v1.setVin("1HGCR2F3XFA027535");
        v1.setMake("BMW");
        v1.setModel("M3");
        v1.setYear(2012);
        v1.setRedlineRpm(5100);
        v1.setMaxFuelVolume(25);
        v1.setLastServiceDate("2017-05-25T17:31:30.268Z");

        return Arrays.asList(v1,v2);

    }

    public Vehicle findOne(String vin) {
        Vehicle v1 = new Vehicle();
        v1.setVin("1HGCR2F3XFA027534");
        v1.setMake("HONDA");
        v1.setModel("ACCORD");
        v1.setYear(2015);
        v1.setRedlineRpm(5500);
        v1.setMaxFuelVolume(15);
        v1.setLastServiceDate("2017-05-25T17:31:25.268Z");
        return v1;
    }

    public Vehicle create(Vehicle vehicle) {
        return null;
    }

    public Vehicle update(Vehicle vehicle) {
        return null;
    }

    public void delete(Vehicle vehicle) {

    }
}
