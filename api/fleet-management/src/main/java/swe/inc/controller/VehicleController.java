package swe.inc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import swe.inc.entity.Vehicle;
import swe.inc.service.VehicleService;
import java.util.List;

@ComponentScan
@RestController
public class VehicleController {
    @Autowired
    VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET, value = "/vehicles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<Vehicle> findAll(){

        return vehicleService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/vehicles/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Vehicle findOne(@PathVariable("vin") String vin){

        return vehicleService.findOne(vin);
    }


    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public Vehicle create(@RequestBody Vehicle vehicle){

        return vehicleService.create(vehicle);
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
