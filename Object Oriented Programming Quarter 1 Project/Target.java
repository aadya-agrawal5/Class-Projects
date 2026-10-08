import java.awt.Color;
import java.awt.Graphics;

public class Target {
    private int x;
    private int y;
    private int width;
    private int height;

    public Target(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public boolean targetIsHit(Ball ball1) {
        return ball1.getX()>=x && ball1.getX()<=x+width && ball1.getY()>=y && ball1.getY()<=y+height;
    }

    public void draw(Graphics draw1) {
        draw1.setColor(Color.RED);
        draw1.fillRect(x, y, width, height);
    }
}
