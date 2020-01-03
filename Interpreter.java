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
    System.out.print(">> ");
    read = new Scanner(System.in);
    Tokens token;
    ArrayList<Tokens> loopTokens = new ArrayList<>();
    boolean inLoop = false;
    char program[] = read.nextLine().toCharArray();
    for (final char currentToken : program) { // need to get it to read character by character in an efficient way
      token = getToken(currentToken);
      checkToken(token, currentToken);
      if (token == Tokens.START_LOOP || inLoop == true) {
        inLoop = true;
        if (token != Tokens.END_LOOP) {
          loopTokens.add(token);
        } else {
          inLoop = false;
          a.whileLoop(loopTokens, a);
          continue;
        }
      } else {
        evaluate(token);
      }
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

  public static void evaluate(Tokens token) {
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
  
  // @Override
  public static void evaluate(Tokens token, ArrayField i) {
		if (token == Tokens.INCREMENT) {
      i.incrementValue();
		} else if (token == Tokens.DECREMENT) {
      i.decrementValue();
		} else if (token == Tokens.MOVE_RIGHT) {
      i.moveRight();
		} else if (token == Tokens.MOVE_LEFT) {
      i.moveLeft();
		} else if (token == Tokens.PRINT) {
      i.printCharacterAtPointer();
    } else if (token == Tokens.INPUT) {
      i.inputCharacterAtIndex();
    } else  if (token == Tokens.START_LOOP || token == Tokens.END_LOOP) {
      // do nothing
    } else {
      System.out.println("ERROR");
    }
	}
  
}
