import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Room implements Drawable {

    //Fields variables 
    private Point pos;
    private Room exitNorth;
    private Room exitEast;
    private Room exitSouth;
    private Room exitWest;

    public static final int SIZE = 50;

    public Room(){
        pos = new Point();
        pos.x = 10;
        pos.y = 10;

        exitNorth = null;
        exitEast = null;
        exitSouth = null;
        exitWest = null;
    }

    public Room(int x, int y){
        this();
        
        pos = new Point(x, y);
    }


    //METHODS

    public Point getPosition(){
        return pos;
    }

    //Set exits
    public void setNorthExit(Room r){
        exitNorth = r;
        r.exitSouth = this;
    }

    public void setEastExit(Room r){
        exitEast = r;
        r.exitWest = this;
    }

    public void setSouthExit(Room r){
        exitSouth = r;
        r.exitNorth = this;
    }

    public void setWestExit(Room r){
        exitWest = r;
        r.exitEast = this;
    }

    //Checking exits in rooms
    public boolean hasNorthExit(){
        if(exitNorth == null){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean hasSouthExit(){
        if(exitSouth == null){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean hasEastExit(){
        if(exitEast == null){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean hasWestExit(){
        if(exitWest == null){
            return false;
        }
        else {
            return true;
        }
    }

    //Getters for exits
    public Room getExitNorth(){
        return exitNorth;
    }

    public Room getExitSouth(){
        return exitSouth;
    }

    public Room getExitEast(){
        return exitEast;
    }

    public Room getExitWest(){
        return exitWest;
    }


    //Drawing the rooms
    @Override
    public void draw(Graphics g){        
        g.setColor(Color.BLACK);

        if(exitNorth != null){
            g.drawLine(pos.x, pos.y, pos.x+20, pos.y);
            g.drawLine(pos.x+20, pos.y, pos.x+20, pos.y-10);
            g.drawLine(pos.x+30, pos.y, pos.x+30, pos.y-10);
            g.drawLine(pos.x+30, pos.y, pos.x+SIZE, pos.y);
        }
        else {
            g.drawLine(pos.x, pos.y, pos.x+SIZE, pos.y);
        }


        if(exitSouth != null){
            g.drawLine(pos.x+SIZE, pos.y+SIZE, pos.x+30, pos.y+SIZE);
            g.drawLine(pos.x+20, pos.y+SIZE, pos.x, pos.y+SIZE);
        }
        else {
            g.drawLine(pos.x+SIZE, pos.y+SIZE, pos.x, pos.y+SIZE);
        }


        if(exitEast != null){
            g.drawLine(pos.x+SIZE, pos.y, pos.x+SIZE, pos.y+20);
            g.drawLine(pos.x+SIZE, pos.y+20, pos.x+60, pos.y+20);

            g.drawLine(pos.x+SIZE, pos.y+30, pos.x+60, pos.y+30);
            g.drawLine(pos.x+SIZE, pos.y+30, pos.x+SIZE, pos.y+SIZE);
        }
        else {
            g.drawLine(pos.x+SIZE, pos.y, pos.x+SIZE, pos.y+SIZE);
        }


        if(exitWest != null){
            g.drawLine(pos.x, pos.y+SIZE, pos.x, pos.y+30);
            g.drawLine(pos.x, pos.y+20, pos.x, pos.y);
        }
        else {
            g.drawLine(pos.x, pos.y+SIZE, pos.x, pos.y);
        }
    }   
}

