package project.app.BackgroundFrame.MainFrame.NavigationBar.HomeButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.NavigationBar.HomeButtonFrame.HomeBackground.HomeBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.HomeButtonFrame.HomeIcon.HomeIcon;
import project.app.BackgroundFrame.MainFrame.NavigationBar.HomeButtonFrame.HomeIcon.HomeIcon_Fade;

import static project.app.Utilities.SizeUtils.*;

public class HomeButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;

    public ExecutorService AnimationThreadPool;

    public HomeBackground HomeBackground_var;
    public HomeIcon HomeIcon_var;
    public HomeIcon_Fade HomeIcon_Fade_var;

    public HomeButtonFrame()
    {

        HomeBackground_var=new HomeBackground();
        HomeIcon_var=new HomeIcon();
        HomeIcon_Fade_var=new HomeIcon_Fade();

        setPrefSize(40*UNIT, 40*UNIT);
        getChildren().addAll(HomeBackground_var, HomeIcon_var, HomeIcon_Fade_var);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        HomeBackground_var.setAnimationThreadPool(AnimationThreadPool);
        HomeIcon_var.setAnimationThreadPool(AnimationThreadPool);
        HomeIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(HomeBackground_var.ExitService.isRunning()==true) {HomeBackground_var.ExitService.cancel();}
                        if(HomeIcon_Fade_var.FadeOutService.isRunning()==true) {HomeIcon_Fade_var.FadeOutService.cancel();}
                        HomeBackground_var.EnterService.restart();
                        HomeIcon_Fade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(HomeBackground_var.EnterService.isRunning()==true) {HomeBackground_var.ExitService.cancel();}
                        if(HomeIcon_Fade_var.FadeInService.isRunning()==true) {HomeIcon_Fade_var.FadeOutService.cancel();}
                        HomeBackground_var.ExitService.restart();
                        HomeIcon_Fade_var.FadeOutService.restart();
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
                        if(HomeIcon_var.ClickOffService.isRunning()==true) {HomeIcon_var.ClickOffService.cancel();}
                        if(HomeIcon_Fade_var.ClickOffService.isRunning()==true) {HomeIcon_Fade_var.ClickOffService.cancel();}
                        HomeIcon_var.ClickOnService.restart();
                        HomeIcon_Fade_var.ClickOnService.restart();
                    }
                    else
                    {
                        if(HomeIcon_var.ClickOnService.isRunning()==true) {HomeIcon_var.ClickOnService.cancel();}
                        if(HomeIcon_Fade_var.ClickOnService.isRunning()==true) {HomeIcon_Fade_var.ClickOnService.cancel();}
                        HomeIcon_var.ClickOffService.restart();
                        HomeIcon_Fade_var.ClickOffService.restart();
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
