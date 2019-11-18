package fr.unilim.iut.tirepressuremonitoringsystem;

public class Alarm
{

    Sensor sensor;
    SafetyRange safetyRange = new SafetyRange();


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

        if (safetyRange.isNotSafe(value))
        {
            activateAlarm();
        }
    }

    private void activateAlarm() {
        alarmOn = true;
    }



    private double probeValue() {
        return sensor.popNextValue();
    }



    public boolean isAlarmOn()
    {
        return alarmOn; 
    }
}
