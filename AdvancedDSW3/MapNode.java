package roadgraph;

import java.util.HashSet;
import java.util.Set;

import geography.GeographicPoint;

public class MapNode 
{	
	/** the latitude and longitude of this node */
	private GeographicPoint location;
	
	/** The list of edges out of this node */
	private HashSet<MapEdge> edges;
	
	/** the predicted distance of this node (used in Week 3 algorithms) */
	private double distance;

	/** the actual distance of this node from start (used in Week 4 algorithms) */
	private double actualDistance;
	
	MapNode(GeographicPoint loc) 
	{
		location = loc;
		edges = new HashSet<MapEdge>();
		distance = 0.0;
		actualDistance = 0.0;
		
	}
		
	public Set<MapEdge> getEdges() 
	{
		return edges;
	}
	
	public void addEdge(MapEdge edge)
	{
		edges.add(edge);
	}
	
	// return the neighbors of this MapNode
	public Set<MapNode> getNeighbors()
	{
		Set<MapNode> neighbors = new HashSet<>();
		
		for (MapEdge edge : edges)
		{
			neighbors.add(edge.getOtherNode(this));
		}
		return neighbors;
	}
	
	// get node distance (predicted)
	public double getDistance()
	{
		return this.distance;
	}
	
	// set node distance (predicted)
	public void setDistance(double distance)
	{
		this.distance = distance;
	}
	
	// get node distance (actual)
	public double getActualDistance()
	{
		return this.actualDistance;
	}
	
	//set node distance (actual)
	public void setActualDistance(double actualDistance)
	{
		this.actualDistance = actualDistance;
	}
	
	//get the location of the node
	public GeographicPoint getLocation()
	{
		return location;
	}	
	
	public boolean equals(Object o)
	{
		if (!(o instanceof MapNode) || (o == null))
			return false;
		
		MapNode node = (MapNode)o;
		return node.location.equals(this.location);
	}
	
	public String toString()
	{
		String toReturn = "[Node at location (" + location + ")";
		toReturn += " intersects streets: ";
		for (MapEdge e: edges)		
			toReturn += e.getRoadName() + ", ";
		
		toReturn += "]";
		return toReturn;		
	}
	
	// Code to implement Comparable
	public int compareTo(Object o) 
	{
		// convert to map node, may throw exception
		MapNode m = (MapNode)o; 
		return ((Double)this.getDistance()).compareTo((Double) m.getDistance());
	}
	
	
	
	
	
	
	
	
	
	
	
}
