package swe.inc.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@NamedQueries({
        @NamedQuery(name = "Reading.findAllForVin",
                query = "SELECT r FROM swe.inc.entity.Reading r where r.vh.vin = :vin"),
})
public class Reading {

    private int readingId;
    private float latitude;
    private float longitude;
    private Timestamp timestamp;
    private double fuelVolume;
    private double speed;
    private int engineHp;
    private boolean checkEngineLightOn;
    private boolean cruiseControlOn;
    private boolean engineCoolantLow;
    private int engineRpm;
    private Vehicle vh;
    private Tires tires;
    private boolean alert = false;
    private  String alertMessage;


    public boolean isAlert() {

        return alert;
    }

    public void setAlert(boolean alert) {
        this.alert = alert;
    }

    public String getAlertMessage() {
        return alertMessage;
    }

    public void setAlertMessage(String alertMessage) {
        this.alertMessage = alertMessage;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reading_id")
    public int getReadingId() {
        return readingId;
    }

    public void setReadingId(int readingId) {
        this.readingId = readingId;
    }

    @ManyToOne
    @JoinColumn(name = "vin", nullable = false )
    public Vehicle getVh() {
        return vh;
    }

    public void setVh(Vehicle vh) {
        this.vh = vh;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public int getEngineHp() {
        return engineHp;
    }

    public void setEngineHp(int engineHp) {
        this.engineHp = engineHp;
    }

    public boolean isCheckEngineLightOn() {
        return checkEngineLightOn;
    }

    public void setCheckEngineLightOn(boolean checkEngineLightOn) {
        this.checkEngineLightOn = checkEngineLightOn;
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public void setCruiseControlOn(boolean cruiseControlOn) {
        this.cruiseControlOn = cruiseControlOn;
    }

    public int getEngineRpm() {
        return engineRpm;
    }

    public void setEngineRpm(int engineRpm) {
        this.engineRpm = engineRpm;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tire_id")
    public Tires getTires() {
        return tires;
    }

    public void setTires(Tires tires) {
        this.tires = tires;
    }

    @Override
    public String toString() {
        return "Reading{" +
//                "vin='" + vin + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", fuelVolume='" + fuelVolume + '\'' +
                ", speed='" + speed + '\'' +
                ", engineHp='" + engineHp + '\'' +
                ", checkEngineLightOn='" + checkEngineLightOn + '\'' +
                ", engineCoolantLow='" + engineCoolantLow + '\'' +
                ", cruiseControlOn='" + cruiseControlOn + '\'' +
                ", engineRpm='" + engineRpm + '\'' +
                ", tires='" + tires + '\'' +
                '}';
    }

    public boolean isEngineCoolantLow() {
        return engineCoolantLow;
    }

    public void setEngineCoolantLow(boolean engineCoolantLow) {
        this.engineCoolantLow = engineCoolantLow;
    }
}
