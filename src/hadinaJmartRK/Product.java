package hadinaJmartRK;

/**
 * Write a description of class Product here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public abstract class Product extends Recognizable
{
    public int id;
    public String name;
    public int weight;
    public boolean conditionUsed;
    public Treasury priceTag;
    public ProductCategory category;
    public ProductRating rating;
    private static int idCounter;

    public Product(int id, int storeId, String name, int weight, boolean conditionUsed, Treasury priceTag, ProductCategory category)
    {
        super(id);
        this.name = name;
        this.weight = weight;
        this.conditionUsed = conditionUsed;
        this.priceTag = priceTag;
        this.category = category;
        this.rating = rating;
        id = idCounter;
        idCounter++;
    }

    public String toString(){
        return(
        "Name: " + this.name +
        "Weight: " + this.weight +
        "conditionUsed: " + this.conditionUsed +
        "priceTag: " + this.priceTag +
        "category: " + this.category + 
        "rating: " + this.rating +
        "storeId: " + this.idCounter + "\n");
    }
}