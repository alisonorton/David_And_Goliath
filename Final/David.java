import javax.swing.ImageIcon;

public class David extends Sprite {
    //Field variable
    private int numStones;

    public David(){
        super();
        image = new ImageIcon("david.png");
        numStones = 0;
    }

    //METHODS
    public void pickUpStone(){
        numStones++;
    }

    public boolean isArmed(){
        if(numStones == 5){
            return true;
        }
        else {
            return false;
        }
    }

    public void reset(){
        numStones = 0;
    }
}
