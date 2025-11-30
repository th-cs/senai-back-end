// Print a different message according to the object that is calling the
// overridden method
package ex01Vehicles;

public class Main {
	public static void main(String[] args) {

		Vehicle vehicle = new Vehicle();
		Car car = new Car();

		vehicle.start();
		car.start();
	}
}
