package hadinaJmartRK;


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
    private static HashMap<Class<?>, Integer> mapCounter = new HashMap<>();

    protected Serializable(int id)
    {
        Integer counter = mapCounter.get(getClass());
        counter = counter == null ? 0 : counter + 1;
        mapCounter.put(getClass(), counter);
        this.id = counter;
    }

    public <T extends Serializable> int getClosingId(Class<T> clazz)
    {
        return mapCounter.get(clazz);
    }

    public <T extends Serializable> int setClosingId(Class<T> clazz, int id)
    {
        mapCounter.replace(clazz, id);
        return mapCounter.get(clazz);
    }

    @Override
    public int compareTo(Serializable other){
        return(this.id <other.id) ? -1 :((this.id == other.id)?0 : 1);
    }

    public boolean equals(Object obj){
        if(obj instanceof Serializable){
            Serializable serializable = (Serializable) obj;
            if(this.id == serializable.id){
                return true;
            }
            return false;
        }
        else
        {
            return false;
        }
    }

    public boolean equals(Serializable serializable){
        if(serializable.id == this.id){
            return true;
        }
        else
        {
            return false;
        }
    }
}


