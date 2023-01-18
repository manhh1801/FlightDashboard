package project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.TicketsMainButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.TicketsMainButtonFrame.TicketsMainBackground.TicketsMainBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.TicketsMainButtonFrame.TicketsMainBackground.TicketsMainBackground_Fade;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.TicketsMainButtonFrame.TicketsMainIcon.TicketsMainIcon;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.UNIT;

public class TicketsMainButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;

    public ExecutorService AnimationThreadPool;

    public TicketsMainBackground TicketsMainBackground_var;
    public TicketsMainBackground_Fade TicketsMainBackground_Fade_var;
    public TicketsMainIcon TicketsMainIcon_var;
    
    public TicketsMainButtonFrame()
    {
        TicketsMainBackground_var =new TicketsMainBackground();
        TicketsMainBackground_Fade_var =new TicketsMainBackground_Fade();
        TicketsMainIcon_var =new TicketsMainIcon();

        setLayoutX(0); setLayoutY(0);
        setPrefSize(60*UNIT, 60*UNIT);
        getChildren().addAll(TicketsMainBackground_var, TicketsMainBackground_Fade_var, TicketsMainIcon_var);

        AnimationThreadPool=Executors.newFixedThreadPool(1);
        TicketsMainBackground_Fade_var.setAnimationThreadPool(AnimationThreadPool);
        TicketsMainIcon_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(TicketsMainBackground_Fade_var.FadeOutService.isRunning()==true) {TicketsMainBackground_Fade_var.FadeOutService.cancel();}
                        TicketsMainBackground_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(TicketsMainBackground_Fade_var.FadeInService.isRunning()==true) {TicketsMainBackground_Fade_var.FadeInService.cancel();}
                        TicketsMainBackground_Fade_var.FadeOutService.restart();
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
                        if(TicketsMainIcon_var.ClickOffService.isRunning()==true) {TicketsMainIcon_var.ClickOffService.cancel();}
                        TicketsMainIcon_var.ClickOnService.restart();
                    }
                    else
                    {
                        if(TicketsMainIcon_var.ClickOnService.isRunning()==true) {TicketsMainIcon_var.ClickOnService.cancel();}
                        TicketsMainIcon_var.ClickOffService.restart();
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
