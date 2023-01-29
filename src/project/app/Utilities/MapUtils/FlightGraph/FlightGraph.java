package project.app.Utilities.MapUtils.FlightGraph;

import java.util.HashMap;

public class FlightGraph extends HashMap<Integer, HashMap<Integer, Integer>>
{
    public FlightGraph()
    {
        super();
        add(0, 0, 0);
    }

    public void add(int Location1, int Location2, int Distance)
    {
        if(containsKey(Location1)==false) {put(Location1, new HashMap<Integer, Integer>());}
        if(containsKey(Location2)==false) {put(Location2, new HashMap<Integer, Integer>());}
        get(Location1).put(Location2, Distance);
        get(Location2).put(Location1, Distance);
    }
}