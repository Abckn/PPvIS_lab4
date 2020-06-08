package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Java implementation to convert infix expression to postfix*/
// Note that here we use Stack class for Stack operations

import java.util.Stack;

public class InfixToPostfix
{

    static int Prec(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
            case '%':
                return 2;

            case '^':
            case '!':
            case '@':
            case '#':
            case '$':
                return 3;
        }
        return -1;
    }

    // The main method that converts given infix expression
    // to postfix expression.
    public static List<String> Convert(String exp)
    {
        // initializing empty String for result
        StringBuilder result = new StringBuilder("");

        exp = exp.replaceAll("(sin|cos|tg|ctg|\\*|/|\\+|-|%)", " $1 ");
        exp = exp.replaceAll("sin", "!");
        exp = exp.replaceAll("cos", "@");
        exp = exp.replaceAll("tg", "#");
        exp = exp.replaceAll("ctg", "$");

        // initializing empty stack
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i<exp.length(); ++i)
        {
            char c = exp.charAt(i);
            if (Character.isLetterOrDigit(c) || c == '.' || c == ' ')
                result.append(c);
            else if (c == '(')
                stack.push(c);

            else if (c == ')')
            {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(" ");
                    result.append(stack.pop());
                }

                if (!stack.isEmpty() && stack.peek() != '(') {
                    return null;
                }
                else {
                    stack.pop();
                }
            }
            else
            {
                while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())){
                    if(stack.peek() == '(')
                        return null;
                    result.append(stack.pop());
                }
                stack.push(c);
            }

        }

        // pop all the operators from the stack
        while (!stack.isEmpty()){
            if(stack.peek() == '(')
                return null;
            result.append(" ");
            result.append(stack.pop());
        }
        var operands = new ArrayList<>(Arrays.asList(result.toString().toString().split(" ")));
        operands.removeIf(String::isBlank);
        return operands;
    }
}