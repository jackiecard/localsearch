/**
 * Created by Jacqueline Cardozo, Fernando Silva, Paulo Victor Sarmento on 4/26/16.
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

// This program is performing a search using Greedy Algorithm to solve the Traveling Salesperson problem
public class Starter {

    // The file must end with "EOF" on the last line
    // Must have blank spaces " : " between variable + value
    public static String file = "/Users/Jackie/IdeaProjects/homework10/src/files/wi29.tsp";

    public static void main (String [] args){''
        TSPObject tsp = parser(file);

        ArrayList<NodeCoordSection> bestPath = new ArrayList<>();
        ArrayList<NodeCoordSection> listOfNodes = tsp.getNodeCoord();

        int [] distances = new int[listOfNodes.size()];
        int tourCost = 0;
        bestPath.add(listOfNodes.get(0));
        listOfNodes.remove(0);
        NodeCoordSection bestNode = new NodeCoordSection();
        distances[0] = 0;

        while(!listOfNodes.isEmpty()) {
            int listSize = listOfNodes.size();
            int lowestDistance = 10000;
            NodeCoordSection lowestDistanceNode = new NodeCoordSection();

            for (NodeCoordSection node : listOfNodes) {
                    NodeCoordSection firstNode = bestPath.get(bestPath.size() - 1);
                    Comparator comparator = new Comparator(firstNode, node);

                    //System.out.println("Distance from " + firstNode.getId() + " to " + node.getId() + " is: " + comparator.getDistance());

                    if(comparator.getDistance() < lowestDistance){
                        lowestDistance = comparator.getDistance();
                        lowestDistanceNode = node;
                    }
            }
            distances[bestPath.size()] = lowestDistance;
            tourCost += lowestDistance;
            bestPath.add(lowestDistanceNode);
            listOfNodes.remove(listOfNodes.indexOf(lowestDistanceNode));
        }

        int i = 0;
        System.out.println(tourCost);
        for (NodeCoordSection node : bestPath) {
            System.out.print(node.getId() + ",");
            /*System.out.println(node.toString());
            System.out.println("Distance: " + distances[i] + "\n");*/
            i++;
        }
//        System.out.println(tsp.toString());
    }

    public static TSPObject parser(String fileName){
        TSPObject tsp = new TSPObject();
        try {
            File f = new File(fileName);
            Scanner sc = new Scanner(f);

            String name = "";
            ArrayList<String> comments = new ArrayList<>();
            String type = "";
            int dimension = 0;
            String edge = "";
            ArrayList<NodeCoordSection> nodesCoord = new ArrayList<>();

            while(sc.hasNextLine()){
                String line = sc.nextLine();
                if(line.indexOf("EOF") == -1) {
                    if (line.indexOf(":") != -1) {
                        String[] details = line.split(" : ");
                        switch (details[0]){
                            case "NAME" :
                                name = details[1];
//                                System.out.println(name);
                                break;
                            case "COMMENT" :
                                String comment = details[1];
                                comments.add(comment);
//                                System.out.println(comment);
                                break;
                            case "TYPE" :
                                type = details[1];
//                                System.out.println(type);
                                break;
                            case "DIMENSION" :
                                dimension = Integer.parseInt(details[1]);
//                                System.out.println(dimension);
                                break;
                            case "EDGE_WEIGHT_TYPE" :
                                edge = details[1];
//                                System.out.println(edge);
                                break;
                        }

                    } else if (line.indexOf("NODE_COORD_SECTION") == -1) {
                        String[] details = line.split(" ");
                        int id = Integer.parseInt(details[0]);
                        double x = Double.parseDouble(details[1]);
                        double y = Double.parseDouble(details[2]);

                        NodeCoordSection node = new NodeCoordSection(id, x, y);
                        nodesCoord.add(node);

                        /*System.out.println("id: " + id +
                                "\nx: " + x +
                                "\ny: " + y);*/
                    }

                }

                tsp = new TSPObject(name, comments, type, dimension, edge, nodesCoord);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return tsp;
    }

}
