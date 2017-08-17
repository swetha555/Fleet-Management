package swe.inc.repository;

import swe.inc.entity.Reading;
import swe.inc.entity.Vehicle;

import java.util.List;
import java.util.Set;

public interface ReadingRepository {
    Reading findAll();
    Reading findOne(int readingId);
    Reading create(Reading reading);
    Reading update(Reading reading);
    void delete(Reading reading);

    List<Reading> getReadingsForVin(String vin);
}
