package listners.implementation;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class ButtonInvertListener implements src.listners.Listeners {

    private Text inputTextField;
    private Button button;

    public ButtonInvertListener(Text inputField, String value, Composite parent) {
        this.inputTextField = inputField;
        this.button = new Button(parent, SWT.PUSH);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        button.setText(value);
        button.addListener(SWT.MouseDown, new Listener(){

            @Override
            public void handleEvent(Event e) {
                action();
            }
        });
    }

    public void DisposeButton() {
        button.dispose();
    }

    @Override
    public void action() {
        inputTextField.setText("1/(" + inputTextField.getText() + ")");
    }
}