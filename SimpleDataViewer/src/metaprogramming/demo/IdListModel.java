package metaprogramming.demo;

import javax.swing.AbstractListModel;

public class IdListModel extends DataFieldAbstractListModel{

	private DataModel model;
	private String listName = "Id";
	
	public IdListModel (DataModel model){
		this.model = model;
	}
	
	@Override
	public Object getElementAt(int index) {
		return model.get(index).getId();
	}

	@Override
	public int getSize() {
		return model.getSize();
	}

	@Override
	public void sort() {
		model.sortById();
	}

	@Override
	public String getListName() {
		return this.listName;
	}

}
