package freeFallSimulation;

public class FreeFallSimulation {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Please provide 3 double values as command-line arguments.");
			return;
		}

		double initialAcceleration = Double.parseDouble(args[0]);
		double timeConstant = Double.parseDouble(args[1]);
		double fallTime = Double.parseDouble(args[2]);

		double velocity = calculateVelocity(initialAcceleration, timeConstant, fallTime);
		double displacement = calculateDisplacement(initialAcceleration, fallTime, velocity);
		double finalResult = calculateCombinedResult(initialAcceleration, displacement);

		finalResult = Math.round(finalResult * 100) * 1.0 / 100;
		System.out.println(finalResult);
	}

	// Function to calculate the velocity of a free-falling object based on initial
	// acceleration, time constant, and fall time
	// Input ranges: initialAcceleration >= 0, timeConstant > 0, fallTime >= 0
	public static double calculateVelocity(double initialAcceleration, double timeConstant, double fallTime) {
		// Velocity calculation: v = initialAcceleration * (1 - e^(-timeConstant *
		// fallTime))
		double velocity = initialAcceleration * (1 - Math.exp(-timeConstant * fallTime));
		return velocity % 100000;
	}

	// Function to calculate the displacement of a free-falling object based on
	// initial acceleration, time constant, fall time, and velocity
	// Input ranges: initialAcceleration >= 0, timeConstant > 0, fallTime >= 0
	public static double calculateDisplacement(double initialAcceleration, double fallTime, double velocity) {
		// Displacement calculation: s = 0.5 * initialAcceleration * fallTime^2 +
		// velocity * fallTime
		double displacement = 0.5 * initialAcceleration * Math.pow(fallTime, 2) + velocity * fallTime;
		return displacement % 100000;
	}

	// Function to calculate a combined value based on initial acceleration, time
	// constant, fall time, and displacement
	// Input ranges: initialAcceleration >= 0, timeConstant > 0, fallTime >= 0
	public static double calculateCombinedResult(double timeConstant, double displacement) {
		// Example combined value: |displacement| * timeConstant
		double finalResult = Math.abs(displacement) * timeConstant;
		return finalResult % 100000;
	}
}
