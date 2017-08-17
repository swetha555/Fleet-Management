package swe.inc.service;

import swe.inc.entity.Reading;

import java.util.List;

public interface ReadingService {
    List<Reading> findAll(String vin);
    Reading create(Reading reading);


}
