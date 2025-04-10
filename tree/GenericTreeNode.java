package tree;
import java.util.ArrayList;

public class GenericTreeNode<E> {
	E data;
	//<some list of children>
	ArrayList<GenericTreeNode<E>> children = new ArrayList<>();
	
	public GenericTreeNode(E theItem) {
		data = theItem;
	}
	
	public void addChild(GenericTreeNode<E> theItem) {
		children.add(theItem);
	}
	
	public void removeChild(E theItem) {
		// this one is a little harder.
		// what do you do when the item has children?
		// I suggest "give them to the parent"
	       for (int i = 0; i < children.size(); i++) {
	           GenericTreeNode<E> child = children.get(i);
	           if (child.data.equals(theItem)) {
	               // Promote its children to this node
	               children.addAll(child.children);
	               // Remove the child
	               children.remove(i);
	               return;
	           }
	       }
		
	}
	
	
} 
