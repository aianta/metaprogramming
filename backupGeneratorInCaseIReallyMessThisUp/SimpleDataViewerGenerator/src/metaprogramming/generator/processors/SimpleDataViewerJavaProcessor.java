package metaprogramming.generator.processors;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.tree.ParseTree;

import metaprogramming.antlr.Java8Parser;
import metaprogramming.generator.SourceFile;
import metaprogramming.generator.SourceProcessor;
import metaprogramming.generator.listeners.DataJavaListener;
import metaprogramming.generator.listeners.DataModelJavaListener;
import metaprogramming.generator.listeners.SimpleDataViewerJavaListener;

public class SimpleDataViewerJavaProcessor extends SourceProcessor{

	public SimpleDataViewerJavaProcessor(SourceFile sourceFile) {
		super(sourceFile);
		// TODO Auto-generated constructor stub
	}
	
	public void processFile (){
		
		Java8Parser javaParser = processJava (super.getSourceFile());
		javaParser.addParseListener(new SimpleDataViewerJavaListener());
	
		saveRuleNames(javaParser);
		createJSON("./src/metaprogramming/target/json/" + super.getSourceFile().getName() + ".json");
		
		ParseTree dataJavaTree = javaParser.compilationUnit();
		
		finalizeJSON("./src/metaprogramming/target/json/" + super.getSourceFile().getName() + ".json");
		
		//Trees.inspect(dataJavaTree, javaParser);
		
		//super.getSourceFile().addJSON("./src/metaprogramming/target/json/" + super.getSourceFile().getName() + ".json");
		//super.getSourceFile().addJSON("./src/metaprogramming/target/" + super.getSourceFile().getName() + "-gen.json");
		super.getSourceFile().addJSON("./src/metaprogramming/target/json/" + super.getSourceFile().getName() + "-targets.json");
		
		//super.getSourceFile().printSource();
		//super.getSourceFile().printSource("Data");
		//super.getSourceFile().printJSON("Data");
		
		//System.out.println(super.getSourceFile().getTarget("declareField"));
		
	}
	
	

}
