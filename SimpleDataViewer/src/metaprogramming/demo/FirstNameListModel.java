package metaprogramming.demo;

import javax.swing.AbstractListModel;

public class FirstNameListModel extends DataFieldAbstractListModel{

	private DataModel model;
	private String listName = "First Name";
	
	public FirstNameListModel (DataModel model){
		this.model = model;
	}
	
	@Override
	public Object getElementAt(int index) {
		return model.get(index).getFirstName();
	}

	@Override
	public int getSize() {
		return model.getSize();
	}

	@Override
	public void sort() {
		model.sortByFirstName();
	}

	@Override
	public String getListName() {
		return this.listName;
	}

}
