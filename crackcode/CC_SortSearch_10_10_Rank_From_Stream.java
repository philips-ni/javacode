package crackcode;

/**
 * CC.SortSearch.10.10 Rank From Stream
 * 
 * Question : Imagine you are reading in a stream of integers. Periodically, you
 * wish to be able to look up the rank of a number x (the number of values less
 * than or equal to x). Implement the data structure and algorithms to support
 * these operations. That is, implement the method track(int x), which is called
 * when each number is generated, and the method getRankOfNumber(int x), which
 * returns the number of values less than or equal to x (not including x
 * itself).
 * 
 * e.g.
 * 
 * Stream : 5,1,4,4,5,9,7,13,3
 * 
 * getRankOfNumber(1)=0
 * 
 * getRankOfNumber(3)=1
 *
 */
public class CC_SortSearch_10_10_Rank_From_Stream {

	public class RankNode {
		public int data = 0;
		public RankNode left, right;
		public int left_size = 0;

		public RankNode(int d) {
			data = d;
		}

		public void insert(int d) {
			if (d <= data) {
				if (left == null) {
					left = new RankNode(d);
				} else {
					left.insert(d);
				}
				left_size++;
			} else {
				if (right == null) {
					right = new RankNode(d);
				} else {
					right.insert(d);
				}
			}
		}

		public int getRank(int d) {
			if (d == data) {
				return left_size;
			} else if (d < data) {
				if (left == null)
					return -1;
				else
					return left.getRank(d);
			} else {
				int right_rank = right == null ? -1 : right.getRank(d);
				if (right_rank == -1)
					return -1;
				else
					return left_size + 1 + right_rank;
			}
		}
	}

	private RankNode root = null;

	public void track(int x) {
		if (root == null){
			root = new RankNode(x);
		}
		else
			root.insert(x);
	}

	public int getRankOfNumber(int x) {
		return root.getRank(x);
	}

	public static void main(String[] args) {
		CC_SortSearch_10_10_Rank_From_Stream test = new CC_SortSearch_10_10_Rank_From_Stream();
		test.track(5);
		test.track(10);
		test.track(13);
		test.track(15);
		test.track(20);
		test.track(25);
		test.track(23);
		test.track(24);

		System.out.println(test.getRankOfNumber(25));
	}

}
