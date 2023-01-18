package project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.AdderButtonFrame.AdderBackground;

import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FillTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.GREEN_WHITE;
import static project.app.Utilities.SizeUtils.UNIT;

public class AdderBackground extends Rectangle
{
    public FillTransitionService EnterService, ExitService;

    public AdderBackground()
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