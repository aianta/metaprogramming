package metaprogramming.generator;

import java.util.ArrayList;

public abstract class Job {
	
	private String name;
	private ArrayList<TreeData> jobTargets = new ArrayList<TreeData>();

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void run();
	
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
		
		return this.jobTargets;
	}
	
	public abstract void analyzeTargets();
}
