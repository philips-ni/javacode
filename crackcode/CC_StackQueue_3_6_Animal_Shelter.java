package crackcode;

import java.util.LinkedList;

/**
 * CC.StackQueue.3.6 Animal Shelter
 * 
 * Question : An animal shelter, which holds only dogs and cats, operates on a
 * strictly "first in, first out" basis.People must adopt either the
 * oldest(based on arrival time) of all animals at the shelter, or they can
 * select whether they would prefer a dog or a cat (and will receive the oldest
 * animal of that type). They cannot select which specific animal they would
 * like. Create the data structure to maintain this system and implement
 * operations such as enqueue, dequeueAny, dequeueDog and dequeueCat.you may use
 * the built-in LinkedList data structure.
 *
 */
public class CC_StackQueue_3_6_Animal_Shelter {

	abstract class Animal {
		private int order;

		public Animal() {

		}

		public void setOrder(int order) {
			this.order = order;
		}

		public int getOrder() {
			return this.order;
		}

		public boolean isOlderThan(Animal a) {
			if (this.order < a.getOrder())
				return true;
			else
				return false;
		}
	}

	class Dog extends Animal {
		public Dog() {
			super();
		}
	}

	class Cat extends Animal {
		public Cat() {
			super();
		}
	}

	public class shelter {
		LinkedList<Dog> dogs = new LinkedList<Dog>();
		LinkedList<Cat> cats = new LinkedList<Cat>();

		private int order = 0;

		public void enqueue(Animal a) {
			a.setOrder(order);
			order++;

			if (a instanceof Dog)
				dogs.add((Dog) a);
			else if (a instanceof Cat)
				cats.add((Cat) a);
		}

		public Animal dequeueAny() {
			if (dogs.size() == 0)
				return dequeueCats();
			else if (cats.size() == 0)
				return dequeueDogs();

			Dog dog = dogs.peek();
			Cat cat = cats.peek();

			if (dog.isOlderThan(cat)) {
				return dequeueDogs();
			} else {
				return dequeueCats();
			}
		}

		public Dog dequeueDogs() {
			return dogs.poll();
		}

		public Cat dequeueCats() {
			return cats.poll();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
