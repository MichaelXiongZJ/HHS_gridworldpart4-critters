package info.gridworld.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;

public class ChameleonKid extends ChameleonCritter{

	  public ArrayList<Actor> getActors(){
		  
	//	  if (getDirection() == NORTH)
		  
		  
		  System.out.println(getDirection());
	        
		  
		  
		  return getGrid().getNeighbors(getLocation());
	        
	        
	        
	    }
}
