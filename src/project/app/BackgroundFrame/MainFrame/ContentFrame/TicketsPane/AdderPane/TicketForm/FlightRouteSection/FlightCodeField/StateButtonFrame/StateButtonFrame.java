package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField.StateButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField.StateButtonFrame.StateIcon.StateIcon;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField.StateButtonFrame.StateIcon.StateIcon_Fade;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.UNIT;

public class StateButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, FocusState;

    public ExecutorService AnimationThreadPool;

    public StateIcon StateIcon_var;
    public StateIcon_Fade StateIcon_Fade_var;

    public StateButtonFrame()
    {
        StateIcon_var=new StateIcon();
        StateIcon_Fade_var=new StateIcon_Fade();

        setLayoutX(90*UNIT); setLayoutY(10*UNIT);
        setPrefSize(20*UNIT, 20*UNIT);
        getChildren().addAll(StateIcon_var, StateIcon_Fade_var);

        AnimationThreadPool=Executors.newFixedThreadPool(3);
        StateIcon_var.setAnimationThreadPool(AnimationThreadPool);
        StateIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        if(StateIcon_Fade_var.FadeOutService.isRunning()==true) {StateIcon_Fade_var.FadeOutService.cancel();}
                        StateIcon_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(StateIcon_Fade_var.FadeInService.isRunning()==true) {StateIcon_Fade_var.FadeOutService.cancel();}
                        StateIcon_Fade_var.FadeOutService.restart();
                    }
                }
            }
        );
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

        FocusState =new SimpleBooleanProperty(false);
        FocusState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        if(StateIcon_var.FocusOffService.isRunning()==true) {StateIcon_var.FocusOffService.cancel();}
                        if(StateIcon_Fade_var.FocusOffService.isRunning()==true) {StateIcon_Fade_var.FocusOffService.cancel();}
                        StateIcon_var.FocusOnService.restart();
                        StateIcon_Fade_var.FocusOnService.restart();
                    }
                    else
                    {
                        if(StateIcon_var.FocusOnService.isRunning()==true) {StateIcon_var.FocusOnService.cancel();}
                        if(StateIcon_Fade_var.FocusOnService.isRunning()==true) {StateIcon_Fade_var.FocusOnService.cancel();}
                        StateIcon_var.FocusOffService.restart();
                        StateIcon_Fade_var.FocusOffService.restart();
                    }
                }
            }
        );
    }
}