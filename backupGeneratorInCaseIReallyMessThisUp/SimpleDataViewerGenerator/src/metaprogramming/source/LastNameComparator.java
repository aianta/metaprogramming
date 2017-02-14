package metaprogramming.demo;

import java.util.Comparator;

public class LastNameComparator implements Comparator<Data> {

	@Override
	public int compare(Data data1, Data data2) {
		// TODO Auto-generated method stub
		return data1.getLastName().compareTo(data2.getLastName());
	}
	

}
