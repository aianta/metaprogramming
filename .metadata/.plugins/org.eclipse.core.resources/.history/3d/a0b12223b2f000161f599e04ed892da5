package metaprogramming.demo;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.beans.PropertyChangeSupport;

public class SimpleDataViewer extends JFrame {

	private JPanel contentPane;
	private boolean componentUpdate = false;
	private PropertyChangeSupport stateProperty =
			new PropertyChangeSupport(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleDataViewer frame = new SimpleDataViewer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public SimpleDataViewer() {
		setTitle("Simple Data Viewer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		Data record1 = new Data();
		record1.setFirstName("Bob");
		record1.setLastName("Marley");
		record1.setId(5);
		
		
		Data record2 = new Data(); 
		record2.setFirstName("Tim");
		record2.setLastName("Cook");
		record2.setId(1);
		
		Data record3 = new Data();
		record3.setFirstName("Alex");
		record3.setLastName("Ianta");
		record3.setId(7);
		
		DataModel dataModel = new DataModel();
		dataModel.addData(record1);
		dataModel.addData(record2);
		dataModel.addData(record3);
		
		FirstNameListModel firstNameModel = new FirstNameListModel (dataModel);
		LastNameListModel lastNameModel = new LastNameListModel(dataModel);
		IdListModel idModel = new IdListModel(dataModel);
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {1, 1, 1};
		gbl_contentPane.rowHeights = new int[]{1, 0};

		gbl_contentPane.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		//Load First Name Data Field
		DataFieldPanel firstNamePanel = new DataFieldPanel(firstNameModel, this);
		GridBagConstraints gbc_firstNamePanel = new GridBagConstraints();
		gbc_firstNamePanel.fill = GridBagConstraints.BOTH;
		gbc_firstNamePanel.gridx = 0;
		gbc_firstNamePanel.gridy = 0;
		contentPane.add(firstNamePanel, gbc_firstNamePanel);
		
		//Load Last Name Data Field
		DataFieldPanel lastNamePanel = new DataFieldPanel(lastNameModel, this);
		GridBagConstraints gbc_lastNamePanel = new GridBagConstraints();
		gbc_lastNamePanel.fill = GridBagConstraints.BOTH;
		gbc_lastNamePanel.gridx = 1;
		gbc_lastNamePanel.gridy = 0;
		contentPane.add(lastNamePanel, gbc_lastNamePanel);
		
		//Load Id Data Field
		DataFieldPanel idPanel = new DataFieldPanel(idModel, this);
		GridBagConstraints gbc_idPanel = new GridBagConstraints();
		gbc_idPanel.fill = GridBagConstraints.BOTH;
		gbc_idPanel.gridx = 2;
		gbc_idPanel.gridy = 0;
		contentPane.add(idPanel, gbc_idPanel);
		
		
		stateProperty.addPropertyChangeListener(new SimpleDataViewerListener(firstNamePanel));
		stateProperty.addPropertyChangeListener(new SimpleDataViewerListener(lastNamePanel));
		stateProperty.addPropertyChangeListener(new SimpleDataViewerListener(idPanel));
		
	}

	public boolean isStateChanged() {
		
		return componentUpdate;
	}

	public void changeState() {

		boolean oldComponentUpdate = componentUpdate;
		
		if (this.componentUpdate){
			this.componentUpdate = false;
		}else{
			this.componentUpdate = true;
		}
		
		stateProperty.firePropertyChange("componentUpdate", oldComponentUpdate, componentUpdate);
	}
	


}
