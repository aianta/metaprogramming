package metaprogramming.demo;

import java.util.ArrayList;

public class DataField {
	
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

	public ArrayList<Data> getData() {
		return data;
	}
	
}
