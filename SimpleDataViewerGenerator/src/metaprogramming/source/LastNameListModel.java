package metaprogramming.demo;

import javax.swing.AbstractListModel;

public class LastNameListModel extends DataFieldAbstractListModel{

	private DataModel model;
	private String listName = "Last Name";
	
	public LastNameListModel (DataModel model){
		this.model = model;
	}
	
	@Override
	public Object getElementAt(int index) {
		return model.get(index).getLastName();
	}

	@Override
	public int getSize() {
		return model.getSize();
	}

	@Override
	public void sort() {
		model.sortByLastName();
	}

	@Override
	public String getListName() {
		return this.listName;
	}

}
