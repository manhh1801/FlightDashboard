package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FromField;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FromField.FromFieldBackground.FromFieldBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FromField.FromPicker.FromPicker;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FromField.FromText.FromText;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FromField.StateButtonFrame.StateButtonFrame;

import static project.app.Utilities.SizeUtils.UNIT;

public class FromField extends Pane
{
    public SimpleBooleanProperty FocusState;
    public SimpleIntegerProperty FromLocation;

    public FromFieldBackground FromFieldBackground_var;
    public FromText FromText_var;
    public StateButtonFrame StateButtonFrame_var;
    public FromPicker FromPicker_var;

    public FromField()
    {
        FromFieldBackground_var=new FromFieldBackground();
        FromText_var=new FromText();
        StateButtonFrame_var=new StateButtonFrame();
        FromPicker_var=new FromPicker();

        FromFieldBackground_var.Height.bindBidirectional(FromPicker_var.Height);

        setLayoutX(0); setLayoutY(40*UNIT);
        setPrefSize(210*UNIT, 40*UNIT);
        getChildren().addAll(FromFieldBackground_var, FromText_var, StateButtonFrame_var, FromPicker_var);

        FocusState=new SimpleBooleanProperty(false);
        FocusState.bindBidirectional(FromFieldBackground_var.FocusState);
        FocusState.bindBidirectional(FromText_var.FocusState);
        FocusState.bindBidirectional(StateButtonFrame_var.FocusState);
        FocusState.bindBidirectional(FromPicker_var.FocusState);
        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    FocusState.set(!FocusState.get());
                }
            }
        );

        FromLocation=new SimpleIntegerProperty(0);
        FromLocation.bindBidirectional(FromPicker_var.LocationContainer_var.FromLocation);
        FromLocation.bindBidirectional(FromText_var.FromLocation);
    }
}