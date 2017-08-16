package swe.inc.entity;

import java.sql.Timestamp;

public class JSONReadingVO {

        private float latitude;
        private float longitude;
        private Timestamp timestamp;
        private double fuelVolume;
        private double speed;
        private int engineHp;
        private boolean checkEngineLightOn;
        private boolean cruiseControlOn;
        private int engineRpm;
        private Tires tires;
        private  String vin;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
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

        public Tires getTires() {
            return tires;
        }

        public void setTires(Tires tires) {
            this.tires = tires;
        }
    }

