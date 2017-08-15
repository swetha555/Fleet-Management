package swe.inc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import swe.inc.entity.Vehicle;
import swe.inc.exception.BadRequestException;
import swe.inc.exception.ResourceNotFoundException;
import swe.inc.repository.VehicleRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService{
    @Autowired
    VehicleRepository vehicleRepository;
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    public Vehicle findOne(String vin) {
        Vehicle existing = vehicleRepository.findOne(vin);
        if(existing==null){
            throw new ResourceNotFoundException("Vehicle with vin number " + vin + " doesn't exist.");
        }

        return existing;
    }

    public Vehicle create(Vehicle vehicle) {
        Vehicle existing = vehicleRepository.findOne(vehicle.getVin());
        if (existing != null) {
            throw new BadRequestException("Vehicle with vin number " + vehicle.getVin() + " already exists.");
        }
        return vehicleRepository.create(vehicle);
    }

    public Vehicle update(String vin, Vehicle vehicle) {
        Vehicle existing = vehicleRepository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin number " + vin + " doesn't exist.");
        }
        return vehicleRepository.update(vehicle);
    }

    public void delete(String vin) {
        Vehicle existing = vehicleRepository.findOne(vin);
        if (existing == null) {
            throw new ResourceNotFoundException("Vehicle with vin number " + vin + " doesn't exist.");
        }
        vehicleRepository.delete(existing);
    }
}
