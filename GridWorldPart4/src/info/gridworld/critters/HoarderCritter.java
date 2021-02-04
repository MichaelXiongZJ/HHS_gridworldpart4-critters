package info.gridworld.critters;

import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;

public class HoarderCritter extends Critter{
		
	private Location home;
	private Actor pray;
	private boolean moveAway = false;
	private int count = 0;
	
	public HoarderCritter() {
		home = new Location(0,0);
	}
	
	public HoarderCritter(Location a) {
		home = a;
	}

	public void processActors(ArrayList<Actor> actors) {
		/*
        for(int a=0; a<actors.size();a++) {
        	if(actors.get(a) instanceof Actor) {
        		actors.remove(a);
        		a--;
        	}
        }*/
		if (pray == null) {
	        int n = actors.size();
	        if (n != 0) {
	            int r = (int) (Math.random() * n);
	            pray = actors.get(r);
	            for (Actor b : actors) {
	                if (b==pray)
	                    b.removeSelfFromGrid();
	            }
	        }
		}
    }
	
	public ArrayList<Location> getMoveLocations() {
		ArrayList<Location> loc = new ArrayList<Location>();
		Location tempLoc;
		int r = (int) (Math.random() * 10);
			if(moveAway == false && pray != null) {
				if(home.getRow()>getLocation().getRow()) {
					tempLoc = new Location(getLocation().getRow()+1, getLocation().getCol());
					if((getGrid().get(tempLoc)==null && getGrid().isValid(tempLoc)) || tempLoc == home)
						loc.add(0, tempLoc);
				}else if(home.getRow()<getLocation().getRow()) {
					tempLoc = new Location(getLocation().getRow()-1, getLocation().getCol());
					if((getGrid().get(tempLoc)==null && getGrid().isValid(tempLoc)) || tempLoc == home)
						loc.add(0, tempLoc);
				}else {
					if(home.getCol()>getLocation().getCol()) {
						tempLoc = new Location(getLocation().getRow(), getLocation().getCol()+1);
						if((getGrid().get(tempLoc)==null && getGrid().isValid(tempLoc)) || tempLoc == home)
							loc.add(0, tempLoc);
					}else if(home.getCol()<getLocation().getCol()) {
						tempLoc = new Location(getLocation().getRow()+1, getLocation().getCol()-1);
						if((getGrid().get(tempLoc)==null && getGrid().isValid(tempLoc)) || tempLoc == home)
							loc.add(0, tempLoc);
					}else {
						loc.add(0, new Location(getLocation().getRow()+1, getLocation().getCol()));
						moveAway = true;
					}
				}
			}else if(moveAway == true && pray == null){
				if(r%2 == 0) {
					if(home.getRow()<=getLocation().getRow()) {
						tempLoc = new Location(getLocation().getRow()+1, getLocation().getCol());
						if(getGrid().get(tempLoc)==null && getGrid().isValid(tempLoc))
							loc.add(0, tempLoc);
					}else if(home.getRow()>getLocation().getRow()) {
						tempLoc = new Location(getLocation().getRow()-1, getLocation().getCol());
						if(getGrid().get(tempLoc)==null && getGrid().isValid(tempLoc))
							loc.add(0, tempLoc);
					}
				}
				if(r%2 != 0) {
					if(home.getCol()<=getLocation().getCol()) {
						tempLoc = new Location(getLocation().getRow(), getLocation().getCol()+1);
						if(getGrid().get(tempLoc)==null && getGrid().isValid(tempLoc))
							loc.add(0, tempLoc);
					}else if(home.getCol()>getLocation().getCol()) {
						tempLoc = new Location(getLocation().getRow()+1, getLocation().getCol()-1);
						if(getGrid().get(tempLoc)==null && getGrid().isValid(tempLoc))
							loc.add(0, tempLoc);
					}
				}
			}else {
			loc = super.getMoveLocations();
		}
        return loc;
    }
    
	public void makeMove(Location loc)
    {
		Location a = getLocation();
		if(moveAway == true && pray != null) {
            moveTo(loc);
    		Actor newActor = pray;
    		newActor.putSelfInGrid(getGrid(), home);
    		pray = null;
    	} else if(pray != null && a == loc){
    		moveTo(selectMoveLocation(super.getMoveLocations()));
    		Actor newActor = pray;
    		newActor.putSelfInGrid(getGrid(), a);
    		pray = null;
        }else {
        	moveTo(loc);
        }
        if(moveAway == true) {
        	count++;
        }
        if(count > 2) {
        	count = 0;
        	moveAway = false;
        }
    }
}
