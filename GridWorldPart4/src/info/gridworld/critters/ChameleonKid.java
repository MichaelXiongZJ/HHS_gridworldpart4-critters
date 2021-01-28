package info.gridworld.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;

public class ChameleonKid extends ChameleonCritter{

	  public ArrayList<Actor> getActors(){
		  
		  int a = getDirection();
		  
		  if (a==0 || a==180) {
			  
		  }else if (a==45 || a==225) {
			  
		  }else if (a==90 || a==270){
			  
		  }else if (a==135 || a== 315) {
			  
		  }else {
			  
		  }
			  
	  
		  
	  
		  
		  return getGrid().getNeighbors(getLocation());
	        
	        
	        
	    }
}
