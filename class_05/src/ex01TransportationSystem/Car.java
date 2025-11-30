// This class describes how to calculate the travel time for a car
package ex01TransportationSystem;

public class Car extends Vehicle {

	// Overridden method
	@Override
	public void calculateTime(float distance) {
		float totalTime = (distance / super.getAverageSpeed()) * 60;
		float timeHour = (int)(totalTime / 60);
		float timeMinute = totalTime % 60;

		System.out.printf("Carro:\n"
			+ "- Modelo: %s\n"
			+ "- Velocidade Média: %.0f Km/h\n"
			+ "- Tempo total de viagem: %.0f hora(s) e %.0f minuto(s)\n\n",
			super.getModel(), super.getAverageSpeed(), timeHour, timeMinute);
	}

}
