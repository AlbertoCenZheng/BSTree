import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Alberto Cen Zheng Date Apr/30th/2017 Class CSI213 Prof Dr.Magnus
 * 
 *         Create a tree to keep track of the frequency of the work appear in
 *         the file
 *
 */
public class BStree {

	private static BSTNode root = null;

	public BStree() {
		root = null;
	}

	//be able to set root
	public void setRoot(String data) {
		root = new BSTNode(data);
	}

	//return the root
	public BSTNode getRoot() {
		return root;
	}

	public void insert(String data) {
		if (root != null) {
			insert(root, data);
		} else {
			root = new BSTNode(data);
		}
	}

	// insert a node, if it already exist, increase its counter;
	private static void insert(BSTNode node, String data) {
		if (data.compareTo(node.getData()) < 0) {
			if (node.left != null) {
				insert(node.left, data);
			} else {
				// System.out.println("++Inserted " + data + " to left of " +
				// node.getData());
				node.left = new BSTNode(data);
			}
		} else if (data.compareTo(node.getData()) > 0) {
			if (node.right != null) {
				insert(node.right, data);
			} else {
				// System.out.println("--Inserted " + data + " to right of " +
				// node.getData());
				node.right = new BSTNode(data);
			}
		} else if (data.compareTo(node.getData()) == 0) {
			node.addCounter();
		}
	}

	//
	public void inorder() {
		inorder(root);
	}

	//go through the whole list;
	private void inorder(BSTNode r) {
		if (r != null) {
			inorder(r.getLeft());
			System.out.println(r.getData() + " :" + r.getCounter());
			inorder(r.getRight());
		}
	}

	//find the node of correponding data;
	public BSTNode find(BSTNode node, String word) {
		if (root == null) {
			return null;
		} else if (word.compareTo(root.getData()) < 0) {
			if (root.left != null) {
				return find(root.left, word);
			}
		} else if (word.compareTo(root.getData()) > 0) {
			if (root.right != null) {
				return find(root.right, word);
			}
		} else if (word.compareTo(root.getData()) == 0) {
			return node;
		}
		return null;

	}

	//don't know how to do this one......  :(
	public BSTNode delete(String data) {
		return null;
	}

	public static void main(String[] args) throws IOException {

		// System.out.println(new File("wordsFrequency.txt").exists());
		// System.out.println(new File("wordsFrequency.txt").getAbsoluteFile());

		BStree tree = new BStree();
		FileInputStream fstream = new FileInputStream("wordsFrequency.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;

		// Read File Line By Line
		while ((strLine = br.readLine()) != null) {
			// Print the content on the console
			// System.out.println(strLine);
			tree.insert(strLine);
		}

		// Close the input stream
		br.close();

		tree.inorder();

		System.out.println("\nfind and print out its counter");

		System.out.println(tree.find(root, "because").getCounter());

	}

}
