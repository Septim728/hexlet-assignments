package exercise;

// BEGIN
public class Segment {

    private Point beginPoint;
    private Point midPoint;
    private Point endPoint;

    public Segment(Point beginPoint, Point endPoint) {
        this.beginPoint = beginPoint;
        this.endPoint = endPoint;

        var beginPointX =  beginPoint.getX();
        var beginPointY =  beginPoint.getY();

        var endPointX =  endPoint.getX();
        var endPointY =  endPoint.getY();

        this.midPoint = new Point ((beginPointX + endPointX) / 2, (beginPointY + endPointY) / 2);
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        return midPoint;
    }
}
// END
