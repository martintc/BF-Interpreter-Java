import java.util.Scanner;
import java.util.ArrayList;

public class Interpreter {
    
  // instance variables and datastructures
  private static ArrayField a;
  private Scanner read;

  public Interpreter() {
    a = new ArrayField();
  }

  public void interpretFromTerminal() {
    read = new Scanner(System.in);
    Tokens token;
    ArrayList<Tokens> loopTokens;
    char program[] = read.nextLine().toCharArray();
    for (final char currentToken : program) { // need to get it to read character by character in an efficient way
      token = getToken(currentToken);
      checkToken(token, currentToken);
      if (token == Tokens.START_LOOP) {

      }
      evaluate(token, program);
      System.out.println(a.toString());
    }
  }

  private Tokens getToken(final char tokenInput) {
    final Tokens t = Tokens.identifyToken(tokenInput);
    return t;
  }

  private boolean checkToken(final Tokens t, final char token) {
    if (t == Tokens.ERROR) {
      System.out.println("Error: Token " + token + " is not a valid token");
      return false;
    } else {
      return true;
    }
  }

  public static void evaluate(final Tokens token, char program[]) {
		if (token == Tokens.INCREMENT) {
      a.incrementValue();
		} else if (token == Tokens.DECREMENT) {
      a.decrementValue();
		} else if (token == Tokens.MOVE_RIGHT) {
      a.moveRight();
		} else if (token == Tokens.MOVE_LEFT) {
      a.moveLeft();
		} else if (token == Tokens.PRINT) {
      a.printCharacterAtPointer();
    } else if (token == Tokens.INPUT) {
      a.inputCharacterAtIndex();
    } else {
      System.out.println("ERROR");
    }
	}
  
}
