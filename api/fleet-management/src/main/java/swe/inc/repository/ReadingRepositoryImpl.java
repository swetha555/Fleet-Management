package swe.inc.repository;

import org.springframework.stereotype.Repository;
import swe.inc.entity.Reading;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository{

    @PersistenceContext
    private EntityManager entityManager;


    public Reading findAll() {
        return null;
    }

    public Reading findOne(int readingId) {
        return entityManager.find(Reading.class,readingId);
    }
    
    public Reading create(Reading reading) {
        //this will set alert message for speed more than 100
        if(reading.getSpeed() >= 100){
            reading.setAlert(true);
            reading.setAlertMessage("Driving too fast!!");
        }
        entityManager.persist(reading);
        return reading;
    }

    public Reading update(Reading reading) {

        return entityManager.merge(reading);
    }

    public void delete(Reading reading) {
        entityManager.remove(reading);
    }

    public List<Reading> getReadingsForVin(String vin) {
        Query readingQuery = entityManager.createNamedQuery("Reading.findAllForVin", Reading.class);
        readingQuery.setParameter("vin", vin);
        List<Reading> readingList = readingQuery.getResultList();

        return readingList;
    }
}
