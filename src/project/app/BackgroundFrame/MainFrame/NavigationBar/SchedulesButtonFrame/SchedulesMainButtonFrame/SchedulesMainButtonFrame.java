package project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.SchedulesMainButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.SchedulesBackground.SchedulesBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.SchedulesMainButtonFrame.SchedulesMainBackground.SchedulesMainBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.SchedulesMainButtonFrame.SchedulesMainBackground.SchedulesMainBackground_Fade;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.SchedulesMainButtonFrame.SchedulesMainIcon.SchedulesMainIcon;
import static project.app.Utilities.SizeUtils.*;

public class SchedulesMainButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;

    public ExecutorService AnimationThreadPool;

    public SchedulesMainBackground SchedulesMainBackground_var;
    public SchedulesMainBackground_Fade SchedulesMainBackground_Fade_var;
    public SchedulesMainIcon SchedulesMainIcon_var;
    
    public SchedulesMainButtonFrame()
    {
        SchedulesMainBackground_var=new SchedulesMainBackground();
        SchedulesMainBackground_Fade_var=new SchedulesMainBackground_Fade();
        SchedulesMainIcon_var=new SchedulesMainIcon();

        setLayoutX(0); setLayoutY(0);
        setPrefSize(60*UNIT, 60*UNIT);
        getChildren().addAll(SchedulesMainBackground_var, SchedulesMainBackground_Fade_var, SchedulesMainIcon_var);

        AnimationThreadPool=Executors.newFixedThreadPool(1);
        SchedulesMainBackground_Fade_var.setAnimationThreadPool(AnimationThreadPool);
        SchedulesMainIcon_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(SchedulesMainBackground_Fade_var.FadeOutService.isRunning()==true) {SchedulesMainBackground_Fade_var.FadeOutService.cancel();}
                        SchedulesMainBackground_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(SchedulesMainBackground_Fade_var.FadeInService.isRunning()==true) {SchedulesMainBackground_Fade_var.FadeInService.cancel();}
                        SchedulesMainBackground_Fade_var.FadeOutService.restart();
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
                        if(SchedulesMainIcon_var.ClickOffService.isRunning()==true) {SchedulesMainIcon_var.ClickOffService.cancel();}
                        SchedulesMainIcon_var.ClickOnService.restart();
                    }
                    else
                    {
                        if(SchedulesMainIcon_var.ClickOnService.isRunning()==true) {SchedulesMainIcon_var.ClickOnService.cancel();}
                        SchedulesMainIcon_var.ClickOffService.restart();
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
