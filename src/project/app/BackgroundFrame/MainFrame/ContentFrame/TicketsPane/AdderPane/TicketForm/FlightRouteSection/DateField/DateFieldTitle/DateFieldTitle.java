package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.DateField.DateFieldTitle;

import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static project.app.Utilities.ColorUtils.GRAY;
import static project.app.Utilities.FontUtils.AVERTA;
import static project.app.Utilities.SizeUtils.UNIT;

public class DateFieldTitle extends Text
{
    public DateFieldTitle()
    {
        setText("Date");
        setFont(AVERTA(1, 11*UNIT));
        setFill(GRAY(1));
        setTextAlignment(TextAlignment.LEFT);
        setTextOrigin(VPos.CENTER);
        setLayoutX(15*UNIT); setLayoutY(10*UNIT);
    }
}