package metaprogramming.generator;

import metaprogramming.antlr.*;
import metaprogramming.generator.processors.DataJavaProcessor;
import metaprogramming.generator.processors.DeclareFieldProcessor;
import metaprogramming.generator.processors.GetFieldProcessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.runtime.tree.Tree;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeListener;

public class Generate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SourceFile dataJava = 
				new SourceFile ("Data", "src/metaprogramming/source/Data.java", ".java");

		SourceFile declareField =
				new SourceFile ("declareField", "src/metaprogramming/microservice/declareField.java", ".java");
		
		SourceFile getField =
				new SourceFile ("getField", "src/metaprogramming/microservice/fieldGetter.java", ".java");
		
		SourceFile dataModelJava = 
				new SourceFile ("DataModel", "src/metaprogramming/source/DataModel.java", ".java");
		
		SourceFile dataFieldPanelJava =
				new SourceFile ("DataFieldPanel", "src/metaprogramming/source/DataFieldPanel.java", ".java");
		
		SourceFile simpleDataViewerJava =
				new SourceFile ("SimpleDataViewer","src/metaprogramming/source/SimpleDataViewer.java", ".java");
	
		dataJava.load();
		declareField.load();
		getField.load();
		dataModelJava.load();
		dataFieldPanelJava.load();
		simpleDataViewerJava.load();
		
		DataJavaProcessor dataJavaProcessor = new DataJavaProcessor(dataJava);
		dataJavaProcessor.processFile();
		
		DeclareFieldProcessor declareFieldProcessor = new DeclareFieldProcessor(declareField);
		declareFieldProcessor.processFile();
		declareFieldProcessor.getSourceFile().getTarget("fieldName").setText("customName");
		
		dataJavaProcessor.getSourceFile()
			.applyMicroservice(
					declareFieldProcessor.getSourceFile().getSourceTree(),
					"declareField");
		
		declareFieldProcessor.processFile();
		declareFieldProcessor.getSourceFile().getTarget("fieldName").setText("customName2");
		dataJavaProcessor.getSourceFile()
			.applyMicroservice(
					declareFieldProcessor.getSourceFile().getSourceTree(),
					"declareField");
		
		GetFieldProcessor getFieldProcessor = new GetFieldProcessor(getField);
		getFieldProcessor.processFile();
		getFieldProcessor.getSourceFile().getTarget("fieldName").setText("customName");
		getFieldProcessor.getSourceFile().getTarget("methodName").setText("getCustomName");
		dataJavaProcessor.getSourceFile()
			.applyMicroservice(
					getFieldProcessor.getSourceFile().getSourceTree(),
					"declareField");
		
		dataJavaProcessor.generate();
		
	}
	
}
