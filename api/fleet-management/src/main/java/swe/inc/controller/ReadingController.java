package swe.inc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import swe.inc.entity.*;
import swe.inc.service.ReadingService;

import java.util.ArrayList;
import java.util.List;

@ComponentScan
@RestController
public class ReadingController {

    @Autowired
    ReadingService readingService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, value = "/readings",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public JSONReadingVO create(@RequestBody JSONReadingVO reading) {

        Reading jpaReading = convertToJPAReading(reading);
        readingService.create(jpaReading);
        return reading;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/readings/{vin}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ReadingsVO findReadingsForVin(@PathVariable("vin") String vin){

        ReadingsVO vo = new ReadingsVO();
        List<Reading> readings = readingService.findAll(vin);
        List<JSONReadingVO> jsr = new ArrayList<JSONReadingVO>();
        for(Reading r : readings){
            JSONReadingVO x = convertToJSONReading(r);
            jsr.add(x);
        }
        vo.setReadings(jsr);
        return vo;
    }

    private JSONReadingVO convertToJSONReading(Reading r) {
        JSONReadingVO j = new JSONReadingVO();
        j.setCheckEngineLightOn(r.isCheckEngineLightOn());
        j.setCruiseControlOn(r.isCruiseControlOn());
        j.setEngineHp(r.getEngineHp());
        j.setEngineRpm(r.getEngineRpm());
        j.setFuelVolume(r.getFuelVolume());
        j.setLatitude(r.getLatitude());
        j.setLongitude(r.getLongitude());
        j.setVin(r.getVh().getVin());
        j.setSpeed(r.getSpeed());
        j.setTimestamp(r.getTimestamp());
        j.setAlert(r.isAlert());
        j.setAlertMessage(r.getAlertMessage());
        j.setEngineCoolantLow(r.isEngineCoolantLow());

        return j;
    }

    public Reading convertToJPAReading(JSONReadingVO jsonReadingVO) {
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
        reading.setEngineCoolantLow(jsonReadingVO.isEngineCoolantLow());
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

}
