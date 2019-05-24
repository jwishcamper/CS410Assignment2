import sensor.*;
public class SensorAdapter {
	PressureSensor p = new PressureSensor();
	RadiationSensor r = new RadiationSensor();
	TemperatureSensor t = new TemperatureSensor();
	
	public String getPressureName() {
		return p.getSensorName();
	}
	public String getRadiationName() {
		return r.getName();
	}
	public String getTemperatureName() {
		return t.getSensorType();
	}
	public String getPressureReading() {
		return p.getReport();
	}
	public String getRadiationReading() {
		return r.getStatusInfo();
	}
	public String getTemperatureReading() {
		return t.getTempReport();
	}
	public double getPressureValue() {
		return p.readValue();
	}
	public double getRadiationValue() {
		return r.getRadiationValue();
	}
	public double getTemperatureValue() {
		return t.senseTemperature();
	}
}
