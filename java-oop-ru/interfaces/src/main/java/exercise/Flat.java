package exercise;

// BEGIN
class Flat implements Home {
    double area;
    double balconyArea;
    int floor;

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return this.area + this.balconyArea;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea() +
                " метров на " + floor + " этаже";
    }
}
// END
