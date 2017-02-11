package metaprogramming.generator;

import metaprogramming.antlr.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
				new SourceFile ("Data", "src/metaprogramming/source/Data.java");

		SourceFile dataFieldJava = 
				new SourceFile ("DataField", "src/metaprogramming/source/DataField.java");
		
		SourceFile dataFieldPanelJava =
				new SourceFile ("DataFieldPanel", "src/metaprogramming/source/DataFieldPanel.java");

		SourceFile firstNameComparatorJava =
				new SourceFile ("FirstNameComparator","src/metaprogramming/source/FirstNameComparator.java");
		
		SourceFile simpleDataViewerJava =
				new SourceFile ("SimpleDataViewer","src/metaprogramming/source/SimpleDataViewer.java");
	
		dataJava.load();
		dataFieldJava.load();
		dataFieldPanelJava.load();
		firstNameComparatorJava.load();
		simpleDataViewerJava.load();
		
		Java8Parser javaParser = processJava (dataJava, new DataJavaListener());
		ParseTree dataJavaTree = javaParser.compilationUnit();
		DataJavaListener dataListener = new DataJavaListener();
		javaParser.addParseListener(dataListener);
		
		Trees.inspect(dataJavaTree, javaParser);
		
	}
	

	public static Java8Parser processJava (SourceFile javaFile, ParseTreeListener listener){
		
		ANTLRInputStream antlrInput = new ANTLRInputStream(javaFile.getData());
		Java8Lexer lexer = new Java8Lexer (antlrInput);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		Java8Parser parser = new Java8Parser(tokenStream);
		
		
		return parser;
	}
	
}