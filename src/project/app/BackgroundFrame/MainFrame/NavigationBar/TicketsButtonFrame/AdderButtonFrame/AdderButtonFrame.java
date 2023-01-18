package project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.AdderButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.AdderButtonFrame.AdderBackground.AdderBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.AdderButtonFrame.AdderIcon.AdderIcon;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.AdderButtonFrame.AdderIcon.AdderIcon_Fade;

import project.app.Utilities.AnimationUtils.FadeTransitionService;
import static project.app.Utilities.SizeUtils.UNIT;

public class AdderButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;

    public ExecutorService AnimationThreadPool;

    public FadeTransitionService FadeInService, FadeOutService;

    public AdderBackground AdderBackground_var;
    public AdderIcon AdderIcon_var;
    public AdderIcon_Fade AdderIcon_Fade_var;

    public AdderButtonFrame()
    {
        FadeInService=new FadeTransitionService(Duration.millis(300), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(300), this, 1, 0);

        AdderBackground_var =new AdderBackground();
        AdderIcon_var =new AdderIcon();
        AdderIcon_Fade_var =new AdderIcon_Fade();

        setLayoutX(10*UNIT);
        setPrefSize(40*UNIT, 40*UNIT);
        getChildren().addAll(AdderBackground_var, AdderIcon_var, AdderIcon_Fade_var);
        setOpacity(0);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        AdderBackground_var.setAnimationThreadPool(AnimationThreadPool);
        AdderIcon_var.setAnimationThreadPool(AnimationThreadPool);
        AdderIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(AdderBackground_var.ExitService.isRunning()==true) {AdderBackground_var.ExitService.cancel();}
                        if(AdderIcon_Fade_var.FadeOutService.isRunning()==true) {AdderIcon_Fade_var.FadeOutService.cancel();}
                        AdderBackground_var.EnterService.restart();
                        AdderIcon_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(AdderBackground_var.EnterService.isRunning()==true) {AdderBackground_var.ExitService.cancel();}
                        if(AdderIcon_Fade_var.FadeInService.isRunning()==true) {AdderIcon_Fade_var.FadeOutService.cancel();}
                        AdderBackground_var.ExitService.restart();
                        AdderIcon_Fade_var.FadeOutService.restart();
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
                        if(AdderIcon_var.ClickOffService.isRunning()==true) {AdderIcon_var.ClickOffService.cancel();}
                        if(AdderIcon_Fade_var.ClickOffService.isRunning()==true) {AdderIcon_Fade_var.ClickOffService.cancel();}
                        AdderIcon_var.ClickOnService.restart();
                        AdderIcon_Fade_var.ClickOnService.restart();
                    }
                    else
                    {
                        if(AdderIcon_var.ClickOnService.isRunning()==true) {AdderIcon_var.ClickOnService.cancel();}
                        if(AdderIcon_Fade_var.ClickOnService.isRunning()==true) {AdderIcon_Fade_var.ClickOnService.cancel();}
                        AdderIcon_var.ClickOffService.restart();
                        AdderIcon_Fade_var.ClickOffService.restart();
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