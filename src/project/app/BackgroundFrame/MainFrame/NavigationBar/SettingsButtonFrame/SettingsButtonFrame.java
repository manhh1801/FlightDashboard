package project.app.BackgroundFrame.MainFrame.NavigationBar.SettingsButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.NavigationBar.SettingsButtonFrame.SettingsBackground.SettingsBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SettingsButtonFrame.SettingsIcon.SettingsIcon;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SettingsButtonFrame.SettingsIcon.SettingsIcon_Fade;

import static project.app.Utilities.SizeUtils.*;

public class SettingsButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;

    public ExecutorService AnimationThreadPool;

    public SettingsBackground SettingsBackground_var;
    public SettingsIcon SettingsIcon_var;
    public SettingsIcon_Fade SettingsIcon_Fade_var;

    public SettingsButtonFrame()
    {
        SettingsBackground_var=new SettingsBackground();
        SettingsIcon_var=new SettingsIcon();
        SettingsIcon_Fade_var=new SettingsIcon_Fade();

        setLayoutX(10*UNIT); setLayoutY(1010*UNIT);
        setPrefSize(40*UNIT, 40*UNIT);
        getChildren().addAll(SettingsBackground_var, SettingsIcon_var, SettingsIcon_Fade_var);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        SettingsBackground_var.setAnimationThreadPool(AnimationThreadPool);
        SettingsIcon_var.setAnimationThreadPool(AnimationThreadPool);
        SettingsIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(SettingsBackground_var.ExitService.isRunning()==true) {SettingsBackground_var.ExitService.cancel();}
                        if(SettingsIcon_Fade_var.FadeOutService.isRunning()==true) {SettingsIcon_Fade_var.FadeOutService.cancel();}
                        SettingsBackground_var.EnterService.restart();
                        SettingsIcon_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(SettingsBackground_var.EnterService.isRunning()==true) {SettingsBackground_var.ExitService.cancel();}
                        if(SettingsIcon_Fade_var.FadeInService.isRunning()==true) {SettingsIcon_Fade_var.FadeOutService.cancel();}
                        SettingsBackground_var.ExitService.restart();
                        SettingsIcon_Fade_var.FadeOutService.restart();
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

        ClickState=new SimpleBooleanProperty(false);
        ClickState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(ClickState.get()==true)
                    {
                        if(SettingsIcon_var.ClickOffService.isRunning()==true) {SettingsIcon_var.ClickOffService.cancel();}
                        if(SettingsIcon_Fade_var.ClickOffService.isRunning()==true) {SettingsIcon_Fade_var.ClickOffService.cancel();}
                        SettingsIcon_var.ClickOnService.restart();
                        SettingsIcon_Fade_var.ClickOnService.restart();
                    }
                    else
                    {
                        if(SettingsIcon_var.ClickOnService.isRunning()==true) {SettingsIcon_var.ClickOnService.cancel();}
                        if(SettingsIcon_Fade_var.ClickOnService.isRunning()==true) {SettingsIcon_Fade_var.ClickOnService.cancel();}
                        SettingsIcon_var.ClickOffService.restart();
                        SettingsIcon_Fade_var.ClickOffService.restart();
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
}