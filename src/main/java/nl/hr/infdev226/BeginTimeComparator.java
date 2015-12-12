package nl.hr.infdev226;

import java.util.Comparator;

/**
 * Created by Hesam Zarza - 0775768.
 */

public class BeginTimeComparator implements Comparator<Monitoring> {

    @Override
    public int compare(Monitoring monitoring, Monitoring t1) {
        return monitoring.getBeginTime().compareTo(t1.getBeginTime());
    }
}

