package metaprogramming.generator;

import java.util.ArrayList;

public abstract class Job {
	
	private String name;
	private ArrayList<TreeData> jobTargets = new ArrayList<TreeData>();
	private ArrayList<TreeData> explicitTargets = new ArrayList<TreeData>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void run();
	
	public TreeData getTargetByName(String targetName){
		for (TreeData target: explicitTargets){
			if(target.getTarget().equals(targetName)){
				return target;
			}
		}
		
		return null;
	}
	
	public void complete() {
		
		System.out.println("Job " + this.getName() + " completed!");
	}
	
	private void addTargetToJob(TreeData target){
		this.jobTargets.add(target);
	}
	
	protected void addSourceFileTargetsToJob (SourceFile source){
		
		ArrayList<TreeData> sourceTargets = source.getTargets();
		
		for (TreeData sourceTarget: sourceTargets){
			this.addTargetToJob(sourceTarget);
		}
		
	}
	
	public ArrayList<TreeData> getExplicitTargets (){
		
		for (TreeData target: jobTargets){
			if(isCommonTarget(target)){
				continue;
			}else{
				this.explicitTargets.add(target);
			}
		}
		
		return this.explicitTargets;
	}
	
	protected void processExplicitTargets(){
		for (TreeData explicitTarget: explicitTargets){
			for (TreeData jobTarget: jobTargets){
				if (jobTarget.getTarget().equals(explicitTarget.getTarget())){
					jobTarget.setText(explicitTarget.getText());
				}
			}
		}
	}
	
	public boolean isCommonTarget(TreeData target){
		for (TreeData explicitTarget: this.explicitTargets){
			if(target.getTarget().equals(explicitTarget.getTarget())){
				return true;
			}
		}
		
		return false;
	}
	
	public abstract void analyzeTargets();
}
