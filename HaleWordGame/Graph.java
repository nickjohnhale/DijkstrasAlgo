import java.io.*;
import java.util.*;
import java.lang.*;

/*
Nick Hale
Final Project
 */

/*
This class is the main engine of the project. It reads the list of words in (making sure that the input is correct)
and builds an Adjacency List out of all the verticies. It then will ask the user to input the words they would like
to find the path between and then outputs the shortest path. It will keep asking the user if they would like to continue
until they enter "n" or "no"

*/

public class Graph{

    public static void main(String args[]){
	Scanner sys = new Scanner(System.in);
	String inp = "yes";
	String word1 = "";
	String word2 = "";

	AdjacencyList g = new AdjacencyList();
	try{
	    Scanner s = new Scanner(new FileInputStream(args[0]));
	    
	    while(s.hasNext()){
		g.addVertex(s.next());
	    }
	}
	catch(FileNotFoundException x){
	    System.out.println("File not found");
	}
	
	while(true){//Go while the user doesn't enter no or n


	    System.out.println("Enter first word: ");
	    word1 = sys.nextLine().toUpperCase();

	    int index1 = g.searchVerticies(word1);//Get the index of the first vertex
	    
	    System.out.println("Enter the second word: ");
	    word2 = sys.nextLine().toUpperCase();

	    int index2 = g.searchVerticies(word2);
	    if(index1 == -1){           //Default if the word is not in the list
		System.out.println("First word does not exist");
	    }

	    else if(index2 == -1){
		System.out.println("Second word does not exist");
	    }

	    else{ //If both words exist, proceed to find the shortest path
			Vertex v1 = g.getVerticies().get(index1);
			Vertex v2 = g.getVerticies().get(index2);
			computePaths(v1);
			List<String> path = getShortestPathTo(v2);

			System.out.print("The shortest distance between ");
			System.out.print(word1);
			System.out.print(" and ");
			System.out.print(word2);
			System.out.println(" Is " + v2.minDistance);
			System.out.println("The path is " + path);
	    }
	    


	    System.out.println("Another Trial? ");
	    inp = sys.nextLine().toLowerCase();
	    while(!inp.equals("yes") && !inp.equals("y") && !inp.equals("no") && !inp.equals("n")){//Forces the user to input a valid input
		System.out.println("Invalid Input, please enter \"yes\", \"y\", \"no\", or \"n\": ");
		inp = sys.nextLine().toLowerCase();

	    }

	    if(inp.equals("no") || inp.equals("n")){
		break;
	    }
	    g.refreshVerticies();
	}
    }

    
    public static List<String> getShortestPathTo(Vertex target)
    {
	List<String> path = new ArrayList<String>();
	for(Vertex v = target; v != null; v = v.previous){
	    path.add(v.getStr());
	}

	Collections.reverse(path);
	return path;
    }

    public static void computePaths(Vertex source)
    {
	source.minDistance = 0;
	PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
	vertexQueue.add(source);
	while(!vertexQueue.isEmpty()){
	    Vertex u = vertexQueue.poll();
		
	    for(Edge e : u.getConnections()){
		Vertex v = e.getV2();
		int distance = u.minDistance + e.getWeight();
		if(distance < v.minDistance){
		    vertexQueue.remove(v);
		    v.minDistance = distance;
		    v.previous = u;
		    vertexQueue.add(v);
		}
	    }
	}
    }

}



