package info.gridworld.critters;

import java.awt.Color;
import java.util.ArrayList;

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

public class BlusterCritter extends Critter{
	
	private int c = 8;
//	private int x = getLocation().getRow();
//	private int y = getLocation().getCol();
	private static final double COLOR_FACTOR = 0.3;

	public ArrayList<Actor> getActors() {
	 	 int x = getLocation().getCol();
		 int y = getLocation().getRow();
		 ArrayList<Actor> actors =  getGrid().getNeighbors(getLocation());
		 
		 Location one = new Location(y-1, x-1);
		 Location two = new Location(y-1, x+1);
		 Location three = new Location(y+1, x+1);
		 Location four = new Location(y+1, x-1);
		 
		 ArrayList <Location> subCritters = new ArrayList<Location>();
		 subCritters.add(one);
		 subCritters.add(two);
		 subCritters.add(three);
		 subCritters.add(four);
		 for(int a=0; a<4; a++) {
			 if(getGrid().isValid(subCritters.get(a).getAdjacentLocation(Location.WEST+a*90)) && getGrid().get(subCritters.get(a).getAdjacentLocation(Location.WEST+a*90)) != null) {
				 actors.add(getGrid().get(subCritters.get(a).getAdjacentLocation(Location.WEST+a*90)));
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

	public void processActors(ArrayList<Actor> actors) {
		
			int n = actors.size();
        	Color c = getColor();
        	int red = (int) (c.getRed());
        	int green = (int) (c.getGreen());
        	int blue = (int) (c.getBlue());
	        if (n<2) {
	        	blue *= (1+COLOR_FACTOR); 
	        	green *= (1+COLOR_FACTOR);
	        	red *= (1+COLOR_FACTOR);
	        	if(red>255) {
	        		red = 255;
	        	}
	        	if(green>255) {
	        		green = 255;
	        	}
	        	if(blue>255) {
	        		blue = 255;
	        	}
	        	setColor(new Color(red, green, blue));        	
	            return;
	        }else if(n>2) {
	        	blue *= (1-COLOR_FACTOR); 
	        	green *= (1-COLOR_FACTOR);
	        	red *= (1-COLOR_FACTOR);
	        	if(red<1) {
	        		red = 1;
	        	}
	        	if(green<1) {
	        		green = 1;
	        	}
	        	if(blue<1) {
	        		blue = 1;
	        	}
	        	setColor(new Color(red, green, blue));        	
	            return;
	        }
	}
}
