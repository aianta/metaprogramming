package metaprogramming.generator;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import metaprogramming.antlr.Java8BaseListener;
import metaprogramming.antlr.Java8Listener;
import metaprogramming.antlr.Java8Parser;
import metaprogramming.antlr.Java8Parser.*;

public class DataJavaListener extends Java8BaseListener {

	public void exitClassBodyDeclaration(Java8Parser.ClassBodyDeclarationContext ctx) {
		
		System.out.println(ctx.children);
	}

}
