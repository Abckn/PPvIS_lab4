package listners.implementation;

import util.InfixToPostfix;

import java.util.Stack;



public class StackCalculator implements src.listners.Listeners {

    private static StackCalculator calculator;

    public static StackCalculator getCalculator() {
        return calculator;
    }

    private double answer;

    public StackCalculator() {
        calculator = this;
    }

    private void calculate() {
        String input = ListenerText.getTextField().getText().getText();
        var operands = InfixToPostfix.Convert(input);
        Stack<Double> stack = new Stack<>();
        for (var operand : operands) {
            switch(operand) {
                case "+":
                {
                    double firstOperand = stack.pop(), secondOperand = stack.pop();
                    stack.push(firstOperand + secondOperand);
                }
                break;
                case "-":
                {
                    double firstOperand = stack.pop(), secondOperand = stack.pop();
                    stack.push(secondOperand - firstOperand);
                }
                break;
                case "*":
                {
                    double firstOperand = stack.pop(), secondOperand = stack.pop();
                    stack.push(firstOperand * secondOperand);
                }
                break;
                case "/":
                {
                    double firstOperand = stack.pop(), secondOperand = stack.pop();
                    stack.push(secondOperand / firstOperand);
                }
                break;
                case "%":
                {
                    double firstOperand = stack.pop(), secondOperand = stack.pop();
                    stack.push(secondOperand % firstOperand);
                }
                break;
                case "!":
                {
                    double firstOperand = stack.pop();
                    stack.push(Math.sin(firstOperand));
                }
                break;
                case "@":
                {
                    double firstOperand = stack.pop();
                    stack.push(Math.cos(firstOperand));
                }
                break;
                case "#":
                {
                    double firstOperand = stack.pop();
                    stack.push(Math.tan(firstOperand));
                }
                break;
                case "$":
                {
                    double firstOperand = stack.pop();
                    stack.push(1 / Math.tan(firstOperand));
                }
                break;
                case "":
                    break;
                default:
                    stack.push(Double.parseDouble(operand));
                    break;
            }
        }
        answer = stack.pop();
    }

    public double getAnswer() {
        return answer;
    }

    @Override
    public void action() {
        calculate();
    }
}