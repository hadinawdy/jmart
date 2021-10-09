package hadinaJmartRK;

public class PriceTag
{
    public static final double COMMISSION_MULTIPLIER = 0.05;
    public static final double BOTTOM_PRICE = 20000.0;
    public static final double BOTTOM_FEE = 1000.0;
    public double discount;
    public double price;

    /**
     * Constructor for objects of class PriceTag
     */
    public PriceTag(double price)
    {
        this.price = price;
    }
    
     public PriceTag(double price, double discount){
        this.price = price;
        this.discount  = discount;
    }
    
     private double getDiscountedPrice(){
    if (discount>=100){
        return 0;
    }
    else{
        double totalPrice = price - (price * (discount/100));
        return totalPrice;
    }
    }
    
    public double getAdminFee(){
        double discount = getDiscountedPrice();
        
        if (discount<BOTTOM_PRICE){
            return BOTTOM_FEE;
        }
            return discount - COMMISSION_MULTIPLIER;
    }
    
    public double getAdjustedPrice(){
        return getDiscountedPrice() + getAdminFee();
    }
}
    
