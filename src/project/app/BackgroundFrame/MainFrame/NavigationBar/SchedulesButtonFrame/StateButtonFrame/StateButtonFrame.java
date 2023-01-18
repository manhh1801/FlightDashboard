package project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.StateButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.StateButtonFrame.StateBackground.StateBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.StateButtonFrame.StateIcon.StateIcon;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.StateButtonFrame.StateIcon.StateIcon_Fade;

import static project.app.Utilities.SizeUtils.*;

public class StateButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, SizeState;

    public ExecutorService AnimationThreadPool;

    public StateBackground StateBackground_var;
    public StateIcon StateIcon_var;
    public StateIcon_Fade StateIcon_Fade_var;

    public StateButtonFrame()
    {

        StateBackground_var=new StateBackground();
        StateIcon_var=new StateIcon();
        StateIcon_Fade_var=new StateIcon_Fade();

        setLayoutX(10*UNIT);
        setPrefSize(40*UNIT, 30*UNIT);
        getChildren().addAll(StateBackground_var, StateIcon_var, StateIcon_Fade_var);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        StateBackground_var.setAnimationThreadPool(AnimationThreadPool);
        StateIcon_var.setAnimationThreadPool(AnimationThreadPool);
        StateIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(StateBackground_var.ExitService.isRunning()==true) {StateBackground_var.ExitService.cancel();}
                        if(StateIcon_Fade_var.FadeOutService.isRunning()==true) {StateIcon_Fade_var.FadeOutService.cancel();}
                        StateBackground_var.EnterService.restart();
                        StateIcon_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(StateBackground_var.EnterService.isRunning()==true) {StateBackground_var.ExitService.cancel();}
                        if(StateIcon_Fade_var.FadeInService.isRunning()==true) {StateIcon_Fade_var.FadeOutService.cancel();}
                        StateBackground_var.ExitService.restart();
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

        SizeState=new SimpleBooleanProperty(false);
        SizeState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(SizeState.get()==true)
                    {
                        if(StateIcon_var.ClickOffService.isRunning()==true) {StateIcon_var.ClickOffService.cancel();}
                        if(StateIcon_Fade_var.ClickOffService.isRunning()==true) {StateIcon_Fade_var.ClickOffService.cancel();}
                        StateIcon_var.ClickOnService.restart();
                        StateIcon_Fade_var.ClickOnService.restart();
                    }
                    else
                    {
                        if(StateIcon_var.ClickOnService.isRunning()==true) {StateIcon_var.ClickOnService.cancel();}
                        if(StateIcon_Fade_var.ClickOnService.isRunning()==true) {StateIcon_Fade_var.ClickOnService.cancel();}
                        StateIcon_var.ClickOffService.restart();
                        StateIcon_Fade_var.ClickOffService.restart();
                    }
                }
            }
        );
        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    SizeState.set(!SizeState.get());
                }
            }
        );
    }
}