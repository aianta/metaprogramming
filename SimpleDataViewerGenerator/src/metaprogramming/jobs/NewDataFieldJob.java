package metaprogramming.jobs;

import java.util.ArrayList;

import metaprogramming.generator.Job;
import metaprogramming.generator.SourceFile;
import metaprogramming.generator.TreeData;
import metaprogramming.generator.processors.AddComparatorProcessor;
import metaprogramming.generator.processors.AddFieldListModelProcessor;
import metaprogramming.generator.processors.AddSortFunctionProcessor;
import metaprogramming.generator.processors.DataJavaProcessor;
import metaprogramming.generator.processors.DataModelJavaProcessor;
import metaprogramming.generator.processors.DeclareFieldProcessor;
import metaprogramming.generator.processors.GetFieldProcessor;
import metaprogramming.generator.processors.SetFieldProcessor;
import metaprogramming.generator.processors.SimpleDataViewerJavaProcessor;

public class NewDataFieldJob extends Job{
	
	//Define microservice source files
	SourceFile declareField;
	SourceFile getField;
	SourceFile setField;
	SourceFile addSortFunction;
	SourceFile addComparator;
	SourceFile addFieldListModel;
	
	//Define microservice processors
	DeclareFieldProcessor declareFieldProcessor;
	GetFieldProcessor getFieldProcessor;
	SetFieldProcessor setFieldProcessor;
	AddSortFunctionProcessor addSortFunctionProcessor;
	AddComparatorProcessor addComparatorProcessor;
	AddFieldListModelProcessor addFieldListModelProcessor;
	
	public NewDataFieldJob (){
		this.setName("[New Data Field]");
	}
	
	
	@Override
	public void run() {
		super.processExplicitTargets();
		
		SourceFile dataJava = 
				new SourceFile ("Data", "src/metaprogramming/source/Data.java", ".java");
	
		SourceFile dataModelJava =
				new SourceFile ("DataModel", "src/metaprogramming/source/DataModel.java",".java");
		
		SourceFile simpleDataViewerJava =
				new SourceFile ("SimpleDataViewer", "src/metaprogramming/source/SimpleDataViewer.java", ".java");
		
		dataJava.load();
		dataModelJava.load();
		simpleDataViewerJava.load();
		
		DataJavaProcessor dataJavaProcessor = new DataJavaProcessor(dataJava);
		DataModelJavaProcessor dataModelJavaProcessor = new DataModelJavaProcessor(dataModelJava);
		SimpleDataViewerJavaProcessor simpleDataViewerJavaProcesssor = new SimpleDataViewerJavaProcessor(simpleDataViewerJava);
		
		dataJavaProcessor.processFile();
		dataModelJavaProcessor.processFile();
		simpleDataViewerJavaProcesssor.processFile();
		
		dataJavaProcessor.getSourceFile()
		.applyMicroservice(
				getFieldProcessor.getSourceFile().getSourceTree(),
				"classBody");
	
		dataJavaProcessor.getSourceFile()
		.applyMicroservice(setFieldProcessor.getSourceFile().getSourceTree()
				, "classBody");
		
		dataJavaProcessor.getSourceFile()
			.applyMicroservice(
					declareFieldProcessor.getSourceFile().getSourceTree(),
					"classBody");
		
		dataModelJavaProcessor.getSourceFile()
			.applyMicroservice(addSortFunctionProcessor.getSourceFile().getSourceTree(),
					"classBody");
		
		dataJavaProcessor.generate();
		dataModelJavaProcessor.generate();
		addComparatorProcessor.generate(super.getTargetByName("fieldName").getText() + "Comparator");
		addFieldListModelProcessor.generate(super.getTargetByName("fieldName").getText() + "ListModel");
		simpleDataViewerJavaProcesssor.generate();
		
		super.complete();
	}


	@Override
	public void analyzeTargets() {
		
		declareField =
				new SourceFile ("declareField", "src/metaprogramming/microservice/declareField.java", ".java");
		
		getField =
				new SourceFile ("getField", "src/metaprogramming/microservice/fieldGetter.java", ".java");
		
		setField =
				new SourceFile ("setField", "src/metaprogramming/microservice/fieldSetter.java", ".java");
				
		addSortFunction =
				new SourceFile ("addSortFunction", "src/metaprogramming/microservice/addSortFunction.java",".java");
		
		addComparator =
				new SourceFile ("addComparator", "src/metaprogramming/microservice/addComparator.java", ".java");
		
		addFieldListModel =
				new SourceFile ("addFieldListModel", "src/metaprogramming/microservice/addFieldListModel.java", ".java");
		
		declareField.load();
		getField.load();
		setField.load();
		addSortFunction.load();
		addComparator.load();
		addFieldListModel.load();
		
		declareFieldProcessor = new DeclareFieldProcessor(declareField);
		getFieldProcessor = new GetFieldProcessor(getField);
		setFieldProcessor = new SetFieldProcessor(setField);
		addSortFunctionProcessor = new AddSortFunctionProcessor(addSortFunction);
		addComparatorProcessor = new AddComparatorProcessor(addComparator);
		addFieldListModelProcessor = new AddFieldListModelProcessor(addFieldListModel);
		
		declareFieldProcessor.processFile();
		getFieldProcessor.processFile();
		setFieldProcessor.processFile();
		addSortFunctionProcessor.processFile();
		addComparatorProcessor.processFile();
		addFieldListModelProcessor.processFile();
		
		super.addSourceFileTargetsToJob(declareField);
		super.addSourceFileTargetsToJob(getField);
		super.addSourceFileTargetsToJob(setField);
		super.addSourceFileTargetsToJob(addSortFunction);
		super.addSourceFileTargetsToJob(addComparator);
		super.addSourceFileTargetsToJob(addFieldListModel);
	
		System.out.println("HALT!");
	}

}
