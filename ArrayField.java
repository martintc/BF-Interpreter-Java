import java.util.Scanner;


public class ArrayField {
  
  private int[] array;
  private int pointer;
  final int SIZE = 8;
  
  public ArrayField () {
    array = new int[SIZE]; // standard size for BrainF*ck; can be shortened for made larger
    for (int i = 0; i < array.length; i++) {
      array[i] = 0; // initialize all values in array to zero
    }
    pointer = 0; // The location in the array that the program is at
  }
  
  public void moveRight () {
    if (pointer != array.length) { // check to see if at end of array
      pointer++;
    } else {
      System.out.println("ERROR: Reached end of array!");
    }
  }
  public void moveLeft () {
    if (pointer != 0) { // check to see at the array's first index
      pointer--;
    } else {
      System.out.println("ERROR: At the first index of array, can not move left!");
    }
  }
  
  public void incrementValue() {
    array[pointer]++;
  }
  
  public void decrementValue () {
    if (array[pointer] == 0) { // check to see if current value is zero, do not allow values lower than zero
      System.out.println("ERROR: Current index is at zero and will not go below!");
    } else {
      array[pointer]--;
    }
  }

  public void printCharacterAtPointer () {
    System.out.println((char) array[pointer]); // prints character at point
  }

  public void inputCharacterAtIndex () {
    Scanner scan = new Scanner(System.in);
    String c = scan.next();
    if (c.length() > 1) {
      System.out.println("ERROR: Only one character for input!");
      scan.close();
    } else {
      array[pointer] = (int) c.charAt(0);
      scan.close();
    }
  }

  public void whileLoop (char function[]) {
      for(int i = 0; i < function.length; i++) {
        Interpreter.evaluate(Tokens.identifyToken(function[i]));
      }
      if (this.array[pointer] != 0) {
        whileLoop(function);
      }
  }
  
  public String toString () { // test code
	  String s = "";
	  for (int i : array) {
		  s = s + i + " ";
	  }
	  return s;
  }
  
}
