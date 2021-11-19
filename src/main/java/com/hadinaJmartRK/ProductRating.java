package com.hadinaJmartRK;

public class ProductRating
{
    private long total;
    private long count;

    public ProductRating()
    {
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