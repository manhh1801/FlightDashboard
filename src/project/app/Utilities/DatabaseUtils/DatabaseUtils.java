package project.app.Utilities.DatabaseUtils;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseUtils
{
    public static ArrayList getFlightList(int FromLocation, int ToLocation)
    {
        ArrayList FlightList=new ArrayList<String>();
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select FLIGHT_CODE from Flights where FROM_LOCATION="+FromLocation+" and TO_LOCATION="+ToLocation+" and AVAILABLE=true");
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {FlightList.add(FlightSet.getString(1));}
        }
        catch(Exception e) {}
        if(FlightList.size()==0) {FlightList.add("--");}
        return FlightList;
    }

    public static long getDepartureTime(String FlightCode)
    {
        long DepartureTime=0L;
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select DEPARTURE_TIME from Flights where FLIGHT_CODE=\""+FlightCode+"\"");
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {DepartureTime=FlightSet.getLong(1);}
        }
        catch(Exception e) {e.printStackTrace();}
        return DepartureTime;
    }
}