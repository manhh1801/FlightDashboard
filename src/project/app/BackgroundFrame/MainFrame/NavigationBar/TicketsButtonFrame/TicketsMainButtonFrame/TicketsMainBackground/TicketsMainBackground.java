package project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.TicketsMainButtonFrame.TicketsMainBackground;

import javafx.scene.shape.Circle;

import static project.app.Utilities.ColorUtils.SECONDHALF_GRADIENT;
import static project.app.Utilities.SizeUtils.*;

public class TicketsMainBackground extends Circle
{
    public TicketsMainBackground()
    {
        setFill(SECONDHALF_GRADIENT(1));
        setLayoutX(30*UNIT); setLayoutY(30*UNIT);
        setRadius(20*UNIT);
    }
}