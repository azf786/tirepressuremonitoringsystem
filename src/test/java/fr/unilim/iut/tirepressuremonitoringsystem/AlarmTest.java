package fr.unilim.iut.tirepressuremonitoringsystem;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class AlarmTest {

	@Test
	public void activateAlarmWhenPressureValueIsTooLow() {
		PressureSensor sensor = probeValue(15.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

	private PressureSensor probeValue(double value) {
		PressureSensor sensor = mock(PressureSensor.class);
		when(sensor.popNextValue()).thenReturn(value);
		return sensor;
	}

	private PressureSensor probeValue(double value1, double value2) {
		PressureSensor sensor = mock(PressureSensor.class);
		when(sensor.popNextValue()).thenReturn(value1).thenReturn(value2);
		return sensor;
	}

	@Test
	public void activateAlarmWhenPressureValueIsTooHigh() {
		PressureSensor sensor = probeValue(22.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}
	@Test
	public void doNotActivateAlarmWhenPressureValueIsInTheAcceptedValues() {
		PressureSensor sensor = probeValue(20.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertFalse(alarm.isAlarmOn());
	}
	@Test
	public void alarmStayActivated() {
		PressureSensor sensor = probeValue(15.0, 18.0);
		Alarm alarm = new Alarm(sensor);
		alarm.check();
		assertTrue(alarm.isAlarmOn());
		alarm.check();
		assertTrue(alarm.isAlarmOn());
	}

}
