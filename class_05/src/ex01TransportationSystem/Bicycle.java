// This class describes how to calculate the travel time for a bicycle
package ex01TransportationSystem;

public class Bicycle extends Vehicle {

	// Overridden method
	@Override
	public void calculateTime(float distance) {
		float totalTime = (distance / super.getAverageSpeed()) * 60;
		float timeHour = (int)(totalTime / 60);
		float timeMinute = totalTime % 60;

		System.out.printf("Bicicleta:\n"
			+ "- Modelo: %s\n"
			+ "- Velocidade Média: %.0f Km/h\n"
			+ "- Tempo total de viagem: %.0f hora(s) e %.0f minuto(s)\n\n",
			super.getModel(), super.getAverageSpeed(), timeHour, timeMinute);
	}

}
