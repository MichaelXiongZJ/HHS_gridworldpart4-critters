package info.gridworld.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;

public class ChameleonKid extends ChameleonCritter{

	  public ArrayList<Actor> getActors(){
		  
		  
		  
		  
		  
	        return getGrid().getNeighbors(getLocation());
	        
	        
	        
	    }
}
