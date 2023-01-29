package project.app.Utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtils
{
    public static String renderClock(LocalDateTime time)
    {
        int day=time.getDayOfMonth();
        if(day>3) {return (time.format(DateTimeFormatter.ofPattern("HH:mm:ss  |  E - MMM d"))+"th"+time.format(DateTimeFormatter.ofPattern(" - u")));}
        if(day==1) {return (time.format(DateTimeFormatter.ofPattern("HH:mm:ss  |  E - MMM d"))+"st"+time.format(DateTimeFormatter.ofPattern(" - u")));}
        else if(day==2) {return (time.format(DateTimeFormatter.ofPattern("HH:mm:ss  |  E - MMM d"))+"nd"+time.format(DateTimeFormatter.ofPattern(" - u")));}
        else {return (time.format(DateTimeFormatter.ofPattern("HH:mm:ss  |  E - MMM d"))+"rd"+time.format(DateTimeFormatter.ofPattern(" - u")));}
    }

    public static String renderTimeDate(LocalDateTime time) {return time.format(DateTimeFormatter.ofPattern("HH:mm - d.M.u"));}

    public static String renderTime(LocalDateTime time) {return time.format(DateTimeFormatter.ofPattern("HH:mm"));}

    public static String renderDate(LocalDateTime time)
    {
        int day=time.getDayOfMonth();
        if(day>3) {return (time.format(DateTimeFormatter.ofPattern("MMM d"))+"th"+time.format(DateTimeFormatter.ofPattern(", u")));}
        if(day==1) {return (time.format(DateTimeFormatter.ofPattern("MMM d"))+"st"+time.format(DateTimeFormatter.ofPattern(", u")));}
        else if(day==2) {return (time.format(DateTimeFormatter.ofPattern("MMM d"))+"nd"+time.format(DateTimeFormatter.ofPattern(", u")));}
        else {return (time.format(DateTimeFormatter.ofPattern("MMM d"))+"rd"+time.format(DateTimeFormatter.ofPattern(", u")));}
    }
}