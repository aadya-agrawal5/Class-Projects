
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{
    private static final int groundYValue = 450;
    private static final int wallXValue = 700;
    private static final double startingX = 100;
    private static final double startingY = 440;
    private boolean inFlight;
    private double lastKnownSpeed;
    private double lastKnownAngle;
    private int groundBounces;
    private int hits;

    private int shots;
    private String message = "";

    private Ball ball;
    private Target target;
    private JSlider speedSlider;
    private JSlider angleSlider;
    private JButton launchButton;
    public GamePanel()
    {
        setPreferredSize(new Dimension(800,500));
        setBackground(new Color(200, 230, 255));
        
        speedSlider = new JSlider(100,1000,700);
        angleSlider = new JSlider(5,80,45);
        ball = new Ball(startingX,startingY);
        target = new Target(680,250,30,80);
        launchButton = new JButton("Launch");
        launchButton.addActionListener(this);
        add(launchButton);

        add(new JLabel("Speed"));
        add(speedSlider);
        speedSlider.setMajorTickSpacing(300);
        speedSlider.setPaintLabels(true);
        angleSlider.setPaintLabels(true);

        add(new JLabel("Angle"));

        add(angleSlider);
        Timer timer = new Timer(16, this);
        timer.start();
        angleSlider.setMajorTickSpacing(15);
        angleSlider.setPaintLabels(inFlight);
        
    }

    private void updateGame() {
        if (inFlight) {
            ball.update(0.016);
            double xPlusRadius = ball.getX() + ball.getRadius();
            double yPlusRadius = ball.getY() + ball.getRadius();
            if (xPlusRadius>=wallXValue) {
                ball.bounceOffWall(wallXValue);
            }
            if (yPlusRadius>=groundYValue) {
                ball.bounceOffGround(groundYValue);
                groundBounces = groundBounces + 1;
            }

            if (ball.getY() - ball.getRadius() <= 0) {
                ball.bounceOffCeiling();
            }

            if (ball.getX() - ball.getRadius() <=0) {
                ball.bounceOffLeft();
            }

            if (target.targetIsHit(ball)) {
                hits = hits + 1;
                message = "Good job! Yayyy!";
                target.setY((int) (Math.random() * 290) + 80);
                endShot();
            }
            else if (groundBounces>=2) {
                message = "Better like next time, I guess!";
                endShot();
            }
        }
        repaint();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == launchButton) {
            if (!inFlight) {
                lastKnownSpeed = speedSlider.getValue();
                lastKnownAngle = angleSlider.getValue();
                ball.launch(lastKnownSpeed,lastKnownAngle);
                message = "";
                inFlight = true;
                groundBounces = 0;
            }
        }
        else 
            {
                updateGame();
            }
    }

    public void paintComponent(Graphics object)
    {
        super.paintComponent(object);
        object.setColor(Color.green);
        object.fillRect(0, groundYValue, getWidth(), 50);

        object.setColor(Color.gray);
        object.fillRect(wallXValue, 0, getWidth() - wallXValue, groundYValue);

        target.draw(object);

        object.setColor(Color.orange);
        int radius1 = (int) ball.getRadius();
        object.fillOval((int) ball.getX() - radius1, (int) ball.getY() - radius1, 2 * radius1, 2 * radius1);
        object.setColor(Color.black);
        object.drawString("Hits: " + hits + " / Shots: " + shots, 20, 100); // 20 and 100 are the x and y coordinates, respectively of where this message will be displayed
        object.drawString(message, 20, 125);
        object.setFont(new Font("Arial", Font.BOLD, 18)); // to emphasize the message
    }

    private void endShot() {
        shots = shots + 1;
        ball.reset(startingX, startingY);
        inFlight = false;
    }

}