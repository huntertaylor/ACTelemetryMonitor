package telemetry.assettocorsa.zotyt.actelemetrymonitor.data;

import android.databinding.BaseObservable;

import telemetry.assettocorsa.zotyt.actelemetrymonitor.BR;

/**
 * Created by zotyt on 2017. 03. 17..
 */

public class TelemetryData extends BaseObservable {
    public float speed = 0.0F;
    public float rpm = 0.0F;
    public float fuel = 0.0F;
    public float fuelLaps = 0.0F;
    public float gear = 0.0F;
    public TyreData frontLeft = new TyreData();
    public TyreData frontRight = new TyreData();
    public TyreData rearLeft = new TyreData();
    public TyreData rearRight = new TyreData();

    public String getSpeed() {
        return Float.toString(speed);
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getRpm() {
        return Float.toString(rpm);
    }

    public void setRpm(float rpm) {
        this.rpm = rpm;
    }

    public String getFuel() {
        return Float.toString(fuel);
    }

    public void setFuel(float fuel) {
        this.fuel = fuel;
    }

    public String getFuelLaps() {
        return Float.toString(fuelLaps);
    }

    public void setFuelLaps(float fuelLaps) {
        this.fuelLaps = fuelLaps;
    }

    public String getGear() {
        return Float.toString(gear);
    }

    public void setGear(float gear) {
        this.gear = gear;
    }

    public TyreData getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(TyreData frontLeft) {
        this.frontLeft = frontLeft;
    }

    public TyreData getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(TyreData frontRight) {
        this.frontRight = frontRight;
    }

    public TyreData getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(TyreData rearLeft) {
        this.rearLeft = rearLeft;
    }

    public TyreData getRearRight() {
        return rearRight;
    }

    public void setRearRight(TyreData rearRight) {
        this.rearRight = rearRight;
    }

    public String getPerformanceMeter() {
        return Float.toString(performanceMeter);
    }

    public void setPerformanceMeter(float performanceMeter) {
        this.performanceMeter = performanceMeter;
    }

    public float performanceMeter = 0.0F;

    public void notifyProp(){
        notifyPropertyChanged(BR._all);
    }
}
