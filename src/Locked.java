import javax.swing.*;
import java.awt.*;

public class Locked extends JFrame{
    
    JPanel panel = new JPanel();
    JPanel buttons = new JPanel();
    JButton delete, clear, back;
    JLabel background;
    
    String keyDelete;
    
    public Locked(){
        super("Restricted");
        setLayout(null);
        panel.setLayout(null);
        buttons.setLayout(new GridLayout(3,1));
        
        delete = new JButton("DELETE KEY");
        clear = new JButton("CLEAR ALL");
        back = new JButton("BACK");
        background = new JLabel(new ImageIcon(new ImageIcon("images/menu.png").getImage().getScaledInstance(430,400,java.awt.Image.SCALE_SMOOTH)));
        
        delete.setFont(new Font("Calibri", Font.BOLD, 20));
        clear.setFont(new Font("Calibri", Font.BOLD, 20));
        back.setFont(new Font("Calibri", Font.BOLD, 20));
        
        delete.setForeground(Color.WHITE);
        clear.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);
        
        delete.setBackground(Color.DARK_GRAY);
        clear.setBackground(Color.DARK_GRAY);
        back.setBackground(Color.DARK_GRAY);
        
        buttons.setBounds(10,50,410,340);
        background.setBounds(0,0,430,400);
        panel.setBounds(0,0,435,435);
        
        buttons.add(delete);
        buttons.add(clear);
        buttons.add(back);
        panel.add(buttons);
        panel.add(background);
        add(panel);
    }
}
