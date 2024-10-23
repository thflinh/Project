/**
 * Name: Pham, Thuy Linh
 * Project: 02
 * Course: cs-2400-01-f24
 * 
 * Description: This class provides a simple array-based implementation of a stack. 
 * It supports basic stack operations like push, pop, peek, and clear, 
 * following a Last-In, First-Out (LIFO) structure.
 */
public class ArrayStack<T> implements StackInterface<T>
{
    private T[] stack;
    private int topOfStack;
    private static final int DEFAULT_CAPACITY = 64;

    /**
     * Default constructor that initializes the stack with a default capacity.
     */
    public ArrayStack()
    {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructor that initializes the stack with a specified capacity.
     * @param desiredCapacity The initial capacity of the stack.
     */
    public ArrayStack(int desiredCapacity)
    {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[]) new Object[desiredCapacity];
        stack = tempStack;
        topOfStack = -1; //array starts at 0, when push an element top++, empty check if top == -1
    }

    /**
     * Adds a new entry to the top pf this stack
     * @param newEntry An object to be added to the stack
     */
    @Override
    public void push(T newEntry) 
    {
        if (topOfStack == stack.length - 1)
        {
            throw new RuntimeException("Stack is full.");
        }
        stack[topOfStack + 1] = newEntry;
        topOfStack++;
    }

    /**
     * Removes and returns this stack's top entry
     * @return The object at the top of the stack.
     * @throws RuntimeException if the stack is empty before the operation
     */
    @Override
    public T pop() 
    {
        if(isEmpty())
        {
            throw new RuntimeException("Stack is empty");
        }
        T top = stack[topOfStack];
        stack[topOfStack] = null;
        topOfStack--;
        return top;
    }

    /**
     * Retrieves this stack's top entry.
     * @return The object at the top of the stack.
     * @throws RuntimeException if the stack is empty
     */
    @Override
    public T peek() 
    {
        if (isEmpty())
        {
            throw new RuntimeException("Stack is empty");
        }
        return stack[topOfStack];
    }

    /**
     * Detects whether this stack is empty.
     * @return True if the stack is empty
     */
    @Override
    public boolean isEmpty() 
    {
        return topOfStack < 0;
    }

    /**
     * Removes all entries from this stack.
     */
    @Override
    public void clear() 
    {
        topOfStack = -1;
    }
}