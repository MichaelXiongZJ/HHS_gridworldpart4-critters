package info.gridworld.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.actor.Flower;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class ZoolanderCritter extends Critter {
	
	
	
	
	
	public ArrayList<Location> getMoveLocations(){
        ArrayList<Location> next = new ArrayList<Location>(); 
        next.add(getLocation().getAdjacentLocation(getDirection()));			
		return next;
	}
	
	public Location selectMoveLocation(ArrayList<Location> locs){
		
        if (getGrid().isValid(locs.get(0)) && ((getGrid().get(locs.get(0)) == null) || (getGrid().get(locs.get(0)) instanceof Flower)))
            return locs.get(0);
        else
            setDirection(getDirection() + Location.RIGHT);
        	return getLocation();
	}
	
    public void processActors(ArrayList<Actor> actors){
        for (Actor a : actors){
            if (a instanceof Flower)
                a.removeSelfFromGrid();
        }
    }
    
}
