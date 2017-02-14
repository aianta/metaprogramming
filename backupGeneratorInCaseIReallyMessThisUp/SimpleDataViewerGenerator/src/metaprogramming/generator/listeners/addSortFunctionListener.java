package metaprogramming.generator.listeners;

import metaprogramming.antlr.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Stack;

import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import metaprogramming.antlr.Java8BaseListener;
import metaprogramming.antlr.Java8Listener;
import metaprogramming.antlr.Java8Parser;
import metaprogramming.antlr.Java8Parser.*;

public class addSortFunctionListener extends Java8BaseListener {
	
	static Stack<Integer> activeStack = new Stack<Integer>();
	static int nodeId = 0;
	static String filename = "./src/metaprogramming/microservice/json/addSortFunction.json";

	public void enterEveryRule(ParserRuleContext ctx){
		activeStack.push(nodeId);
		nodeId++;
	}
	
	public void exitEveryRule(ParserRuleContext ctx) {
		
		int exitingNodeId = activeStack.pop();
		
		try{
			File f = new File (filename);
			FileWriter fw = new FileWriter (f, true);
			
			fw.append("\t\t{\n");
			fw.append("\t\t\t\"nodeId\": \"" + exitingNodeId + "\",\n");
			fw.append("\t\t\t\"type\": \"rule\",\n" );
			fw.append("\t\t\t\"ruleIndex\": \"" + ctx.getRuleIndex() + "\",\n");
			
			if (!activeStack.isEmpty()){
				fw.append("\t\t\t\"parentId\":\"" + activeStack.peek() + "\"\n");
				fw.append("\t\t},\n");
			}else{
				fw.append("\t\t\t\"parentId\": \"-1\"\n");
				fw.append("\t\t}\n");
			}
			
			fw.close();
			
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
		//System.out.println(ctx.getText());
		
	}
	
	public void visitTerminal(TerminalNode node) {
		activeStack.push(nodeId);
		nodeId++;
		
		int exitingNodeId = activeStack.pop();
		
		try{
			
			File f = new File (filename);
			FileWriter fw = new FileWriter(f,true);
			
			fw.append("\t\t{\n");
			fw.append("\t\t\t\"nodeId\": \"" + exitingNodeId + "\",\n");
			fw.append("\t\t\t\"type\": \"token\",\n" );
			fw.append("\t\t\t\"text\": \"" + node.getText() + "\",\n");
			
			if (!activeStack.isEmpty()){
				fw.append("\t\t\t\"parentId\":\"" + activeStack.peek() + "\"\n");
				fw.append("\t\t},\n");
			}else{
				fw.append("\t\t\t\"parentId\": \"-1\"\n");
				fw.append("\t\t}\n");
			}
			
			fw.close();
			
		}catch(IOException e){
			
		}
		
	}

}
