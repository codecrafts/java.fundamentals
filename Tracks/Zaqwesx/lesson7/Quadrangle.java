public class Quadrangle {
    private Dot[] dotArray;

    public Dot[] getDotArray() {
        return dotArray;
    }

    public boolean isRectangle() {
        return (DotUtils.getDistance(dotArray[0],dotArray[1]).equals(DotUtils.getDistance(dotArray[2],dotArray[3]))
                && DotUtils.getDistance(dotArray[0],dotArray[2]).equals(DotUtils.getDistance(dotArray[1],dotArray[3]))
                && DotUtils.getDistance(dotArray[0],dotArray[3]).equals(DotUtils.getDistance(dotArray[1],dotArray[2])));
    }

    public Quadrangle(Dot[] dotArray) {
        this.dotArray = dotArray;
    }
}
