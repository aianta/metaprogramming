package metaprogramming.generator;

import java.util.ArrayList;

import javax.swing.JTextField;

public class ExplicitTarget {
	
	TreeData target;
	JTextField textField;

	
	public ExplicitTarget(TreeData target, JTextField textField){
		this.target = target;
		this.textField = textField;
	}
	
	public TreeData getTarget() {
		return target;
	}
	public void setTarget(TreeData target) {
		this.target = target;
	}
	public JTextField getTextField() {
		return textField;
	}
	public void setTextField(JTextField textField) {
		this.textField = textField;
	}
	
}
