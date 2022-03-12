import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Stone extends Sprite {
    public Stone(){
        super();
        image = new ImageIcon("stone.png");
    }

    @Override
    public void draw(Graphics g){
        if(currentRoom != null && image != null){
            image.paintIcon(null, g, currentRoom.getPosition().x+9, currentRoom.getPosition().y+9);
        }
    }
    
}
