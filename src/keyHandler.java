import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
   if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
       gui.file.save();
   }
        if (e.isShiftDown() && e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
            gui.file.SavaAS();
        }
        if (e.isAltDown() && e.getKeyCode()==KeyEvent.VK_F){
            gui.fileMenu.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    GUI gui;
    public keyHandler(GUI gui) {
        this.gui = gui;
    }

}
