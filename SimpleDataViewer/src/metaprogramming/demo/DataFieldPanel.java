package metaprogramming.demo;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DataFieldPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public DataFieldPanel(DataField data) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{51, 0};
		gridBagLayout.rowHeights = new int[]{0, 48, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel DataFieldName = new JLabel("First Name");
		GridBagConstraints gbc_DataFieldName = new GridBagConstraints();
		gbc_DataFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_DataFieldName.insets = new Insets(0, 0, 5, 0);
		gbc_DataFieldName.gridx = 0;
		gbc_DataFieldName.gridy = 0;
		add(DataFieldName, gbc_DataFieldName);
		
		JList DataList = new JList();
		DataList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		AbstractListModel dataFieldModel = new AbstractListModel() {
			DataField values = data;
			public int getSize() {
				return values.getSize();
			}
			public Object getElementAt(int index) {
				return data.get(index).getFirstName();
			}
		}; 
		
		DataList.setModel(dataFieldModel);
		
		GridBagConstraints gbc_DataList = new GridBagConstraints();
		gbc_DataList.fill = GridBagConstraints.HORIZONTAL;
		gbc_DataList.insets = new Insets(0, 0, 5, 0);
		gbc_DataList.anchor = GridBagConstraints.NORTH;
		gbc_DataList.gridx = 0;
		gbc_DataList.gridy = 1;
		add(DataList, gbc_DataList);
		
		JButton DataFieldSort = new JButton("Sort");
		DataFieldSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.sortByFirstName();
				DataList.updateUI();
			}
		});
		
		GridBagConstraints gbc_DataFieldSort = new GridBagConstraints();
		gbc_DataFieldSort.fill = GridBagConstraints.HORIZONTAL;
		gbc_DataFieldSort.gridx = 0;
		gbc_DataFieldSort.gridy = 2;
		add(DataFieldSort, gbc_DataFieldSort);

	}

}
