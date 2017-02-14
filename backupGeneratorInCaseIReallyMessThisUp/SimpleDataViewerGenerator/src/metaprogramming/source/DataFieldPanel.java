package metaprogramming.demo;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class DataFieldPanel extends JPanel {

	private JList dataList;
	
	public DataFieldPanel(DataFieldAbstractListModel data, SimpleDataViewer owner) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{51, 0};
		gridBagLayout.rowHeights = new int[]{0, 48, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel DataFieldName = new JLabel(data.getListName());
		Border padding = BorderFactory.createEmptyBorder(10,10,10,10);
		DataFieldName.setBorder(padding);
		DataFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_DataFieldName = new GridBagConstraints();
		gbc_DataFieldName.fill = GridBagConstraints.HORIZONTAL;
		gbc_DataFieldName.insets = new Insets(0, 0, 5, 0);
		gbc_DataFieldName.gridx = 0;
		gbc_DataFieldName.gridy = 0;
		add(DataFieldName, gbc_DataFieldName);
		
		dataList = new JList();
		dataList.setEnabled(false);
		dataList.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null)); 
		
		dataList.setModel(data);
		
		GridBagConstraints gbc_DataList = new GridBagConstraints();
		gbc_DataList.fill = GridBagConstraints.HORIZONTAL;
		gbc_DataList.insets = new Insets(0, 0, 5, 0);
		gbc_DataList.anchor = GridBagConstraints.NORTH;
		gbc_DataList.gridx = 0;
		gbc_DataList.gridy = 1;
		add(dataList, gbc_DataList);
		
		JButton DataFieldSort = new JButton("Sort");
		DataFieldSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.sort();
				dataList.updateUI();
				owner.changeState();
			}
		});
		
		GridBagConstraints gbc_DataFieldSort = new GridBagConstraints();
		gbc_DataFieldSort.fill = GridBagConstraints.HORIZONTAL;
		gbc_DataFieldSort.gridx = 0;
		gbc_DataFieldSort.gridy = 2;
		add(DataFieldSort, gbc_DataFieldSort);

	}

	public JList getDataList() {
		return dataList;
	}

}
