public class Dot {
    private final int x;
    private final int y;

    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public double getDistance(Dot otherDot) {
        double distance;
        int otherDotX = otherDot.getX();
        int otherDotY = otherDot.getY();

        distance = Math.sqrt(Math.pow(this.x-otherDotX,2) + Math.pow(this.y-otherDotY,2));

        return distance;
    }

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
