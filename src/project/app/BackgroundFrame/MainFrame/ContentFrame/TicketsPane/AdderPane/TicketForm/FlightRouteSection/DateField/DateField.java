package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.DateField;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.DateField.DateDisplay.DateDisplay;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.DateField.DateFieldBackground.DateFieldBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.DateField.DateFieldTitle.DateFieldTitle;

import static project.app.Utilities.SizeUtils.UNIT;

public class DateField extends Pane
{
    public DateFieldTitle DateFieldTitle_var;
    public DateFieldBackground DateFieldBackground_var;
    public DateDisplay DateDisplay_var;

    public DateField()
    {
        DateFieldTitle_var=new DateFieldTitle();
        DateFieldBackground_var=new DateFieldBackground();
        DateDisplay_var=new DateDisplay();

        setLayoutX(300*UNIT); setLayoutY(90*UNIT);
        setPrefSize(140*UNIT, 50*UNIT);
        getChildren().addAll(DateFieldTitle_var, DateFieldBackground_var, DateDisplay_var);
    }
}