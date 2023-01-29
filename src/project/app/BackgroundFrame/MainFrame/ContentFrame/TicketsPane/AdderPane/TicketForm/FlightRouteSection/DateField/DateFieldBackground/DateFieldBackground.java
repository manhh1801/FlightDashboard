package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.DateField.DateFieldBackground;

import javafx.geometry.Bounds;
import javafx.scene.shape.SVGPath;

import static project.app.Utilities.ColorUtils.GRAY;
import static project.app.Utilities.SizeUtils.UNIT;

public class DateFieldBackground extends SVGPath
{
    public DateFieldBackground()
    {
        setContent("M0 11C0 5.47713 4.47715 0.999976 10 0.999976C10.3333 0.981666 11 1.15603 11 1.99998C11 2.84392 10.3333 3.0549 10 3.0549C5.50005 3.55235 2 7.36742 2 12V30C2 34.9705 6.02944 39 11 39H129C133.971 39 138 34.9705 138 30V12C138 7.02941 133.971 2.99998 129 2.99998H45C44.6667 2.99998 44 2.79998 44 2C44 1.20002 44.6667 0.999992 45 0.999976H130C135.523 0.999976 140 5.47713 140 11V31C140 36.5228 135.523 41 130 41H10C4.47716 41 0 36.5228 0 31V11Z");
        setFill(GRAY(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(-Bounds.getMinX()); setLayoutY(10*UNIT-Bounds.getMinY());
    }
}