package src.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;

import listners.implementation.ButtonInputListener;

public class AdditionalView {

    private Text inputFieldText;
    private Composite parent;
    private List<ButtonInputListener> Inputbuttons = new ArrayList<>();
    private Point prevSize;

    public AdditionalView(Composite parent, Text inputField) {
        this.parent = parent;
        this.inputFieldText = inputField;
    }

    public void show() {
        Inputbuttons.add(new ButtonInputListener(inputFieldText, "sin", parent));

        Inputbuttons.add(new ButtonInputListener(inputFieldText, "cos", parent));

        Inputbuttons.add(new ButtonInputListener(inputFieldText, "tg", parent));

        Inputbuttons.add(new ButtonInputListener(inputFieldText, "ctg", parent));
        this.prevSize = parent.getSize();
        parent.pack();
        parent.setSize(prevSize);
    }

    public void hide() {
        for (ButtonInputListener inputbutton : Inputbuttons) {
            inputbutton.DisposeButton();
        }
        Inputbuttons.clear();
        parent.pack();
        parent.setSize(prevSize);
    }
}