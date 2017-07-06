package data_structures;

public class NodeInteger {

	int val;
	NodeInteger left, right;
	
	public NodeInteger(int data, NodeInteger l, NodeInteger r) {
		this.val = data;
		this.left = l;
		this.right = r;
	}
}
