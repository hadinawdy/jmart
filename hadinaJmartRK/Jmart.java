package hadinaJmartRK;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Jmart
{
    public static void main(String[] args){
        create();
        //Promo
        System.out.println(getPromo());
        //Customer
        System.out.println(getCustomer());
            
        //Discount Percentage
        System.out.println(getDiscountPercentage(1000,900));
        System.out.println(getDiscountPercentage(1000, 0));
        System.out.println(getDiscountPercentage(0, 0));
        System.out.println(getDiscountPercentage(0, 1));
            
        //Discounted Price
        System.out.println(getDiscountedPrice(1000, 10.0f));
        System.out.println(getDiscountedPrice(1000, 100.0f));
        System.out.println(getDiscountedPrice(1000, 120.0f));
        System.out.println(getDiscountedPrice(0, 0.0f));
            
        //Original Price
        System.out.println(getOriginalPrice(900, 10.0f));
        System.out.println(getOriginalPrice(1000, 0.0f));
        System.out.println(getOriginalPrice(0, 100.0f));
        System.out.println(getOriginalPrice(0, 120.0f));
            
        //Commission Multiplier
        System.out.println(getCommissionMultiplier());
            
        //Adjusted Price
        System.out.println(getAdjustedPrice(1000));
        System.out.println(getAdjustedPrice(500));
        System.out.println(getAdjustedPrice(0));
            
        //Admin Fee
        System.out.println(getAdminFee(1000));
        System.out.println(getAdminFee(500));
        System.out.println(getAdminFee(0));  
    }
        
    
    public static Product create(){
        return
    }
    public static int getPromo(){
        return 0;
    }
        
    public static String getCustomer(){
        return "oop";
    }
        
    public static float getDiscountPercentage(int before, int after){
        float before_ = before;
        float after_ = after;  
            
            if(before_ < after_){
                return 0.0f;
            }
            else{
                float percentage = ((before_ - after_) / before_) * 100;
                return percentage;
            }
    } 
        
    public static int getDiscountedPrice(int price, float discountPercentage){
        float x;
            if(discountPercentage > 100.0f){
                return 0;
            }
            else {
                return (int) (x = price - (price * (discountPercentage/100)));
            }

    }
        
    
    public static int getOriginalPrice(int discountedPrice, float discountPercentage){
        return (int) (discountedPrice * 100.0f / (100.0f - discountPercentage));
    }
        
    public static float getCommissionMultiplier(){
        return 0.05f;
    }
        
    public static int getAdjustedPrice(int price){
        float finalPrice = price + getCommissionMultiplier() * price;
        return (int) finalPrice;
    }
        
    public static int getAdminFee(int price){
        return (int) ((float) price * getCommissionMultiplier());
    }
}