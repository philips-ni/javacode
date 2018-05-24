package dynamicprogramming;

import java.util.HashMap;

/**
 * Jumping Ball
 * 
 * Question : We're on a crazy jumping ball, trying to stop, while avoiding
 * spikes along the way.
 * 
 * Here are the rules:
 * 
 * 1) You¡®re given a flat runway with a bunch of spikes in it. The runway is
 * represented by a boolean array which indicates if a particular (discrete)
 * spot is clear of spikes. It is True for clear and False for not clear.
 * 
 * 2) Youâ€™re given a starting speed S. S is a non-negative integer at any given
 * point and it indicates how much you will move forward with the next jump.
 * 
 * 3) Every time you land on a spot, you can adjust your speed by up to 1 unit
 * before the next jump.
 * 
 * 4) You want to safely stop anywhere along the runway (does not need to be at
 * the end of the array). You stop when your speed becomes 0. However, if you
 * land on a spike at any point, your crazy bouncing ball bursts and itâ€™s a game
 * over.
 * 
 * The output of your function should be a boolean indicating whether we can
 * safely stop anywhere along the runway.
 *
 */
public class Jumping_Ball {

	public static boolean canStop(boolean[] runway, int speed, int location) {
		if (location >= runway.length || location < 0 || speed < 0 || !runway[location]) {
			return false;
		}

		if (speed == 0) {
			return true;
		}

		int[] speeds = { speed, speed - 1, speed + 1 };
		for (int newspeed : speeds) {
			if (canStop(runway, newspeed, location + newspeed)) {
				return true;
			}
		}

		return false;
	}

	public static boolean canStop_dp(boolean[] runway, int speed, int location, HashMap<String, Boolean> map) {

		String k = "speed" + "_" + location;

		if (map.containsKey(k))
			return map.get(k);

		if (location >= runway.length || location < 0 || speed < 0 || !runway[location]) {
			map.put(k, false);
			return false;
		}

		if (speed == 0) {
			map.put(k, true);
			return true;
		}

		int[] speeds = { speed, speed - 1, speed + 1 };
		for (int newspeed : speeds) {
			if (canStop(runway, newspeed, location + newspeed)) {
				map.put(k, true);
				return true;
			}
		}

		map.put(k, false);
		return false;
	}

	public static void main(String[] args) {

		boolean[] runway = { true, false, true, true, true, false, true, true, false, true, true };
		System.out.println(canStop(runway, 4, 0));

		HashMap<String, Boolean> map = new HashMap<String,Boolean>();
		System.out.println(canStop_dp(runway, 4, 0, map));

	}

}
