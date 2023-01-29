package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.DateField.DateDisplay;

import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import static project.app.Utilities.ColorUtils.GRAY;
import static project.app.Utilities.DatabaseUtils.DatabaseUtils.getDepartureTime;
import static project.app.Utilities.FontUtils.AVERTA;
import static project.app.Utilities.SizeUtils.UNIT;
import static project.app.Utilities.TimeUtils.*;

public class DateDisplay extends Text
{
    public SimpleStringProperty FlightCode;

    public DateDisplay()
    {
        setText("");
        setFont(AVERTA(0, 13*UNIT));
        setFill(GRAY(1));
        setTextAlignment(TextAlignment.LEFT);
        setTextOrigin(VPos.CENTER);
        setLayoutX(15*UNIT); setLayoutY(30*UNIT);

        FlightCode=new SimpleStringProperty("");
        FlightCode.addListener
        (
            new ChangeListener<String>()
            {
                public void changed(ObservableValue<? extends String> observableValue, String OldValue, String NewValue)
                {
                    long DepartureTime=getDepartureTime(NewValue);
                    if(DepartureTime!=0) {setText(renderDate(LocalDateTime.ofInstant(Instant.ofEpochMilli(DepartureTime), TimeZone.getDefault().toZoneId())));}
                    else {setText("");}
                }
            }
        );
    }
}