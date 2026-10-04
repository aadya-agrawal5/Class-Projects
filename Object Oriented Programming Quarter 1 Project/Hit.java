public class Hit {
    private double speed;
    private double angle;
    private boolean shot;

    public Hit(double speed, double angle, boolean shot) {
        this.speed = speed;
        this.angle = angle;
        this.shot = shot;
    }

    public double getSpeed() {
        return speed;
    }

    public double getAngle() {
        return angle;
    }

    public boolean getShot() {
        return shot;
    }

}
