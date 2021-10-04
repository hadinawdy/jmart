package hadinaJmartRK;


/**
 * Write a description of interface Transactor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public interface Transactor
{
    public default boolean validate() {
        return false;
    }

    public default Invoice perform() {
        return null;
    }
}
