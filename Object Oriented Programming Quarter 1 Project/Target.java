import java.awt.Color;
import java.awt.Graphics;

public class Target {
    private int x;
    private int y;
    private int width;
    private int height;

    public Target(int height, int width, int x, int y) {
        this.height = height;
        this.width = width;
        this.x = x;
        this.y = y;
    }

    public boolean targetIsHit(Ball ball1) {
        return ball1.getX()>=x && ball1.getY()<=x+width && ball1.getY()>=y && ball1.getY()<=y+height;
    }

    public void draw(Graphics draw1) {
        draw1.setColor(Color.RED);
        draw1.fillRect(x, y, width, height);
    }
}
