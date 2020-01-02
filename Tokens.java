public enum Tokens {
  
  // Tokens List
  
  MOVE_RIGHT, // Move pointer to the right
  MOVE_LEFT, // Move the pointer to the left
  INCREMENT, // Increment value at pointer
  DECREMENT, // Decrement value at pointer
  PRINT, // Print current character at pointer location
  INPUT, // Take a single charater input
  START_LOOP, // Start of a loop
  END_LOOP,
  ERROR; // End of a Loop
  
  // Takes a char token and returns the token value
  public static Tokens identifyToken (char t) {
   switch (t) {
    case '>' :
      return MOVE_RIGHT;
    case '<' : 
      return MOVE_LEFT;
    case '+' :
      return INCREMENT;
    case '-' :
      return DECREMENT;
    case '.' :
      return PRINT;
    case ',' :
      return INPUT;
    case '[' :
      return START_LOOP;
    case ']' :
      return END_LOOP;
    default :
      return ERROR;
  }
  }

}
