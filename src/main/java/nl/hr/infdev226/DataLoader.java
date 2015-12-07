package nl.hr.infdev226;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;

public class DataLoader {
    /**
     * Let's try out the JCF a bit.
     * Sorry, no tests this time.
     *
     * You will:
     * 1. choose a JCF-data structure and argument why you chose that one
     * 2. fill it with some data
     * 3. Explore and use existing JCF-algorithms
     * -. along the way you'll also learn about generics, comparators
     *
     * Be sure to read up on all this stuff. For example here:
     * http://docs.oracle.com/javase/tutorial/collections/TOC.html
     */
    public static void main(String[] args) {
        BufferedReader br = getFileReader("Monitoring.csv");

        //TODO change to a lower level interface of you liking
        Collection<Monitoring> col = getCollection(br);

        //TODO sort the collection on 'beginTime'

        //TODO now sort the collection on 'type'

        //TODO shuffle the collection in random order

        //TODO find the lowest 'UnitId'

        //TODO find the maximum 'beginTime'

        //TODO find the amount of elements that were sent on 'endTime' = 2015-03-10 (just the date)
    }

    /**
     * Takes a csv-file (BufferedReader) and returns a
     * collection (which you have to choose).
     * @param br
     * @return
     */
    private static Collection<Monitoring> getCollection(BufferedReader br){
        Monitoring mon = new Monitoring();
        Collection<Monitoring> collection = null; //TODO chose your collection and instantiate it here
        try {
            br.readLine(); //skip the first line
            String line = br.readLine();

            while(line != null) {
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
