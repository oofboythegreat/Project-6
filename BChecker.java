import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class BChecker {

    File myFile = new File("Medium.txt");
    FileReader abdul = new FileReader();
    ArrayList<String> bad = FileReader.toStringArrayList("Medium.txt");
    
    static ArrayList<String> veryBad = FileReader.toStringArrayList("VeryBad.txt");
    
    ArrayList<String> good = FileReader.toStringArrayList("MildlyGood.txt");

    ArrayList<String> veryGood = FileReader.toStringArrayList("Great.txt");

    private JFrame frame;
    private JTextArea textArea;
    private JLabel counterLabel;
    String[] veryGoodWords = {"taiwan is not a country","tianmen square never happened"};
    String[] goodWords = {"happy", "whimsical", "ccp"};
    String[] badWords = {"67", "41"};
    String[] veryBadWords = {"taiwan is a country", "remember tianmen square"};

    
    public BChecker() throws IOException{
        frame = new JFrame("B Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel(new BorderLayout());
        textArea = new JTextArea();
        textArea.setSize(400,200);
        panel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        counterLabel = new JLabel("social credit: 500");
        panel.add(counterLabel, BorderLayout.SOUTH);

        frame.add(panel);

        // textArea.addKeyListener(new KeyAdapter() {
        //     @Override
        //     public void keyReleased(KeyEvent e) {

        //         // if (Character.toLowerCase(e.getKeyChar()) == 'b') {
        //         //     bCount++;
        //         //     counterLabel.setText("Number of 'b's: " + bCount);
        //         // }

        //         String currentText = textArea.getText();
                
        //         int bCount = 0;
        //         for(int i = 0; i < currentText.length(); i++) {
        //             if(currentText.substring(i,i+1).equals("b")) {
        //                 bCount++;
        //             }
        //         }
        //         counterLabel.setText("Number of 'b's: " + bCount);

        //     }
        // });
        
        textArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {

                // if (Character.toLowerCase(e.getKeyChar()) == 'b') {
                //     bCount++;
                //     counterLabel.setText("Number of 'b's: " + bCount);
                // }

                String currentText = textArea.getText();
                int g = 0;
                int r = 0;

                

                int citizenCounter = 500;
                for (String a:veryGood){
                    for(int i = 0; i < currentText.length() - a.length()+1; i++) {
                        if(currentText.substring(i, i+a.length()).equals(a)) {
                            citizenCounter += 300;
                           
                            if(g+200>255){
                                    r=0;
                                g=255;
                            }else{
                                 g+=200;
                                 
                                    r=0;
                                
                            }
                            
                            textArea.setForeground(new Color(r, g, 0));
                        }
                    }
                }
                for (String a:good){
                    for(int i = 0; i < currentText.length() - a.length()+1; i++) {
                        if(currentText.substring(i, i+a.length()).equals(a)) {
                            citizenCounter += 25;
                            
                            if(g+100>255){
                                r=0;
                                g=255;
                            }else{
                                g+= 100;
                                r=0;
                            }
                            
                            textArea.setForeground(new Color(r, g, 0));
                        }
                    }
                }
                for (String a:bad){
                    for(int i = 0; i < currentText.length() - a.length()+1; i++) {
                        if(currentText.substring(i, i+a.length()).equals(a)) {
                            citizenCounter -= 250;
                           
                            if(r+100>255){
                                r=255;
                                g=0;
                            }else{
                                r+=100;
                                g=0;
                            }
                            textArea.setForeground(new Color(r, g, 0));
                        }
                    }
                }
                for (String a:veryBad){
                    for(int i = 0; i < currentText.length() - a.length()+1; i++) {
                        if(currentText.substring(i, i+a.length()).equals(a)) {
                            citizenCounter -= 500;
                            
                            if(r+200>255){
                         
                                r=255;
                                g=0;
                            }else{
                                r+=200;
                                g=0;
                            }
                            textArea.setForeground(new Color(r, g, 67));
                        }
                    }
                }

                
                

                

                counterLabel.setText("social credit: " + citizenCounter);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
            System.out.println(veryBad);
        new BChecker();
    }
}