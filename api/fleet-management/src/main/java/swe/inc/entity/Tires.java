package swe.inc.entity;

import javax.persistence.*;

@Entity
public class Tires {

    private int tireId;

    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;

    private Reading reading;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reading_id", nullable = false)
    public Reading getReading() {
        return reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tire_id")
    public int getTireId() {
        return tireId;
    }

    public void setTireId(int tireId) {
        this.tireId = tireId;
    }

    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }
}
