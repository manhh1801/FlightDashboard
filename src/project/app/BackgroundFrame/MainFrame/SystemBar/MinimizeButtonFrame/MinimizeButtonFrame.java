package project.app.BackgroundFrame.MainFrame.SystemBar.MinimizeButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.SystemBar.MinimizeButtonFrame.MinimizeBackground.MinimizeBackground;
import project.app.BackgroundFrame.MainFrame.SystemBar.MinimizeButtonFrame.MinimizeIcon.MinimizeIcon;
import project.app.BackgroundFrame.MainFrame.SystemBar.MinimizeButtonFrame.MinimizeIcon.MinimizeIcon_Fade;

import static project.app.Utilities.SizeUtils.*;


public class MinimizeButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState;

    public ExecutorService AnimationThreadPool;

    public MinimizeBackground MinimizeBackground_var;
    public MinimizeIcon MinimizeIcon_var;
    public MinimizeIcon_Fade MinimizeIcon_Fade_var;

    public MinimizeButtonFrame()
    {
        MinimizeBackground_var=new MinimizeBackground();
        MinimizeIcon_var=new MinimizeIcon();
        MinimizeIcon_Fade_var=new MinimizeIcon_Fade();

        setLayoutX(1490*UNIT);
        setLayoutY(10*UNIT);
        setPrefSize(40*UNIT, 40*UNIT);
        getChildren().addAll(MinimizeBackground_var, MinimizeIcon_var, MinimizeIcon_Fade_var);

        AnimationThreadPool=Executors.newFixedThreadPool(2);
        MinimizeBackground_var.setAnimationThreadPool(AnimationThreadPool);
        MinimizeIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(MinimizeBackground_var.ExitService.isRunning()==true) {MinimizeBackground_var.ExitService.cancel();}
                        if(MinimizeIcon_Fade_var.FadeOutService.isRunning()==true) {MinimizeIcon_Fade_var.FadeOutService.cancel();}
                        MinimizeBackground_var.EnterService.restart();
                        MinimizeIcon_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(MinimizeBackground_var.EnterService.isRunning()==true) {MinimizeBackground_var.EnterService.cancel();}
                        if(MinimizeIcon_Fade_var.FadeInService.isRunning()==true) {MinimizeIcon_Fade_var.FadeOutService.cancel();}
                        MinimizeBackground_var.ExitService.restart();
                        MinimizeIcon_Fade_var.FadeOutService.restart();
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
                    Stage Stage_var=(Stage)(getScene().getWindow());
                    Stage_var.setIconified(true);
                    Stage_var=null;
                }
            }
        );
    }
}
