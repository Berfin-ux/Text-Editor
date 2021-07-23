import java.awt.*;

public class NatureMode implements Mode {

    public NatureMode() {
        display();             // constructor method is calling display() method
    }

    @Override
    public void display() {        // setting features of nature mode through SingletonEditor
        Color area = Color.decode("#2B552A");
        Color panel = Color.decode("#0E330D");
        Color font = Color.decode("#C0BFBF");
        Color menu = Color.decode("#1C6C1A");
        SingletonEditor.getEditor().mb.setBackground(menu);
        SingletonEditor.getEditor().area.setBackground(area);
        SingletonEditor.getEditor().area.setForeground(Color.WHITE);
        SingletonEditor.getEditor().panel.setBackground(panel);
        SingletonEditor.getEditor().label.setForeground(font);
        for (int i=0; i<7; i++){
            SingletonEditor.getEditor().mb.getMenu(i).setForeground(font);
        }
    }
}
