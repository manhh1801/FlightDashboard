package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightRouteSectionTitle.FlightRouteSectionTitle;

import static project.app.Utilities.SizeUtils.UNIT;

public class FlightRouteSection extends Pane
{
    public FlightRouteSectionTitle FlightRouteSectionTitle_var;

    public FlightRouteSection()
    {
        FlightRouteSectionTitle_var=new FlightRouteSectionTitle();

        setLayoutX(0); setLayoutY(200*UNIT);
        setPrefSize(440*UNIT, 140*UNIT);
        getChildren().addAll(FlightRouteSectionTitle_var);
    }
}