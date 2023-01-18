package project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.SchedulesBackground;

import javafx.animation.*;
import javafx.scene.shape.Rectangle;
import java.util.concurrent.ExecutorService;
import javafx.util.Duration;

import project.app.Utilities.AnimationUtils.ParallelTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class SchedulesBackground extends Rectangle
{
    public ParallelTransitionService ClickOnService, ClickOffService;

    public SchedulesBackground()
    {
        Timeline ClickOn=new Timeline(new KeyFrame(Duration.millis(300), new KeyValue(heightProperty(), 220*UNIT)));
        ClickOnService=new ParallelTransitionService(ClickOn);
        Timeline ClickOff=new Timeline(new KeyFrame(Duration.millis(300), new KeyValue(heightProperty(), 110*UNIT)));
        ClickOffService=new ParallelTransitionService(ClickOff);

        setFill(FIRSTHALF_GRADIENT(0.5));
        setArcWidth(60*UNIT); setArcHeight(60*UNIT);
        setLayoutX(0); setLayoutY(0);
        setWidth(60*UNIT); setHeight(110*UNIT);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}