package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.TimeField.TimeFieldBackground;

import javafx.geometry.Bounds;
import javafx.scene.shape.SVGPath;

import static project.app.Utilities.ColorUtils.GRAY;
import static project.app.Utilities.SizeUtils.UNIT;

public class TimeFieldBackground extends SVGPath
{
    public TimeFieldBackground()
    {
        setContent("M0 11C0 5.47713 4.47715 0.999976 10 0.999976C10.3333 0.981666 11 1.15603 11 1.99998C11 2.84392 10.3333 3.0549 10 3.0549C5.50005 3.55235 2 7.36742 2 12V30C2 34.9705 6.02944 39 11 39H109C113.971 39 118 34.9705 118 30V12C118 7.02941 113.971 2.99998 109 2.99998H45.866C45.5327 2.99998 44.866 2.79998 44.866 2C44.866 1.20002 45.5327 0.999992 45.866 0.999976H110C115.523 0.999976 120 5.47713 120 11V31C120 36.5228 115.523 41 110 41H10C4.47716 41 0 36.5228 0 31V11Z");
        setFill(GRAY(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(-Bounds.getMinX()); setLayoutY(10*UNIT-Bounds.getMinY());
    }
}