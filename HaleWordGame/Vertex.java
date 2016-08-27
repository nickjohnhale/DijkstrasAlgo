import java.util.*;


public class Vertex implements Comparable<Vertex>{
    
    private String value;
    private List<Edge> connections;
    public int minDistance = 999999;
    public Vertex previous;

    public Vertex(String s){
	this.value = s;
	this.connections = new ArrayList<Edge>(0);
    }
    public int compareTo(Vertex other){
	return Integer.compare(minDistance, other.minDistance);
    }

    public void addEdge(Vertex v, int weight){
	this.connections.add(new Edge(this, v, weight));
    }

    public String getNeighbors(){//Formats the neighbors nicely
	String s = "";
	for(Edge e: this.connections){
	    s += e.getV2().getStr() + " " + e.getWeight() + " ";
	}
	return s;
    }

    public String getStr(){
	return this.value;
    }

    public List<Edge> getConnections(){
	return this.connections;
    }

}