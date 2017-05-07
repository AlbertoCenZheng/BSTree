
public class BSTNode {
	BSTNode left, right, parent;
	String data;
	int counter;

	public BSTNode() {
		left = null;
		right = null;
		parent = null;
		data = this.data;
		counter = 1;
	}

	public BSTNode(String n) {
		left = null;
		right = null;
		parent = null;
		data = n;
		counter = 1;
	}

	public void setLeft(BSTNode n) {
		left = n;
	}

	public void setRight(BSTNode n) {
		right = n;
	}

	public BSTNode getLeft() {
		return left;
	}

	public BSTNode getRight() {
		return right;
	}

	public boolean hasLeft() {
		return !(left == null);
	}

	public boolean hasRight() {
		return !(right == null);
	}

	public void setData(String d) {
		data = d;
	}

	public String getData() {
		return data;
	}

	public void addCounter() {
		counter++;
	}

	public int getCounter() {
		return counter;
	}
}
