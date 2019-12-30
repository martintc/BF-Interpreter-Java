public class ArrayField {
  
  private int[] array;
  private int pointer;
  
  public ArrayField () {
    array = new int[30000]; // standard size for BrainF*ck; can be shortened for made larger
    for (int i = 0; i < array.length; i++) {
      array[i] = 0; // initialize all values in array to zero
    }
    pointer = 0; // The location in the array that the program is at
  }
  
  public boolean moveRight () {
    if (pointer != array.length) { // check to see if at end of array
      pointer++;
    } else {
      return false;
    }
  }
  public boolean moveLeft () {
    if (pointer != 0) { // check to see at the array's first index
      pointer--;
    } else {
      return false;
    }
  }
  
  public boolean incrementValue() {
    array[pointer]++;
    return true; 
  }
  
  public boolean decrementValue () {
    if (array[pointer] == 0) { // check to see if current value is zero, do not allow values lower than zero
      return false;
    } else {
      array[pointer] = array[pointer] + 1;
    }
  }
  
}
