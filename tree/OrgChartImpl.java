package tree;

import java.util.ArrayList;
import java.util.List;

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
				GenericTreeNode<Employee> newNode = new GenericTreeNode<>(newPerson);
				currentEmployee.addChild(newNode);
				nodes.add(newNode);
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
		// TODO Auto-generated method stub

	}

}
