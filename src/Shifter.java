public class Shifter {
    
  
    public static void shift(String[][] connections,int i){
        
        int j=0,length;
   
        while(connections[i][j]!=null){
            j++;
        }length=j;
        
            String temp=connections[i][0];
            for(j=0;j<length-1;j++){
                connections[i][j]=connections[i][j+1];
            }
            connections[i][j]=temp;
        
    }   
}