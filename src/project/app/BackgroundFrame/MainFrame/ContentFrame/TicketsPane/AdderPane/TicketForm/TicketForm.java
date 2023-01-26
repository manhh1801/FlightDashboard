package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.AddButtonFrame.AddButtonFrame;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DetailTitle.DetailTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightRouteSection;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PISection;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.PricingSection;

import static project.app.Utilities.SizeUtils.*;

public class TicketForm extends Pane
{
    public DetailTitle DetailTitle_var;
    public AddButtonFrame AddButtonFrame_var;
    public PISection PISection_var;
    public FlightRouteSection FlightRouteSection_var;
    public PricingSection PricingSection_var;

    public TicketForm()
    {
        DetailTitle_var=new DetailTitle();
        AddButtonFrame_var=new AddButtonFrame();
        PISection_var=new PISection();
        FlightRouteSection_var=new FlightRouteSection();
        PricingSection_var=new PricingSection();

        setLayoutX(0); setLayoutY(320*UNIT);
        setPrefSize(440*UNIT, 960*UNIT);
        getChildren().addAll(DetailTitle_var, AddButtonFrame_var, PISection_var, FlightRouteSection_var, PricingSection_var);
    }
}