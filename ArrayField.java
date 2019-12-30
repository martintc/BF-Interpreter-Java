public class ArrayField {
  
  private int[] array;
  private int pointer;
  
  public ArrayField () {
    array = new int[30000]; // standard size for BrainF*ck; can be shortened for made larger
    pointer = 0; // Where the pointer is pointing
  }
  
  public boolean moveRight () {
    if (pointer != array.length) {
      pointer++;
    } else {
      return false;
    }
  }
  public boolean moveLeft () {
    if (pointer != 0) {
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
    if (array[pointer] == 0) {
      return false;
    } else {
      array[pointer] = array[pointer] + 1;
    }
  }
  
}
