
import java.util.Stack;

public interface Command {
    public Stack stack = new Stack();      // to keep transactions to be made
    void execute(String text);         // transactions will be added to stack
    String undo();                  // transactions will be removed from stack
}
