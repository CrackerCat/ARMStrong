package simulator.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import simulator.core.Cpu;
import simulator.core.Preprocessor;
import simulator.core.Program;
import simulator.core.Token;

public class PreprocessorTests {
    @Test
	public void testLexer() {
		List<Token> tokens = Program.lexer("mov r4,r4");
		Preprocessor preprocessor = new Preprocessor(new Cpu());
		
		try {
			preprocessor.preProcessPass2(tokens,0);
		}
		catch (Exception e) {
			fail();
		}
		tokens = Program.lexer("mov r4,r40");
		try {
			preprocessor.preProcessPass2(tokens,0);
			fail();
		}
		catch (Exception e) {
		}
		
		tokens = Program.lexer("strb r4,[r10]");
		try {
			preprocessor.preProcessPass2(tokens,0);
		}
		catch (Exception e) {
			fail();
		}
		
		tokens = Program.lexer("ldrh r4,[r10]");
		try {
			preprocessor.preProcessPass2(tokens,0);
		}
		catch (Exception e) {
			fail();
		}

		tokens = Program.lexer("ldrh r4");
		try {
			preprocessor.preProcessPass2(tokens,0);
			fail();
		}
		catch (Exception e) {
		}
		
		tokens = Program.lexer("add r4,r4,#-25");
		try {
			preprocessor.preProcessPass2(tokens,0);
		}
		catch (Exception e) {
			fail();
		}
		
		tokens = Program.lexer("b label");
		try {
			preprocessor.preProcessPass2(tokens,0);
			fail();
		}
		catch (Exception e) {
		}
		
		tokens = Program.lexer("ldrheq r4,[r10]");
		try {
			preprocessor.preProcessPass2(tokens,0);
		}
		catch (Exception e) {
			fail();
		}
		
		tokens = Program.lexer("movcc r4,#95");
		try {
			preprocessor.preProcessPass2(tokens,0);
		}
		catch (Exception e) {
			fail();
		}
	}
}
