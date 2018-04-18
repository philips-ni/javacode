package foundation;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
	private String id;
	private TreeNode parent;
	private List<TreeNode> children = new ArrayList<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<TreeNode> getChildren() {
		return this.children;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	public TreeNode getParent() {
		return this.parent;
	}
}
