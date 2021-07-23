import java.awt.*;

public class DarkMode implements Mode {

    public DarkMode() {
        display();            // constructor method is calling display() method
    }
    @Override
    public void display() {       // setting features of dark mode through SingletonEditor
        Color areaColor = Color.decode("#302E2E");
        Color font = Color.decode("#8B8989");
        SingletonEditor.getEditor().mb.setBackground(Color.BLACK);
        SingletonEditor.getEditor().area.setBackground(areaColor);
        SingletonEditor.getEditor().area.setForeground(Color.WHITE);
        SingletonEditor.getEditor().panel.setBackground(Color.darkGray);
        SingletonEditor.getEditor().label.setForeground(font);
        for (int i=0; i<7; i++){
            SingletonEditor.getEditor().mb.getMenu(i).setForeground(font);
        }
    }
}
