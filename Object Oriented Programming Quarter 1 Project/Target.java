import java.awt.Color;
import java.awt.Graphics;

public class Target {
    private double x;
    private double y;
    private double width;
    private double height;

    public boolean targetIsHit(Ball ball1) {
        if (ball1.getX()>=x && ball1.getX()<=x+width) {
            if (ball1.getY()>=y && ball1.getY()<=y+height){
                return true;
            }
        }
        else {
            return false;
        }
    }

    public void draw(Graphics draw1) {
        draw1.setColor(Color.RED);
        draw1.fillRect(x, y, width, height);
    }
}
