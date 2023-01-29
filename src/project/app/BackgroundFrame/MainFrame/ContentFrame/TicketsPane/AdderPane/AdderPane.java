package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplay;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.TicketForm;

import static project.app.Utilities.SizeUtils.*;

public class AdderPane extends Pane
{
    public SimpleBooleanProperty TicketType;
    public SimpleStringProperty CustomerName, PassportID, FlightCode;
    public SimpleIntegerProperty FromLocation, ToLocation;

    public TicketDisplay TicketDisplay_var;
    public TicketForm TicketForm_var;

    public AdderPane()
    {
        TicketDisplay_var=new TicketDisplay();
        TicketForm_var=new TicketForm();

        setLayoutX(980*UNIT); setLayoutY(0);
        setPrefSize(440*UNIT, 960*UNIT);
        getChildren().addAll(TicketDisplay_var, TicketForm_var);

        TicketType=new SimpleBooleanProperty(false);
        TicketType.bindBidirectional(TicketDisplay_var.TicketType);
        TicketType.bindBidirectional(TicketForm_var.TicketType);

        CustomerName=new SimpleStringProperty("");
        CustomerName.bindBidirectional(TicketDisplay_var.CustomerName);
        CustomerName.bindBidirectional(TicketForm_var.CustomerName);
        PassportID=new SimpleStringProperty("");
        PassportID.bindBidirectional(TicketDisplay_var.PassportID);
        PassportID.bindBidirectional(TicketForm_var.PassportID);
        FlightCode=new SimpleStringProperty("--");
        FlightCode.bindBidirectional(TicketDisplay_var.FlightCode);
        FlightCode.bindBidirectional(TicketForm_var.FlightCode);
        FromLocation=new SimpleIntegerProperty(0);
        FromLocation.bindBidirectional(TicketDisplay_var.FromLocation);
        FromLocation.bindBidirectional(TicketForm_var.FromLocation);
        ToLocation=new SimpleIntegerProperty(0);
        ToLocation.bindBidirectional(TicketDisplay_var.ToLocation);
        ToLocation.bindBidirectional(TicketForm_var.ToLocation);
    }
}