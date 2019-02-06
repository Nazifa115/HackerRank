package data_structures;

public class NodeCharacter {

	char val;
	NodeCharacter left, right;
	
	public NodeCharacter(char data, NodeCharacter l, NodeCharacter r) {
		this.val = data;
		this.left = l;
		this.right = r;
	}
}
