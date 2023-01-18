package project.app.BackgroundFrame.MainFrame.NavigationBar.StatisticsButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.NavigationBar.StatisticsButtonFrame.StatisticsBackground.StatisticsBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.StatisticsButtonFrame.StatisticsIcon.StatisticsIcon;
import project.app.BackgroundFrame.MainFrame.NavigationBar.StatisticsButtonFrame.StatisticsIcon.StatisticsIcon_Fade;

import static project.app.Utilities.SizeUtils.UNIT;

public class StatisticsButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;

    public ExecutorService AnimationThreadPool;

    public StatisticsBackground StatisticsBackground_var;
    public StatisticsIcon StatisticsIcon_var;
    public StatisticsIcon_Fade StatisticsIcon_Fade_var;

    public StatisticsButtonFrame()
    {
        StatisticsBackground_var=new StatisticsBackground();
        StatisticsIcon_var=new StatisticsIcon();
        StatisticsIcon_Fade_var=new StatisticsIcon_Fade();

        setPrefSize(40*UNIT, 40*UNIT);
        getChildren().addAll(StatisticsBackground_var, StatisticsIcon_var, StatisticsIcon_Fade_var);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        StatisticsBackground_var.setAnimationThreadPool(AnimationThreadPool);
        StatisticsIcon_var.setAnimationThreadPool(AnimationThreadPool);
        StatisticsIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        final SimpleBooleanProperty LastFlag=new SimpleBooleanProperty(false);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(ClickState.get()==false)
                    {
                        if(MousePosState.get()==true)
                        {
                            if(StatisticsBackground_var.ExitService.isRunning()==true) {StatisticsBackground_var.ExitService.cancel();}
                            if(StatisticsIcon_Fade_var.FadeOutService.isRunning()==true) {StatisticsIcon_Fade_var.FadeOutService.cancel();}
                            StatisticsBackground_var.EnterService.restart();
                            StatisticsIcon_Fade_var.FadeInService.restart();
                        }
                        else
                        {
                            if(StatisticsBackground_var.EnterService.isRunning()==true) {StatisticsBackground_var.ExitService.cancel();}
                            if(StatisticsIcon_Fade_var.FadeInService.isRunning()==true) {StatisticsIcon_Fade_var.FadeOutService.cancel();}
                            StatisticsBackground_var.ExitService.restart();
                            StatisticsIcon_Fade_var.FadeOutService.restart();
                        }
                    }
                    else
                    {
                        if(MousePosState.get()==true)
                        {
                            if(StatisticsIcon_Fade_var.FadeOutService.isRunning()==true) {StatisticsIcon_Fade_var.FadeOutService.cancel();}
                            StatisticsIcon_Fade_var.FadeInService.restart();
                        }
                        else
                        {
                            if(LastFlag.get()==false)
                            {
                                if(StatisticsIcon_Fade_var.FadeInService.isRunning()==true) {StatisticsIcon_Fade_var.FadeOutService.cancel();}
                                StatisticsIcon_Fade_var.FadeOutService.restart();
                            }
                            else
                            {
                                if(StatisticsBackground_var.EnterService.isRunning()==true) {StatisticsBackground_var.ExitService.cancel();}
                                if(StatisticsIcon_Fade_var.FadeInService.isRunning()==true) {StatisticsIcon_Fade_var.FadeOutService.cancel();}
                                StatisticsBackground_var.ExitService.restart();
                                StatisticsIcon_Fade_var.FadeOutService.restart();
                                LastFlag.set(false);
                            }
                        }
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
                        if(StatisticsIcon_var.ClickOffService.isRunning()==true) {StatisticsIcon_var.ClickOffService.cancel();}
                        if(StatisticsIcon_Fade_var.ClickOffService.isRunning()==true) {StatisticsIcon_Fade_var.ClickOffService.cancel();}
                        StatisticsIcon_var.ClickOnService.restart();
                        StatisticsIcon_Fade_var.ClickOnService.restart();
                        LastFlag.set(true);
                    }
                    else
                    {
                        if(StatisticsIcon_var.ClickOnService.isRunning()==true) {StatisticsIcon_var.ClickOnService.cancel();}
                        if(StatisticsIcon_Fade_var.ClickOnService.isRunning()==true) {StatisticsIcon_Fade_var.ClickOnService.cancel();}
                        StatisticsIcon_var.ClickOffService.restart();
                        StatisticsIcon_Fade_var.ClickOffService.restart();
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
                    ClickState.set(true);
                }
            }
        );
    }
}
