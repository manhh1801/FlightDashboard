package project.app.Utilities;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

public class DatabaseUtils
{
    //Flights:
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
        catch(Exception e) {}
        return DepartureTime;
    }

    public static int getFlightFromLocation(String FlightCode)
    {
        int FromLocation=0;
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select FROM_LOCATION from Flights where FLIGHT_CODE=\""+FlightCode+"\"");
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {FromLocation=FlightSet.getInt(1);}
        }
        catch(Exception e) {}
        return FromLocation;
    }

    public static int getFlightToLocation(String FlightCode)
    {
        int ToLocation=0;
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select TO_LOCATION from Flights where FLIGHT_CODE=\""+FlightCode+"\"");
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {ToLocation=FlightSet.getInt(1);}
        }
        catch(Exception e) {}
        return ToLocation;
    }

    public static boolean getFlightAvailability(String FlightCode)
    {
        boolean Availability=false;
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select AVAILABLE from Flights where FLIGHT_CODE=\""+FlightCode+"\"");
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {Availability=FlightSet.getBoolean(1);}
        }
        catch(Exception e) {}
        return Availability;
    }



    //Tickets:
    public static boolean insertTicket(String CustomerName, String PassportID, boolean TicketType, String FlightCode, int BaseCost, int ServiceFee)
    {
        try
        {
            long Now=ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("GMT+7")).toInstant().toEpochMilli();
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("insert into Tickets(CUSTOMER_NAME, PASSPORT_ID, TICKET_TYPE, FLIGHT_CODE, BASE_COST, SERVICE_FEE, ADD_TIME) values(\""+CustomerName+"\", \""+PassportID+"\", "+TicketType+", \""+FlightCode+"\", "+BaseCost+", "+ServiceFee+", "+Now+")");
            Statement.execute();
            return true;
        }
        catch(Exception e) {return false;}
    }

    public static boolean updateTicket(long ID, String CustomerName, String PassportID, boolean TicketType, String FlightCode, int BaseCost, int ServiceFee)
    {
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("update Tickets set CUSTOMER_NAME=\""+CustomerName+"\", PASSPORT_ID=\""+PassportID+"\", TICKET_TYPE="+TicketType+", FLIGHT_CODE=\""+FlightCode+"\", BASE_COST="+BaseCost+", SERVICE_FEE="+ServiceFee+" where ID="+ID);
            Statement.execute();
            return true;
        }
        catch(Exception e) {return false;}
    }

    public static String getTicketCustomerName(long ID)
    {
        String CustomerName="";
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select CUSTOMER_NAME from Tickets where ID="+ID);
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {CustomerName=FlightSet.getString(1);}
        }
        catch(Exception e) {}
        return CustomerName;
    }

    public static String getTicketPassportID(long ID)
    {
        String PassportID="";
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select PASSPORT_ID from Tickets where ID="+ID);
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {PassportID=FlightSet.getString(1);}
        }
        catch(Exception e) {}
        return PassportID;
    }

    public static boolean getTicketType(long ID)
    {
        boolean TicketType=false;
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select TICKET_TYPE from Tickets where ID="+ID);
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {TicketType=FlightSet.getBoolean(1);}
        }
        catch(Exception e) {}
        return TicketType;
    }

    public static String getTicketFlightCode(long ID)
    {
        String FlightCode="--";
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select FLIGHT_CODE from Tickets where ID="+ID);
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {FlightCode=FlightSet.getString(1);}
        }
        catch(Exception e) {}
        return FlightCode;
    }

    public static int getTicketBaseCost(long ID)
    {
        int BaseCost=20000;
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select BASE_COST from Tickets where ID="+ID);
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {BaseCost=FlightSet.getInt(1);}
        }
        catch(Exception e) {}
        return BaseCost;
    }

    public static int getTicketServiceFee(long ID)
    {
        int ServiceFee=20000;
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select SERVICE_FEE from Tickets where ID="+ID);
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {ServiceFee=FlightSet.getInt(1);}
        }
        catch(Exception e) {}
        return ServiceFee;
    }

    public static long getTicketAddTime(long ID)
    {
        long AddTime=0;
        try
        {
            Connection Database=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dashboard", "root", "manh1234");
            PreparedStatement Statement=Database.prepareStatement("select Add_Time from Tickets where ID="+ID);
            ResultSet FlightSet=Statement.executeQuery();
            while(FlightSet.next()) {AddTime=FlightSet.getLong(1);}
        }
        catch(Exception e) {}
        return AddTime;
    }

}