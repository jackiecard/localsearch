/**
 * Created by jackie on 4/27/16.
 */
public class Comparator {

    private NodeCoordSection coordNode1;
    private NodeCoordSection coordNode2;
    private int distance;

    public Comparator() {
    }

    public Comparator(NodeCoordSection coordNode1, NodeCoordSection coordNode2) {
        this.coordNode1 = coordNode1;
        this.coordNode2 = coordNode2;
        this.distance = calculateDistance();
    }

    public int calculateDistance(){
        double x1 = getCoordNode1().getX();
        double x2 = getCoordNode2().getX();
        double y1 = getCoordNode1().getY();
        double y2 = getCoordNode2().getY();
        return (int) Math.round(Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
    }

    public NodeCoordSection getCoordNode1() {
        return coordNode1;
    }

    public void setCoordNode1(NodeCoordSection coordNode1) {
        this.coordNode1 = coordNode1;
    }

    public NodeCoordSection getCoordNode2() {
        return coordNode2;
    }

    public void setCoordNode2(NodeCoordSection coordNode2) {
        this.coordNode2 = coordNode2;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}

