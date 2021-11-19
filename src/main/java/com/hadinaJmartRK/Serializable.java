package com.hadinaJmartRK;


/**
 * Write a description of class Serializable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.HashMap;
import java.util.Map;

public class Serializable implements Comparable<Serializable>
{
    public final int id;
    public int incr;

    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    protected Serializable(){
        Class gotClass = getClass();
        if(mapCounter.get(gotClass) == null){
            mapCounter.put(gotClass, 0);
        }
        else{
            mapCounter.put(gotClass, mapCounter.get(gotClass) + 1);
        }
        this.id = mapCounter.get(gotClass);
    }

    @Override
    public int compareTo(Serializable other){
        return(this.id <other.id) ? -1 :((
                this.id == other.id)?0 : 1);
    }

    public boolean equals(Object obj){
        if(obj instanceof Serializable){
            Serializable serializable = (Serializable) obj;
            if(this.id == serializable.id){
                return true;
            }
            return false;
        }else{
            return false;
        }
    }

    public boolean equals(Serializable serializable){
        if(serializable.id == this.id){
            return true;
        }
        else{
            return false;
        }
    }

    public static <T extends Serializable> int setClosingId(Class<T> clazz, int id){

        return mapCounter.getOrDefault(clazz, id);
    }

    public static <T extends Serializable> int getClosingId(Class<T> clazz){

        return mapCounter.get(clazz);
    }

}


