/**
 * Created by jackie on 4/26/16.
 */
public class NodeCoordSection {

    private int id;
    private double x;
    private double y;

    public NodeCoordSection() {
    }

    public NodeCoordSection(int id, double x, double y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String toString(){
        return "ID: " + getId() +
                "\nX: " + getX() +
                "\nY: " + getY();
    }
}
