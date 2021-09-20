package hadinaJmartRK;


/**
 * Write a description of class Coupon here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Coupon
{
    private boolean used;
    public final String name;
    public final int code;
    public final Type type;
    public final double cut;
    public final double minimum;

    public Coupon(String name, int code, Type type, double cut, double minimum)
    {
        this.name = name;
        this.code = code;
        this.type = type;
        this.cut = cut;
        this.minimum = minimum;
        this.used = false;
    }

    public boolean isUsed(){
       return used;
    }

    public boolean canApply(PriceTag priceTag)
    {
        if(priceTag.getAdjustedPrice() >= minimum && used == false)
        {
            return true;
        }
        else{
            return false;
        }
    }


    public double apply(PriceTag pricetag){
        this.used = true;
        if (type == Type.DISCOUNT){
            return (pricetag.getAdjustedPrice() * (100-this.cut)/100);
        }
        else if (type==Type.REBATE){
            return pricetag.getAdjustedPrice() - this.cut;
        }
        return 1;
    }
}
