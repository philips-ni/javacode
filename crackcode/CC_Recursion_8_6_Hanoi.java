package crackcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * CC.Recursion.8.6 Towers Of Hanoi
 * 
 * Question : In the classic problem of the Towers of Hanoi, you have 3 towers
 * and N disks of different sizes which can slide onto any tower. The puzzle
 * starts with disks sorted in ascending order of size from top to bottom(i.e.
 * each disk sits on top of an even larger one). You have the following
 * constraints:
 * 
 * 1) Only one disk can be moved at a time
 * 
 * 2) A disk is slid off the top of one tower onto another tower
 * 
 * 3) A disk cannot be placed on top of a smaller disk
 * 
 * Write a program to move the disks from the first tower to the last using
 * stacks.
 *
 */
public class CC_Recursion_8_6_Hanoi {

	public class Tower {
		private Stack<Integer> disks;

		Tower(int index) {
			disks = new Stack<Integer>();
		}

		public Stack<Integer> getDisks() {
			return disks;
		}

		public void add(int disk) {
			if (!disks.isEmpty() && disks.peek() < disk) {
				System.out.println("Can't push larger disk on smaller one");
			} else {
				disks.push(disk);
			}
		}

		public void moveLastDisk(Tower target) {
			target.add(disks.pop());
		}

		public void moveDisks(int nDisks, Tower target, Tower buffer) {
			if (nDisks == 0)
				return;

			moveDisks(nDisks - 1, buffer, target);

			moveLastDisk(target);

			buffer.moveDisks(nDisks - 1, target, this);
		}
	}

	public void moveDisks() {
		Tower[] towers = new Tower[3];

		for (int i = 0; i < 3; i++) {
			towers[i] = new Tower(i);
		}

		int nDisks = 3;
		for (int i = nDisks; i > 0; i--) {
			towers[0].add(i);
		}

		printTower(towers[0]);
		towers[0].moveDisks(nDisks, towers[1], towers[2]);
		printTower(towers[1]);
	}

	public void printTower(Tower t) {
		System.out.println(Arrays.toString(t.getDisks().toArray()));
	}

	public static void main(String[] args) {
		CC_Recursion_8_6_Hanoi test = new CC_Recursion_8_6_Hanoi();
		test.moveDisks();
	}

}
