package project.app.Utilities.MapUtils;

import project.app.Utilities.MapUtils.FlightGraph.DomesticGraph;
import project.app.Utilities.MapUtils.FlightGraph.InternationalGraph;
import project.app.Utilities.MapUtils.LocationMap.LocationMap;

import java.util.ArrayList;

public class MapUtils
{
    private final static LocationMap LocationMap_var=new LocationMap();
    public static String getLocationName(int location) {return LocationMap_var.get(location);}

    private final static DomesticGraph DomesticGraph_var=new DomesticGraph();
    private final static InternationalGraph InternationalGraph_var=new InternationalGraph();

    public static ArrayList getLocationList(boolean Mode, int Location)
    {
        ArrayList LocationList=new ArrayList<Integer>();
        if(Mode==false) {DomesticGraph_var.get(Location).forEach((LinkedLocation, Distance)->{LocationList.add(LinkedLocation);});}
        else {InternationalGraph_var.get(Location).forEach((LinkedLocation, Distance)->{LocationList.add(LinkedLocation);});}
        return LocationList;
    }

    public static ArrayList getDomesticList()
    {
        ArrayList LocationList=new ArrayList<Integer>();
        LocationList.add(0);
        for(int count=1; count<16; count++) {LocationList.add(count);}
        return LocationList;
    }

    public static ArrayList getInternationalList()
    {
        ArrayList LocationList=new ArrayList<Integer>();
        LocationList.add(0);
        LocationList.add(4); LocationList.add(8); LocationList.add(9); LocationList.add(11);
        for(int count=16; count<43; count++) {LocationList.add(count);}
        return LocationList;
    }

    public static int getDistance(int FromLocation, int ToLocation)
    {
        boolean Mode=((FromLocation>15)||(ToLocation>15));
        try
        {
            if(Mode==false) {return DomesticGraph_var.get(FromLocation).get(ToLocation);}
            else {return InternationalGraph_var.get(FromLocation).get(ToLocation);}
        }
        catch(Exception e) {return 0;}
    }
}