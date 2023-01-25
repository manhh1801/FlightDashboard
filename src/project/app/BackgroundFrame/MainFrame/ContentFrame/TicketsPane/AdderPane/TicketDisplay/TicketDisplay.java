package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayBack.TicketDisplayBack;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFade.TicketDisplayFade;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.TicketDisplayFront;

import static project.app.Utilities.SizeUtils.*;

public class TicketDisplay extends Pane
{
    public SimpleBooleanProperty MousePosState, TicketTypeState;

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

        TicketTypeState=new SimpleBooleanProperty(false);
        TicketTypeState.bindBidirectional(TicketDisplayBack_var.TicketTypeState);
        TicketTypeState.bindBidirectional(TicketDisplayFront_var.TicketTypeState);
        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    TicketTypeState.set(!TicketTypeState.get());
                }
            }
        );

    }
}