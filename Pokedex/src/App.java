import javax.swing.*;
import java.awt.event.*;

public class App {
    public static void main(String[] args) throws Exception {
        int boardWidth = 540;
        int boardHeight = 840;

        JFrame frame = new JFrame("Pokedex");
        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the pokedex panel and add it to the frame
        pokedex Pokedex = new pokedex();
        frame.add(Pokedex);
        frame.pack();
        Pokedex.requestFocus();
























        // Create a panel to hold the button and set a layout

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null); // Absolute positioning


        //rigth button
        JButton button = new JButton("Click me");
        button.setBounds(465, 665, 68, 63); // Set the position and size of the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pokedex.RightPaddle(); //function that gets called when clicked
            }
        });






     

        buttonPanel.add(button);

        //left button

        JButton button1 = new JButton("Click me");
        button1.setBounds(375, 665, 68, 63); // Set the position and size of the button
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Pokedex.leftPaddle(); 
            }
        });
        buttonPanel.add(button1);




        
        frame.add(buttonPanel); // Add the button panel to the frame































        Pokedex.scanfiles();
        
        frame.setVisible(true);


       

    }
}