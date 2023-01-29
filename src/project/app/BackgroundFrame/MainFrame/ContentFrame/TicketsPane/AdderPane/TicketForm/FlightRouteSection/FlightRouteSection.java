package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.DateField.DateField;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField.FlightCodeField;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightRouteSectionTitle.FlightRouteSectionTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FromField.FromField;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.TimeField.TimeField;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.ToField.ToField;

import static project.app.Utilities.SizeUtils.UNIT;

public class FlightRouteSection extends Pane
{
    public FlightRouteSectionTitle FlightRouteSectionTitle_var;

    public TimeField TimeField_var;
    public DateField DateField_var;
    public FlightCodeField FlightCodeField_var;
    public FromField FromField_var;
    public ToField ToField_var;

    public FlightRouteSection()
    {
        FlightRouteSectionTitle_var=new FlightRouteSectionTitle();
        TimeField_var=new TimeField();
        DateField_var=new DateField();
        FlightCodeField_var=new FlightCodeField();
        FromField_var=new FromField();
        ToField_var=new ToField();

        setLayoutX(0); setLayoutY(200*UNIT);
        setPrefSize(440*UNIT, 140*UNIT);
        getChildren().addAll(FlightRouteSectionTitle_var, TimeField_var, DateField_var, FlightCodeField_var, FromField_var, ToField_var);
    }
}