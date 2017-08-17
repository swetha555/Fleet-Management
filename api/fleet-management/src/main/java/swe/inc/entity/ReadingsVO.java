package swe.inc.entity;

import java.util.List;

public class ReadingsVO {

    private List<JSONReadingVO> readings;

    public List<JSONReadingVO> getReadings() {
        return readings;
    }

    public void setReadings(List<JSONReadingVO> readings) {
        this.readings = readings;
    }
}
