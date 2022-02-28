import javax.swing.*;
import java.awt.*;
import java.util.*;

public class TeachMe extends JFrame {
    JPanel panel = new JPanel();
    JButton save, back, clear;
    JLabel totalLabel, total;
    JLabel background;
    JTextArea question, answer;
    JScrollPane qScroll, aScroll;
    
    public TeachMe(){
        super("Teach Me");
        
        setLayout(null);
        panel.setLayout(null);
        
        save = new JButton("TEACH");
        back = new JButton("BACK");
        clear = new JButton("CLEAR");
        question = new JTextArea("");
        answer = new JTextArea("");
        totalLabel = new JLabel("Things I Know: ");
        total = new JLabel();
        qScroll = new JScrollPane(question);
        aScroll = new JScrollPane(answer);
        background = new JLabel(new ImageIcon(new ImageIcon("images/teach.png").getImage().getScaledInstance(430,410,java.awt.Image.SCALE_SMOOTH)));
        
        qScroll.setBounds(83,94,268,89);
        aScroll.setBounds(82,237,268,88);
        
        save.setBounds(25,360,120,40);
        clear.setBounds(155,360,120,40);
        back.setBounds(285,360,120,40);
        background.setBounds(0,0,430,410);
        panel.setBounds(0,0,435,445);
        
        totalLabel.setBounds(220,15,130,30);
        total.setBounds(350,14,50,30);
        
        question.setLineWrap(true);
        answer.setLineWrap(true);
        question.setWrapStyleWord(true);
        answer.setWrapStyleWord(true);
        
        question.setFont(new Font("Calibri", Font.BOLD, 20));
        answer.setFont(new Font("Calibri", Font.BOLD, 20));
        totalLabel.setFont(new Font("Calibri", Font.BOLD, 20));
        total.setFont(new Font("Calibri", Font.BOLD, 22));
        totalLabel.setForeground(Color.DARK_GRAY);
        total.setForeground(Color.WHITE);
        
        save.setFont(new Font("Calibri", Font.BOLD, 14));
        back.setFont(new Font("Calibri", Font.BOLD, 14));
        clear.setFont(new Font("Calibri", Font.BOLD, 14));
        save.setForeground(Color.white);
        back.setForeground(Color.white);
        clear.setForeground(Color.white);
        save.setBackground(Color.DARK_GRAY);
        back.setBackground(Color.DARK_GRAY);
        clear.setBackground(Color.DARK_GRAY);
        
        panel.add(qScroll);
        panel.add(aScroll);
        panel.add(totalLabel);
        panel.add(total);
        panel.add(save);
        panel.add(clear);
        panel.add(back);
        panel.add(background);
        add(panel);
    }
}
