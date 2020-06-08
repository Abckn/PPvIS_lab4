package src.converter;

import java.util.List;
import java.util.Stack;

public class PostfixToInfix {

    public static String convert(List<String> operands){

        Stack<String> stack = new Stack<>();
        for (String operand : operands) {
            switch (operand) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "%": {
                    String s1 = stack.pop();
                    String s2 = stack.pop();
                    String temp = "(" + s2 + operand + s1 + ")";
                    stack.push(temp);
                    break;
                }
                case "!": {
                    String s1 = stack.pop();
                    String temp = "sin(" + s1 + ")";
                    stack.push(temp);
                    break;
                }
                case "@": {
                    String s1 = stack.pop();
                    String temp = "cos(" + s1 + ")";
                    stack.push(temp);
                    break;
                }
                case "#": {
                    String s1 = stack.pop();
                    String temp = "tg(" + s1 + ")";
                    stack.push(temp);
                    break;
                }
                case "$": {
                    String s1 = stack.pop();
                    String temp = "ctg(" + s1 + ")";
                    stack.push(temp);
                    break;
                }
                default:
                    stack.push(operand);
                    break;
            }
        }

        String result=stack.pop();
        return result;
    }
}