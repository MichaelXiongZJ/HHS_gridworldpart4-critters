

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Rock;
import info.gridworld.critters.ChameleonCritter;
import info.gridworld.grid.Location;
import info.gridworld.critters.ChameleonKid;
import java.awt.Color;


public class ChameleonKidRunner
{
    public static void main(String[] args)
    {
        ActorWorld world = new ActorWorld();
        world.add(new Location(7, 8), new Rock());
        world.add(new Location(3, 3), new Rock());
        world.add(new Location(2, 8), new Rock(Color.BLUE));
        world.add(new Location(5, 5), new Rock(Color.PINK));
        world.add(new Location(1, 5), new Rock(Color.RED));
        world.add(new Location(7, 2), new Rock(Color.YELLOW));
        world.add(new Location(4, 4), new ChameleonKid());
        world.add(new Location(5, 8), new ChameleonKid());
        world.show();
    }
}