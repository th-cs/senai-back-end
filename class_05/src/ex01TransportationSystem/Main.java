// Calculate the travel time for a bicycle, a bus and a car
package ex01TransportationSystem;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		boolean isMenuOpen;
		int menuOption;
		float distance;
		String[] vehicleType = {"Bicicleta", "Ônibus", "Carro"};

		Bicycle bicycle = new Bicycle();
		Bus bus = new Bus();
		Car car = new Car();

		Vehicle[] vehicleList = {bicycle, bus, car};

		Scanner input = new Scanner(System.in);

		System.out.println("-- Sistema de Transportes: Cálculo do tempo de "
			+ "viagem para diferentes veículos --\n");

		isMenuOpen = true;

		while(isMenuOpen) {
			System.out.println("Olá, qual é o modelo de cada veículo?");
			for (int i = 0; i < vehicleType.length; i++) {
				System.out.printf("%s: ", vehicleType[i]);
				vehicleList[i].setModel(input.nextLine());
			}

			System.out.println("\nQual é a velocidade média de cada veículo "
				+ "durante a viagem (Km/h)?");
			for (int i = 0; i < vehicleType.length; i++) {
				System.out.printf("%s: ", vehicleType[i]);
				vehicleList[i].setAverageSpeed(input.nextFloat());
			}

			System.out.print("\nAconteceram quantas paradas de ônibus? ");
			bus.setStops(input.nextInt());

			System.out.print("Qual foi a distância total da viagem (Km)? ");
			distance = input.nextFloat();

			System.out.printf("\nCálculo para uma viagem de %.0f Km:\n",
				distance);

			for (Vehicle k : vehicleList) {
				k.calculateTime(distance);
			}

			do {
				System.out.println("Deseja calcular novamente com outros "
					+ "valores ou veículos?\n"
					+ "| 1 | - Sim\n"
					+ "| 2 | - Não");
				menuOption = input.nextInt();

				switch (menuOption) {
					case 1:
						input.nextLine();
						break;
					case 2:
						System.out.println("Saindo do sistema...");
						isMenuOpen = false;
						break;
					default:
						System.out.println("Opção não aceita");
						break;
				}
			} while(menuOption < 1 || menuOption > 2);
		}

		input.close();
	}
}
