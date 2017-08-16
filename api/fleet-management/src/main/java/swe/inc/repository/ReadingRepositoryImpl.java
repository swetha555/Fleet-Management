package swe.inc.repository;

import org.springframework.stereotype.Repository;
import swe.inc.entity.Reading;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ReadingRepositoryImpl implements ReadingRepository{

    @PersistenceContext
    private EntityManager entityManager;


    public Reading findOne(int readingId) {
        return entityManager.find(Reading.class,readingId);
    }

    public Reading create(Reading reading) {
        entityManager.persist(reading);
        return reading;
    }

    public Reading update(Reading reading) {

        return entityManager.merge(reading);
    }

    public void delete(Reading reading) {
        entityManager.remove(reading);
    }
}
