package project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.MapButtonFrame;

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
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.MapButtonFrame.MapBackground.MapBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.MapButtonFrame.MapIcon.MapIcon;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.MapButtonFrame.MapIcon.MapIcon_Fade;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import static project.app.Utilities.SizeUtils.*;

public class MapButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;

    public ExecutorService AnimationThreadPool;

    public FadeTransitionService FadeInService, FadeOutService;

    public MapBackground MapBackground_var;
    public MapIcon MapIcon_var;
    public MapIcon_Fade MapIcon_Fade_var;

    public MapButtonFrame()
    {
        FadeInService=new FadeTransitionService(Duration.millis(300), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(300), this, 1, 0);

        MapBackground_var=new MapBackground();
        MapIcon_var=new MapIcon();
        MapIcon_Fade_var=new MapIcon_Fade();

        setLayoutX(10*UNIT);
        setPrefSize(40*UNIT, 40*UNIT);
        getChildren().addAll(MapBackground_var, MapIcon_var, MapIcon_Fade_var);
        setOpacity(0);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        MapBackground_var.setAnimationThreadPool(AnimationThreadPool);
        MapIcon_var.setAnimationThreadPool(AnimationThreadPool);
        MapIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(MapBackground_var.ExitService.isRunning()==true) {MapBackground_var.ExitService.cancel();}
                        if(MapIcon_Fade_var.FadeOutService.isRunning()==true) {MapIcon_Fade_var.FadeOutService.cancel();}
                        MapBackground_var.EnterService.restart();
                        MapIcon_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(MapBackground_var.EnterService.isRunning()==true) {MapBackground_var.ExitService.cancel();}
                        if(MapIcon_Fade_var.FadeInService.isRunning()==true) {MapIcon_Fade_var.FadeOutService.cancel();}
                        MapBackground_var.ExitService.restart();
                        MapIcon_Fade_var.FadeOutService.restart();
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
                        if(MapIcon_var.ClickOffService.isRunning()==true) {MapIcon_var.ClickOffService.cancel();}
                        if(MapIcon_Fade_var.ClickOffService.isRunning()==true) {MapIcon_Fade_var.ClickOffService.cancel();}
                        MapIcon_var.ClickOnService.restart();
                        MapIcon_Fade_var.ClickOnService.restart();
                    }
                    else
                    {
                        if(MapIcon_var.ClickOnService.isRunning()==true) {MapIcon_var.ClickOnService.cancel();}
                        if(MapIcon_Fade_var.ClickOnService.isRunning()==true) {MapIcon_Fade_var.ClickOnService.cancel();}
                        MapIcon_var.ClickOffService.restart();
                        MapIcon_Fade_var.ClickOffService.restart();
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