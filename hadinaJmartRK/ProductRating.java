package hadinaJmartRK;

public class ProductRating
{
    // instance variables - replace the example below with your own
    private long total;
    private long count;

    public ProductRating()
    {
        // initialise instance variables
        int count= 0;
        long total= 0;
    }

    public void insert(int rating)
    {
        long ratingtotal = rating + total;
        count++;
    }
    
    public double getAverage(){
        return ((double) total/count);
    }


    public long getCount(){
        return count;
    }
    public long getTotal(){
        return total;
    }
}