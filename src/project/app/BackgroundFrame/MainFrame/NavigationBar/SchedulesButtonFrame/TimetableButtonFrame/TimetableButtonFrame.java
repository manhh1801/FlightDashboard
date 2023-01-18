package project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.TimetableButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javafx.util.Duration;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.TimetableButtonFrame.TimetableBackground.TimetableBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.TimetableButtonFrame.TimetableIcon.TimetableIcon;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.TimetableButtonFrame.TimetableIcon.TimetableIcon_Fade;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import static project.app.Utilities.SizeUtils.*;

public class TimetableButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;

    public ExecutorService AnimationThreadPool;

    public FadeTransitionService FadeInService, FadeOutService;

    public TimetableBackground TimetableBackground_var;
    public TimetableIcon TimetableIcon_var;
    public TimetableIcon_Fade TimetableIcon_Fade_var;

    public TimetableButtonFrame()
    {
        FadeInService=new FadeTransitionService(Duration.millis(300), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(300), this, 1, 0);

        TimetableBackground_var=new TimetableBackground();
        TimetableIcon_var=new TimetableIcon();
        TimetableIcon_Fade_var=new TimetableIcon_Fade();

        setLayoutX(10*UNIT);
        setPrefSize(40*UNIT, 40*UNIT);
        getChildren().addAll(TimetableBackground_var, TimetableIcon_var, TimetableIcon_Fade_var);
        setOpacity(0);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        TimetableBackground_var.setAnimationThreadPool(AnimationThreadPool);
        TimetableIcon_var.setAnimationThreadPool(AnimationThreadPool);
        TimetableIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(TimetableBackground_var.ExitService.isRunning()==true) {TimetableBackground_var.ExitService.cancel();}
                        if(TimetableIcon_Fade_var.FadeOutService.isRunning()==true) {TimetableIcon_Fade_var.FadeOutService.cancel();}
                        TimetableBackground_var.EnterService.restart();
                        TimetableIcon_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(TimetableBackground_var.EnterService.isRunning()==true) {TimetableBackground_var.ExitService.cancel();}
                        if(TimetableIcon_Fade_var.FadeInService.isRunning()==true) {TimetableIcon_Fade_var.FadeOutService.cancel();}
                        TimetableBackground_var.ExitService.restart();
                        TimetableIcon_Fade_var.FadeOutService.restart();
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

        ClickState=new SimpleBooleanProperty(true);
        ClickState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(ClickState.get()==true)
                    {
                        if(TimetableIcon_var.ClickOffService.isRunning()==true) {TimetableIcon_var.ClickOffService.cancel();}
                        if(TimetableIcon_Fade_var.ClickOffService.isRunning()==true) {TimetableIcon_Fade_var.ClickOffService.cancel();}
                        TimetableIcon_var.ClickOnService.restart();
                        TimetableIcon_Fade_var.ClickOnService.restart();
                    }
                    else
                    {
                        if(TimetableIcon_var.ClickOnService.isRunning()==true) {TimetableIcon_var.ClickOnService.cancel();}
                        if(TimetableIcon_Fade_var.ClickOnService.isRunning()==true) {TimetableIcon_Fade_var.ClickOnService.cancel();}
                        TimetableIcon_var.ClickOffService.restart();
                        TimetableIcon_Fade_var.ClickOffService.restart();
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
                    ClickState.set(!ClickState.get());
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FadeInService.setExecutor(AnimationThreadPool);
        FadeOutService.setExecutor(AnimationThreadPool);
    }
}