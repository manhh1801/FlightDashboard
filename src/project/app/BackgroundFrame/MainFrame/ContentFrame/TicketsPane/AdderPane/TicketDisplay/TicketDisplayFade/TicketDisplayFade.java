package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFade;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class TicketDisplayFade extends Rectangle
{
    public SimpleBooleanProperty MousePosState;

    public ExecutorService AnimationThreadPool;

    public FadeTransitionService EnterService, ExitService;

    public TicketDisplayFade()
    {
        EnterService=new FadeTransitionService(Duration.millis(150), this, 0, 1);
        ExitService=new FadeTransitionService(Duration.millis(150), this, 1, 0);

        setFill(GRAY(1));
        setArcWidth(55*UNIT); setArcHeight(55*UNIT);
        setLayoutX(20*UNIT); setLayoutY(20*UNIT);
        setWidth(400*UNIT); setHeight(240*UNIT);
        setEffect(new GaussianBlur(25*UNIT));
        setOpacity(0);

        AnimationThreadPool=Executors.newFixedThreadPool(1);
        setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        if(ExitService.isRunning()==true) {ExitService.cancel();}
                        EnterService.restart();
                    }
                    else
                    {
                        if(EnterService.isRunning()==true) {EnterService.cancel();}
                        ExitService.restart();
                    }
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
    }

}