package metaprogramming.jobs;

import java.util.ArrayList;

import metaprogramming.generator.Job;
import metaprogramming.generator.SourceFile;
import metaprogramming.generator.TreeData;
import metaprogramming.generator.processors.DataJavaProcessor;
import metaprogramming.generator.processors.DeclareFieldProcessor;
import metaprogramming.generator.processors.GetFieldProcessor;

public class NewDataFieldJob extends Job{
	
	SourceFile declareField;
	SourceFile getField;
	DeclareFieldProcessor declareFieldProcessor;
	GetFieldProcessor getFieldProcessor;
	
	public NewDataFieldJob (){
		this.setName("DataFieldJob");
	}
	
	
	@Override
	public void run() {
		SourceFile dataJava = 
				new SourceFile ("Data", "src/metaprogramming/source/Data.java", ".java");
	
		dataJava.load();
		
		DataJavaProcessor dataJavaProcessor = new DataJavaProcessor(dataJava);
		
		dataJavaProcessor.processFile();
		
		dataJavaProcessor.getSourceFile()
			.applyMicroservice(
					declareFieldProcessor.getSourceFile().getSourceTree(),
					"declareField");
		
		dataJavaProcessor.getSourceFile()
			.applyMicroservice(
					getFieldProcessor.getSourceFile().getSourceTree(),
					"declareField");
		
		dataJavaProcessor.generate();
		
		super.complete();
	}


	@Override
	public void analyzeTargets() {
		
		declareField =
				new SourceFile ("declareField", "src/metaprogramming/microservice/declareField.java", ".java");
		
		getField =
				new SourceFile ("getField", "src/metaprogramming/microservice/fieldGetter.java", ".java");
		
		declareField.load();
		getField.load();
		
		declareFieldProcessor = new DeclareFieldProcessor(declareField);
		getFieldProcessor = new GetFieldProcessor(getField);
		
		declareFieldProcessor.processFile();
		getFieldProcessor.processFile();
		
		super.addSourceFileTargetsToJob(declareField);
		super.addSourceFileTargetsToJob(getField);
		
	}

}
