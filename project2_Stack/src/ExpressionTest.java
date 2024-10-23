/**
 * Name: Pham, Thuy Linh
 * Project: 02
 * Course: cs-2400-01-f24
 * 
 * Description: This application tests the conversion of infix expressions to postfix notation 
 * and evaluates them. It accepts expressions as command-line arguments, converts them 
 * to postfix, and then evaluates and displays the results. In case of errors, it reports 
 * the issue.
 */

public class ExpressionTest {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No command line parameters provided.");
            return;
        }

        System.out.println("Expression by L. Pham\n");

        for (String arg: args)
        {
            String[] infix = arg.split(" ");
            System.out.println(arg);

            try
            {
                String[] postfix = Expression.convertToPostfix(infix);
                System.out.print("\t" + String.join(" ", postfix));
                int result = Expression.evaluatePostfix(postfix);
                System.out.println(" = " + result);
            }
            catch (RuntimeException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
