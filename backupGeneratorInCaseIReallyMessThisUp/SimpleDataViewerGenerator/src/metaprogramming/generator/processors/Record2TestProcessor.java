package metaprogramming.generator.processors;

import org.antlr.v4.runtime.tree.ParseTree;

import metaprogramming.antlr.Java8Parser;
import metaprogramming.generator.SourceFile;
import metaprogramming.generator.SourceProcessor;
import metaprogramming.generator.listeners.DataJavaListener;
import metaprogramming.generator.listeners.DeclareFieldListener;
import metaprogramming.generator.listeners.GetFieldListener;
import metaprogramming.generator.listeners.Record2TestListener;
import metaprogramming.generator.listeners.SetFieldListener;
import metaprogramming.generator.listeners.addSortFunctionListener;

public class Record2TestProcessor extends SourceProcessor {

	public Record2TestProcessor(SourceFile sourceFile) {
		super(sourceFile);
	}
	
	public void processFile (){
		
		Java8Parser javaParser = processJava (super.getSourceFile());
		javaParser.addParseListener(new Record2TestListener());
	
		saveRuleNames(javaParser);
		createJSON("./src/metaprogramming/microservice/json/" + super.getSourceFile().getName() + ".json");
		
		ParseTree dataJavaTree = javaParser.blockStatement();
		
		finalizeJSON("./src/metaprogramming/microservice/json/" + super.getSourceFile().getName() + ".json");
		
		//Trees.inspect(dataJavaTree, javaParser);
		
		super.getSourceFile().addJSON("./src/metaprogramming/microservice/json/" + super.getSourceFile().getName() + "-targets.json");
		super.getSourceFile().printSource();
		
	}
	

}
