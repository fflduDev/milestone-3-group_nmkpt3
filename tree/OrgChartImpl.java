package tree;

import java.util.ArrayList;
import java.util.List;

public class OrgChartImpl implements OrgChart {

	// Employee is your generic 'E'..
	private List<GenericTreeNode<Employee>> nodes = new ArrayList<>();
	private GenericTreeNode<Employee> root;

	@Override
	public void addRoot(Employee e) {
		root = new GenericTreeNode<Employee>(e);
		nodes.add(root);
	}

	@Override
	public void clear() {
		nodes = new ArrayList<>();
		root = null;

	}

	@Override
	public void addDirectReport(Employee manager, Employee newPerson) {
		// TODO Auto-generated method stub

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
