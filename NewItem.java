/**
 * NewItem.java : Represents one new item,
 * maintenanceType (A  new Item)
 * unit (e.g. "each", "ounce", "pound", "count") 
 * size (ex. 1.5, 12) 
 * distributorIdentification, distributorName, category, subCategory (String variables; independent)
 * attributes ("organic", "non-gmo", etc)
 * tax (boolean, true if taxable)
 * derived/child class of ItemMaintenance.java 
 *
 * @author Michelle Carter
*/
public class NewItem extends ItemMaintenance
{
  //CONSTANT VARIABLES 
    public static final String DEFAULT_MAINTENANCE_TYPE = "A";
    public static final String DEFAULT_UNIT = "Ounces";
    public static final String DEFAULT_DISTRIBUTOR_IDENTIFICATION = "UNITED";
    public static final String DEFAULT_DISTRIBUTOR_NAME = "United Natural Foods";
    public static final String DEFAULT_BRAND = "Kettle";
    public static final String DEFAULT_CATEGORY = "Chips";
    public static final String DEFAULT_SUB_CATEGORY = "Potato Chips";
    public static final String DEFAULT_ATTRIBUTES = "Organic";
    public static final int DEFAULT_SIZE = 16;

  //INSTANCE VARIABLES
    private String maintenanceType;
    private String unit;
    private String distributorIdentification;
    private String distributorName;
    private String brand;
    private String category;
    private String subCategory;
    private String attributes;
    private int size;
  
  //CONSTRUCTORS 
  /**
  * Full constructor with error handling (shuts down on invalid data)
  *
  * @param maintenanceType - String - the type of maintenance (always A for New items)
  * @param unit - String - the unit of measurement (e.g. "each", "ounce", "pound", "count
  * @param size (of each item in the vendor case)
  * @param distributorIdentification - String - the distributor's identification (shortened code based on full distributorName)
  * @param distributorName - String - the distributor's name
  * @param name brand name, don't use parent brand name (ex. hain celestial owns celestial seasonings, use celestial seasonings)
  * @param category - String - generic category of item
  * @param subCategory - String - specific category of item
  * @param attributes - String - attributes of item (e.g. organic, non-gmo, etc)
  *  
  */
    public NewItem(String itemDescription, int upc, int distributorNumber, int vendorCase, int vendorProductNumber, double caseCost, double retail, String maintenanceType, String unit, String distributorIdentification, String distributorName, String brand, String category, String subCategory, String attributes, int size) {
      //set old data
        super(itemDescription, upc, distributorNumber, vendorCase, vendorProductNumber, caseCost, retail);
      //set new data
        if(!this.setMaintenanceType(maintenanceType) || !this.setUnit(unit) || !this.setDistributorIdentification(distributorIdentification) || !this.setDistributorName(distributorName) || !this.setBrand(brand) || !this.setCategory(category) || !this.setSubCategory(subCategory) || !this.setAttributes(attributes) || !this.setSize(size)) {
          System.out.println("ERROR: Bad data given to full NewItem constructor");
          System.exit(0);
        }
    }

/**
* Default constructor using constant variable default values 
*/
  public NewItem(){
    //set old data
    super();
    //set new data 
    this.setMaintenanceType(DEFAULT_MAINTENANCE_TYPE);
    this.setUnit(DEFAULT_UNIT);
    this.setDistributorIdentification(DEFAULT_DISTRIBUTOR_IDENTIFICATION);
    this.setDistributorName(DEFAULT_DISTRIBUTOR_NAME);
    this.setBrand(DEFAULT_BRAND);
    this.setCategory(DEFAULT_CATEGORY);
    this.setSubCategory(DEFAULT_SUB_CATEGORY);
    this.setAttributes(DEFAULT_ATTRIBUTES);
    this.setSize(DEFAULT_SIZE);
  }

  /**
  * Copy constructor created deep copy of all instance variables
  */
  public NewItem(NewItem original){
    if(original != null){
      this.setAll(original.getItemDescription(), original.getUpc(), original.getDistributorNumber(), original.getVendorCase(), original.getVendorProductNumber(), original.getCaseCost(), original.getRetail(), original.getMaintenanceType(), original.getUnit(), original.getDistributorIdentification(), original.getDistributorName(), original.getBrand(), original.getCategory(), original.getSubCategory(), original.getAttributes(), original.getSize());
    } else{
      System.out.println("ERROR: null data given to copy NewItem constructor");
      System.exit(0);
    }
  }

//SETTER/MUTATORS

/**
  * Set maintenanceType for object with error checking
  *
  * @param maintenanceType - String - the type of maintenance (always A for New items)
  *
  * @return boolean true if a valid String (not null and not empty), false otherwise 
  */
  
  public boolean setMaintenanceType(String maintenanceType) {
      if(maintenanceType != null && maintenanceType.length() > 0){
        this.maintenanceType = maintenanceType;
        return true;
      }else{
        return false;
      }
  }

/**
  * Set unit type for each item 
  *
  * @param unit - String - the unit of measurement (e.g. "each", "ounce", "pound", "count
  *
  * @return boolean true if valid (>= 0), false otherwise 
  */

