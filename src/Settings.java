import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Settings extends JFrame{
    JPanel panel = new JPanel();
    JPanel configure = new JPanel();
    JComboBox face;
    JSpinner size;
    JRadioButton plain, bold, italic, black, red, green, blue;
    JLabel faceLabel, sizeLabel, styleLabel, colorLabel;
    JButton save, cancel, restrict;
    JTextArea fontTester;
    ButtonGroup fontStyle, fontColor;
    JLabel background;
    
    String[] fontFace = {"Arial", "Calibri", "Century Gothic", "Comic Sans MS", "Consolas", "Courier New", "Lucida Sans", "Tahoma", "Times New Roman", "Verdana"};
    SpinnerNumberModel fontSizeModel = new SpinnerNumberModel(16,7,50,1);
    
    String selectedFontFace;
    int fontSize;
    
    Font font;
    
    public Settings(){
        
        super("SimSimi Settings");
        
        setLayout(null);
        panel.setLayout(null);
        configure.setLayout(null);
        
        fontStyle = new ButtonGroup();
        fontColor = new ButtonGroup();
        face = new JComboBox(fontFace);
        size = new  JSpinner(fontSizeModel);
        plain = new JRadioButton("Plain");
        bold = new JRadioButton("Bold");
        italic = new JRadioButton("Italic");
        black = new JRadioButton("Black");
        red = new JRadioButton("Red");
        green = new JRadioButton("Green");
        blue = new JRadioButton("Blue");
        faceLabel = new JLabel("Font Face: ");
        sizeLabel = new JLabel("Font Size: ");
        styleLabel = new JLabel("Font Style: ");
        colorLabel = new JLabel("Font Color: ");
        fontTester = new JTextArea(" You: Hi!\n SimSimi: Hello!\n You: How are you?\n SimSimi: I'm fine.");
        save = new JButton("SAVE");
        cancel = new JButton("CANCEL");
        restrict = new JButton("RESTRICTED");
        background = new JLabel(new ImageIcon(new ImageIcon("images/settings.png").getImage().getScaledInstance(430,500,java.awt.Image.SCALE_SMOOTH)));
        
        fontTester.setEditable(false);
        
        bold.setSelected(true);
        black.setSelected(true);
        
        faceLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        sizeLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        styleLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        colorLabel.setFont(new Font("Calibri", Font.BOLD, 16));
        face.setFont(new Font("Calibri", Font.PLAIN, 16));
        size.setFont(new Font("Calibri", Font.PLAIN, 16));
        plain.setFont(new Font("Calibri", Font.PLAIN, 16));
        bold.setFont(new Font("Calibri", Font.PLAIN, 16));
        italic.setFont(new Font("Calibri", Font.PLAIN, 16));
        black.setFont(new Font("Calibri", Font.PLAIN, 16));
        red.setFont(new Font("Calibri", Font.PLAIN, 16));
        green.setFont(new Font("Calibri", Font.PLAIN, 16));
        blue.setFont(new Font("Calibri", Font.PLAIN, 16));
        save.setFont(new Font("Calibri", Font.BOLD, 14));
        cancel.setFont(new Font("Calibri", Font.BOLD, 14));
        restrict.setFont(new Font("Calibri", Font.BOLD, 16));
        
        save.setForeground(Color.WHITE);
        cancel.setForeground(Color.WHITE);
        restrict.setForeground(Color.WHITE);
        
        face.setBackground(Color.WHITE);
        size.setBackground(Color.WHITE);
        plain.setBackground(Color.WHITE);
        bold.setBackground(Color.WHITE);
        italic.setBackground(Color.WHITE);
        black.setBackground(Color.WHITE);
        red.setBackground(Color.WHITE);
        green.setBackground(Color.WHITE);
        blue.setBackground(Color.WHITE);
        save.setBackground(Color.DARK_GRAY);
        cancel.setBackground(Color.DARK_GRAY);
        restrict.setBackground(Color.RED);
        configure.setBackground(Color.WHITE);
        
        faceLabel.setBounds(40,10,100,25);
        face.setBounds(140,10,200,25);
        
        sizeLabel.setBounds(40,45,100,25);
        size.setBounds(140,45,50,25);
        
        styleLabel.setBounds(40,80,100,25);
        plain.setBounds(140,80,100,25);
        bold.setBounds(140,105,100,25);
        italic.setBounds(140,130,100,25);
        
        colorLabel.setBounds(40,165,100,25);
        black.setBounds(140,165,100,25);
        red.setBounds(140,190,100,25);
        green.setBounds(140,215,100,25);
        blue.setBounds(140,240,200,25);
        
        fontTester.setBounds(10,340,410,100);
        save.setBounds(10,450,120,40);
        cancel.setBounds(298,450,120,40);
        restrict.setBounds(298,10,120,30);
        background.setBounds(0,0,430,500);
        configure.setBounds(10,50,410,280);
        panel.setBounds(0,0,435,535);
        
        configure.add(faceLabel);
        configure.add(sizeLabel);
        configure.add(styleLabel);
        configure.add(colorLabel);
        configure.add(face);
        configure.add(size);
        configure.add(plain);
        configure.add(bold);
        configure.add(italic);
        configure.add(black);
        configure.add(red);
        configure.add(green);
        configure.add(blue);
        panel.add(fontTester);
        panel.add(configure);
        panel.add(save);
        panel.add(cancel);
        panel.add(restrict);
        panel.add(background);
        add(panel);
        
        fontStyle.add(plain);
        fontStyle.add(bold);
        fontStyle.add(italic);
        
        fontColor.add(black);
        fontColor.add(red);
        fontColor.add(green);
        fontColor.add(blue);
        
        face.setSelectedIndex(1);
        
        selectedFontFace = (String)face.getSelectedItem();
        fontSize = (int)size.getValue();
        
        font = new Font(selectedFontFace, Font.PLAIN, fontSize);
        setFont(fontTester);
    }
    
    public void setFont(JTextArea changeFont){
        if(plain.isSelected()){
            font = null;
            font = new Font(selectedFontFace, Font.PLAIN, fontSize);
        }
        if(bold.isSelected()){
            font = null;
            font = new Font(selectedFontFace, Font.BOLD, fontSize);
        }
        if(italic.isSelected()){
            font = null;
            font = new Font(selectedFontFace, Font.ITALIC, fontSize);
        }
        changeFont.setFont(font);
        setFontColor(changeFont);
    }
    
    public void setFontColor(JTextArea changeChat){
        if(black.isSelected())
            changeChat.setForeground(Color.BLACK);
        if(red.isSelected())
            changeChat.setForeground(Color.RED);
        if(green.isSelected())
            changeChat.setForeground(Color.GREEN);
        if(blue.isSelected())
            changeChat.setForeground(Color.BLUE);
    }
}
