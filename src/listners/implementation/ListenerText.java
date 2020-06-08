package listners.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;


import src.converter.PostfixToInfix;
import util.InfixToPostfix;

public class ListenerText implements src.listners.Listeners, src.listners.ControlState {

    private static ListenerText text;
    private List<String> states;
    private int stateIndex = 0;
    private Text inputField;


    public static ListenerText getTextField() {
        return text;
    }

    public ListenerText(Composite parent) {
        this.inputField = new Text(parent, SWT.BORDER);
        inputField.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 4, 1));
        this.states = new ArrayList<>();
        this.text = this;
    }

    public Text getText() {
        return inputField;
    }

    @Override
    public void action() {
        states.clear();
        states.add(inputField.getText());
        calculateStates();
    }

    private void calculateStates() {
        String input = inputField.getText();
        var operands = InfixToPostfix.Convert(input);
        for(int i = 0; i < operands.size(); i++) {
            switch(operands.get(i)) {
                case "+":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-2)), secondOperand = Double.parseDouble( operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(firstOperand + secondOperand));
                    String nextState = PostfixToInfix.convert(operands);
                    states.add(nextState);
                }
                break;
                case "-":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-2));
                    double secondOperand = Double.parseDouble( operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(firstOperand - secondOperand));
                    String nextState = PostfixToInfix.convert(operands);
                    states.add(nextState);
                }
                break;
                case "*":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-2));
                    double secondOperand = Double.parseDouble( operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(firstOperand * secondOperand));
                    String nextState = PostfixToInfix.convert(operands);
                    states.add(nextState);
                }
                break;
                case "/":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-2));
                    double secondOperand = Double.parseDouble( operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(firstOperand / secondOperand));
                    String nextState = PostfixToInfix.convert(operands);
                    states.add(nextState);
                }
                break;
                case "%":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-2));
                    double secondOperand = Double.parseDouble( operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(firstOperand % secondOperand));
                    String nextState = PostfixToInfix.convert(operands);
                    states.add(nextState);
                }
                break;
                case "!":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(Math.sin(firstOperand)));
                    String nextState = PostfixToInfix.convert(operands);
                    states.add(nextState);
                }
                break;
                case "@":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(Math.cos(firstOperand)));
                    String nextState = PostfixToInfix.convert(operands);
                    states.add(nextState);
                }
                break;
                case "#":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(Math.tan(firstOperand)));
                    String nextState = PostfixToInfix.convert(operands);
                    states.add(nextState);
                }
                break;
                case "$":
                {
                    double firstOperand = Double.parseDouble(operands.get(i-1));
                    operands.remove(i-1);
                    i--;
                    operands.set(i, String.valueOf(1/Math.tan(firstOperand)));
                    String nextState = PostfixToInfix.convert(operands);
                    states.add(nextState);
                }
                break;
                default:
                    break;
                   
                   // throw new IllegalStateException("Unexpected value: " + operands.get(i));
            }
        }
    }

    @Override
    public void nextState() {
        if(stateIndex + 1 < states.size()) {
            stateIndex++;
            inputField.setText(states.get(stateIndex));
        }
    }

    @Override
    public void previousState() {
        if(stateIndex - 1 >= 0) {
            stateIndex--;
            inputField.setText(states.get(stateIndex));
        }
    }

}