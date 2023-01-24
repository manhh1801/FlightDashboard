package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemBackground;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FillTransitionService;
import project.app.Utilities.AnimationUtils.LinearFillTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class FilterItemBackground extends Rectangle
{
    public SimpleBooleanProperty MousePosState, ClickState;

    public ExecutorService AnimationThreadPool;

    public FillTransitionService EnterService, ExitService;
    public LinearFillTransitionService ClickOnService, ClickOffService;

    public FilterItemBackground()
    {
        EnterService=new FillTransitionService(Duration.millis(50), this, DARK_GRAY(1), GRAY(1));
        ExitService=new FillTransitionService(Duration.millis(50), this, GRAY(1), DARK_GRAY(1));
        ClickOnService=new LinearFillTransitionService(Duration.millis(50), this, "right", "636678", "636678", "92FE9D", "00C9FF");
        ClickOffService=new LinearFillTransitionService(Duration.millis(50), this, "right", "92FE9D", "00C9FF", "636678", "636678");

        setFill(DARK_GRAY(1));
        setArcWidth(20*UNIT); setArcHeight(20*UNIT);
        setLayoutX(0); setLayoutY(0);
        setWidth(60*UNIT); setHeight(60*UNIT);

        AnimationThreadPool= Executors.newFixedThreadPool(1);
        setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(ClickState.get()==false)
                    {
                        if(NewValue==true)
                        {
                            if(ExitService.isRunning()) {ExitService.cancel();}
                            EnterService.restart();
                        }
                        else
                        {
                            if(EnterService.isRunning()) {EnterService.cancel();}
                            ExitService.restart();
                        }
                    }
                }
            }
        );

        ClickState=new SimpleBooleanProperty(false);
        ClickState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        if(ClickOffService.isRunning()) {ClickOffService.cancel();}
                        ClickOnService.restart();
                    }
                    else
                    {
                        if(ClickOnService.isRunning()) {ClickOnService.cancel();}
                        ClickOffService.restart();
                    }
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}