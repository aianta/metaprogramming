package metaprogramming.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import metaprogramming.antlr.Java8Lexer;
import metaprogramming.antlr.Java8Parser;

public class SourceProcessor {
	
	private SourceFile sourceFile;
	
	public SourceProcessor (SourceFile sourceFile){
		this.sourceFile = sourceFile;
	}
	
	public Java8Parser processJava (SourceFile javaFile){
		
		ANTLRInputStream antlrInput = new ANTLRInputStream(javaFile.getData());
		Java8Lexer lexer = new Java8Lexer (antlrInput);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		Java8Parser parser = new Java8Parser(tokenStream);
		
		
		return parser;
	}
	
	public void createJSON (String path){
		
		try{
			File f = new File (path);
			FileWriter fw = new FileWriter(f);
			
			fw.append("{\n");
			fw.append("\t\"nodes\": [\n");
			
			fw.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
	public static void finalizeJSON (String path){
		try{
			File f = new File (path);
			FileWriter fw = new FileWriter(f, true);
			
			fw.append("\t]\n");
			fw.append("}\n");
			
			fw.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static void saveRuleNames(Java8Parser parser){
		
		try{
			
			String [] ruleNames = parser.getRuleNames();
			
			File json = new File ("RuleData.json");
			FileWriter fw = new FileWriter(json);
			
			fw.append("{\n");
			fw.append("\t\"rules\": [\n");
			
			for (int i = 0; i < ruleNames.length; i++){
				
				fw.append("\t\t{\n");
				fw.append("\t\t\t\"name\": \"" + ruleNames[i]+ "\",\n" );
				fw.append("\t\t\t\"index\":\"" + i + "\"\n");
				
				if (i != (ruleNames.length-1)){
					fw.append("\t\t},\n");
				}else{
					fw.append("\t\t}\n");
				} 
			}
			
			fw.append("\t]\n");
			fw.append("}\n");
			
			fw.close();
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}

	public SourceFile getSourceFile() {
		return sourceFile;
	}

	public void setSourceFile(SourceFile sourceFile) {
		this.sourceFile = sourceFile;
	}
	
	public void generate (){
		this.sourceFile.printJSON(sourceFile.getName());
		this.sourceFile.printSource(sourceFile.getName() + "-gen");
	}
	
	public void generate (String customName){
		this.sourceFile.printJSON(customName);
		this.sourceFile.printSource(customName + "-gen");

	}

}
