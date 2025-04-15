package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class OrgChartImpl implements OrgChart {

	// Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();
	private GenericTreeNode<Employee> root = null;

	@Override
	public void addRoot(Employee e) {
		if (root == null) {
			root = new GenericTreeNode<Employee>(e);
			// GenericTreeNode<Employee> root = new GenericTreeNode<Employee>(e);
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
		for (int i = 0; i < nodes.size(); i++) {
			GenericTreeNode<Employee> currentEmployee = nodes.get(i);
			if (currentEmployee.data.equals(manager)) {
				GenericTreeNode<Employee> newNode = new GenericTreeNode<Employee>(newPerson);
				currentEmployee.addChild(newNode);
				nodes.add(newNode);
				break;
			}
		}

	}

	@Override
	public void removeEmployee(Employee firedPerson) {
		for (GenericTreeNode<Employee> currentEmployee : nodes) {
			for (int i = 0; i < currentEmployee.children.size(); i++) {
				GenericTreeNode<Employee> child = currentEmployee.children.get(i);
				if (child.data.equals(firedPerson)) {
					currentEmployee.removeChild(firedPerson);
					nodes.remove(child);
					return;
				}
			}
		}
	}

	@Override
	public void showOrgChartDepthFirst() {
		if (root == null) {
			return;
		}

		Stack<GenericTreeNode<Employee>> stack = new Stack<>();
		ArrayList<Employee> explored = new ArrayList<>();

		stack.push(root);

		while (!stack.isEmpty()) {
			GenericTreeNode<Employee> current = stack.pop();

			if (!explored.contains(current.data)) {
				explored.add(current.data);
			}

			for (int i = current.children.size() - 1; i >= 0; i--) {
				stack.push(current.children.get(i));
			}
		}

		System.out.println("Org Chart (DFS) of the comapny is: ");
		for (Employee e : explored) {
			System.out.println("- " + e.toString());
		}

	}

	@Override
	public void showOrgChartBreadthFirst() {
		if (root == null) {
			return;
		}

		Queue<GenericTreeNode<Employee>> queue = new LinkedList<>();
		ArrayList<Employee> explored = new ArrayList<>();

		for (int i = 0; i < nodes.size(); i++) {
			queue.add(nodes.get(i));
			while (!queue.isEmpty()) {
				GenericTreeNode<Employee> current = queue.remove();

				if (!explored.contains(current.data)) {
					explored.add(current.data);
				}
				if (current.children.size() > 0) {
					queue.addAll(current.children);
				}

			}
		}

		System.out.println("Org Chart (BFS) of the company is: ");
		for (Employee e : explored)
			System.out.println(e.toString());
	}
}