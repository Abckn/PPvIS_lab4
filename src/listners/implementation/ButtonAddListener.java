package listners.implementation;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Text;

public class ButtonAddListener implements src.listners.Listeners {

    private boolean isCollapsed = true;
    private src.view.AdditionalView additionalView;

    public ButtonAddListener(String value, Composite parent, Text inputField) {
        Button button = new Button(parent, SWT.PUSH);
        button.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 2, 1));
        button.setText(value);
        button.addListener(SWT.MouseDown, new Listener(){

            @Override
            public void handleEvent(Event e) {
                action();
            }
        });
        this.additionalView = new src.view.AdditionalView(parent, inputField);
    }

    @Override
    public void action() {
        if(isCollapsed) {
            additionalView.show();
            this.isCollapsed = false;
        } else {
            additionalView.hide();
            this.isCollapsed = true;
        }
    }

}