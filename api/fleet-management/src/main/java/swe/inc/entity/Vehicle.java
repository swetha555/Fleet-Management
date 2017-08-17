package swe.inc.entity;

import javax.persistence.*;
import java.util.List;

@Entity

@NamedQueries({
        @NamedQuery(name="Vehicle.findAll", query = "select v from Vehicle v order by v.year desc "),
})
public class Vehicle {

    private String vin;
    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private double maxFuelVolume;
    private String lastServiceDate;

    private List<Reading> readings;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="vh", fetch = FetchType.EAGER)
    public List<Reading> getReadings() {
        return readings;
    }

    public void setReadings(List<Reading> readings) {
        this.readings = readings;
    }

    @Id
    @Column(columnDefinition = "VARCHAR(36)")
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }

    public double getMaxFuelVolume() {
        return maxFuelVolume;
    }

    public void setMaxFuelVolume(double maxFuelVolume) {
        this.maxFuelVolume = maxFuelVolume;
    }

    public String getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(String lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", redlineRpm='" + redlineRpm + '\'' +
                ", maxFuelVolume='" + maxFuelVolume + '\'' +
                ", lastServiceDate='" + lastServiceDate + '\'' +
                '}';
    }
}
