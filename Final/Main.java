import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Main extends JPanel implements KeyListener {

    //Field variables
    Room[] rooms = new Room[25];
    int index = 0;
    David david;
    Goliath goliath;
    Stone[] stones = new Stone[5];
    

    ArrayList<Drawable> canDraw = new ArrayList<>();

    //Constructor
    public Main(){

        int x = 10;
        int y = 10;

        addKeyListener(this);

        //Parsing through rooms to instantiate
        //and assign coordinates.
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                rooms[index] = new Room(x, y);
                canDraw.add(rooms[index]);
                x += 60;
                index++;
            }
            x = 10;
            y += 60;
        }

        //Setting exits
        setExits();

        //Instantiating characters
        david = new David();
        david.setCurrentRoom(rooms[12]);
        canDraw.add(david);

        goliath = new Goliath();
        goliath.setCurrentRoom(rooms[2]);
        canDraw.add(goliath);

        //Instantiating stones
        for(int i = 0; i < 5; i++){
            stones[i] = new Stone();
            canDraw.add(stones[i]);
        }

        stones[0].setCurrentRoom(rooms[4]);
        stones[1].setCurrentRoom(rooms[6]);
        stones[2].setCurrentRoom(rooms[14]);
        stones[3].setCurrentRoom(rooms[16]);
        stones[4].setCurrentRoom(rooms[19]);

    }

    //Setting the individual exits for the rooms
    public void setExits(){
        rooms[0].setSouthExit(rooms[5]);
        rooms[0].setEastExit(rooms[1]);

        rooms[1].setSouthExit(rooms[6]);

        rooms[2].setSouthExit(rooms[7]);
        rooms[2].setEastExit(rooms[3]);

        rooms[3].setSouthExit(rooms[8]);

        rooms[4].setSouthExit(rooms[9]);

        rooms[5].setSouthExit(rooms[10]);

        rooms[7].setSouthExit(rooms[12]);

        rooms[8].setEastExit(rooms[9]);
        rooms[8].setSouthExit(rooms[13]);

        rooms[9].setSouthExit(rooms[14]);

        rooms[10].setEastExit(rooms[11]);

        rooms[11].setEastExit(rooms[12]);

        rooms[12].setSouthExit(rooms[17]);
        rooms[12].setEastExit(rooms[13]);

        rooms[13].setSouthExit(rooms[18]);

        rooms[15].setEastExit(rooms[16]);
        rooms[15].setSouthExit(rooms[20]);

        rooms[17].setEastExit(rooms[18]);
        rooms[17].setSouthExit(rooms[22]);

        rooms[18].setSouthExit(rooms[23]);

        rooms[19].setSouthExit(rooms[24]);

        rooms[20].setEastExit(rooms[21]);

        rooms[21].setEastExit(rooms[22]);
 
        rooms[22].setEastExit(rooms[23]);

        rooms[23].setEastExit(rooms[24]);
        
    }

    @Override
    public void paintComponent(Graphics g){
        requestFocusInWindow();

        g.setColor(new Color(125, 245, 157));
        g.fillRect(0, 0, getWidth(), getHeight());

        for(int i = 0; i < canDraw.size(); i++){
            canDraw.get(i).draw(g);
        }
    }
 
    /*****************************************************
     * KeyListener Methods
     *****************************************************/

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int k = e.getKeyCode();

        //Move David
        if (k == KeyEvent.VK_UP){
            david.moveNorth();
        }
        if (k == KeyEvent.VK_DOWN){
            david.moveSouth();
        }
        if (k == KeyEvent.VK_RIGHT){
            david.moveEast();
        }
        if (k == KeyEvent.VK_LEFT){
            david.moveWest();
        }

        //Move Goliath
        if(k == KeyEvent.VK_W){
            goliath.moveNorth();
        }
        if(k == KeyEvent.VK_S){
            goliath.moveSouth();
        }
        if(k == KeyEvent.VK_D){
            goliath.moveEast();
        }
        if(k == KeyEvent.VK_A){
            goliath.moveWest();
        }

        for(int i = 0; i < stones.length; i++){
            if(stones[i].getCurrentRoom() == david.getCurrentRoom()){
                david.pickUpStone();
                stones[i].setCurrentRoom(null);
            }
        }

        if(david.getCurrentRoom() == goliath.getCurrentRoom()){
            if(david.isArmed()){
                goliath.setCurrentRoom(null);
                JOptionPane.showMessageDialog(null, "Congratulations, you defeated Goliath!");
                reset();
            }
            else{
                JOptionPane.showMessageDialog(null, "Oh no, Goliath got you!  Try again, David.");
                reset();
            }
        }


        repaint();
    }

    //Reseting the game for the user to play again
    private void reset(){
        david.reset();
        david.setCurrentRoom(rooms[12]);
        goliath.setCurrentRoom(rooms[2]);

        stones[0].setCurrentRoom(rooms[4]);
        stones[1].setCurrentRoom(rooms[6]);
        stones[2].setCurrentRoom(rooms[14]);
        stones[3].setCurrentRoom(rooms[16]);
        stones[4].setCurrentRoom(rooms[19]);

    }

    @Override
    public void keyReleased(KeyEvent e) {}
    


    public static void main(String[] args){
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(400, 400);
        window.setContentPane(new Main());
        window.setVisible(true);
    }
}