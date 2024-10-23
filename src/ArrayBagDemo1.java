public class ArrayBagDemo1
{
    public static void main(String[] args)
    {
        System.out.println("Testing an initially empty bag with sufficient capacity:");
        BagInterface<String> aBag = new ArrayBag<>();
        String[] contentsOfBag1 = {"A", "A", "B", "A", "C"}; // sufficient capacity
        testAdd(aBag, contentsOfBag1);

        System.out.println("\nTesting an initially empty bag that will be filled to capacity:");
        aBag = new ArrayBag<>(4);
        String[] contentsOfBag2 = {"A", "B", "C", "A"};
        testAdd(aBag, contentsOfBag2);
    }

    // Tests the method add
    private static void testAdd(BagInterface<String> aBag, String[] content)
    {
        System.out.println("Adding to the bag:");
        for (int index = 0; index < content.length; index++)
        {
            if (aBag.add(content[index]))
            {
                System.out.print(content[index] + " ");
            }
            else
            {
                System.out.println("\nUnable to add " + content[index] + " to the bag.");
            }
        }
        System.out.println();
        displayBag(aBag);
    }

    // Tests the method toArray while displaying the bag
    private static void displayBag(BagInterface<String> aBag)
    {
        System.out.println("The bag contains the following string(s):");
        Object[] bagArray = aBag.toArray();
        for (int index = 0; index < bagArray.length; index++)
        {
            System.out.print(bagArray[index] + " ");
        }
        System.out.println();
    }
}
/**
 * since main is static anf calls these other methods -> they must be static as well
 * method: testAdd accepts as its args a bag and an array of strings 
 *      uses lpp[ to add each string in the array to the bag
 *      also tests the return value of the add method 
 * method: displayBag takes bag as its arg and uses the bag's method toArray to access its contents 
 */