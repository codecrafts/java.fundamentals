public class DotUtils {

    public static Double getDistance(Dot dot1, Dot dot2) {
        Double distance;
        Integer x1 = dot1.getX();
        Integer x2 = dot2.getX();
        Integer y1 = dot1.getY();
        Integer y2 = dot2.getY();

        distance = Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));

        return distance;
    }
}
