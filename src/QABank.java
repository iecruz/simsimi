import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class QABank extends JFrame implements ActionListener {
    JButton add, delete, view;
    
    static HashMap<String,String> QA = null;
    
    static String question, answer;
    
    public QABank(){
        super("QABank");
        
        setLayout(new GridLayout(3,1));
        
        add = new JButton("Add");
        view = new JButton("View");
        delete = new JButton("Delete");
        
        add(add);
        add(view);
        add(delete);
        
        add.addActionListener(QABank.this);
        view.addActionListener(QABank.this);
        delete.addActionListener(QABank.this);
    }
    
    public void load(){
        try{
            FileInputStream fileIn = new FileInputStream("QABank.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            QA = (HashMap)objectIn.readObject();
            objectIn.close();
            fileIn.close();
        }
        catch(FileNotFoundException err){
            System.out.println("Creating File");
            QA = new HashMap<String,String>();
            try{
                FileOutputStream fileOut = new FileOutputStream("QABank.txt");
                fileOut.close();
            }
            catch(FileNotFoundException e){e.printStackTrace();}
            catch(IOException e){e.printStackTrace();}
        }
        catch(IOException err){
            System.err.println("I/O failed");
        }
        catch(ClassNotFoundException err){
            System.err.println("Class Not Found");;
        }
    }
    
    public void save(){
        try{
            FileOutputStream fileOut = new FileOutputStream("QABank.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(QA);
            objectOut.close();
            fileOut.close();
        }
        catch(FileNotFoundException err){
            System.err.println("File Not Found");
        }
        catch(IOException err){
            System.err.println("I/O failed");
        }
    }
    
    public static void main(String args[]){
        QABank frame = new QABank();
        frame.setSize(200,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(800,400);
        frame.setVisible(true);
        frame.load();
    }
    
    public void actionPerformed(ActionEvent event){
        if(event.getSource() == add){
            question = JOptionPane.showInputDialog(this, "Enter Question: ", "Add", JOptionPane.QUESTION_MESSAGE);
            if(QA.containsKey(question.toLowerCase()))
                JOptionPane.showMessageDialog(this, "Question already exists!", "ERROR", JOptionPane.ERROR_MESSAGE);
            else{
                answer = JOptionPane.showInputDialog(this, "Enter Answer: ", "Add", JOptionPane.QUESTION_MESSAGE);
                QA.put(question.toLowerCase(),answer);
                save();
            }
        }
        if(event.getSource() == view){
            System.out.println(QA);
        }
        if(event.getSource() == delete){
            question = JOptionPane.showInputDialog(this, "Enter Question to be Deleted: ", "Delete", JOptionPane.ERROR_MESSAGE);
            QA.remove(question.toLowerCase());
        }
    }
}