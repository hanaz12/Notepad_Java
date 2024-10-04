import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;
    // for text area
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn=false;
    //for menuBar
    JMenuBar menuBar;
    JMenu fileMenu,editMenu,formatmenu,colorMenu;
    // for file menu
    JMenuItem iNew , iOpen,iSave , iSaveas , iExit;
    //for format menu
    JMenuItem iWrap , iFontArial , iFontCSMS ,iFontTNR , iFontSize8 ,  iFontSize12 , iFontSize16 , iFontSize20 , iFontSize24 , iFontSize28;
    JMenu menuFont , menuFontSize;
   // for color menu
    JMenuItem iColor1,iColor2,iColor3;
  // for Edit menu
    JMenuItem iundo , iredo;

    FunctionFile file= new FunctionFile(this);
    FunctionFormat format= new FunctionFormat(this);
    FunctionColor color= new FunctionColor(this);
    FunctionEdit edit= new FunctionEdit(this);
    keyHandler kHandler= new keyHandler(this);
    UndoManager um=new UndoManager();
    public static void main(String[] args) {
       new GUI();
    }
    public GUI() {
     createWindow();
     createTextarea();
     createMenuBar();
     format.selectedFont="CSMS";
     format.createFont(16);
     window.setVisible(true);
    }
    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextarea(){
        textArea = new JTextArea();
        textArea.addKeyListener(kHandler);
        textArea.getDocument().addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                um.addEdit(e.getEdit());
            }
        });
        scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);
        fileMenu = new JMenu("File");
        editMenu = new JMenu("Edit");
        formatmenu = new JMenu("Format");
        colorMenu = new JMenu("Color");
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(formatmenu);
        menuBar.add(colorMenu);
        createFileMenu();
        createFormatMenu();
        createColorMenu();
        createEditMenu();

    }
    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");



        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");


        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("Save");

        iSaveas = new JMenuItem("Save as");
        iSaveas.addActionListener(this);
        iSaveas.setActionCommand("SaveAs");

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("Exit");


        fileMenu.add(iNew);
        fileMenu.add(iOpen);
        fileMenu.add(iSave);
        fileMenu.add(iSaveas);
        fileMenu.add(iExit);
    }
    public void createFormatMenu(){
        iWrap = new JMenuItem("Wrap : off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Wrap");
        formatmenu.add(iWrap);

        menuFont = new JMenu("Font");
        formatmenu.add(menuFont);

        menuFontSize = new JMenu("Font Size");
        formatmenu.add(menuFontSize);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS=new JMenuItem("CSMS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("CSMS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("TNR");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("TNR");
        menuFont.add(iFontTNR);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("8");
        menuFontSize.add(iFontSize8);

        iFontSize12= new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("12");
        menuFontSize.add(iFontSize12);

        iFontSize16= new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("16");
        menuFontSize.add(iFontSize16);

        iFontSize20= new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("20");
        menuFontSize.add(iFontSize20);

        iFontSize24= new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("24");
        menuFontSize.add(iFontSize24);

        iFontSize28= new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("28");
        menuFontSize.add(iFontSize28);

    }
    public void createColorMenu(){
        iColor1 = new JMenuItem("White");
        iColor1.setActionCommand("White");
        iColor1.addActionListener(this);
        colorMenu.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.setActionCommand("Black");
        iColor2.addActionListener(this);
        colorMenu.add(iColor2);

        iColor3 = new JMenuItem("Blue");
        iColor3.setActionCommand("Blue");
        iColor3.addActionListener(this);
        colorMenu.add(iColor3);
    }
    public void createEditMenu(){
        iundo = new JMenuItem("Undo");
        iundo.addActionListener(this);
        iundo.setActionCommand("Undo");
        editMenu.add(iundo);

        iredo = new JMenuItem("Redo");
        iredo.setActionCommand("Redo");
        iredo.addActionListener(this);
        editMenu.add(iredo);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command){
            case "New":
                file.newFile();
                break;
            case "Open":
                file.open();
                break;
            case "SaveAs":
                file.SavaAS();
                break;
            case "Save":
                file.save();
                break;
           case "Exit":
               file.Exit();
               break;
            case "Wrap":
                format.wordWrap();
                break;
            case "8":
                format.createFont(8);
                break;
            case "12":
                format.createFont(12);
                break;
            case "16":
                format.createFont(16);
                break;
            case "20":
                format.createFont(20);
                break;
            case "24":
                format.createFont(24);
                break;
            case "28":
                format.createFont(28);
                break;
            case "Arial":
                format.setFont("Arial");
                break;
            case "CSMS":
                format.setFont("CSMS");
                break;
            case "TNR":
                format.setFont("TNR");
                break;
            case "White":
                color.setColor(command);
                break;
            case "Black":
                color.setColor(command);
                break;
            case "Blue":
                color.setColor(command);
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();
                break;

        }
    }
}
