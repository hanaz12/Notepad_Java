import java.awt.*;

public class FunctionColor {
    GUI gui;
    public FunctionColor(GUI gui) {
        this.gui = gui;
    }
    public void setColor(String color) {
    switch (color) {
        case "White":
            gui.window.getContentPane().setBackground(Color.WHITE);
            gui.textArea.setBackground(Color.WHITE);
            gui.textArea.setForeground(Color.BLACK);
            break;
        case "Black":
            gui.window.getContentPane().setBackground(Color.BLACK);
            gui.textArea.setBackground(Color.BLACK);
            gui.textArea.setForeground(Color.WHITE);
            break;
        case "Blue":
            gui.window.getContentPane().setBackground(Color.BLUE);
            gui.textArea.setBackground(Color.BLUE);
            gui.textArea.setForeground(Color.white);
            break;
    }
    }
}
