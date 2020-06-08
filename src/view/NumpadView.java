package src.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import listners.implementation.ButtonAddListener;
import listners.implementation.ButtonClearListener;
import listners.implementation.ButtonEqualsListener;
import listners.implementation.ButtonInputListener;
import listners.implementation.ButtonInvertListener;
import listners.implementation.ListenerText;
import listners.implementation.ButtonStateListener;

public class NumpadView extends Composite {

    public NumpadView(Composite parent, int style) {
        super(parent, style);
        Text inputTextField = ListenerText.getTextField().getText();
        this.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 4, 1));
        this.setLayout(new GridLayout(5, true));

        ButtonStateListener undoButton = new ButtonStateListener(this, "<");

        ButtonStateListener redoButton = new ButtonStateListener(this, ">");

        ButtonClearListener clearButton = new ButtonClearListener(inputTextField, "C", this);

        ButtonInputListener leftBracketButton = new ButtonInputListener(inputTextField, "(", this);

        ButtonInputListener rightBracketButton = new ButtonInputListener(inputTextField, ")", this);

        ButtonInputListener nineButton = new ButtonInputListener(inputTextField, "9", this);

        ButtonInputListener eightButton = new ButtonInputListener(inputTextField, "8", this);

        ButtonInputListener sevenButton = new ButtonInputListener(inputTextField, "7", this);

        ButtonInputListener plusButton = new ButtonInputListener(inputTextField, "+", this);

        ButtonInputListener minusButton = new ButtonInputListener(inputTextField, "-", this);

        ButtonInputListener sixButton = new ButtonInputListener(inputTextField, "6", this);

        ButtonInputListener fiveButton = new ButtonInputListener(inputTextField, "5", this);

        ButtonInputListener fourButton = new ButtonInputListener(inputTextField, "4", this);

        ButtonInputListener multiplyButton = new ButtonInputListener(inputTextField, "*", this);

        ButtonInputListener divisionButton = new ButtonInputListener(inputTextField, "/", this);

        ButtonInputListener oneButton = new ButtonInputListener(inputTextField, "1", this);

        ButtonInputListener twoButton = new ButtonInputListener(inputTextField, "2", this);

        ButtonInputListener threeButton = new ButtonInputListener(inputTextField, "3", this);

        ButtonInputListener moduloButton = new ButtonInputListener(inputTextField, "%", this);

        ButtonInvertListener invertButton = new ButtonInvertListener(inputTextField, "1/x", this);

        ButtonInputListener zeroButton = new ButtonInputListener(inputTextField, "0", this);

        ButtonInputListener comButton = new ButtonInputListener(inputTextField, ".", this);

        ButtonEqualsListener resultButton = new ButtonEqualsListener("=", this);

        ButtonAddListener NewFunctionButton = new ButtonAddListener("Trigonometric function", this, inputTextField);
    }

}