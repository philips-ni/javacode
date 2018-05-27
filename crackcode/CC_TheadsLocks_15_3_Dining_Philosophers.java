package crackcode;

/**
 * CC.ThreadsLocks.15.3 Dining Philosophers
 * 
 * Question : In the famous dining philosophers problem, a bunch of philosophers
 * are sitting around a circular table with one chopstick between each of them.
 * A philosopher needs both chopsticks to eat, and always picks up the left
 * chopstick before the right one. A deadlock could potentially occur if all the
 * philosophers reached for the left chopstick at the same time. Using threads
 * and locks, implement a simulation of the dining philosophers problem that
 * prevents deadlocks.
 * 
 * Pseudo code:
 * 
 * while(true) {
 * 
 * // Initially, thinking about life, universe, and everything
 * 
 * think();
 * 
 * // Take a break from thinking, hungry now
 * 
 * pick_up_left_fork();
 * 
 * pick_up_right_fork();
 * 
 * eat();
 * 
 * put_down_right_fork();
 * 
 * put_down_left_fork();
 * 
 * // Not hungry anymore. Back to thinking!
 * 
 * }
 *
 */
public class CC_TheadsLocks_15_3_Dining_Philosophers {

	public class Philosopher implements Runnable {

		// The forks on either side of this Philosopher
		private Object leftFork;
		private Object rightFork;

		public Philosopher(Object leftFork, Object rightFork) {
			this.leftFork = leftFork;
			this.rightFork = rightFork;
		}

		private void doAction(String action) throws InterruptedException {
			System.out.println(Thread.currentThread().getName() + " " + action);
			Thread.sleep(((int) (Math.random() * 100)));
		}

		@Override
		public void run() {
			try {
				while (true) {
					// thinking
					doAction(System.nanoTime() + ": Thinking");
					synchronized (leftFork) {
						doAction(System.nanoTime() + ": Picked up left fork");
						synchronized (rightFork) {
							// eating
							doAction(System.nanoTime() + ": Picked up right fork - eating");

							doAction(System.nanoTime() + ": Put down right fork");
						}

						// Back to thinking
						doAction(System.nanoTime() + ": Put down left fork. Back to thinking");
					}
				}
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				return;
			}
		}
	}

	public void start() {
		Philosopher[] philosophers = new Philosopher[5];
		Object[] forks = new Object[philosophers.length];

		for (int i = 0; i < forks.length; i++) {
			forks[i] = new Object();
		}

		for (int i = 0; i < philosophers.length; i++) {
			Object leftFork = forks[i];
			Object rightFork = forks[(i + 1) % forks.length];

			// The primary reason for a deadlock is the circular wait condition where each
			// process waits upon a resource that’s being held by some other process.
			// Hence, to avoid a deadlock situation we need to make sure that the circular
			// wait condition is broken.

			// philosophers[i] = new Philosopher(leftFork, rightFork);

			// Solution:
			// All Philosophers reach for their left fork first, except
			// one who first reaches for his right fork.
			if (i == philosophers.length - 1) {
				// The last philosopher picks up the right fork first
				philosophers[i] = new Philosopher(rightFork, leftFork);
			} else {
				philosophers[i] = new Philosopher(leftFork, rightFork);
			}

			Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
			t.start();
		}
	}

	public static void main(String[] args) throws Exception {
		CC_TheadsLocks_15_3_Dining_Philosophers test = new CC_TheadsLocks_15_3_Dining_Philosophers();
		test.start();
	}

}
