import java.util.*;
import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class SplashScreen extends JFrame implements ActionListener, ChangeListener, KeyListener {
    JPanel panel = new JPanel();
    
    static Menu menu = new Menu();
    static Chat chat = new Chat();
    static File file = new File();
    static Settings settings = new Settings();
    static TeachMe teach = new TeachMe();
    static Locked lock = new Locked();
    
    boolean lastMain = false;
    
    public SplashScreen(){
        super("SimSimi");
        panel.setLayout(null);
        JLabel icon = new JLabel(new ImageIcon(new ImageIcon("images/splashscreen.jpg").getImage().getScaledInstance(320, 480, java.awt.Image.SCALE_SMOOTH)));
        
        icon.setBounds(0,0,320,480);
        panel.setBounds(0,0,325,515);
        
        panel.add(icon);
        add(panel);
        
        //Menu
        menu.play.addActionListener(this);
        menu.set.addActionListener(this);
        menu.teach.addActionListener(this);
        menu.exit.addActionListener(this);
        
        //Settings
        settings.face.addActionListener(this);
        settings.save.addActionListener(this);
        settings.cancel.addActionListener(this);
        settings.restrict.addActionListener(this);
        settings.size.addChangeListener(this);
        
        settings.black.addActionListener(this);
        settings.red.addActionListener(this);
        settings.green.addActionListener(this);
        settings.blue.addActionListener(this);
        
        settings.plain.addActionListener(this);
        settings.bold.addActionListener(this);
        settings.italic.addActionListener(this);
        
        //Chat
        chat.send.addActionListener(this);
        chat.msgBox.addKeyListener(this);
        chat.teachMe.addActionListener(this);
        chat.settings.addActionListener(this);
        chat.exit.addActionListener(this);
        chat.clear.addActionListener(this);
        chat.back.addActionListener(this);
        
        //TeachMe
        teach.save.addActionListener(this);
        teach.clear.addActionListener(this);
        teach.back.addActionListener(this);
        teach.question.addKeyListener(this);
        
        //Locked
        lock.delete.addActionListener(this);
        lock.clear.addActionListener(this);
        lock.back.addActionListener(this);
    }
    
    public static void main(String args[]) throws InterruptedException {
        file.load();
        
        SplashScreen splashScreen = new SplashScreen();
        
        splashScreen.setLayout(null);
        splashScreen.setSize(325,515);
        splashScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashScreen.setLocation(100,100);
        splashScreen.setResizable(false);
        
        menu.setSize(435,435);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setLocation(100,100);
        menu.setResizable(false);
        
        settings.setSize(435,535);
        settings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        settings.setLocation(100,100);
        settings.setResizable(false);
        
        chat.setSize(435,735);
        chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chat.setLocation(100,100);
        chat.setResizable(false);
        
        teach.setSize(435,445);
        teach.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        teach.setLocation(100,100);
        teach.setResizable(false);
        
        lock.setSize(435,435);
        lock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lock.setLocation(100,100);
        lock.setResizable(false);
        
        splashScreen.setVisible(true);
        Thread.sleep(1500);
        splashScreen.setVisible(false);
        menu.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent event){
        //Menu
        
        if(event.getSource() == menu.play){
            menu.setVisible(false);
            chat.setVisible(true);
        }
        
        if(event.getSource() == menu.set){
            lastMain = true;
            menu.setVisible(false);
            settings.setVisible(true);
        }
        
        if(event.getSource() == menu.teach){
            lastMain = true;
            menu.setVisible(false);
            teach.total.setText("" + file.QA.size());
            teach.setVisible(true);
        }
        
        if(event.getSource() == menu.exit){
            if(JOptionPane.showConfirmDialog(this,"Are you leaving me?","Don't Leave Me!",JOptionPane.YES_NO_OPTION) == 0){
                JOptionPane.showMessageDialog(this,"Goodbye","Farewell",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        
        //Settings
        
        if(event.getSource() == settings.plain || event.getSource() == settings.bold || event.getSource() == settings.italic || 
                event.getSource() == settings.black || event.getSource() == settings.red || event.getSource() == settings.green || event.getSource() == settings.blue){
            settings.setFont(settings.fontTester);
        }
        
        if(event.getSource() == settings.face){
            settings.selectedFontFace = (String)settings.face.getSelectedItem();
            settings.setFont(settings.fontTester);
        }
        
        if(event.getSource() == settings.save){
            settings.setFont(chat.chatBox);
            settings.setVisible(false);
            if(lastMain){
                lastMain = false;
                menu.setVisible(true);
            }
            else
                chat.setVisible(true);
        }
        
        if(event.getSource() == settings.cancel){
            settings.setVisible(false);
            if(lastMain){
                lastMain = false;
                menu.setVisible(true);
            }
            else
                chat.setVisible(true);
        }
        
        if(event.getSource() == settings.restrict){
            JPanel inputPassword = new JPanel();
            JPasswordField pass = new JPasswordField(15);
            inputPassword.add(new JLabel("Enter Password: "));
            inputPassword.add(pass);
            String[] optionPassword = {"Okay", "Cancel"};
            if(JOptionPane.showOptionDialog(null,inputPassword,"Restricted",JOptionPane.NO_OPTION,JOptionPane.WARNING_MESSAGE,null,optionPassword,optionPassword[0]) == 0){
                if(new String(pass.getPassword()).equals("12252015")){
                    JOptionPane.showMessageDialog(this,"Access Granted","Restricted",JOptionPane.WARNING_MESSAGE);
                    settings.setVisible(false);
                    lock.setVisible(true);
                }
                else
                    JOptionPane.showMessageDialog(this,"Access Denied","Restricted",JOptionPane.WARNING_MESSAGE);
            }
        }
        
        //Chat
        
        if(event.getSource() == chat.send){
            if(!(chat.msgBox.getText().equals(""))){
                chat.msg = chat.chatBox.getText();
                if(file.QA.containsKey(chat.msgBox.getText().toLowerCase()))
                    chat.chatBox.setText(chat.msg + " You: " + chat.msgBox.getText() + "\n" + " SimSimi: " + file.QA.get(chat.msgBox.getText().toLowerCase()) + "\n");
                else
                    chat.chatBox.setText(chat.msg + " You: " + chat.msgBox.getText() + "\n SimSimi: I don't know what to say!" + "\n");
                chat.msgBox.setText("");
            }
        }
        
        if(event.getSource() == chat.teachMe){
            teach.total.setText("" + file.QA.size());
            chat.setVisible(false);
            teach.setVisible(true);
        }
        
        if(event.getSource() == chat.settings){
            chat.setVisible(false);
            settings.setVisible(true);
        }
        
        if(event.getSource() == chat.exit){
            if(JOptionPane.showConfirmDialog(this,"Are you leaving me?","Don't Leave Me!",JOptionPane.YES_NO_OPTION) == 0){
                JOptionPane.showMessageDialog(this,"Goodbye","Farewell",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        
        if(event.getSource() == chat.back){
            chat.setVisible(false);
            menu.setVisible(true);
        }
        
        if(event.getSource() == chat.clear){
            chat.msg = "";
            chat.chatBox.setText("");
        }
        
        //TeachMe
        
        if(event.getSource() == teach.save){
            if(teach.question.getText().equals("") || teach.answer.getText().equals("")){
                if(teach.question.getText().equals("") && teach.answer.getText().equals(""))
                    JOptionPane.showMessageDialog(this, "Teach me what?", "Teach Me", JOptionPane.ERROR_MESSAGE);
                else{
                    if(teach.question.getText().equals(""))
                        JOptionPane.showMessageDialog(this, "What are you asking again?", "No Question", JOptionPane.ERROR_MESSAGE);
                    else if(teach.answer.getText().equals(""))
                        JOptionPane.showMessageDialog(this, "What's the answer?", "No Answer", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                if(file.QA.containsKey(teach.question.getText().toLowerCase())){
                    JOptionPane.showMessageDialog(this, "I know this already! Teach me something else", "Teach Me", JOptionPane.ERROR_MESSAGE);
                    teach.question.setText("");
                    teach.answer.setText("");
                }
                else{
                    file.QA.put(teach.question.getText().toLowerCase(), teach.answer.getText());
                    JOptionPane.showMessageDialog(this, "Thank you for teaching me!", "Teach Me", JOptionPane.INFORMATION_MESSAGE);
                    file.save();
                    teach.total.setText("" + file.QA.size());
                    if(JOptionPane.showConfirmDialog(this, "Do you still want to teach me something else?", "Teach Me More", JOptionPane.YES_NO_OPTION) == 0){
                        teach.question.setText("");
                        teach.answer.setText("");
                    }
                    else{
                        teach.question.setText("");
                        teach.answer.setText("");
                        teach.setVisible(false);
                        if(lastMain){
                            lastMain = false;
                            menu.setVisible(true);
                        }
                        else
                            chat.setVisible(true);
                    }
                }
            }
        }
        
        if(event.getSource() == teach.clear){
            teach.question.setText("");
            teach.answer.setText("");
        }
        
        if(event.getSource() == teach.back){
            teach.setVisible(false);
            if(lastMain){
                lastMain = false;
                menu.setVisible(true);
            }
            else
                chat.setVisible(true);
        }
        
        //Locked
        
        if(event.getSource() == lock.delete){
            lock.keyDelete = JOptionPane.showInputDialog(this,"Enter key to be deleted: ", "Delete", JOptionPane.QUESTION_MESSAGE);
            if(!(lock.keyDelete == null)){
                if(file.QA.containsKey(lock.keyDelete.toLowerCase())){
                    file.QA.remove(lock.keyDelete.toLowerCase());
                    JOptionPane.showMessageDialog(this, "Key successfully deleted!", "Delete Suceess", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                    JOptionPane.showMessageDialog(this, "Key doesn't exists!", "Delete Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(event.getSource() == lock.clear){
            if(JOptionPane.showConfirmDialog(this,"Are you sure you want to clear your database?","Clear All",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE) == 0)
                if(JOptionPane.showConfirmDialog(this,"This process cannot be undone.\nAre you sure you want to continue?","Clear All",JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE) == 0){
                    file.QA.clear();
                    file.save();
                    JOptionPane.showMessageDialog(this, "Database successfully cleared", "Database Purged", JOptionPane.INFORMATION_MESSAGE);
                }
        }
        
        if(event.getSource() == lock.back){
            lock.setVisible(false);
            settings.setVisible(true);
        }
    }
    
    //Settings
    
    public void stateChanged(ChangeEvent event){
        if(event.getSource() == settings.size){
            settings.fontSize = (int)settings.size.getValue();
            settings.setFont(settings.fontTester);
        }
    }
    
    //Chat
    
    public void keyPressed(KeyEvent event){
        if(event.getKeyCode() == KeyEvent.VK_ENTER){
            if(!(chat.msgBox.getText().equals(""))){
                chat.msg = chat.chatBox.getText();
                if(file.QA.containsKey(chat.msgBox.getText().toLowerCase()))
                    chat.chatBox.setText(chat.msg + " You: " + chat.msgBox.getText() + "\n" + " SimSimi: " + file.QA.get(chat.msgBox.getText().toLowerCase()) + "\n");
                else
                    chat.chatBox.setText(chat.msg + " You: " + chat.msgBox.getText() + "\n SimSimi: I don't know what to say!" + "\n");
                chat.msgBox.setText("");
            }
        }
    }
    
    public void keyReleased(KeyEvent event){
        
    }
    
    public void keyTyped(KeyEvent event){
        
    }
}
