
public class Edge{
    
    private Vertex v1;
    private Vertex v2;
    private int weight;

    public Edge(Vertex ver1, Vertex ver2, int inputWeight){
	this.v1 = ver1;
	this.v2 = ver2;
	this.weight = inputWeight;
    }

    public Vertex getV1(){
	return this.v1;
    }

    public Vertex getV2(){
	return this.v2;
    }

    public int getWeight(){
	return this.weight;
    }

}