package swe.inc.repository;

import swe.inc.entity.Reading;

import java.util.List;

public interface ReadingRepository {
    Reading findAll();
    Reading create(Reading reading);
    List<Reading> getReadingsForVin(String vin);
}
