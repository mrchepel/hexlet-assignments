package exercise;

// BEGIN
class Segment {
    Point beginPoint;
    Point endPoint;

    public Segment(Point begin, Point end) {
        this.beginPoint = begin;
        this.endPoint = end;
    }

    public Point getBeginPoint() {
        return beginPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public Point getMidPoint() {
        return new Point((beginPoint.x + endPoint.x) / 2, (beginPoint.y + endPoint.y) / 2);
    }
}
// END
