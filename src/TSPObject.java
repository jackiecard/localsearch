import java.util.ArrayList;

/**
 * Created by jackie on 4/26/16.
 */
public class TSPObject {

    private String name;
    private ArrayList<String> commentsLine;
    private String type;
    private int dimension;
    private String edgeWeightType;
    private ArrayList<NodeCoordSection> nodeCoord = new ArrayList<>();

    public TSPObject(String name, ArrayList<String> commentsLine, String type, int dimension, String edgeWeightType, ArrayList<NodeCoordSection> nodeCoord) {
        this.name = name;
        this.commentsLine = commentsLine;
        this.type = type;
        this.dimension = dimension;
        this.edgeWeightType = edgeWeightType;
        this.nodeCoord = nodeCoord;
    }

    public TSPObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCommentsLine() {
        return commentsLine;
    }

    public void setCommentsLine(ArrayList<String> commentsLine) {
        this.commentsLine = commentsLine;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public String getEdgeWeightType() {
        return edgeWeightType;
    }

    public void setEdgeWeightType(String edgeWeightType) {
        this.edgeWeightType = edgeWeightType;
    }

    public ArrayList<NodeCoordSection> getNodeCoord() {
        return nodeCoord;
    }

    public void setNodeCoord(ArrayList<NodeCoordSection> nodeCoord) {
        this.nodeCoord = nodeCoord;
    }

    public String toString(){
        return "Name: " + getName() +
                "\nComments: \n" + getCommentsLine().toString() +
                "\nType: " + getType() +
                "\nDimension: " + getDimension() +
                "\nEdge Weight Type: " + getEdgeWeightType() +
                "\nNodes Coordenates: \n" + getNodeCoord().toString();
    }
}
