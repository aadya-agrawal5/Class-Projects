/**
 * This class represents a simple picture. You can draw the picture using
 * the draw method. But wait, there's more: being an electronic picture, it
 * can be changed. You can set it to black-and-white display and back to
 * colors (only after it's been drawn, of course).
 *
 * This class was written as an early example for teaching Java with BlueJ.
 * 
 * @author  Michael Kšlling and David J. Barnes
 * @version 7.0
 */
// Aadya Agrawal 08/25/2026 - This exercise involved adding objects and creating your own method to create a sunrise scene.
public class Picture
{
    private Square sky;
    private Square wall;
    private Square window;
    private Triangle roof;
    private Circle moon;
    private Circle star;
    private Circle star1;
    private Circle star2;
    private Circle star3;
    private Circle sun;
    private Square grass;
    private boolean drawn;

    /**
     * Constructor for objects of class Picture
     */
    public Picture()
    {
        wall = new Square();
        window = new Square();
        roof = new Triangle();  
        moon = new Circle();
        sky = new Square();
        star = new Circle();
        star1 = new Circle();
        star2 = new Circle();
        star3 = new Circle();
        sun = new Circle();
        grass = new Square();
        drawn = false;
    }

    /**
     * Draw this picture.
     */
    public void draw()
    {
        if(!drawn) {
            sky.changeSize(1500);
            sky.moveHorizontal(-500);
            sky.moveVertical(-500);
            sky.changeColor("black");
            sky.makeVisible();            
            
            wall.changeColor("blue");
            wall.moveHorizontal(-140);
            wall.moveVertical(20);
            wall.changeSize(140);
            wall.makeVisible();
            
            window.changeColor("white");
            window.moveHorizontal(-120);
            window.moveVertical(40);
            window.changeSize(40);
            window.makeVisible();
    
            roof.changeColor("green");
            roof.changeSize(60, 180);
            roof.moveHorizontal(20);
            roof.moveVertical(-60);
            roof.makeVisible();
    
            moon.changeColor("white");
            moon.moveHorizontal(100);
            moon.moveVertical(-40);
            moon.changeSize(80);
            moon.makeVisible();
            
            /*sun.changeColor("yellow");
            sun.changeSize(80);
            sun.moveHorizonta
            /*sun.slowMoveVertical(60);*/
            
            star.changeColor("white");
            star.moveHorizontal(100);
            star.moveVertical(-60);
            star.changeSize(15);
            star.makeVisible();
            
            star1.changeColor("white");
            star1.moveHorizontal(-50);
            star1.moveVertical(-70);
            star1.changeSize(10);
            star1.makeVisible();
            
            star2.changeColor("white");
            star2.moveHorizontal(180);
            star2.moveVertical(-80);
            star2.changeSize(8);
            star2.makeVisible();
            
            star3.changeColor("white");
            star3.moveHorizontal(70);
            star3.moveVertical(-80);
            star3.changeSize(9);
            star3.makeVisible();
            drawn = true;
        }
    }

    /**
     * Change this picture to black/white display
     */
    public void setBlackAndWhite()
    {
        wall.changeColor("black");
        window.changeColor("white");
        roof.changeColor("black");
        moon.changeColor("white");
    }

    /**
     * Change this picture to use color display
     */
    public void setColor()
    {
        sky.changeColor("black");
        wall.changeColor("blue");
        window.changeColor("white");
        roof.changeColor("green");
        moon.changeColor("white");

    }
    
    public void sunrise()
    {
        moon.slowMoveVertical(20);
        moon.changeColor("gray");
        moon.slowMoveVertical(20);
        
        star.makeInvisible();
        star1.makeInvisible();
        star2.makeInvisible();
        star3.makeInvisible();
        
        sky.changeColor("white");
        
        wall.changeColor("red");
        wall.makeVisible();
        
        roof.changeColor("green");
        roof.makeVisible();
        
        window.changeColor("black");
        window.makeVisible();
        
        sun.changeColor("yellow");
        sun.changeSize(80);
        sun.moveHorizontal(-10);
        sun.moveVertical(-80);
        sun.makeVisible();
        sun.slowMoveVertical(-50);
        
        grass.changeColor("green");
        grass.changeSize(3000);
        grass.moveVertical(160);
        grass.moveHorizontal(-500);
        grass.makeVisible();
    }
}
