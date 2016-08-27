import java.util.*;

public class AdjacencyList{

    private List<Vertex> verticies;

    public AdjacencyList(){
	this.verticies = new ArrayList<Vertex>(0);
    }

    public List<Vertex> getVerticies(){
	return this.verticies;
    }


    //Search the Verticies and return the index of the desired one, or -1 if it isnt there
    public int searchVerticies(String inp){;
	for(int i = 0; i < this.verticies.size(); i++){;
	    if(this.verticies.get(i).getStr().equals(inp)){
		return i;
	    }
	}
	return -1;
    }

    //Adds the vertex and generates all its neighbors
    public void addVertex(String s){
	Vertex v = new Vertex(s);
	int w = 0;

	if(this.verticies.isEmpty()){
	    this.verticies.add(v);
	    return;
	}

	for(int i = 0; i < this.verticies.size(); i++){
	    w = 0;
	    for(int j = 0; j < 5; j++){
		if(s.charAt(j) == this.verticies.get(i).getStr().charAt(j)){
		    w ++;
		}
	    }

	    //Adds the edge both ways
	    if(w == 3){
		v.addEdge(verticies.get(i),5);
		this.verticies.get(i).addEdge(v, 5);
	    }
	    else if(w == 4){
		v.addEdge(verticies.get(i),1);
		this.verticies.get(i).addEdge(v, 1);
	    }
	}
	this.verticies.add(v);
	
    }

    public void refreshVerticies(){
	for(Vertex v : this.verticies){
	    v.minDistance = 999999;
	    v.previous = null;
	}
    }
}