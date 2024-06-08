public class NewItemBox {

  // CONSTANT VARIABLES
  public static final int DEFAULT_CAPACITY = 10;

  // INSTANCE VARIABLES
  private NewItem[] added;
  private int numAdded;

  // CONSTRUCTORS
  public NewItemBox(NewItem[] added) throws IllegalArgumentException {
    if(added == null || added.length == 0) {
      throw new IllegalArgumentException("Invalid New Item array provided to NewItemBox.");
    }
    this.numAdded = added.length;
    this.added = this.deepCopyArray(added, this.numAdded*2);
  }

  public NewItemBox() {
    this.added = new NewItem[DEFAULT_CAPACITY];
    this.numAdded = 0;
  }

  // ACCESSOR/GETTER METHODS
  //returns -1 if not found
  public int getLocation(String newItemName) {
      int location = -1, count = 0;

      while(count < this.numAdded && location == -1) {
          if(this.added[count] != null && this.added[count].getItemDescription() != null && this.added[count].getItemDescription().equalsIgnoreCase(newItemName)) {
              location = count;
          }
          count++;
      }
      return location;
  }

  public NewItem getNewItem(int location) throws IndexOutOfBoundsException {
    if(location < 0 || location >= this.numAdded){
      throw new IndexOutOfBoundsException("Location provided is <0 or >= number of unique New Item in box.");
    } else{
      return this.added[location];
      }

  }

  public int getNumAdded() {
    return this.numAdded;
  }

  public boolean isEmpty() {
    return this.numAdded == 0;
  }

  public boolean hasNewItem(String newItemName) {
    return this.getLocation(newItemName) != -1;
  }

  // MUTATOR/SETTER METHODS
  //precondition: newItem cannot be null 
  //@param newItem
  //ABOVE not needed bc error is caught below

  public void add(NewItem newItem) throws NewItemAlreadyExistsException {
    if( this.hasNewItem(newItem.getItemDescription()) ) {
      throw new NewItemAlreadyExistsException("ERROR! New Item already exists:", newItem);
    } else {
    //new pokemon,  add to partially filled array
    //but first check if box is full
      if(this.numAdded == this.added.length){
        //if full, then grow array *2 and copy contents over
        this.added = this.deepCopyArray(this.added, this.numAdded*2);
      }

    //then add new caught pokemon
    try{
        this.added[this.numAdded] = new NewItem(newItem);
        this.numAdded++;
        //this.numCaught +=2;
      } catch (IllegalArgumentException iae) {
        System.out.println("ERROR: trying to copy null New item is in New Item Box");
        System.exit(0);
      }
    }  
  }

  // OTHER REQUIRED METHODS
  public String toString() {
    if(this.isEmpty()) {
      return "This box is empty";
    } else {
      String all = "\t01. " + this.added[0].toRow();
      for(int i = 1; i < this.numAdded; i++) {
        all += String.format("%n\t%02d. %s", i+1, this.added[i].toRow());
      }

      return String.format("This box has %d New Item, which are:%n%s",
        this.numAdded, all);
    }
  }

  private NewItem[] deepCopyArray(NewItem[] p, int newLength) {
    NewItem[] deepCopy = new NewItem[newLength];

    //for(int i = 0; i < deepCopy.length; i++) {
    for(int i = 0; i < p.length; i++) {
      try{
        deepCopy[i] = new NewItem(p[i]);
      } catch (IllegalArgumentException iae){


        System.out.println("ERROR: trying to copy null while deep copying array.");
      System.exit(0);
      }
    }

    return deepCopy;
  }
}