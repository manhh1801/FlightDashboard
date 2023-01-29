package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.ToField;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.ToField.ToFieldBackground.ToFieldBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.ToField.ToPicker.ToPicker;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.ToField.ToText.ToText;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.ToField.StateButtonFrame.StateButtonFrame;

import static project.app.Utilities.SizeUtils.UNIT;

public class ToField extends Pane
{
    public SimpleBooleanProperty FocusState;
    public SimpleIntegerProperty FromLocation, ToLocation;

    public ToFieldBackground ToFieldBackground_var;
    public ToText ToText_var;
    public StateButtonFrame StateButtonFrame_var;
    public ToPicker ToPicker_var;

    public ToField()
    {
        ToFieldBackground_var=new ToFieldBackground();
        ToText_var=new ToText();
        StateButtonFrame_var=new StateButtonFrame();
        ToPicker_var=new ToPicker();

        setLayoutX(230*UNIT); setLayoutY(40*UNIT);
        setPrefSize(210*UNIT, 40*UNIT);
        getChildren().addAll(ToFieldBackground_var, ToText_var, StateButtonFrame_var, ToPicker_var);

        ToFieldBackground_var.Height.bindBidirectional(ToPicker_var.Height);

        FocusState=new SimpleBooleanProperty(false);
        FocusState.bindBidirectional(ToFieldBackground_var.FocusState);
        FocusState.bindBidirectional(ToText_var.FocusState);
        FocusState.bindBidirectional(StateButtonFrame_var.FocusState);
        FocusState.bindBidirectional(ToPicker_var.FocusState);
        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    if(FromLocation.get()!=0) {FocusState.set(!FocusState.get());}
                }
            }
        );

        FromLocation=new SimpleIntegerProperty(0);
        FromLocation.bindBidirectional(ToPicker_var.FromLocation);
        ToLocation=new SimpleIntegerProperty(0);
        ToLocation.bindBidirectional(ToPicker_var.LocationContainer_var.ToLocation);
        ToLocation.bindBidirectional(ToText_var.ToLocation);
    }
}