package listners.implementation;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class ButtonStateListener implements src.listners.ControlState, src.listners.Listeners {

    private String value;

    public ButtonStateListener(Composite parent, String value) {
        this.value = value;
        Button button = new Button(parent, SWT.PUSH);
        button.setText(value);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
        button.addListener(SWT.MouseDown, new Listener(){

            @Override
            public void handleEvent(Event e) {
                action();
            }
        });
    }

    @Override
    public void action() {
        switch(value) {
            case "<":
            {
                previousState();
            }
            break;
            case ">":
            {
                nextState();
            }
            break;
            default:
                break;
        }
    }

    @Override
    public void nextState() {
        ListenerText.getTextField().nextState();
        ListenerTree.getTree().nextState();
    }

    @Override
    public void previousState() {
        ListenerText.getTextField().previousState();
        ListenerTree.getTree().previousState();
    }

}