// This abstract class describes the method that other classes must implement
// to calculate the travel time for each vehicle
package ex01TransportationSystem;

abstract class Vehicle {

	// Attributes
	private String model;
	private float averageSpeed;

	// Getters
	public String getModel() {
		return model;
	}

	public float getAverageSpeed() {
		return averageSpeed;
	}

	// Setters
	public void setModel(String model) {
		this.model = model;
	}

	public void setAverageSpeed(float averageSpeed) {
		this.averageSpeed = averageSpeed;
	}

	// Abstract method
	abstract void calculateTime(float distance);

}
