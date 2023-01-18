package project.app.BackgroundFrame.MainFrame.SystemBar.DateDisplay;

import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import java.util.TimerTask;

import static project.app.Utilities.SizeUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.ColorUtils.*;

public class DateDisplay extends Text
{
    public DateDisplay()
    {
        setFont(AVERTA(0, 18*UNIT));
        setFill(WHITE(1));
        setTextAlignment(TextAlignment.LEFT);
        setTextOrigin(VPos.CENTER);
        setLayoutX(40*UNIT); setLayoutY(30*UNIT);

        Timer DateTimer=new Timer();
        DateTimer.scheduleAtFixedRate
        (
            new TimerTask()
            {
                public void run()
                {
                    LocalDateTime now= LocalDateTime.now();
                    render(now);
                }
            },
            0, 1000
        );
    }

    public void render(LocalDateTime now)
    {
        int day=now.getDayOfMonth();
        if(day>3) {setText(now.format(DateTimeFormatter.ofPattern("HH:mm:ss  |  E - MMM d"))+"th"+now.format(DateTimeFormatter.ofPattern(" - u")));}
        if(day==1) {setText(now.format(DateTimeFormatter.ofPattern("HH:mm:ss  |  E - MMM d"))+"st"+now.format(DateTimeFormatter.ofPattern(" - u")));}
        else if(day==2) {setText(now.format(DateTimeFormatter.ofPattern("HH:mm:ss  |  E - MMM d"))+"nd"+now.format(DateTimeFormatter.ofPattern(" - u")));}
        else if(day==3) {setText(now.format(DateTimeFormatter.ofPattern("HH:mm:ss  |  E - MMM d"))+"rd"+now.format(DateTimeFormatter.ofPattern(" - u")));}
    }
}