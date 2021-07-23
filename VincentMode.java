import java.awt.*;

public class VincentMode implements Mode {

    public VincentMode() {
        display();             // constructor method is calling display() method
    }
    @Override
    public void display() {        // setting features of vincent mode through SingletonEditor
        Color blue = Color.decode("#0B243B");
        Color panelBlue = Color.decode("#0A0A2A");
        Color font = Color.decode("#C0BFBF");
        Color bar = Color.decode("#373738");
        SingletonEditor.getEditor().mb.setBackground(bar);
        SingletonEditor.getEditor().area.setBackground(blue);
        SingletonEditor.getEditor().area.setForeground(Color.WHITE);
        SingletonEditor.getEditor().panel.setBackground(panelBlue);
        SingletonEditor.getEditor().label.setForeground(font);
        for (int i=0; i<7; i++){
            SingletonEditor.getEditor().mb.getMenu(i).setForeground(font);
        }
    }
}
