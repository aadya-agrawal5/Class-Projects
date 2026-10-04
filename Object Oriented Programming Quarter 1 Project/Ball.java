
/**
 * Name: Aadya Agrawal
 * Course: Object Oriented Programming
 * Instructor: Dr. Ashwin Mohan, IMSA
 * Title: Quarter 1 Final Project, Fall 2026, Junior Year
 */
public class Ball
{
    public double x; // x position
    public double y; // y position
    public double vx; // velocity in the x direction
    public double vy; // velocity in the y direction
    public double radius = 10;
    public static final double GRAVITY = 600;

    public Ball(double x, double y) // these are parameters of the constructor, so unique values are assigned each time a new object is instantiated
    {
        radius = 10;
        this.x = x;
        this.y = y;
    }

    public void launch(double speed, double angleDegrees) // run when launch button is pressed; this method will need to be called in another method
    {
        double angleRadians = Math.toRadians(angleDegrees); // Java requires radians to calculate sine and cosine
        vx = speed * Math.cos(angleRadians);
        vx = speed * Math.sin(angleRadians);
    }
    
    public void update(double time)
    {
        x = x + vx*time;
        y = y + vy*time;
    }
    
    public void bounceOffGround()
    {
        vy = -vy * 0.8;
    }
    
    public void bounceOffWall()
    {
        vx = -vx * 0.8;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getRadius()
    {
        return radius;
    }
}