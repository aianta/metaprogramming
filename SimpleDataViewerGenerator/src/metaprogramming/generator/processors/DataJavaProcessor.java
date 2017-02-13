package metaprogramming.generator.processors;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.tree.ParseTree;

import metaprogramming.antlr.Java8Parser;
import metaprogramming.generator.SourceFile;
import metaprogramming.generator.SourceProcessor;
import metaprogramming.generator.listeners.DataJavaListener;

public class DataJavaProcessor extends SourceProcessor{

	public DataJavaProcessor(SourceFile sourceFile) {
		super(sourceFile);
		// TODO Auto-generated constructor stub
	}
	
	public void processFile (){
		
		Java8Parser javaParser = processJava (super.getSourceFile());
		javaParser.addParseListener(new DataJavaListener());
	
		saveRuleNames(javaParser);
		createJSON("./src/metaprogramming/target/json/" + super.getSourceFile().getName() + ".json");
		
		ParseTree dataJavaTree = javaParser.compilationUnit();
		
		finalizeJSON("./src/metaprogramming/target/json/" + super.getSourceFile().getName() + ".json");
		
		Trees.inspect(dataJavaTree, javaParser);
		
		//super.getSourceFile().addJSON("./src/metaprogramming/target/json/" + super.getSourceFile().getName() + ".json");
		//super.getSourceFile().addJSON("./src/metaprogramming/target/" + super.getSourceFile().getName() + "-gen.json");
		super.getSourceFile().addJSON("./src/metaprogramming/target/json/" + super.getSourceFile().getName() + "-declareField-target.json");
		
		//super.getSourceFile().printSource();
		//super.getSourceFile().printSource("Data");
		//super.getSourceFile().printJSON("Data");
		
		System.out.println(super.getSourceFile().getTarget("declareField"));
		
	}
	
	

}
