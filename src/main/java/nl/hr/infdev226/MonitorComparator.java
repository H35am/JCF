package nl.hr.infdev226;

import java.util.Comparator;

/**
 * Created by Hesam Zarza - 0775768.
 */
public class MonitorComparator {


    public class BeginTimeComparator implements Comparator<Monitoring> {

        @Override
        public int compare(Monitoring monitoring, Monitoring t1) {
            return monitoring.getBeginTime().compareTo(t1.getBeginTime());
        }


    }

    public class TypeComparator implements Comparator<Monitoring> {


        //@Override
        public int compare(Monitoring t1, Monitoring t2) {
            return t1.getType().compareTo(t2.getType());
        }

        //@override
        public int compareUnitId(Monitoring t1, Monitoring t2){
            return t1.getUnitId().compareTo(t2.getUnitId());
        }


    }

    public class UnitIdComparator implements Comparator<Monitoring> {


        //@override
        public int compare(Monitoring t1, Monitoring t2){
            return t1.getUnitId().compareTo(t2.getUnitId());
        }


    }

}
