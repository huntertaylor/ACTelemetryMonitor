package telemetry.assettocorsa.zotyt.actelemetrymonitor.data;

/**
 * Created by zotyt on 2017. 03. 17..
 */

public class TyreData {
    public float innerTemp = 0.0F;
    public float medTemp = 0.0F;
    public float outerTemp = 0.0F;
    public float pressure = 0.0F;
    public float wear = 0.0F;
    public float coreTemp = 0.0F;
    public float dirtyLevel = 0.0F;
    public float brakeTemperature = 0.0F;

    public String getInnerTemp() {
        return Integer.toString(Math.round(innerTemp));
    }

    public void setInnerTemp(float innerTemp) {
        this.innerTemp = innerTemp;
    }

    public String getMedTemp() {
        return Integer.toString(Math.round(medTemp));
    }

    public void setMedTemp(float medTemp) {
        this.medTemp = medTemp;
    }

    public String getOuterTemp() {
        return Integer.toString(Math.round(outerTemp));
    }

    public void setOuterTemp(float outerTemp) {
        this.outerTemp = outerTemp;
    }

    public String getPressure() {
        return Integer.toString(Math.round(pressure));
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public String getWear() {
        return Integer.toString(Math.round(wear));
    }

    public void setWear(float wear) {
        this.wear = wear;
    }

    public String getCoreTemp() {
        return Integer.toString(Math.round(coreTemp));
    }

    public void setCoreTemp(float coreTemp) {
        this.coreTemp = coreTemp;
    }

    public String getDirtyLevel() {
        return Float.toString(dirtyLevel);
    }

    public void setDirtyLevel(float dirtyLevel) {
        this.dirtyLevel = dirtyLevel;
    }

    public String getBrakeTemperature() {
        return Integer.toString(Math.round(brakeTemperature));
    }

    public void setBrakeTemperature(float brakeTemperature) {
        this.brakeTemperature = brakeTemperature;
    }

}
