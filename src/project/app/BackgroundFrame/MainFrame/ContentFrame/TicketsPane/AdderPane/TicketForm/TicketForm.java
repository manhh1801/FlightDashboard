package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.AddButtonFrame.AddButtonFrame;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DetailTitle.DetailTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightRouteSection;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PISection;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.PricingSection;

import static project.app.Utilities.SizeUtils.*;

public class TicketForm extends Pane
{
    public SimpleBooleanProperty ModeState;
    public SimpleBooleanProperty TicketType;
    public SimpleStringProperty CustomerName, PassportID, FlightCode;
    public SimpleIntegerProperty FromLocation, ToLocation, BaseCost, ServiceFee;

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
        getChildren().addAll(DetailTitle_var, AddButtonFrame_var, PISection_var, PricingSection_var, FlightRouteSection_var);

        ModeState=new SimpleBooleanProperty(false);
        ModeState.bindBidirectional(FlightRouteSection_var.FromField_var.FromPicker_var.ModeState);
        ModeState.bindBidirectional(FlightRouteSection_var.ToField_var.ToPicker_var.ModeState);

        TicketType=new SimpleBooleanProperty(false);
        TicketType.bindBidirectional(PricingSection_var.TicketType);

        CustomerName=new SimpleStringProperty("");
        CustomerName.bindBidirectional(PISection_var.NameField_var.CustomerName);
        PassportID=new SimpleStringProperty("");
        PassportID.bindBidirectional(PISection_var.PassportIDField_var.PassportID);
        FromLocation=new SimpleIntegerProperty(0);
        FromLocation.bindBidirectional(FlightRouteSection_var.FromField_var.FromLocation);
        FromLocation.bindBidirectional(FlightRouteSection_var.ToField_var.FromLocation);
        FromLocation.bindBidirectional(FlightRouteSection_var.FlightCodeField_var.FromLocation);
        FromLocation.bindBidirectional(PricingSection_var.PriceCounter_var.FromLocation);
        ToLocation=new SimpleIntegerProperty(0);
        ToLocation.bindBidirectional(FlightRouteSection_var.ToField_var.ToLocation);
        ToLocation.bindBidirectional(PricingSection_var.PriceCounter_var.ToLocation);
        ToLocation.bindBidirectional(FlightRouteSection_var.FlightCodeField_var.ToLocation);
        FlightCode=new SimpleStringProperty("--");
        FlightCode.bindBidirectional(FlightRouteSection_var.TimeField_var.TimeDisplay_var.FlightCode);
        FlightCode.bindBidirectional(FlightRouteSection_var.DateField_var.DateDisplay_var.FlightCode);
        FlightCode.bindBidirectional(FlightRouteSection_var.FlightCodeField_var.FlightCode);
        BaseCost=new SimpleIntegerProperty(20000);
        BaseCost.bindBidirectional(PricingSection_var.BaseCostField_var.BaseCost);
        BaseCost.bindBidirectional(PricingSection_var.PriceCounter_var.BaseCost);
        ServiceFee=new SimpleIntegerProperty(0);
        ServiceFee.bindBidirectional(PricingSection_var.ServiceFeeField_var.ServiceFee);
        ServiceFee.bindBidirectional(PricingSection_var.PriceCounter_var.ServiceFee);
    }
}