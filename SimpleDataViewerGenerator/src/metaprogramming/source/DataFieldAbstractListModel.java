package metaprogramming.demo;

import javax.swing.AbstractListModel;

public abstract class DataFieldAbstractListModel extends AbstractListModel {

	public abstract void sort();
	
	public abstract String getListName();
}