  public boolean setUnit(String unit) {
      if(unit != null && unit.length() > 0){
        this.unit = unit;
        return true;
      }else{
        return false;
      }
  }

/** 
  * Set distributorIdentification, shortened code based on full distributorName
  *
  * @param distributorIdentification - String - the distributor's identification (shortened code based on full distributorName)
  *
  * @return boolean true if valid (>= 0), false otherwise
*/

  public boolean setDistributorIdentification(String distributorIdentification) {
      if(distributorIdentification != null && distributorIdentification.length() > 0){
        this.distributorIdentification = distributorIdentification;
        return true;
      }else{
        return false;
      }
  }
  
  /** 
    * Set distributorName (full name of distribution center)
    *
    * @param distributorName - String - the distributor's name
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

    public boolean setDistributorName(String distributorName) {
        if(distributorName != null && distributorName.length() > 0){
          this.distributorName = distributorName;
          return true;
        }else{
          return false;
        }
    }

  /** 
    * Set brand name (validate correct before submitting)
    *
    * @param name brand name, don't use parent brand name (ex. hain celestial owns celestial seasonings, use celestial seasonings)
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

    public boolean setBrand(String brand) {
        if(brand != null && brand.length() > 0){
          this.brand = brand;
          return true;
        }else{
          return false;
        }
    }

  /** 
    * Set category that is generic to item 
    *
    * @param category - String - generic category of item
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

    public boolean setCategory(String category) {
        if(category != null && category.length() > 0){
          this.category = category;
          return true;
        }else{
          return false;
        }
    }

  /** 
    * Set sub-category that is generic to item 
    *
    * @param subCategory - String - specific category of item
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

    public boolean setSubCategory(String subCategory) {
        if(subCategory != null && subCategory.length() > 0){
          this.subCategory = subCategory;
          return true;
        }else{
          return false;
        }
    }

  /** 
    * Set sub-category that is generic to item 
    *
    * @param attributes - String - attributes of item (e.g. organic, non-gmo, etc)
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

    public boolean setAttributes(String attributes) {
        if(attributes != null && attributes.length() > 0){
          this.attributes = attributes;
          return true;
        }else{
          return false;
        }
    }

    /**
    * Set size in container with error checking
    *
    * @param size (of each item in the vendor case)
    *
    * @return boolean true if valid (>= 0), false otherwise 
    */
  
    public boolean setSize(int size) {
      if(size >= 0){
        this.size = size;
        return true; 
      }  else{
        return false;
      }
    }

  /**
   * Sets all valid instance variables
   *
   * @param maintenanceType - String - the type of maintenance (always A for New items)
   * @param unit - String - the unit of measurement (e.g. "each", "ounce", "pound", "count
   * @param size (of each item in the vendor case)
   * @param distributorIdentification - String - the distributor's identification (shortened code based on full distributorName)
   * @param distributorName - String - the distributor's name
   * @param name brand name, don't use parent brand name (ex. hain celestial owns celestial seasonings, use celestial seasonings)
   * @param category - String - generic category of item
   * @param subCategory - String - specific category of item
   * @param attributes - String - attributes of item (e.g. organic, non-gmo, etc)
   *
   * @return boolean if all nine parameters are valid 
  */
    public boolean setAll(String itemDescription, int upc, int distributorNumber, int vendorCase, int vendorProductNumber, double caseCost, double retail, String maintenanceType, String unit, String distributorIdentification, String distributorName, String brand, String category, String subCategory, String attributes, int size){
      return super.setAll(itemDescription, upc, distributorNumber, vendorCase, vendorProductNumber, caseCost, retail) && this.setMaintenanceType(maintenanceType) && this.setUnit(unit) && this.setDistributorIdentification(distributorIdentification) && this.setDistributorName(distributorName) && this.setBrand(brand) && this.setCategory(category) && this.setSubCategory(subCategory) && this.setAttributes(attributes) && this.setSize(size); 
    }

//GETTERS//ACCESORS
/** 
  * Gets maintenance type 
  *
  * @return maintenance type 
  */
    public String getMaintenanceType() {
        return this.maintenanceType;
    }
  /** 
  * Gets number size in each item in the vendor case
  *
  * @return number size in each item in the vendor case
  */
    public String getUnit() {
        return this.unit;
    }

  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public String getDistributorIdentification() {
        return this.distributorIdentification;
    }

  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public String getDistributorName() {
        return this.distributorName;
    }

  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public String getBrand() {
        return this.brand;
    }

  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public String getCategory() {
        return this.category;
    }

  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public String getSubCategory() {
        return this.subCategory;
    }

  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public String getAttributes() {
        return this.attributes;
    }
  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public int getSize() {
        return this.size;
    }

  public String toRow() {
    if(this.brand == null) {
      return String.format("%s [%s]", this.category, this.maintenanceType);
    } else {
      return String.format("%s [%s - %s]", this.category, this.maintenanceType, this.brand);
    }
  }
}