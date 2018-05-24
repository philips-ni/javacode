package crackcode;

import java.util.ArrayList;

/**
 * CC.OOP.7.4 Parking Lot
 * 
 * Question : Design a parking lot using object-oriented principles.
 *
 */
public class CC_OOP_7_4_Parking_Lot {

	public enum VehicleSize {
		Motorcycle, Compact, Large
	}

	public abstract class Vehicle {

		// The vehicle would need up to 5 spots
		protected ArrayList<ParkingSpot> parkingSpots = new ArrayList<ParkingSpot>();

		protected String licensePlate;
		protected int spotNeeded;
		protected VehicleSize size;

		public void parkInSpot(ParkingSpot spot) {
			parkingSpots.add(spot);
		}

		public void removeSpots() {
			parkingSpots.clear();
		}

		public abstract boolean canFitInSpot(ParkingSpot spot); // abstract
																// method

		public VehicleSize getSize() {
			return size;
		}

		public int getSpotNeeded() {
			return spotNeeded;
		}
	}

	public class Bus extends Vehicle {
		public Bus() {
			spotNeeded = 5;
			size = VehicleSize.Large;
		}

		public boolean canFitInSpot(ParkingSpot spot) {

		}
	}

	public class Car extends Vehicle {
		public Car() {
			spotNeeded = 1;
			size = VehicleSize.Compact;
		}

		public boolean canFitInSpot(ParkingSpot spot) {

		}

	}

	public class MotorCycle extends Vehicle {
		public MotorCycle() {
			spotNeeded = 1;
			size = VehicleSize.Motorcycle;
		}

		public boolean canFitInSpot(ParkingSpot spot) {

		}
	}

	public class ParkingLot {
		private level[] levels;
		private final int NUM_LEVELS = 5;

		public ParkingLot() {
		}

		public boolean parkVehicle(Vehicle vehicle) {
			return true;
		}
	}

	public class Level {
		private int floor;
		private ParkingSpot[] spots;
		private int availableSpots = 0;
		private static final int SPOTS_PER_ROW = 10;

		public Level(int flr, int numberSpots) {
			floor = flr;
			availableSpots = numberSpots;
		}

		public int getAvailable() {
			return availableSpots;
		}

		// Find a place to park vehicle. Return false if failed.
		public boolean parkVehicle(Vehicle vehicle) {

		}

		// Find a vehicle starting at spot and continue until
		// vehicle.spotsNeeded
		private boolean parkStartingAtSpot(Vehicle vehicle, int startSpot) {

		}

		// Find a spot to park vehicle. Return index of spot or -1 on failure.
		private int findAvailableSpots(Vehicle vehicle) {

		}

		public void spotFreed() {
			availableSpots++;
		}
	}

	public class ParkingSpot {
		private Vehicle vehicle;
		private VehicleSize spotSize;
		private Level level;
		private int row;
		private int spotNumber;

		public ParkingSpot(Level lvl, int r, int n, VehicleSize sz) {

		}

		public boolean isAvaiable() {
			return vehicle == null;
		}

		public boolean canFitVehicle(Vehicle vehicle) {

		}

		public boolean park(Vehicle v) {

		}

		public int getRow() {
			return row;
		}

		public int getSpotNumber() {
			return spotNumber;
		}

		// remove vehicle from spot and notify level that a new spot is
		// available
		public void removeVehicle() {

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
