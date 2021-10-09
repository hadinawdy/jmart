package hadinaJmartRK;


/**
 * Write a description of class Recognizable here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Recognizable implements Comparable<Recognizable>
{
    public final int id;

    protected Recognizable(int id)
    {
        this.id = id;
    }

    public int compareTo(Recognizable other) {
        return (this.id < other.id) ? -1 : ((this.id == other.id) ? 0 : 1);
    }

    public boolean equals (Object object)
    {
        if(object instanceof Recognizable)
        {
            Recognizable recognizable = (Recognizable) object;
            return (this.id == recognizable.id);
        }
        return false;
    }
    
    public boolean equals(Recognizable recognizable){
        return (this.id == recognizable.id);
    }

    public static <T extends Recognizable> int setClosingId(Class<T> clazz, int id) {
        return 0;
    }

    public static <T extends Recognizable> int getClosingId(Class<T> clazz) {
        return 0;
    }
}