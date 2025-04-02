package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OrgChartImpl implements OrgChart {

	// Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();
	private GenericTreeNode<Employee> root = null;

	@Override
	public void addRoot(Employee e) {
		if(root== null) {
			GenericTreeNode<Employee> root = new GenericTreeNode<Employee>(e);
			nodes.add(root);
		}
	}

	@Override
	public void clear() {
		nodes = new ArrayList<>();
		root = null;

	}

	@Override
	public void addDirectReport(Employee manager, Employee newPerson) {
		// TODO Auto-generated method stub
		for(int i = 0; i< nodes.size(); i++) {
			GenericTreeNode<Employee> currentEmployee = nodes.get(i);
			if(currentEmployee.data.equals(manager)) {
				GenericTreeNode<Employee> newNode = new GenericTreeNode<Employee>(newPerson);
				currentEmployee.addChild(newNode);
				nodes.add(newNode);
				break;
			}
		}

	}

	@Override
	public void removeEmployee(Employee firedPerson) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showOrgChartDepthFirst() {
		// TODO Auto-generated method stub

	}

	
	@Override
	public void showOrgChartBreadthFirst() {
		if(root == null) {
			return;
		}
		
		Queue<GenericTreeNode> q = new LinkedList<>();
		q.add(root);
		
		for(int i = 0; i < nodes.size(); i++) {
			while (!q.isEmpty()) {
				int n = q.size();

				// If this node has children
				while (n > 0) {
					// Dequeue an item from queue and print it
					TreeNode p = q.peek();
					q.remove();
					System.out.print(p.key + " ");
				}
			}
		}
            
        

	}

}
