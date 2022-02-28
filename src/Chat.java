import java.util.*;
import javax.swing.*;
import java.awt.*;

public class Chat extends JFrame{
    JTextArea chatBox;
    JTextField msgBox;
    JButton send, teachMe, settings, exit, back, clear;
    JScrollPane scroll;
    JLabel background;
    JPanel panel = new JPanel();
    
    String msg = "";
    
    public Chat(){
        super("SimSimi");
        
        setLayout(null);
        panel.setLayout(null);
        
        chatBox = new JTextArea();
        scroll = new JScrollPane(chatBox);
        msgBox = new JTextField();
        send = new JButton("SEND");
        teachMe = new JButton("TEACH ME");
        settings = new JButton("SETTINGS");
        exit = new JButton("EXIT");
        back = new JButton("BACK");
        clear = new JButton("CLEAR");
        background = new JLabel(new ImageIcon(new ImageIcon("images/chatbox.png").getImage().getScaledInstance(430,700,java.awt.Image.SCALE_SMOOTH)));
        
        scroll.setBounds(10,50,410,535);
        msgBox.setBounds(10,595,273,40);
        
        send.setBounds(298,595,120,40);
        teachMe.setBounds(10,645,120,40);
        settings.setBounds(154,645,120,40);
        exit.setBounds(298,645,120,40);
        clear.setBounds(173,10,120,30);
        back.setBounds(298,10,120,30);
        
        background.setBounds(0,0,430,700);
        panel.setBounds(0,0,435,735);
        
        chatBox.setLineWrap(true);
        chatBox.setWrapStyleWord(true);
        
        chatBox.setEditable(false);
        chatBox.setFont(new Font("Calibri", Font.BOLD, 16));
        msgBox.setFont(new Font("Calibri", Font.BOLD, 16));
        
        send.setFont(new Font("Calibri", Font.BOLD, 14));
        teachMe.setFont(new Font("Calibri", Font.BOLD, 14));
        settings.setFont(new Font("Calibri", Font.BOLD, 14));
        exit.setFont(new Font("Calibri", Font.BOLD, 14));
        clear.setFont(new Font("Calibri", Font.BOLD, 14));
        back.setFont(new Font("Calibri", Font.BOLD, 14));
        
        send.setForeground(Color.WHITE);
        teachMe.setForeground(Color.WHITE);
        settings.setForeground(Color.WHITE);
        exit.setForeground(Color.WHITE);
        clear.setForeground(Color.WHITE);
        back.setForeground(Color.WHITE);
        
        send.setBackground(Color.DARK_GRAY);
        teachMe.setBackground(Color.DARK_GRAY);
        settings.setBackground(Color.DARK_GRAY);
        exit.setBackground(Color.DARK_GRAY);
        clear.setBackground(Color.DARK_GRAY);
        back.setBackground(Color.DARK_GRAY);
        
        panel.add(scroll);
        panel.add(msgBox);
        panel.add(teachMe);
        panel.add(settings);
        panel.add(exit);
        panel.add(send);
        panel.add(clear);
        panel.add(back);
        panel.add(background);
        add(panel);
    }
}
