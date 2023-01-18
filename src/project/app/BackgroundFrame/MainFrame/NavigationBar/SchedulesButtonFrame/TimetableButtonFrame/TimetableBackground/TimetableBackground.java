package project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.TimetableButtonFrame.TimetableBackground;

import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.util.concurrent.ExecutorService;

import project.app.Utilities.AnimationUtils.FillTransitionService;
import static project.app.Utilities.SizeUtils.*;
import static project.app.Utilities.ColorUtils.*;

public class TimetableBackground extends Rectangle
{
    public FillTransitionService EnterService, ExitService;

    public TimetableBackground()
    {
        EnterService =new FillTransitionService(Duration.millis(50), this, GREEN_WHITE(0), GREEN_WHITE(0.2));
        ExitService =new FillTransitionService(Duration.millis(50), this, GREEN_WHITE(0.2), GREEN_WHITE(0));

        setFill(GREEN_WHITE(0));
        setArcWidth(20*UNIT); setArcHeight(20*UNIT);
        setLayoutX(0); setLayoutY(0);
        setWidth(40*UNIT); setHeight(40*UNIT);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
    }
}