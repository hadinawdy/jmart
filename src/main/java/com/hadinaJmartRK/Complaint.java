package com.hadinaJmartRK;


/**
 * Write a description of class Complaint here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import com.hadinaJmartRK.dbjson.Serializable;

import java.util.Date;
import java.text.SimpleDateFormat;


public class Complaint extends Serializable
{
    public Date date;
    public String desc;

    public Complaint(String desc){
        this.desc = desc;
        this.date = new Date();
    }

    public String toString(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd/MM/yyyy");
        String dateFormat = SDFormat.format(this.date);
        return ("Complaint{date=" + dateFormat + "desc='" +this.desc+ "'}");
    }
}
