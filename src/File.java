import java.io.*;
import java.util.*;

public class File {
    
    static HashMap QA = null;
    
    public void load(){
        try{
            FileInputStream fileIn = new FileInputStream("QABank.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            QA = (HashMap)objectIn.readObject();
            objectIn.close();
            fileIn.close();
        }
        catch(FileNotFoundException err){
            System.out.println("Creating New File...");
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
}
