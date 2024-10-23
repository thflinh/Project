/**
 * Name: Pham, Thuy Linh
 * Project: 02
 * Course: cs-2400-01-f24
 * 
 * Description: This interface defines the basic operations of a stack data structure,
 * which follows the Last-In, First-Out (LIFO) principle. It allows for adding, removing,
 * and peeking at entries, as well as checking whether the stack is empty and clearing its contents. 
 */
public interface StackInterface<T> 
{
    /**
     * Adds a new entry to the top pf this stack
     * @param newEntry An object to be added to the stack
     */
    public void push(T newEntry);

    /**
     * Removes and returns this stack's top entry
     * @return The object at the top of the stack.
     * @throws RuntimeException if the stack is empty before the operation
     */
    public T pop();
    
    /**
     * Retrieves this stack's top entry.
     * @return The object at the top of the stack.
     * @throws RuntimeException if the stack is empty
     */
    public T peek();

    /**
     * Detects whether this stack is empty.
     * @return True if the stack is empty
     */
    public boolean isEmpty();

    /**
     * Removes all entries from this stack.
     */
    public void clear();
}