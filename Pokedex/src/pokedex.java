import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;



public class pokedex extends JPanel implements ActionListener, KeyListener {

    private String[] defaultValue; //this is the value that will be displayed when you are looking at pokemon
    private int position;// this will act as our index when we are looking throughtout the list, so we can go back on forth
    private int index;
    
    private String[] stringArray;
    private ArrayList<Image> imageList;
    int boardWidth = 540;
    int boardHeight = 840;
    Timer gameLoop;
    
    //images
    //background
    Image backgroundImg;
    //balbasour family
    Image balbalImg;
    Image Balbamid;
    Image bigbalba;
    //Charmander
    Image Charmander;
    Image charmeleon;
    Image Charzard;

    
   
    pokedex() {
        imageList = new ArrayList<>();
        setPreferredSize(new Dimension(boardWidth, boardHeight));
        // setBackground(Color.blue);
        setFocusable(true);
        addKeyListener(this);
        


        backgroundImg = new ImageIcon(getClass().getResource("./PokedexImage.jpg")).getImage();


        balbalImg = new ImageIcon(getClass().getResource("./balba.PNG")).getImage();
        Balbamid = new ImageIcon(getClass().getResource("./balbamid.PNG")).getImage();
        bigbalba = new ImageIcon(getClass().getResource("./bigbalba.PNG")).getImage();

        Charmander = new ImageIcon(getClass().getResource("./Charmander.png")).getImage();
        charmeleon = new ImageIcon(getClass().getResource("./Charmealean.png")).getImage();
        Charzard = new ImageIcon(getClass().getResource("./Charzard.png")).getImage();


        imageList.add(balbalImg);
        imageList.add(Balbamid);
        imageList.add(bigbalba);
        imageList.add(Charmander);
        imageList.add(charmeleon);
        imageList.add(Charzard);



        gameLoop = new Timer(1000/60, this); //how long it takes to start timer, milliseconds gone between frames 
        gameLoop.start();
        
    }


    public void scanfiles() {
        // Creating the fileReader Object 
        reading fileReader = new reading("Pokedex\\src\\pokemondata.txt");  
        stringArray = fileReader.toStringArray();  // Store the array in the instance variable
        System.out.println(stringArray[position]);
    }

    



    

    //allows us to draw
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    //actually draws the image on screen
    public void draw(Graphics g) {
        // Background
        g.drawImage(backgroundImg, 0, 0, this.boardWidth, this.boardHeight, null);

        // Set font and draw string
        g.setFont(new Font("Arial", Font.PLAIN, 16));
        if (stringArray != null && position < stringArray.length) {
            //imageList
            g.drawImage(imageList.get(index), 120, 260, 300, 300, null);
            g.drawString(stringArray[position], 134, 680);
            g.drawString(stringArray[position +2], 134, 700);
        } else {
            g.drawString("No data to display", 10, 35);  // Optional: display message if data is missing
        }
    }

    public void RightPaddle(){
        System.out.println("hi");
        index +=1;
        position+=3;
        if (position <=-1){
            position = 0;//we dont want to go past 0
        }

        if (index <=-1){
            index = 0;//we dont want to go past 0
        }
        




    }


    public void leftPaddle(){
        index -=1;
        System.out.print("left paddle");
        position-=3;
        if (position <=-1){
            position = 0;//we dont want to go past 0
        }

        if (index <=-1){
            index = 0;//we dont want to go past 0
        }
        
    }


    


    @Override
    public void actionPerformed(ActionEvent e) { //called every x milliseconds by gameLoop timer
        
        repaint();
       
      
    
    }




    @Override
    public void keyPressed(KeyEvent e) {}

    //not needed
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

}

