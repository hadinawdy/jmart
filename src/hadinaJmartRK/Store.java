package hadinaJmartRK;


/**
 * Write a description of class Store here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable
{
    public static String REGEX_PHONE = "^\\d{9,12}$";
    public static String REGEX_NAME = "^[A-Z](?1.*(\\s)\1).{4,20}$";
    public String name;
    public String address;
    public String phoneNumber;

    public Store(int accountId, String name, String address, String phoneNumber)
    {
        super(accountId);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Store(Account account, String name, String address, String phoneNumber) {
        super(account.id);
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public boolean read(String content){
        return false;
    }
    
    public boolean validate(){
        Pattern pattern = Pattern.compile(REGEX_NAME);
        Matcher matcher = pattern.matcher(this.name);
        Pattern pattern2 = Pattern.compile(REGEX_PHONE);
        Matcher matcher2 = pattern2.matcher(this.phoneNumber);
        return matcher.find() && matcher2.find();
    }
}
