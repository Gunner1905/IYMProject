import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class Frame extends javax.swing.JFrame {
    
	static final long serialVersionUID = 1L;
    public String connections[][] = new String[1000][50];
    
    public Frame() {
        initComponents();
    }

    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        Arama = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Link = new javax.swing.JTextField();
        Aranacak = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel2.setFont(new Font("Arial", Font.PLAIN, 12));
        jScrollPane2 = new javax.swing.JScrollPane();
        Output = new javax.swing.JTextArea();
        Shbutton = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Arama.setText("Ara");
        Arama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AramaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12));
        jLabel1.setText("Dosyanın adını giriniz:");

        Link.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LinkActionPerformed(evt);
            }
        });

        Aranacak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AranacakActionPerformed(evt);
            }
        });

        jLabel2.setText("Aranacak kelimeyi giriniz:");

        Output.setColumns(20);
        Output.setRows(5);
        jScrollPane2.setViewportView(Output);

        Shbutton.setText("Shift Et");
        Shbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ShbuttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(0, 0, Short.MAX_VALUE)
        					.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(30)
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(Aranacak, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(jLabel1)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(Link, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(Shbutton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(Arama, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(0, 9, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Link, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Shbutton, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(Aranacak, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(Arama, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        getContentPane().setLayout(layout);

        pack();
    }

    public int Oku(String a){
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
       return i;
    }
    
    //doing some ranking stuff
    public void rank(int length,String key){
        int i,j,k=0,l=0;
        
        for(i=0;i<length;i++){
            for(j=0;j<length;j++){
                while(k<length){
                    if(connections[k][j]==null){
                        connections[k][j]=" ";
                    }
                    if(connections[k][j].equals(key)){
                        while(connections[k][l]!=null){
                           Output.setText(Output.getText()+" "+connections[k][l]);
                           l++;
                        }connections[k][j]="";
                         l=0;
                         Output.setText(Output.getText()+"\n");
                    }
                    k++;
                }
                k=0;
            }
        }
    }
  
public void Yazdir(String[][] connections){
    int i=0,j=0,k,length;
   
    while(connections[i][0]!=null){
        j=0;
        while(connections[i][j]!=null){
            j++;
        }length=j;

        for(k=0;k<length;k++){
            for(j=0;j<length;j++){
                Output.setText(Output.getText()+" "+connections[i][j]);
            }   Output.setText(Output.getText()+"\n");
            Shifter.shift(connections,i);
        }
        Output.setText(Output.getText()+"\n");
        i++;
    }
}
    
    private void AramaActionPerformed(java.awt.event.ActionEvent evt) {
        Output.setText("");
        String key=Aranacak.getText();
        String file=Link.getText();
        int length=Oku(file);
        rank(length,key);
    }

    private void LinkActionPerformed(java.awt.event.ActionEvent evt) {
       // TODO we can add sth here
    }

    private void AranacakActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO we can add sth here
    }

    private void ShbuttonActionPerformed(java.awt.event.ActionEvent evt) {
        Output.setText("");
        String file=Link.getText();
        connections = Reader.readFile(file);
        Yazdir(connections);
    }

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
        
    }

    private javax.swing.JButton Arama;
    private javax.swing.JTextField Aranacak;
    private javax.swing.JTextField Link;
    private javax.swing.JTextArea Output;
    private javax.swing.JButton Shbutton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
}
