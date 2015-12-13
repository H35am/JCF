package nl.hr.infdev226;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class DataLoader {
    /**
     * Let's try out the JCF a bit.
     * Sorry, no tests this time.
     * <p>
     * You will:
     * 1. choose a JCF-data structure and argument why you chose that one
     * Arraylist because its fast!
     * <p>
     * 2. fill it with some data
     * All ready done
     * 3. Explore and use existing JCF-algorithms
     * -. along the way you'll also learn about generics, comparators
     * <p>
     * Be sure to read up on all this stuff. For example here:
     * http://docs.oracle.com/javase/tutorial/collections/TOC.html
     */


    public static void main(String[] args) {
        BufferedReader br = getFileReader("Monitoring_SMALL.csv");

        //TODO change to a lower level interface of you liking
        ArrayList<Monitoring> col = getCollection(br);

        //TODO sort the collection on 'beginTime'
        for (Monitoring x : col)
            System.out.println(x.toString());
        Collections.sort(col, new BeginTimeComparator());
        System.out.println("En nu gesorteerd op beginTime:");
        for (Monitoring x : col)
            System.out.println(x.toString());


        //TODO now sort the collection on 'type'
        TypeComparator typeCompare = new TypeComparator();
        Collections.sort(col, typeCompare);
        System.out.println("En nu op TYPE.");
        for (Monitoring x : col)
            System.out.println(x.toString());

        //Places:
        //http://stackoverflow.com/questions/6957631/sort-java-collection
        //https://docs.oracle.com/javase/tutorial/collections/interfaces/order.html
        //http://zeroturnaround.com/rebellabs/java-8-explained-applying-lambdas-to-java-collections/
        //http://www.tutorialspoint.com/javaexamples/collection_shuffle.htm
        //http://www.java-examples.com/find-minimum-element-java-arraylist-example
        //http://www.java2s.com/Book/Java/0080__Collections/0100__Collections.htm
        //http://www.tutorialspoint.com/java/util/collections_min_comparator.htm
        //http://www.tutorialspoint.com/java/util/collections_binarysearch_comparator.htm


        //TODO shuffle the collection in random order
        Collections.shuffle(col);
        System.out.println("Hier komt Shuffle:");
        for (Monitoring x : col)
            System.out.println(x.toString());


        //TODO find the lowest 'UnitId'
        UnitIdComparator minUnitId = new UnitIdComparator();

        System.out.println("Hier komt Minimum UnitID:");

            System.out.println(Collections.min(col, minUnitId));


        //TODO find the maximum 'beginTime'
        UnitIdComparator maxUnitId = new UnitIdComparator();

        System.out.println("Hier komt Maximum UnitID:");

            System.out.println(Collections.max(col, maxUnitId));


        //TODO find the amount of elements that were sent on 'endTime' = 2015-03-10 (just the date)
        EndTimeComparator endTime = new EndTimeComparator();

        String findThis = "2015-03-10";
        int index = Collections.binarySearch(col, findThis, endTime);
        System.out.println("Hier komt 'endTime= 2015-03-10' :");

        System.out.println(index);


    }

    /**
     * Takes a csv-file (BufferedReader) and returns a
     * collection (which you have to choose).
     *
     * @param br
     * @return
     */
    private static ArrayList<Monitoring> getCollection(BufferedReader br) {
        //ZIT EEN FOUT IN DE CODE, 'MON' WERD IN MEMORY OPGESLAGEN DUS VERPLAATST NAAR DE WHILE LOOP!!!!!!!
        ArrayList<Monitoring> collection = new ArrayList(); //TODO chose your collection and instantiate it here
        try {
            br.readLine(); //skip the first line
            String line = br.readLine();

            while (line != null) {
                Monitoring mon = new Monitoring();
                mon.create(line);
                collection.add(mon);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return collection;
    }

    private static BufferedReader getFileReader(String file) {
        try {
            return Files.newBufferedReader(Paths.get(file), StandardCharsets.ISO_8859_1);
        } catch (IOException ioe) {
            System.err.println("err: " + ioe);
        }
        return null;
    }
}
