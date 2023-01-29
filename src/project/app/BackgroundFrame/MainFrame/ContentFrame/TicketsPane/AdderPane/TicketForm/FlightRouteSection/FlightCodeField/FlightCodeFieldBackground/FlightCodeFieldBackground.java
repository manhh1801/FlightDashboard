package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField.FlightCodeFieldBackground;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.ColorUtils.DARK_GRAY;
import static project.app.Utilities.SizeUtils.UNIT;

public class FlightCodeFieldBackground extends Rectangle
{
    public SimpleBooleanProperty FocusState;
    public SimpleDoubleProperty Height;

    public ExecutorService AnimationThreadPool;

    public ParallelTransitionService FocusOnService, FocusOffService;

    public FlightCodeFieldBackground()
    {
        FocusOnService=new ParallelTransitionService(new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(heightProperty(), 240*UNIT))));
        FocusOffService=new ParallelTransitionService(new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(heightProperty(), 40*UNIT))));

        setFill(DARK_GRAY(1));
        setArcWidth(20*UNIT); setArcHeight(20*UNIT);
        setLayoutX(0); setLayoutY(0);
        setWidth(120*UNIT); setHeight(40*UNIT);

        AnimationThreadPool= Executors.newFixedThreadPool(1);
        setAnimationThreadPool(AnimationThreadPool);

        Height=new SimpleDoubleProperty(200*UNIT);
        Height.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldValue, Number NewValue)
                {
                    FocusOnService.setAnimation(new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(heightProperty(), NewValue.doubleValue()+40*UNIT))));
                }
            }
        );

        FocusState=new SimpleBooleanProperty(false);
        FocusState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        if(FocusOffService.isRunning()==true) {FocusOffService.cancel();}
                        FocusOnService.restart();
                    }
                    else
                    {
                        if(FocusOnService.isRunning()==true) {FocusOnService.cancel();}
                        FocusOffService.restart();
                    }
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FocusOnService.setExecutor(AnimationThreadPool);
        FocusOffService.setExecutor(AnimationThreadPool);
    }
}