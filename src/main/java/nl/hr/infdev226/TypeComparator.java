package nl.hr.infdev226;

import java.util.Comparator;

/**
 * Created by Hesam Zarza - 0775768.
 */
public class TypeComparator implements Comparator<Monitoring> {


    //@Override
    public int compare(Monitoring t1, Monitoring t2) {
        return t1.getType().compareTo(t2.getType());
    }


}


