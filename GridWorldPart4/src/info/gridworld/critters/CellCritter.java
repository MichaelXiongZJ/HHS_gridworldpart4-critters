package info.gridworld.critters;

import java.util.ArrayList;
import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class CellCritter extends Critter{
	
	public ArrayList<Location> getMoveLocations(){
        return null;
    }
	public Location selectMoveLocation(ArrayList<Location> locs){
		return null;
	}
	public void makeMove(Location loc){
    }
	
	public ArrayList<Actor> getActors(){
        return getGrid().getNeighbors(getLocation());
    }
	
	public void processActors(ArrayList<Actor> actors)
    {
		int count = 0;
        for (Actor a : actors){
            if (a instanceof CellCritter)
                count++;
        }
        if(count >= 5 || count == 0) {
        	removeSelfFromGrid();
        }else if(count<=3){
        	replicate();
        }
    }
	
	public void replicate() {
		ArrayList<Location> babyLocation = super.getMoveLocations();
		Location loc = super.selectMoveLocation(babyLocation);
	    new CellCritter().putSelfInGrid(getGrid(), loc);
 	}
}
