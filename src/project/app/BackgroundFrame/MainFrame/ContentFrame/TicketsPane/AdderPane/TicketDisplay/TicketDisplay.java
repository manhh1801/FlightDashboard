package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayBack.TicketDisplayBack;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFade.TicketDisplayFade;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.TicketDisplayFront;

import static project.app.Utilities.SizeUtils.*;

public class TicketDisplay extends Pane
{
    public SimpleBooleanProperty MousePosState;

    public SimpleBooleanProperty TicketType;

    public SimpleStringProperty CustomerName, PassportID, FlightCode;
    public SimpleIntegerProperty FromLocation, ToLocation;

    public TicketDisplayFade TicketDisplayFade_var;
    public TicketDisplayBack TicketDisplayBack_var;
    public TicketDisplayFront TicketDisplayFront_var;

    public TicketDisplay()
    {
        TicketDisplayFade_var=new TicketDisplayFade();
        TicketDisplayBack_var=new TicketDisplayBack();
        TicketDisplayFront_var=new TicketDisplayFront();

        setLayoutX(0); setLayoutY(0);
        setPrefSize(440*UNIT, 280*UNIT);
        getChildren().addAll(TicketDisplayFade_var, TicketDisplayBack_var, TicketDisplayFront_var);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.bindBidirectional(TicketDisplayFade_var.MousePosState);
        MousePosState.bindBidirectional(TicketDisplayBack_var.MousePosState);
        MousePosState.bindBidirectional(TicketDisplayFront_var.MousePosState);
        setOnMouseEntered
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                            {
                                MousePosState.set(true);
                            }
            }
        );
        setOnMouseExited
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                            {
                                MousePosState.set(false);
                            }
            }
        );

        TicketType=new SimpleBooleanProperty(false);
        TicketType.bindBidirectional(TicketDisplayBack_var.TicketType);
        TicketType.bindBidirectional(TicketDisplayFront_var.TicketType);
        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    TicketType.set(!TicketType.get());
                }
            }
        );

        CustomerName=new SimpleStringProperty("");
        CustomerName.bindBidirectional(TicketDisplayFront_var.NameContent_var.CustomerName);
        PassportID=new SimpleStringProperty("");
        PassportID.bindBidirectional(TicketDisplayFront_var.PassportIDContent_var.PassportID);
        FlightCode=new SimpleStringProperty("--");
        FlightCode.bindBidirectional(TicketDisplayFront_var.FlightContent_var.FlightCode);
        FlightCode.bindBidirectional(TicketDisplayFront_var.DepartureTimeContent_var.FlightCode);
        FromLocation=new SimpleIntegerProperty(0);
        FromLocation.bindBidirectional(TicketDisplayFront_var.FromContent_var.FromLocation);
        ToLocation=new SimpleIntegerProperty(0);
        ToLocation.bindBidirectional(TicketDisplayFront_var.ToContent_var.ToLocation);
    }
}