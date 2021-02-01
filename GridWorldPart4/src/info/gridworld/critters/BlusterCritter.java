package info.gridworld.critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter{
	
	private int c = 8;
	private int x = getLocation().getRow();
	private int y = getLocation().getCol();
	private static final double COLOR_FACTOR = 0.5;

	public ArrayList<Actor> getActors() {
		 ArrayList<Actor> actors =  getGrid().getNeighbors(getLocation());
		 
		 Location one = new Location(x-1, y-1);
		 Location two = new Location(x+1, y-1);
		 Location three = new Location(x-1, y+1);
		 Location four = new Location(x+1, y+1);
		 
		 ArrayList <Location> subCritters = null;
		 subCritters.add(one);
		 subCritters.add(two);
		 subCritters.add(three);
		 subCritters.add(four);
		 
		 for(int a=0; a<4; a++) {
			 if(getGrid().isValid(subCritters.get(a).getAdjacentLocation(Location.WEST+a*90)) && getGrid().get(subCritters.get(a).getAdjacentLocation(Location.WEST+a*90)) != null) {
				 actors.add(getGrid().get(getLocation().getAdjacentLocation(Location.WEST+a*90)));
		     }if(getGrid().isValid(subCritters.get(a).getAdjacentLocation(Location.NORTHWEST+a*90)) && getGrid().get(subCritters.get(a).getAdjacentLocation(Location.NORTHWEST+a*90)) != null) {
		    	 actors.add(getGrid().get(subCritters.get(a).getAdjacentLocation(Location.NORTHWEST+a*90)));
		     }if(getGrid().isValid(subCritters.get(a).getAdjacentLocation(Location.NORTH+a*90)) && getGrid().get(subCritters.get(a).getAdjacentLocation(Location.NORTH+a*90)) != null) {
		    	 actors.add(getGrid().get(subCritters.get(a).getAdjacentLocation(Location.NORTH+a*90)));
		     }if(getGrid().isValid(subCritters.get(a).getAdjacentLocation(Location.NORTHEAST+a*90)) && getGrid().get(subCritters.get(a).getAdjacentLocation(Location.NORTHEAST+a*90)) != null) {
		    	 actors.add(getGrid().get(subCritters.get(a).getAdjacentLocation(Location.NORTHEAST+a*90)));
		     }
		 }

		 return actors;
	}
	/*
	public ArrayList<Actor> getActors() {
		
		for(int a=x-2; a<=x+2; a++) {
			
		}
		
		
		return null;
	}*/

	public void processActors(ArrayList<Actor> actors) {
		
		 int n = actors.size();
	        if (n<8) {
	        	Color c = getColor();
	        	int red = (int) (c.getRed()*(1+COLOR_FACTOR));
	        	int green = (int) (c.getGreen()*(1+COLOR_FACTOR));
	        	int blue = (int) (c.getBlue()*(1+COLOR_FACTOR)); 
	        	
	        	setColor(new Color(red, green, blue));
	        	
	            return;
	        }else if(n>8) {
	        	Color c = getColor();
	        	int red = (int) (c.getRed()*(1-COLOR_FACTOR));
	        	int green = (int) (c.getGreen()*(1-COLOR_FACTOR));
	        	int blue = (int) (c.getBlue()*(1-COLOR_FACTOR)); 
	        	
	        	setColor(new Color(red, green, blue));
	        	
	            return;
	        }
	        /*
	        int r = (int) (Math.random() * n);

	        Actor other = actors.get(r);
	        setColor(other.getColor());*/
	}
}
