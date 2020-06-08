package listners.implementation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;

public class ButtonEqualsListener implements src.listners.Listeners {
    private String value;
    private Button button;

    private List<src.listners.Listeners> listeners = new ArrayList<>();

    public ButtonEqualsListener(String value, Composite parent) {
        Button button = new Button(parent, SWT.PUSH);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        button.setText(value);
        button.addListener(SWT.MouseDown, new Listener() {

            @Override
            public void handleEvent(Event e) {
                action();
            }
        });
    }

    @Override
    public void action() {
        if (!ListenerText.getTextField().getText().getText().isEmpty()) {
            listeners.add(StackCalculator.getCalculator());
            listeners.add(ListenerLabel.getLabel());
            listeners.add(ListenerText.getTextField());
            listeners.add(ListenerTree.getTree());
            for (src.listners.Listeners listener : listeners) {
                listener.action();
            }
        }
        listeners.clear();
    }

}