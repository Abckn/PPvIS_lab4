package src.view;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import listners.implementation.ListenerLabel;
import listners.implementation.ListenerText;
import listners.implementation.ListenerTree;
import listners.implementation.StackCalculator;

public class MainView {
    private Display display = new Display();
    private Shell shell = new Shell(display);

    public MainView() {
        GridLayout layout = new GridLayout(7, true);
        shell.setLayout(layout);

        ListenerLabel output = new ListenerLabel(shell);

        ListenerText input = new ListenerText(shell);

        ListenerTree tree = new ListenerTree(shell);

        src.view.NumpadView numpadView = new src.view.NumpadView(shell, SWT.BORDER);

        StackCalculator calculator = new StackCalculator();
        run();
    }

    public void run() {
        shell.open();
        while(!shell.isDisposed()) {
            if(!display.readAndDispatch()) display.sleep();
        }
        display.dispose();

    }

    public static void main(String[] args) {
         new MainView();
       
    }


}