package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemBackground;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class FilterItemGradientBackground extends Rectangle
{
    public SimpleBooleanProperty ClickState;

    public ExecutorService AnimationThreadPool;

    public FadeTransitionService ClickOnService, ClickOffService;

    public FilterItemGradientBackground()
    {
        ClickOnService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        ClickOffService=new FadeTransitionService(Duration.millis(50), this, 1, 0);

        setFill(MAIN_GRADIENT);
        setArcWidth(20*UNIT); setArcHeight(20*UNIT);
        setLayoutX(0); setLayoutY(0);
        setWidth(60*UNIT); setHeight(60*UNIT);
        setOpacity(0);

        AnimationThreadPool= Executors.newFixedThreadPool(1);
        setAnimationThreadPool(AnimationThreadPool);

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
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}