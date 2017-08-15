package swe.inc.service;

import swe.inc.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    List<Vehicle> findAll();
    Vehicle findOne(String vin);
    Vehicle create(Vehicle vehicle);
    Vehicle update(String vin, Vehicle vehicle);
    void delete(String vin);

}
