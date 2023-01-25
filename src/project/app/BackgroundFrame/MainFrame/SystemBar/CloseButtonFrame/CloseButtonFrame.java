package project.app.BackgroundFrame.MainFrame.SystemBar.CloseButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.SystemBar.CloseButtonFrame.CloseBackground.CloseBackground;
import project.app.BackgroundFrame.MainFrame.SystemBar.CloseButtonFrame.CloseIcon.CloseIcon;
import project.app.BackgroundFrame.MainFrame.SystemBar.CloseButtonFrame.CloseIcon.CloseIcon_Fade;

import static project.app.Utilities.SizeUtils.*;

public class CloseButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState;

    public ExecutorService AnimationThreadPool;

    public CloseBackground CloseBackground_var;
    public CloseIcon CloseIcon_var;
    public CloseIcon_Fade CloseIcon_Fade_var;

    public CloseButtonFrame()
    {
        CloseBackground_var=new CloseBackground();
        CloseIcon_var=new CloseIcon();
        CloseIcon_Fade_var =new CloseIcon_Fade();

        setLayoutX(1550 * UNIT); setLayoutY(10 * UNIT);
        setPrefSize(40 * UNIT, 40 * UNIT);
        getChildren().addAll(CloseBackground_var, CloseIcon_var, CloseIcon_Fade_var);

        AnimationThreadPool=Executors.newFixedThreadPool(2);
        CloseBackground_var.setAnimationThreadPool(AnimationThreadPool);
        CloseIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(CloseBackground_var.ExitService.isRunning()==true) {CloseBackground_var.ExitService.cancel();}
                        if(CloseIcon_Fade_var.FadeOutService.isRunning()==true) {CloseIcon_Fade_var.FadeOutService.cancel();}
                        CloseBackground_var.EnterService.restart();
                        CloseIcon_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(CloseBackground_var.EnterService.isRunning()==true) {CloseBackground_var.EnterService.cancel();}
                        if(CloseIcon_Fade_var.FadeInService.isRunning()==true) {CloseIcon_Fade_var.FadeOutService.cancel();}
                        CloseBackground_var.ExitService.restart();
                        CloseIcon_Fade_var.FadeOutService.restart();
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

        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    System.exit(0);
                }
            }
        );
    }
}
