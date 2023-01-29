package project.app.BackgroundFrame.MainFrame.SystemBar.DateDisplay;

import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

import static project.app.Utilities.TimeUtils.*;
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
                    display(now);
                }
            },
            0, 1000
        );
    }

    public void display(LocalDateTime now)
    {
        setText(renderClock(now));
    }
}