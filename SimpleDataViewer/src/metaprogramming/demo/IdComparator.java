package metaprogramming.demo;

import java.util.Comparator;

public class IdComparator implements Comparator<Data> {

	@Override
	public int compare(Data data1, Data data2) {
		return data1.getId().compareTo(data2.getId());
	}

}
