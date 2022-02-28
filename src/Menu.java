import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame{
    
    JPanel panel = new JPanel();
    JPanel buttons = new JPanel();
    JButton play, set, teach, exit;
    JLabel background;
    
    public Menu(){
        super("SimSimi");
        setLayout(null);
        panel.setLayout(null);
        buttons.setLayout(new GridLayout(4,1));
        
        play = new JButton("CHAT ME");
        set = new JButton("SETTINGS");
        teach = new JButton("TEACH ME");
        exit = new JButton("LEAVE");
        background = new JLabel(new ImageIcon(new ImageIcon("images/menu.png").getImage().getScaledInstance(430,400,java.awt.Image.SCALE_SMOOTH)));
        
        play.setFont(new Font("Calibri", Font.BOLD, 20));
        set.setFont(new Font("Calibri", Font.BOLD, 20));
        teach.setFont(new Font("Calibri", Font.BOLD, 20));
        exit.setFont(new Font("Calibri", Font.BOLD, 20));
        
        play.setForeground(Color.WHITE);
        set.setForeground(Color.WHITE);
        teach.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
        
        play.setBackground(Color.DARK_GRAY);
        set.setBackground(Color.DARK_GRAY);
        teach.setBackground(Color.DARK_GRAY);
        exit.setBackground(Color.DARK_GRAY);
        
        buttons.setBounds(10,50,410,340);
        background.setBounds(0,0,430,400);
        panel.setBounds(0,0,435,435);
        
        buttons.add(play);
        buttons.add(set);
        buttons.add(teach);
        buttons.add(exit);
        panel.add(buttons);
        panel.add(background);
        add(panel);
    }
}
