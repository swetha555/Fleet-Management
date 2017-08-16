package swe.inc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import swe.inc.entity.*;
import swe.inc.service.ReadingService;
import swe.inc.service.VehicleService;
import java.util.List;

@ComponentScan //can delete it
@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @Autowired
    ReadingService readingService;

    @RequestMapping(method = RequestMethod.GET, value = "/vehicles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody //can delete and use once at top
    public List<Vehicle> findAll(){

        return vehicleService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vehicles/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Vehicle findOne(@PathVariable("vin") String vin){

        return vehicleService.findOne(vin);
    }


    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/vehicles",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Vehicle create(@RequestBody Vehicle vehicle){

        return vehicleService.create(vehicle);
    }

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/readings",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Reading create(@RequestBody JSONReadingVO reading){

        Reading jpaReading = convertToJPAReading(reading);
        return readingService.create(jpaReading);
    }

    public Reading convertToJPAReading(JSONReadingVO jsonReadingVO){
        Reading reading = new Reading();
        reading.setCheckEngineLightOn(jsonReadingVO.isCheckEngineLightOn());
        reading.setCruiseControlOn(jsonReadingVO.isCruiseControlOn());
        reading.setEngineHp(jsonReadingVO.getEngineHp());
        reading.setEngineRpm(jsonReadingVO.getEngineRpm());
        reading.setFuelVolume(jsonReadingVO.getFuelVolume());
        reading.setLatitude(jsonReadingVO.getLatitude());
        reading.setLongitude(jsonReadingVO.getLongitude());
        reading.setSpeed(jsonReadingVO.getSpeed());
        reading.setTimestamp(jsonReadingVO.getTimestamp());
        Vehicle vehicle = new Vehicle();
        vehicle.setVin(jsonReadingVO.getVin());
        reading.setVh(vehicle);
        Tires tires = new Tires();
        tires.setFrontLeft(jsonReadingVO.getTires().getFrontLeft());
        tires.setFrontRight(jsonReadingVO.getTires().getFrontRight());
        tires.setRearLeft(jsonReadingVO.getTires().getRearLeft());
        tires.setRearRight(jsonReadingVO.getTires().getRearRight());
        reading.setTires(tires);
        tires.setReading(reading);
        return reading;
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{vin}",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Vehicle update(@PathVariable("vin") String vin, @RequestBody Vehicle vehicle) {

        return vehicleService.update(vin, vehicle);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "/{vin}")
    @ResponseBody
    public void delete(@PathVariable("vin") String vin){
    vehicleService.delete(vin);
    }


}
