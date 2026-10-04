
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class GamePanel extends JPanel{
    private static final int groundYValue = 500;
    private static final int wallXValue = 700;
    public GamePanel()
    {
        setPreferredSize(new Dimension(800,500));
        
        JSlider speedSlider = new JSlider(100,1000);
        JSlider angleSlider = new JSlider(0,180);
        JButton launchButton = new JButton("Launch");
        launchButton.addActionListener(this);
        add(launchButton);

        add(new JLabel("Speed"));
        add(speedSlider);

        add(new JLabel("Angle"));

        add(angleSlider);
        Timer timer = new Timer(16, this);
        timer.start();
        
    }

    public void paintComponent(Graphics object) {
        super.paintComponent(object); // super used to override
        object.setColor(Color.green);
        object.fillRect(0, groundYValue, getWidth(), 50);
        
        object.fillRect(0,wallXValue, 50, groundYValue);

        object.setColor(Color.RED);
        int radius1 = ball.getRadius();
    }

    public void actionPerformed(ActionEvent e) {
        ball.update(0.016);
        repaint();

        double xPlusRadius = ball.getX() + ball.getRadius();
        double yPlusRadius = ball.getY() + ball.getRadius();

        if (xPlusRadius>=wallXValue) {
            ball.bounceOffWall(wallXValue);
        }
        
        if (yPlusRadius>=groundYValue) {
            ball.bounceOffGround(groundYValue);
        }
    }
}