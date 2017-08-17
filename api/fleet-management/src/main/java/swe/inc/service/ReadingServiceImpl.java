package swe.inc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import swe.inc.entity.Reading;
import swe.inc.entity.Vehicle;
import swe.inc.exception.BadRequestException;
import swe.inc.repository.ReadingRepository;
import swe.inc.repository.VehicleRepository;

import java.util.List;

@Service
public class ReadingServiceImpl implements ReadingService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    ReadingRepository readingRepository;

    @Transactional(readOnly = true)
    public List<Reading> findAll(String vin) {
        Vehicle existing = vehicleRepository.findOne(vin);
        if (existing == null) {
            throw new BadRequestException("Vehicle with vin number " + vin + " does NOT already exist");
        }
        List<Reading> readings = readingRepository.getReadingsForVin(vin);
        return readings;
    }

    @Transactional
    public Reading create(Reading reading) {
        Vehicle existing = vehicleRepository.findOne(reading.getVh().getVin());
        if (existing == null) {
            throw new BadRequestException("Vehicle with vin number " + reading.getVh().getVin() + " does NOT already exist");
        }
        //vehicleRepository.update(existing);
        return readingRepository.create(reading);
    }


}
