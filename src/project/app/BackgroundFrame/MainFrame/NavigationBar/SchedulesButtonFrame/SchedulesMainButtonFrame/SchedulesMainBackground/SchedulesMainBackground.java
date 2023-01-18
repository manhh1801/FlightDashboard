package project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.SchedulesMainButtonFrame.SchedulesMainBackground;

import javafx.scene.shape.Circle;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class SchedulesMainBackground extends Circle
{
    public SchedulesMainBackground()
    {
        setFill(FIRSTHALF_GRADIENT(1));
        setLayoutX(30*UNIT); setLayoutY(30*UNIT);
        setRadius(20*UNIT);
    }
}