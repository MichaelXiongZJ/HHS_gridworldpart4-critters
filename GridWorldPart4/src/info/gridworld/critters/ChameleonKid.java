package info.gridworld.critters;

import java.util.ArrayList;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;

public class ChameleonKid extends ChameleonCritter{

	  public ArrayList<Actor> getActors(){
	        ArrayList<Actor> frontAndBackActors = new ArrayList<Actor>();
	        if(getGrid().isValid(getLocation().getAdjacentLocation(getDirection())) && getGrid().get(getLocation().getAdjacentLocation(getDirection())) != null) {
	        	frontAndBackActors.add(getGrid().get(getLocation().getAdjacentLocation(getDirection())));
	        }if(getGrid().isValid(getLocation().getAdjacentLocation(getDirection() + Location.HALF_CIRCLE)) && getGrid().get(getLocation().getAdjacentLocation(getDirection() + Location.HALF_CIRCLE)) != null) {
	        	frontAndBackActors.add(getGrid().get(getLocation().getAdjacentLocation(getDirection() + Location.HALF_CIRCLE)));
	        }
	        return frontAndBackActors;
	    }
}
