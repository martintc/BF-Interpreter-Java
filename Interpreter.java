import java.util.Scanner;

public class Interpreter {
    
  // instance variables and datastructures
  private ArrayField a;
  private Scanner read;
  
  public Interpreter () {
    a = new ArrayField();
  }
  
  public void interpretFromTerminal () {
    read = new Scanner(System.in);
    Tokens token;
    char program[] = read.nextLine().toCharArray();
    for (char currentToken : program) { // need to get it to read character by character in an efficient way
      token = getToken(currentToken);
      checkToken(token, currentToken);
      if (evaluate(token)) {
		  System.out.println(a.toString()); // test code
		  continue;
	  } else {
		  System.out.println("Error!");
	  }
    }
  }
    
  private Tokens getToken (char tokenInput) {
      Tokens t = Tokens.identifyToken(tokenInput);
      return t;
  }
    
    private boolean checkToken(Tokens t, char token) {
        if (t == Tokens.ERROR) {
            System.out.println("Error: Token " + token+ " is not a valid token");
            return false;
        } else {
            return true;
        }
    }
    
    private boolean evaluate (Tokens token) {
		if (token == Tokens.INCREMENT) {
			return a.incrementValue();
		} else if (token == Tokens.DECREMENT) {
			return a.decrementValue();
		} else if (token == Tokens.MOVE_RIGHT) {
			return a.moveRight();
		} else if (token == Tokens.MOVE_LEFT) {
			return a.moveLeft();
		} else {
			return false;
		}
	}
  
}
