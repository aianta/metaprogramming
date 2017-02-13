package metaprogramming.generator;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class JobPanel extends JPanel {
	
	private ArrayList<ExplicitTarget> panelExplicitTargets = new ArrayList<ExplicitTarget>(); 

	private Job j;

	/**
	 * Create the panel.
	 */
	public JobPanel(Job j) {
		setForeground(Color.LIGHT_GRAY);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{158, 39, 86, 0, 0};
		gridBagLayout.rowHeights = new int[]{26, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblJob = new JLabel("Job:");
		GridBagConstraints gbc_lblJob = new GridBagConstraints();
		gbc_lblJob.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblJob.insets = new Insets(0, 0, 5, 5);
		gbc_lblJob.gridx = 0;
		gbc_lblJob.gridy = 0;
		add(lblJob, gbc_lblJob);
		
		JLabel lblJobname = new JLabel(j.getName());
		lblJobname.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_lblJobname = new GridBagConstraints();
		gbc_lblJobname.insets = new Insets(0, 0, 5, 5);
		gbc_lblJobname.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblJobname.gridx = 1;
		gbc_lblJobname.gridy = 0;
		add(lblJobname, gbc_lblJobname);
		
		ArrayList<TreeData> explicitTargets = j.getExplicitTargets();
		
		for (int i = 0; i < explicitTargets.size(); i++){
			
			JLabel lblNewLabel_2 = new JLabel(explicitTargets.get(i).getRelatedSourceFile());
			GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
			gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel_2.gridx = 0;
			gbc_lblNewLabel_2.gridy = i+2;
			add(lblNewLabel_2, gbc_lblNewLabel_2);
			
			JLabel lblNewFieldName = new JLabel(explicitTargets.get(i).getTarget());
			GridBagConstraints gbc_lblNewFieldName = new GridBagConstraints();
			gbc_lblNewFieldName.anchor = GridBagConstraints.EAST;
			gbc_lblNewFieldName.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewFieldName.gridx = 1;
			gbc_lblNewFieldName.gridy = i+2;
			add(lblNewFieldName, gbc_lblNewFieldName);
			
			JTextField explicitValue = new JTextField();
			GridBagConstraints gbc_explicitValue = new GridBagConstraints();
			gbc_explicitValue.gridwidth = 2;
			gbc_explicitValue.insets = new Insets(0, 0, 5, 0);
			gbc_explicitValue.gridx = 2;
			gbc_explicitValue.gridy = i+2;
			add(explicitValue, gbc_explicitValue);
			explicitValue.setColumns(10);
			
			ExplicitTarget newTarget = new ExplicitTarget(explicitTargets.get(i), explicitValue);
			
			this.panelExplicitTargets.add(newTarget);
		}
		

		
		JButton btnRunJob = new JButton("Run Job");
		GridBagConstraints gbc_btnRunJob = new GridBagConstraints();
		gbc_btnRunJob.insets = new Insets(0, 0, 5, 5);
		gbc_btnRunJob.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRunJob.gridx = 2;
		gbc_btnRunJob.gridy = 0;
		add(btnRunJob, gbc_btnRunJob);
		
		btnRunJob.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				for (ExplicitTarget t: panelExplicitTargets){
					t.getTarget().setText(t.getTextField().getText());
				}
				
				j.run();
			}
			
		});
		
		JLabel lblNewLabel_1 = new JLabel("Calling Microservice:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblExplicitTarget = new JLabel("Explicit Targets:");
		GridBagConstraints gbc_lblExplicitTarget = new GridBagConstraints();
		gbc_lblExplicitTarget.insets = new Insets(0, 0, 5, 5);
		gbc_lblExplicitTarget.gridx = 1;
		gbc_lblExplicitTarget.gridy = 1;
		add(lblExplicitTarget, gbc_lblExplicitTarget);
		
		JLabel lblNewLabel = new JLabel("Values:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

	}

}
