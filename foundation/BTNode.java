package foundation;

public class BTNode {
	public int val;
	public BTNode left;
	public BTNode right;
	public BTNode parent; // not necessary for general tree but useful for special cases

	public BTNode() {

	}

	public BTNode(int value) {
		this.val = value;
	}
}
