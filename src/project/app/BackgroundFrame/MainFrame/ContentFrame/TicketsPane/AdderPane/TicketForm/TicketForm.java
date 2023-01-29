package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.AddButtonFrame.AddButtonFrame;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DepositButtonFrame.DepositButtonFrame;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DetailTitle.DetailTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightRouteSection;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PISection;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PopUp.PopUp;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.PricingSection;

import static project.app.Utilities.DatabaseUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class TicketForm extends Pane
{
    public SimpleBooleanProperty EditState;
    public SimpleIntegerProperty PopUpState;

    public SimpleBooleanProperty ModeState;
    public SimpleBooleanProperty TicketType;

    public SimpleLongProperty ID;
    public SimpleStringProperty CustomerName, PassportID, FlightCode;
    public SimpleIntegerProperty FromLocation, ToLocation, BaseCost, ServiceFee;

    public DetailTitle DetailTitle_var;
    public AddButtonFrame AddButtonFrame_var;
    public PISection PISection_var;
    public FlightRouteSection FlightRouteSection_var;
    public PricingSection PricingSection_var;
    public DepositButtonFrame DepositButtonFrame_var;
    public PopUp PopUp_var;

    public TicketForm()
    {
        DetailTitle_var=new DetailTitle();
        AddButtonFrame_var=new AddButtonFrame();
        PISection_var=new PISection();
        FlightRouteSection_var=new FlightRouteSection();
        PricingSection_var=new PricingSection();
        DepositButtonFrame_var=new DepositButtonFrame();
        PopUp_var=new PopUp();

        setLayoutX(0); setLayoutY(320*UNIT);
        setPrefSize(440*UNIT, 960*UNIT);
        getChildren().addAll(DetailTitle_var, AddButtonFrame_var, PISection_var, PricingSection_var, FlightRouteSection_var, DepositButtonFrame_var, PopUp_var);

        EditState=new SimpleBooleanProperty(false);
        PopUpState=new SimpleIntegerProperty(0);
        PopUpState.bindBidirectional(PopUp_var.PopUpState);

        ModeState=new SimpleBooleanProperty(false);
        ModeState.bindBidirectional(FlightRouteSection_var.FromField_var.FromPicker_var.ModeState);
        ModeState.bindBidirectional(FlightRouteSection_var.ToField_var.ToPicker_var.ModeState);
        TicketType=new SimpleBooleanProperty(false);
        TicketType.bindBidirectional(PricingSection_var.TicketType);

        ID=new SimpleLongProperty(0L);
        ID.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldValue, Number NewValue)
                {
                    PopUpState.set(0);
                    long NewID=NewValue.longValue();
                    if(NewID!=0L)
                    {
                        EditState.set(true);

                        PISection_var.NameField_var.NameTypeField_var.setText(getTicketCustomerName(NewID));
                        PISection_var.PassportIDField_var.PassportIDTypeField_var.setText(getTicketPassportID(NewID));
                        String Flight=getTicketFlightCode(NewID);
                        FromLocation.set(getFlightFromLocation(Flight));
                        ToLocation.set(getFlightToLocation(Flight));
                        FlightCode.set(Flight);
                        PricingSection_var.BaseCostField_var.BaseCostTypeField_var.setText(String.valueOf(getTicketBaseCost(NewID)));
                        PricingSection_var.ServiceFeeField_var.ServiceFeeTypeField_var.setText(String.valueOf(getTicketServiceFee(NewID)));
                    }
                    else
                    {
                        EditState.set(false);

                        PISection_var.NameField_var.NameTypeField_var.setText("");
                        PISection_var.PassportIDField_var.PassportIDTypeField_var.setText("");
                        FromLocation.set(0);
                        if(TicketType.get()==true)
                        {
                            PricingSection_var.BaseCostField_var.BaseCostTypeField_var.setText("30000");
                            PricingSection_var.ServiceFeeField_var.ServiceFeeTypeField_var.setText("1000000");
                        }
                        else
                        {
                            PricingSection_var.BaseCostField_var.BaseCostTypeField_var.setText("20000");
                            PricingSection_var.ServiceFeeField_var.ServiceFeeTypeField_var.setText("");
                        }
                    }
                }
            }
        );

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

        AddButtonFrame_var.setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    ID.set(0L);
                }
            }
        );

        DepositButtonFrame_var.setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    if(CustomerName.get()==""||PassportID.get()==""||FromLocation.get()==0||ToLocation.get()==0||FlightCode.get()=="--")
                    {
                        PopUpState.set(1);
                        return;
                    }
                    else if(getFlightAvailability(FlightCode.get())==false)
                    {
                        PopUpState.set(2);
                        return;
                    }

                    boolean Flag=false;
                    if(EditState.get()==false) {Flag=insertTicket(CustomerName.get(), PassportID.get(), TicketType.get(), FlightCode.get(), BaseCost.get(), ServiceFee.get());}
                    else {Flag=updateTicket(ID.get(), CustomerName.get(), PassportID.get(), TicketType.get(), FlightCode.get(), BaseCost.get(), ServiceFee.get());}
                    if(Flag==true)
                    {
                        PopUpState.set(4);
                        return;
                    }
                    else
                    {
                        PopUpState.set(3);
                        return;
                    }
                }
            }
        );
    }
}