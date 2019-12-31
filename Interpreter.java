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
    String currentToken = "";
    Tokens token
    while (read.hasNext()) { // need to get it to read character by character in an efficient way
      currentToken = read.next();
      token = getToken(currentToken);
      checkToken(token, currentToken);
      
    }
  }
    
  private Tokens getToken (String tokenInput) {
      return Tokens.identifyTokens(tokenInput)
  }
    
    private boolean checkToken(Tokens t, String tokenString) {
        if (t == Tokens.ERROR) {
            System.out.println("Error: Token" + tokenString + "is not a valid token");
            System.exit();
        } else {
            return true;
        }
    }
  
}
