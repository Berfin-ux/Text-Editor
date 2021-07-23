import java.awt.*;

public class LightMode implements Mode {

    public LightMode() {
        display();             // constructor method is calling display() method
    }
    @Override
    public void display() {        // setting features of light mode through SingletonEditor
        SingletonEditor.getEditor().mb.setBackground(Color.LIGHT_GRAY);
        SingletonEditor.getEditor().area.setBackground(Color.WHITE);
        SingletonEditor.getEditor().area.setForeground(Color.BLACK);
        SingletonEditor.getEditor().panel.setBackground(Color.GRAY);
        for (int i=0; i<7; i++){
            SingletonEditor.getEditor().mb.getMenu(i).setForeground(Color.BLACK);
        }
    }
}
