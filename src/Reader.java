import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reader{
    public static String connections[][] = new String[1000][20];
    
    public static String[][] readFile(String a){
        BufferedReader br = null;
        String str;
        int i=0,j=0;
        
        try {
            File file = new File(a);
            br = new BufferedReader(new FileReader(file));
            
            while ((str = br.readLine()) != null){
                String[] requiredString = str.split(" ");
                
                for(j=0;j<requiredString.length;j++){
                    connections[i][j]=requiredString[j];
                }i++;
                
            }
            
        }catch (FileNotFoundException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }catch (IOException ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try{
                br.close();
            }catch (IOException ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
       return connections;
    }
    
   
 
    
}
