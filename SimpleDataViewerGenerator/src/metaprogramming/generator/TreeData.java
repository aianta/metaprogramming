package metaprogramming.generator;

public class TreeData {
	
	private Integer nodeId;
	private String type;
	private String text;
	private Integer parentId;
	private String ruleIndex;
	private String target;
	
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public String getRuleIndex() {
		return ruleIndex;
	}
	public void setRuleIndex(String ruleIndex) {
		this.ruleIndex = ruleIndex;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String toString(){
		String result = "nodeId: " + getNodeId() + " parentId: " +
				getParentId() + " type: " + getType() + " ruleIndex: " +
				getRuleIndex() + " target: " + getTarget() + "\n";
		return result;	
	}

}
