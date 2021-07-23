public class Undo implements Command {
    public Undo() {      // constructor method
    }

    @Override
    public void execute(String text) {      // as a parameter text is pushed to stack
        Command.stack.push(text);
    }

    @Override
    public String undo() {               // returns top element on the stack
        return (String) Command.stack.pop();
    }
}
