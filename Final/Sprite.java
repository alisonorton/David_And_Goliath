import java.awt.Graphics;
import javax.swing.ImageIcon;

public abstract class Sprite implements Drawable{
    protected Room currentRoom;
    protected ImageIcon image;

    public Sprite(){
        currentRoom = null;
        image = null;
    }

    //Methods
    
    public void setCurrentRoom(Room r){
        currentRoom = r;
    }

    public Room getCurrentRoom(){
        return currentRoom;
    }


    //Moving characters to different rooms
    public void moveSouth(){
        if(currentRoom.hasSouthExit()){
            setCurrentRoom(currentRoom.getExitSouth());
        }
    }

    public void moveNorth(){
        if(currentRoom.hasNorthExit()){
            setCurrentRoom(currentRoom.getExitNorth());
        }
    }

    public void moveEast(){
        if(currentRoom.hasEastExit()){
            setCurrentRoom(currentRoom.getExitEast());
        }
    }

    public void moveWest(){
        if(currentRoom.hasWestExit()){
            setCurrentRoom(currentRoom.getExitWest());
        }
    }


    //Draw method
    @Override
    public void draw(Graphics g){
        if(currentRoom != null && image != null){
            image.paintIcon(null, g, currentRoom.getPosition().x+7, currentRoom.getPosition().y+6);
        }
    }
}