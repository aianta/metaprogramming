package metaprogramming.generator.processors;

import org.antlr.v4.runtime.tree.ParseTree;

import metaprogramming.antlr.Java8Parser;
import metaprogramming.generator.SourceFile;
import metaprogramming.generator.SourceProcessor;
import metaprogramming.generator.listeners.DataJavaListener;
import metaprogramming.generator.listeners.DeclareFieldListener;
import metaprogramming.generator.listeners.GetFieldListener;
import metaprogramming.generator.listeners.SetFieldListener;

public class SetFieldProcessor extends SourceProcessor {

	public SetFieldProcessor(SourceFile sourceFile) {
		super(sourceFile);
	}
	
	public void processFile (){
		
		Java8Parser javaParser = processJava (super.getSourceFile());
		javaParser.addParseListener(new SetFieldListener());
	
		saveRuleNames(javaParser);
		createJSON("./src/metaprogramming/microservice/json/" + super.getSourceFile().getName() + ".json");
		
		ParseTree dataJavaTree = javaParser.classBodyDeclaration();
		
		finalizeJSON("./src/metaprogramming/microservice/json/" + super.getSourceFile().getName() + ".json");
		
		//Trees.inspect(dataJavaTree, javaParser);
		
		super.getSourceFile().addJSON("./src/metaprogramming/microservice/json/" + super.getSourceFile().getName() + "-targets.json");
		super.getSourceFile().printSource();
		
	}
	

}
