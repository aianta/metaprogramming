package metaprogramming.demo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SimpleDataViewerListener implements PropertyChangeListener{

	DataFieldPanel dataPanel;
	
	public SimpleDataViewerListener (DataFieldPanel dataPanel){
		this.dataPanel = dataPanel;
	}
	
	public void propertyChange(PropertyChangeEvent evt) {
		
		String propertyName = evt.getPropertyName();
		
		if (propertyName.equals("componentUpdate")){
			dataPanel.getDataList().updateUI();
		}	
	}

}
