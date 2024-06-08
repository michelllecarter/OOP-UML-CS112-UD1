/**
 * ItemPromotion.java : Represents a new promotion setup
 * maintenanceType (C  new Item)
 * salePrice, startMonth, startDay, startYear, endMonth, endDay, endYear
 * derived/child class of ItemMaintenance.java 
 *
 * @author Michelle Carter
*/
public class ItemPromotion extends ItemMaintenance
{
  //CONSTANT VARIABLES 
    public static final String DEFAULT_MAINTENANCE_TYPE = "C";
    public static final double DEFAULT_SALE_PRICE = 2.99;
    public static final int DEFAULT_START_MONTH = 04;
    public static final int DEFAULT_START_DAY = 17;
    public static final int DEFAULT_START_YEAR = 2024;
    public static final int DEFAULT_END_MONTH = 6;
    public static final int DEFAULT_END_DAY = 4;
    public static final int DEFAULT_END_YEAR = 2024;

  //INSTANCE VARIABLES
    private String maintenanceType;
    private double salePrice;
    private int startMonth;
    private int startDay;
    private int startYear;
    private int endMonth;
    private int endDay;
    private int endYear;


  //CONSTRUCTORS 
  /**
  * Full constructor with error handling (shuts down on invalid data)
  *
  * @param maintenanceType - String - the type of maintenance (always C for promotions)
  * @param salePrice - double - the price of the promotion (taken off regular retail)
  * @param startMonth , month the promotion starts
  * @param startDay, day promotion starts 
  * @param startyear, year promotion starts
  * @param endMonth, month promotion ends
  * @param endDay, day promotion ends
  * @param endYear, year promotion ends
  *  
  */
    public ItemPromotion(String itemDescription, int upc, int distributorNumber, int vendorCase, int vendorProductNumber, double caseCost, double retail, String maintenanceType, double salePrice, int startMonth, int startDay, int startYear, int endMonth, int endDay, int endYear) {
      // set old data
        super(itemDescription, upc, distributorNumber, vendorCase, vendorProductNumber, caseCost, retail);
      //set new data
        if(!this.setMaintenanceType(maintenanceType) || !this.setSalePrice(salePrice) || !this.setStartMonth(startMonth) || !this.setStartDay(startDay) || !this.setStartYear(startYear) || !this.setEndMonth(endMonth) || !this.setEndDay(endDay) || !this.setEndYear(endYear)){
          System.out.println("ERROR: Bad data given to full ItemPromotion constructor");
          System.exit(0);
        }
    }

/**
* Default constructor using constant variable default values 
*/
  public ItemPromotion(){
    //set old data
    super();
    //set new data 
    this.setMaintenanceType(DEFAULT_MAINTENANCE_TYPE);
    this.setSalePrice(DEFAULT_SALE_PRICE);
    this.setStartMonth(DEFAULT_START_MONTH);
    this.setStartDay(DEFAULT_START_DAY);
    this.setStartYear(DEFAULT_START_YEAR);
    this.setEndMonth(DEFAULT_END_MONTH);
    this.setEndDay(DEFAULT_END_DAY);
    this.setEndYear(DEFAULT_END_YEAR);
  }

  /**
  * Copy constructor created deep copy of all instance variables
  */
  public ItemPromotion(ItemPromotion original){
    if(original != null){
        this.setAll(original.getItemDescription(), original.getUpc(), original.getDistributorNumber(), original.getVendorCase(), original.getVendorProductNumber(), original.getCaseCost(), original.getRetail(), original.getMaintenanceType(), original.getSalePrice(), original.getStartMonth(), original.getStartDay(), original.getStartYear(), original.getEndMonth(), original.getEndDay(), original.getEndYear());
    } else{
      System.out.println("ERROR: null data given to copy ItemPromotion constructor");
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
  * Set sale price for item 
  *
  * @param salePrice - double - the price of the promotion (taken off regular retail)
  *
  * @return boolean true if valid (>= 0), false otherwise 
  */

  public boolean setSalePrice(double salePrice) {
    if(salePrice >= 0){
      this.salePrice = salePrice;
      return true;
    }  else{
      return false;
    }
  }

  /**
  * Set start month
  *
  * @param startMonth , month the promotion starts
  *
  * @return boolean true if valid (>= 0), false otherwise 
  */

  public boolean setStartMonth(int startMonth) {
    if(startMonth >= 0){
      this.startMonth = startMonth;
      return true; 
    }  else{
      return false;
    }
  }

/** 
  * Set start day
  *
  * @param startDay, day promotion starts 
  *
  * @return boolean true if valid (>= 0), false otherwise
*/

  public boolean setStartDay(int startDay) {
    if(startDay >= 0){
      this.startDay = startDay;
      return true; 
    }  else{
      return false;
    }
  }

  /** 
    * Set start year
    *
    * @param startYear, year promotion starts
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

  public boolean setStartYear(int startYear) {
    if(startYear >= 0){
      this.startYear = startYear;
      return true; 
    }  else{
      return false;
    }
  }

  /** 
    * Set end month
    *
    * @param endMonth, month promotion ends
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

    public boolean setEndMonth(int endMonth) {
      if(endMonth >= 0){
        this.endMonth = endMonth;
        return true; 
      }  else{
        return false;
      }
    }

  /** 
    * Set end day
    *
    * @param endDay, day promotion ends
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

    public boolean setEndDay(int endDay) {
      if(endDay >= 0){
        this.endDay = endDay;
        return true; 
      }  else{
        return false;
      }
    }

  /** 
    * Set end year
    *
    * @param endYear, year promotion ends
    *
    * @return boolean true if valid (>= 0), false otherwise
  */

    public boolean setEndYear(int endYear) {
      if(endYear >= 0){
        this.endYear = endYear;
        return true; 
      }  else{
        return false;
      }
    }
  
  /**
   * Sets all valid instance variables
   *
  * @param maintenanceType - String - the type of maintenance (always C for promotions)
  * @param salePrice - double - the price of the promotion (taken off regular retail)
  * @param startMonth , month the promotion starts
  * @param startDay, day promotion starts 
  * @param startyear, year promotion starts
  * @param endMonth, month promotion ends
  * @param endDay, day promotion ends
  * @param endYear, year promotion ends
   *
   * @return boolean if all nine parameters are valid 
  */
    public boolean setAll(String itemDescription, int upc, int distributorNumber, int vendorCase, int vendorProductNumber, double caseCost, double retail, String maintenancetype, double salePrice, int startMonth, int startDay, int startYear, int endMonth, int endDay, int endYear){
      return super.setAll(itemDescription, upc, distributorNumber, vendorCase, vendorProductNumber, caseCost, retail) && this.setMaintenanceType(maintenanceType) && this.setSalePrice(salePrice) && this.setStartMonth(startMonth) && this.setStartDay(startDay) && this.setStartYear(startYear) && this.setEndMonth(endMonth) && this.setEndDay(endDay) && this.setEndYear(endYear); 
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
    public double getSalePrice() {
        return this.salePrice;
    }
  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public int getStartMonth() {
        return this.startMonth;
    }

  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public int getStartDay() {
        return this.startDay;
    }

  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public int getStartYear() {
        return this.startYear;
    }

  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public int getEndMonth() {
        return this.endMonth;
    }

  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public int getEndDay() {
        return this.endDay;
    }

  /** 
  * Gets cost of beverage 
  *
  * @return cost of beverage, either purchase or material cost
  */
    public int getEndYear() {
        return this.endYear;
    }
}