package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm
{
    private final double lowThreshold = 17;
    private final double highThreshold = 21;

    Sensor sensor;


    private boolean alarmOn;

    public Alarm(Sensor sensor) {
        this.sensor = sensor;
        this.alarmOn = false;
    }
    public Alarm() {
        this(new PressureSensor());
    }

    public void check()
    {
        double value = probeValue();

        if (isNotSafe(value))
        {
            activateAlarm();
        }
    }

    private void activateAlarm() {
        alarmOn = true;
    }

    private boolean isNotSafe(double psiPressureValue) {
        return pressionInferieureALowerPressureThreshold(psiPressureValue) || pressionSuperieurALowerPressureThreshold(psiPressureValue);
    }

    private double probeValue() {
        return sensor.popNextValue();
    }

    private boolean pressionSuperieurALowerPressureThreshold(double psiPressureValue) {
        return psiPressureValue > highThreshold;
    }

    private boolean pressionInferieureALowerPressureThreshold(double psiPressureValue) {
        return psiPressureValue < lowThreshold;
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
