package metaprogramming.demo;

import java.util.ArrayList;

public class DataModel {
	
	private ArrayList<Data> data = new ArrayList<Data>();

	public Data get(int index) {
		return data.get(index);
	}
	
	public int getSize(){
		return data.size();
	}

	public void addData (Data data){
		this.data.add(data);
	}
	
	public void sortByFirstName(){
		data.sort(new FirstNameComparator());
	}
	
	public void sortByLastName(){
		data.sort(new LastNameComparator());
	}
	
	public void sortById(){
		data.sort(new IdComparator());
	}

	public ArrayList<Data> getData() {
		return data;
	}
	
}
