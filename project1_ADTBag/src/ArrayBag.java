/**
 * Name: Pham, Thuy Linh
 * Project: 1
 * Due: 09/27/2024
 * Course: cs-2400-01-f24
 * 
 * Description: The ArrayBag implements the generic bag data structure 
 *              that can store a collection of items.
 */
public final class ArrayBag<T> implements BagInterface<T>
{
    private final T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 25;
    private boolean integrityOK = false;
    private static final int MAX_CAPACITY = 10000;

    /**
     * Creates an empty bag whose initial capacity is 25
     */
    public ArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Creates an empty bag having a given initial capacity
     * @param desiredCapacity the integer capacity desired
     */
    public ArrayBag(int desiredCapacity)
    {
        if (desiredCapacity <= MAX_CAPACITY)
        {
            //the cast is safe bc the new array contains null entries
            @SuppressWarnings("unchecked")
            T[] tempBag = (T[]) new Object[desiredCapacity]; //unchecked cast
            bag = tempBag;
            numberOfEntries = 0;
            integrityOK = true;
        }
        else
        {
            throw new IllegalStateException("Attempt to create a bag whose" + 
                                            "capacity exceeds allowed maximum.");
        }
    }

    /**
     * Gets the current number of entries in this bag.
     * @return the int number of entries currently in the bag
     */
    @Override
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    /**
     * Sees whether this bag is empty.
     * @return True if the bag is empty, or false if not.
     */
    @Override
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    }
    
    /**
     * Adds a new entry to this bag.
     * @param newEntry The object to be added as a new entry.
     * @return True if the addition is successful, or false if not.
     */
    @Override
    public boolean add(T newEntry)
    {
        checkIntegrity();
        boolean result = true;
        if (isArrayFull())
        {
            result = false;
        }
        else
        {
            bag[numberOfEntries] = newEntry;
            numberOfEntries++;
        }
        return result;
    }

    /**
     * Removes one unspecified entry from this bag, if possible.
     * @return either the removed entry, 
     * if the removal was successful, or null
     */
    @Override
    public T remove()
    {
        checkIntegrity();
        T result = null;

        if (numberOfEntries > 0)
        {
            result = bag[numberOfEntries -1];
            bag[numberOfEntries -1] = null;
            numberOfEntries--;
        }
        return result;
    }

    /**
     * Removes one occurrence of a given entry from this bag, if possible.
     * @param anEntry The entry to be removed
     * @return True if the removal was successful, or False if not
     */
    @Override
    public boolean remove(T anEntry)
    {
        int index = getIndexOf(anEntry);
        if (index >= 0) {
            numberOfEntries--;
            bag[index] = bag[numberOfEntries];
            bag[numberOfEntries] = null;
            return true;
        } else {
            return false;
        }
    }

    /**
     * Removes all entries from this bag
     */
    @Override
    public void clear()
    {
        while (!isEmpty())
        {
            remove();
        }
    }

    /**
     * Counts the number of times a given entry appears in this bag.
     * @param anEntry The entry to be counted
     * @return the number of times anEntry appears in the bag
     */
    @Override
    public int getFrequencyOf(T anEntry) 
    {
        checkIntegrity();
        int counter = 0;
        
        for (int index = 0; index < numberOfEntries; index++)
        {
            if (anEntry.equals(bag[index]))
            {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Tests whether this bag contains a given entry
     * @param anEntry the entry to find.
     * @return True if the bag contains anEntry, or False if not
     */
    @Override
    public boolean contains(T anEntry) 
    {
        checkIntegrity();
        boolean found  = false;
        int index = 0; 
        while (!found && (index < numberOfEntries))
        {
            if (anEntry.equals(bag[index]))
            {
                found = true;
            }
            index++;
        }
        return found;
    }

    /**
     * Retrieves all entries that are in this bag
     * @return a newly allocated array of all the entries in the bag.
     * Note: if the bag is empty, the returned array is empty
     */
    @Override
    public T[] toArray()
    {
        checkIntegrity();
        //the cast is safe bc the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries];

        for (int i = 0; i < numberOfEntries; i++)
        {
            result[i] = bag[i];
        }
        return result;
    }

    /**
     * Check if the bag is full (not really necessary)
     * @return true if the array is full, or false if not
     */
    private boolean isArrayFull()
    {
        return numberOfEntries >= bag.length;
    }

    //Throws an exception if this object is not initialized 
    private void checkIntegrity() {
        if (!integrityOK)
        {
            throw new SecurityException("ArrayBag object is corrupt.");
        }
    }
    
    //Locates a given entry within the array bag
    //Return the index of the entry, if located, or -1 otherwise
    //Precondition: checkIntegrity has been called
    private int getIndexOf(T anEntry) {
        int where = -1;
        boolean found = false;
        int index = 0;

        while (!found && (index < numberOfEntries)) {
            if (anEntry.equals(bag[index])) {
                found = true;
                where = index;
            }
            index++;
        }
        return where;
    }

    //Removes and returns the entry at a given array index
    //if no such entry exists, returns null
    // private T removeEntry(int givenIndex)
    // {
    //     T result = null;
    //     if (!isEmpty() && (givenIndex >= 0))    //if the bag is not empty and the given index is not neg
    //     {
    //         result = bag[givenIndex];
    //         bag[givenIndex] = bag[numberOfEntries-1];
    //         bag[numberOfEntries - 1] = null;
    //         numberOfEntries--;
    //     }
    //     return result;
    // }
}