package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.TimeField;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.TimeField.TimeDisplay.TimeDisplay;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.TimeField.TimeFieldBackground.TimeFieldBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.TimeField.TimeFieldTitle.TimeFieldTitle;

import static project.app.Utilities.SizeUtils.UNIT;

public class TimeField extends Pane
{
    public TimeFieldTitle TimeFieldTitle_var;
    public TimeFieldBackground TimeFieldBackground_var;
    public TimeDisplay TimeDisplay_var;

    public TimeField()
    {
        TimeFieldTitle_var=new TimeFieldTitle();
        TimeFieldBackground_var=new TimeFieldBackground();
        TimeDisplay_var=new TimeDisplay();

        setLayoutX(160*UNIT); setLayoutY(90*UNIT);
        setPrefSize(120*UNIT, 50*UNIT);
        getChildren().addAll(TimeFieldTitle_var, TimeFieldBackground_var, TimeDisplay_var);
    }
}