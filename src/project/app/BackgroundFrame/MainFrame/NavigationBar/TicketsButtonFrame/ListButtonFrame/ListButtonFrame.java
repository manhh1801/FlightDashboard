package project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.ListButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.ListButtonFrame.ListBackground.ListBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.ListButtonFrame.ListIcon.ListIcon;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.ListButtonFrame.ListIcon.ListIcon_Fade;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.UNIT;

public class ListButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;

    public ExecutorService AnimationThreadPool;

    public FadeTransitionService FadeInService, FadeOutService;

    public ListBackground ListBackground_var;
    public ListIcon ListIcon_var;
    public ListIcon_Fade ListIcon_Fade_var;

    public ListButtonFrame()
    {
        FadeInService=new FadeTransitionService(Duration.millis(300), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(300), this, 1, 0);

        ListBackground_var =new ListBackground();
        ListIcon_var =new ListIcon();
        ListIcon_Fade_var =new ListIcon_Fade();

        setLayoutX(10*UNIT);
        setPrefSize(40*UNIT, 40*UNIT);
        getChildren().addAll(ListBackground_var, ListIcon_var, ListIcon_Fade_var);
        setOpacity(0);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        ListBackground_var.setAnimationThreadPool(AnimationThreadPool);
        ListIcon_var.setAnimationThreadPool(AnimationThreadPool);
        ListIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(ListBackground_var.ExitService.isRunning()==true) {ListBackground_var.ExitService.cancel();}
                        if(ListIcon_Fade_var.FadeOutService.isRunning()==true) {ListIcon_Fade_var.FadeOutService.cancel();}
                        ListBackground_var.EnterService.restart();
                        ListIcon_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(ListBackground_var.EnterService.isRunning()==true) {ListBackground_var.ExitService.cancel();}
                        if(ListIcon_Fade_var.FadeInService.isRunning()==true) {ListIcon_Fade_var.FadeOutService.cancel();}
                        ListBackground_var.ExitService.restart();
                        ListIcon_Fade_var.FadeOutService.restart();
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
                        if(ListIcon_var.ClickOffService.isRunning()==true) {ListIcon_var.ClickOffService.cancel();}
                        if(ListIcon_Fade_var.ClickOffService.isRunning()==true) {ListIcon_Fade_var.ClickOffService.cancel();}
                        ListIcon_var.ClickOnService.restart();
                        ListIcon_Fade_var.ClickOnService.restart();
                    }
                    else
                    {
                        if(ListIcon_var.ClickOnService.isRunning()==true) {ListIcon_var.ClickOnService.cancel();}
                        if(ListIcon_Fade_var.ClickOnService.isRunning()==true) {ListIcon_Fade_var.ClickOnService.cancel();}
                        ListIcon_var.ClickOffService.restart();
                        ListIcon_Fade_var.ClickOffService.restart();
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