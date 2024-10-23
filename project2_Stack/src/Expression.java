/**
 * Name: Pham, Thuy Linh
 * Project: 02
 * Course: cs-2400-01-f24
 * 
 * Description: This class provides methods to convert an infix expression to postfix notation 
 * and to evaluate a postfix expression using a stack. It supports basic arithmetic operations
 * such as addition, subtraction, multiplication, division, and exponentiation.
 */

public class Expression {
    /**
     * Converts an infix expression (array of strings) into a postfix expression using a stack.
     * 
     * @param infixExpression The infix expression as an array of strings.
     * @return The postfix expression as an array of strings.
     * @throws RuntimeException if the expression is invalid or unbalanced.
     */
    public static String[] convertToPostfix(String[] infixExpression)
    {
        StackInterface<String> operatorStack = new ArrayStack<>();
        String[] postfix = new String[infixExpression.length];
        int count = 0;

        if (infixExpression.length == 1 && isOperand(infixExpression[0])) {
            throw new RuntimeException("Invalid input: A single operand is not a valid expression.");
        }

        for (String token: infixExpression)
        {
            if (isOperand(token))
            {
                postfix[count] = token;
                count++;
            }
            else if (isOperator(token))
            {
                while (!operatorStack.isEmpty() && precedence(token) <= precedence(operatorStack.peek()))
                {
                    postfix[count] = operatorStack.pop(); //pop operators to postfix
                    count++; 
                }
                operatorStack.push(token); //push current op. to stack
            }
            else if (token.equals("("))
            {
                operatorStack.push(token);
            }
            else if (token.equals(")"))
            {
                while (!operatorStack.peek().equals("("))
                {
                    if (operatorStack.isEmpty())
                    {
                        throw new RuntimeException("Expression is unbalanced");
                    }
                    postfix[count] = operatorStack.pop();
                    count++;
                }
                operatorStack.pop();
            }
            else
            {
                throw new RuntimeException("Invalid expression");
            }
        }

        //pop remaining from the stack to postfix string 
        while (!operatorStack.isEmpty())
        {
            if (operatorStack.peek().equals("("))
            {
                throw new RuntimeException("Expression is unbalanced");
            }
            postfix[count] = operatorStack.pop();
            count++;
        }

        //return the trim array to the used size
        //return postfix;
        return java.util.Arrays.copyOf(postfix, count);
    }

    /**
     * Evaluates a postfix expression and returns the result as an integer.
     * 
     * @param postfixExpression The postfix expression as an array of strings.
     * @return The evaluated result of the postfix expression.
     * @throws RuntimeException if the expression is invalid.
     */
    public static int evaluatePostfix (String[] posfixExpression)
    {
        StackInterface<Integer> valueStack = new ArrayStack<>();
        
        for (String token : posfixExpression)
        {
            if (isOperand(token))
            {
                valueStack.push(Integer.parseInt(token));
            }
            else if (isOperator(token))
            {
                if (valueStack.isEmpty())
                {
                    throw new RuntimeException("Invalid postfix expression");
                }
                
                int operand2 = valueStack.pop();
                int operand1 = valueStack.pop();
                int result = stackOperation(operand1, operand2, token);
                valueStack.push(result);
            }
            else
            {
                throw new RuntimeException("Invalid token: " + token);
            }
        }

        return valueStack.pop();
    }

    //isOperand helper method
    private static boolean isOperand(String token)
    {
        try
        {
            //check if the token is int or not
            Integer.parseInt(token);
            return true;
        }
        catch (NumberFormatException e)
        {
            return false; //not an integer
        }
    }

    //isOperator to check if it's an operator or not
    private static boolean isOperator(String token)
    {
        return token.equals("+") || token.equals("-") || 
                token.equals("*") || token.equals("/") || token.equals("^");
    }

    //precedence to check the precedence of the operator
    private static int precedence(String operator)
    {
        switch(operator)
        {
            case "^": return 3;
            case "*" : case "/": return 2;
            case "+" : case "-": return 1;
            default: return 0;
        }
    }

    //stackOperation calculate the expression
    private static int stackOperation(int operand1, int operand2, String operator)
    {
        switch(operator)
        {
            case "^": 
            return (int) Math.pow(operand1, operand2);
            case "*": 
            return operand1 * operand2;
            case "/":
            return operand1 / operand2;
            case "-":
            return operand1 - operand2;
            case "+":
            return operand1 + operand2;
            default: throw new RuntimeException("Invalid expression");
        }
    }
}
