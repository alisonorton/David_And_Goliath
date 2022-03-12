

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * This is the "main" class of the program.
 * This is where all the other objects are created, and where
 * all the rendering (drawing) is initiated.
 *
 */
public class Main extends JPanel {

    private ArrayList<Room> rooms;

    /**
     * the constructor is in charge of initializing the fields of the program.
     * In this case, this basically means that the constructor creates all the
     * rooms.
     */
    public Main() {
        rooms = new ArrayList<Room>();

        //create all the room objects at their correct x,y locations
        Room r1 = new Room(10, 10);
        Room r2 = new Room(70, 10);
        Room r3 = new Room(130, 10);
        Room r4 = new Room(190, 10);
        Room r5 = new Room(10, 70);
        Room r6 = new Room(70, 70);
        Room r7 = new Room(130, 70);
        Room r8 = new Room(190, 70);
        Room r9 = new Room(10, 130);
        Room r10 = new Room(70, 130);
        Room r11 = new Room(130, 130);
        Room r12 = new Room(190, 130);
        Room r13 = new Room(10, 190);
        Room r14 = new Room(70, 190);
        Room r15 = new Room(130, 190);
        Room r16 = new Room(190, 190);

        //add all the rooms to the arraylist
        rooms.add(r1);
        rooms.add(r2);
        rooms.add(r3);
        rooms.add(r4);
        rooms.add(r5);
        rooms.add(r6);
        rooms.add(r7);
        rooms.add(r8);
        rooms.add(r9);
        rooms.add(r10);
        rooms.add(r11);
        rooms.add(r12);
        rooms.add(r13);
        rooms.add(r14);
        rooms.add(r15);
        rooms.add(r16);

        //create doorways between all the rooms
        r1.setEastExit(r2);
        r2.setEastExit(r3);
        r2.setSouthExit(r6);
        r3.setEastExit(r4);
        r5.setEastExit(r6);
        r6.setEastExit(r7);
        r8.setSouthExit(r12);
        r9.setEastExit(r10);
        r9.setSouthExit(r13);
        r10.setEastExit(r11);
        r10.setSouthExit(r14);
        r11.setNorthExit(r7);
        r12.setSouthExit(r16);
        r14.setEastExit(r15);
        r15.setEastExit(r16);
    }

    /**
     * This method initiates all the drawing for the game.
     */
    @Override
    public void paintComponent(Graphics g) {
        requestFocusInWindow();

        //fill in the background color
        g.setColor(new Color(200, 255, 200));
        g.fillRect(0, 0, getWidth(), getWidth());

        for (var d : rooms) {
            d.draw(g);
        }
    }

    //Every Java program starts in the "main" method
    public static void main(String[] args) {
        var window = new JFrame("Smackdown: David vs Goliath");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(300,300);
        window.setContentPane(new Main());
        window.setVisible(true);
    }

}
