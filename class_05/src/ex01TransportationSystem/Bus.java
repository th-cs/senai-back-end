// This class describes how to calculate the travel time for a bus
package ex01TransportationSystem;

public class Bus extends Vehicle {

	// Attribute
	private int stops;

	// Setter
	public void setStops(int stops) {
		this.stops = stops;
	}

	// Overridden method
	@Override
	public void calculateTime(float distance) {
		float totalTime = ((distance / super.getAverageSpeed()) * 60)
			+ 15 * stops;
		float timeHour = (int)(totalTime / 60);
		float timeMinute = totalTime % 60;
		float stopsTimeHour = (int)((stops * 15) / 60);
		float stopsTimeMinute = (stops * 15) % 60;

		System.out.printf("Ônibus:\n"
			+ "- Modelo: %s\n"
			+ "- Velocidade Média: %.0f Km/h\n"
			+ "- Quantidade de paradas: %d (+ %.0f hora(s) e %.0f minuto(s) de "
			+ "viagem)\n"
			+ "- Tempo total de viagem: %.0f hora(s) e %.0f minuto(s)\n\n",
			super.getModel(), super.getAverageSpeed(), this.stops,
			stopsTimeHour, stopsTimeMinute, timeHour, timeMinute);
	}

}
