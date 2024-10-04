import java.awt.*;

public class FunctionFormat {
    GUI gui;
    String selectedFont;
    int fontSize;
    public FunctionFormat(GUI gui) {
        this.gui = gui;
    }
    public void wordWrap(){
     if (gui.wordWrapOn==false){
         gui.wordWrapOn=true;
         gui.textArea.setLineWrap(true);
         gui.iWrap.setText("Wrap : on");
         gui.textArea.setWrapStyleWord(true);
     }
     else{
         gui.wordWrapOn=false;
         gui.iWrap.setText("Wrap : off");
         gui.textArea.setLineWrap(false);
         gui.textArea.setWrapStyleWord(false);
     }
    }

    public void createFont(int fontSize){
        this.fontSize=fontSize;
        setFont(selectedFont);
    }

    public void setFont (String fontName){
        selectedFont=fontName;
        Font newFont = new Font(selectedFont, Font.PLAIN, fontSize);
        gui.textArea.setFont(newFont);
    }
}
