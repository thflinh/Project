/**
 * Name: Pham, Thuy Linh
 * Project: 1
 * Due: 09/27/2024
 * Course: cs-2400-01-f24
 * 
 * Description: The JavaKeywords application reads the Java keywords from the file javakeywords.txt 
 * and stores the keywords in a bag. 
 * Also, testing all the methods that implements in the ArrayBag to make sure they work well.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class JavaKeywords {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No command line parameters provided.");
            return;
        }

        ArrayBag<String> keywordBag = loadKeywords("Javakeywords.txt");

        System.out.println("Java Keywords by L. Pham\n");
        //System.out.println();

        if (keywordBag != null) {
            System.out.println(keywordBag.getCurrentSize() + " Java keywords loaded.\n");
        } else {
            System.out.println("Failed to load Java keywords.");
            return;
        }

        for (String arg : args) {
            if (keywordBag.contains(arg)) {
                System.out.println(arg + " is a keyword");
            } else {
                System.out.println(arg + " is not a keyword");
            }
        }
        System.out.println();

        TestMethods(keywordBag);
    }

    private static ArrayBag<String> loadKeywords(String filePath) {
        ArrayBag<String> bag = new ArrayBag<>();
        
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (!line.isEmpty()) {  // Check for non-empty lines
                    bag.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        return bag;
    }

    private static void TestMethods(ArrayBag<String> testBag) {   
        //Clear the old bag
        testBag.clear();

        //Tests add 
        //case 1: add elements in the capacity
        testBag.add("Pham");
        testBag.add("Thuy");
        testBag.add("Linh");

        // Tests toArray
        System.out.println("Testing toArray(): " + Arrays.toString(testBag.toArray()));

        // Tests getFrequencyOf
        System.out.println("'Pham' appears: " + testBag.getFrequencyOf("Pham") + " time(s)");

        // Check size
        System.out.println("Current size: " + testBag.getCurrentSize());

        // Test isEmpty
        System.out.println("Is bag empty: " + testBag.isEmpty());

        //tests contains
        System.out.println("Does it contain 'soup': " + testBag.contains("soup"));

        // Test remove
        System.out.println("Removing 'Pham': " + testBag.remove("Pham"));
        System.out.println("Current size after removal: " + testBag.getCurrentSize());

        // Test clear
        testBag.clear();
        System.out.println("Cleared bag. Current size: " + testBag.getCurrentSize());

        //case2: add elements that exceed the capacity
        for (int i = 0; i < 30; i++)
        {
            testBag.add("hi");
        }

        // Tests toArray
        System.out.println("Testing toArray(): " + Arrays.toString(testBag.toArray()));

        // Tests getFrequencyOf
        System.out.println("'hi' appears: " + testBag.getFrequencyOf("hi") + " time(s)");

        // Check size
        System.out.println("Current size: " + testBag.getCurrentSize());

        // Test isEmpty
        System.out.println("Is bag empty: " + testBag.isEmpty());

        //tests contains
        System.out.println("Does it contain 'hi': " + testBag.contains("hi"));
        System.out.println("Does it contain 'soup': " + testBag.contains("soup"));

        // Test remove
        for (int i = 0; i < 25; i++)
        {
            System.out.println("Removing 'hi': " + testBag.remove("hi"));
        }
        System.out.println("Current size after removal: " + testBag.getCurrentSize());

        // Test clear
        testBag.clear();
        System.out.println("Cleared bag. Current size: " + testBag.getCurrentSize());

        //case 3: provide null to bag
        testBag.add(null);

        // Tests toArray
        System.out.println("Testing toArray(): " + Arrays.toString(testBag.toArray()));

        // Tests getFrequencyOf
        System.out.println("'Pham' appears: " + testBag.getFrequencyOf("Pham") + " time(s)");

        // Check size
        System.out.println("Current size: " + testBag.getCurrentSize());

        // Test isEmpty
        System.out.println("Is bag empty: " + testBag.isEmpty());

        //tests contains
        System.out.println("Does it contain 'soup': " + testBag.contains("soup"));

        // Test remove
        System.out.println("Removing 'Pham': " + testBag.remove("Pham"));
        System.out.println("Current size after removal: " + testBag.getCurrentSize());

        // Test clear
        testBag.clear();
        System.out.println("Cleared bag. Current size: " + testBag.getCurrentSize());
    }
}
