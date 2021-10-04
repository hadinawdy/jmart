package hadinaJmartRK;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.Date;
public class Complaint extends Recognizable implements FileParser
{
    public Date date;
    public String desc;

    public Complaint(int id, String desc){
        super(id);
        this.desc = desc;
        this.date = new Date();
    }

    @Override
    public boolean read(String content){
        return false;
    }
    
    public String toString(){
        return "date: " + this.date + "\n" + "desc: " + this.desc + "n";
    }
}
