package project.app.BackgroundFrame.MainFrame.SystemBar.MinimizeButtonFrame.MinimizeBackground;

import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.util.concurrent.ExecutorService;

import project.app.Utilities.AnimationUtils.FillTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class MinimizeBackground extends Rectangle
{
    public FillTransitionService EnterService, ExitService;

    public MinimizeBackground()
    {
        EnterService=new FillTransitionService(Duration.millis(50), this, DARK_GRAY(0), DARK_GRAY(1));
        ExitService=new FillTransitionService(Duration.millis(50), this, DARK_GRAY(1), DARK_GRAY(0));

        setFill(DARK_GRAY(0));
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