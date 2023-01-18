package project.app.BackgroundFrame.MainFrame.NavigationBar.AppLogo;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.NavigationBar.AppLogo.AppLogoIcon.AppLogoIcon;
import project.app.BackgroundFrame.MainFrame.NavigationBar.AppLogo.AppLogoIcon.AppLogoIconFade;

import static project.app.Utilities.SizeUtils.UNIT;

public class AppLogo extends Pane
{
    public SimpleBooleanProperty MousePosState;

    public ExecutorService AnimationThreadPool;

    AppLogoIcon AppLogoIcon_var;
    AppLogoIconFade AppLogoIconFade_var;

    public AppLogo()
    {
        AnimationThreadPool=Executors.newFixedThreadPool(1);

        AppLogoIcon_var=new AppLogoIcon();
        AppLogoIconFade_var=new AppLogoIconFade();

        setPrefWidth(40*UNIT); setPrefHeight(40*UNIT);
        getChildren().addAll(AppLogoIcon_var, AppLogoIconFade_var);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(AppLogoIconFade_var.FadeOutService.isRunning()==true) {AppLogoIconFade_var.FadeOutService.cancel();}
                        AppLogoIconFade_var.FadeInService.restart();
                    }
                    else
                    {
                        if(AppLogoIconFade_var.FadeInService.isRunning()==true) {AppLogoIconFade_var.FadeInService.cancel();}
                        AppLogoIconFade_var.FadeOutService.restart();
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
    }
}