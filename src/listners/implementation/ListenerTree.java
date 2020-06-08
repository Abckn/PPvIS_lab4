package listners.implementation;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

import util.InfixToPostfix;

public class ListenerTree implements src.listners.Listeners, src.listners.ControlState {

    private static ListenerTree actionTree;

    public static ListenerTree getTree() {
        return actionTree;
    }

    public static void clearTree() {
        actionTree.tree.removeAll();
    }
    private Composite parent;
    private Tree tree;


    public ListenerTree(Composite parent) {
        this.parent = parent;
        this.tree = new Tree(parent, SWT.BORDER);
       // this.parent = parent;
        tree.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
        actionTree = this;
    }

    @Override
    public void action() {
        String input = ListenerText.getTextField().getText().getText();
        var operands = InfixToPostfix.Convert(input);
        Collections.reverse(Objects.requireNonNull(operands));
        tree.removeAll();
        if(operands.size() > 1) {
            createTree(operands, tree, 2, null);
        }
    }

    private List<String> createTree(List<String> operands, Tree root, int childrenLimit, TreeItem parent) {
        int limit = 0;
        while(!operands.isEmpty()) {
            var operand = operands.get(0);
            switch(operand) {
                case "+":
                case "-":
                case "*":
                case "/":
                case "%":
                {
                    TreeItem child;
                    if(parent == null) {
                        child = new TreeItem(root, SWT.NONE);
                        child.setExpanded(true);
                        child.setText(operand);
                        operands.remove(operand);
                        operands = createTree(operands, root, 2, child);
                        parent = child;
                        limit++;
                    }
                    else {
                        child = new TreeItem(parent, SWT.NONE);
                        child.setExpanded(true);
                        child.setText(operand);
                        operands.remove(operand);
                        limit++;
                        operands = createTree(operands, root, 2, child);
                    }
                }
                break;
                case "!":
                case "@":
                case "#":
                case "$":
                {
                    TreeItem child;
                    if(parent == null) {
                        child = new TreeItem(root, SWT.NONE);
                        child.setExpanded(true);
                        switch(operand) {
                            case "!":
                                child.setText("sin");
                                break;
                            case "@":
                                child.setText("cos");
                                break;
                            case "#":
                                child.setText("tg");
                                break;
                            case "$":
                                child.setText("ctg");
                                break;
                        }
                        operands.remove(operand);
                        operands = createTree(operands, root, 1, child);
                        parent = child;
                        limit++;
                    }
                    else {
                        child = new TreeItem(parent, SWT.NONE);
                        child.setExpanded(true);
                        switch(operand) {
                            case "!":
                                child.setText("sin");
                                break;
                            case "@":
                                child.setText("cos");
                                break;
                            case "#":
                                child.setText("tg");
                                break;
                            case "$":
                                child.setText("ctg");
                                break;
                        }
                        operands.remove(operand);
                        limit++;
                        operands = createTree(operands, root, 1, child);
                    }
                }
                break;
                default:
                {
                    if(limit < childrenLimit) {
                        TreeItem num = new TreeItem(parent, SWT.NONE);
                        num.setText(operand);
                        operands.remove(operand);
                        limit++;
                    }
                    if(limit == childrenLimit) return operands;
                }
                break;
            }
        }

        return operands;
    }

    @Override
    public void nextState() {
        action();
    }

    @Override
    public void previousState() {
        action();
    }
}