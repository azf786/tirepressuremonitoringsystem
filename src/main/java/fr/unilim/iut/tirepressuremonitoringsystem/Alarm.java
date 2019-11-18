package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm
{
    private final double lowPressureThreshold = 17;
    private final double highPressureThreshold = 21;

    PressureSensor sensor = new PressureSensor();

    private boolean alarmOn;

    public Alarm(PressureSensor sensor) {
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
        return sensor.popNextPressurePsiValue();
    }

    private boolean pressionSuperieurALowerPressureThreshold(double psiPressureValue) {
        return psiPressureValue > highPressureThreshold;
    }

    private boolean pressionInferieureALowerPressureThreshold(double psiPressureValue) {
        return psiPressureValue < lowPressureThreshold;
    }

    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
