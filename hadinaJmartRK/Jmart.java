package hadinaJmartRK;

/**
 * Write a description of class Jmart here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Date;
import java.text.SimpleDateFormat;
public class Jmart
{
    public static void main(String[] args)
    {
       System.out.println(Shipment.Duration.KARGO.getEstimatedArrival(new Date()));
       Complaint complaint = new Complaint (8, "Barang dikirim ke alamat yang salah \n");
       System.out.print(complaint);
       Account account = new Account(56,"Hadina","hadina@gmail.com","brokenaglass");
       account.validate();
       System.out.println(account);
    }

    public static Product createProduct()
    {
        return null;
    }

    public static Coupon createCoupun()
    {
        return null;
    }

    public static Shipment createShipmentDuration()
    {
        return null;
    }
}