package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField.StateButtonFrame.StateButtonFrame;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField.FlightCodeFieldBackground.FlightCodeFieldBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField.FlightCodePicker.FlightCodePicker;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField.FlightCodeText.FlightCodeText;

import static project.app.Utilities.SizeUtils.UNIT;

public class FlightCodeField extends Pane
{
    public SimpleBooleanProperty FocusState;
    public SimpleIntegerProperty FromLocation, ToLocation;
    public SimpleStringProperty FlightCode;

    public FlightCodeFieldBackground FlightCodeFieldBackground_var;
    public FlightCodeText FlightCodeText_var;
    public StateButtonFrame StateButtonFrame_var;
    public FlightCodePicker FlightCodePicker_var;

    public FlightCodeField()
    {
        FlightCodeFieldBackground_var =new FlightCodeFieldBackground();
        FlightCodeText_var =new FlightCodeText();
        StateButtonFrame_var=new StateButtonFrame();
        FlightCodePicker_var =new FlightCodePicker();

        setLayoutX(0); setLayoutY(100*UNIT);
        setPrefSize(140*UNIT, 40*UNIT);
        getChildren().addAll(FlightCodeFieldBackground_var, FlightCodeText_var, StateButtonFrame_var, FlightCodePicker_var);

        FlightCodeFieldBackground_var.Height.bindBidirectional(FlightCodePicker_var.Height);

        FocusState=new SimpleBooleanProperty(false);
        FocusState.bindBidirectional(FlightCodeFieldBackground_var.FocusState);
        FocusState.bindBidirectional(FlightCodeText_var.FocusState);
        FocusState.bindBidirectional(StateButtonFrame_var.FocusState);
        FocusState.bindBidirectional(FlightCodePicker_var.FocusState);
        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    if(FromLocation.get()!=0&&ToLocation.get()!=0) {FocusState.set(!FocusState.get());}
                }
            }
        );

        FromLocation=new SimpleIntegerProperty(0);
        FromLocation.bindBidirectional(FlightCodePicker_var.FromLocation);
        ToLocation=new SimpleIntegerProperty(0);
        ToLocation.bindBidirectional(FlightCodePicker_var.ToLocation);
        FlightCode=new SimpleStringProperty("--");
        FlightCode.bindBidirectional(FlightCodePicker_var.FlightContainer_var.FlightCode);
        FlightCode.bindBidirectional(FlightCodeText_var.FlightCode);
    }
}