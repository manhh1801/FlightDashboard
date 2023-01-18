package project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.TicketsMainButtonFrame.TicketsMainBackground;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.SECONDHALF_GRADIENT;
import static project.app.Utilities.SizeUtils.*;

public class TicketsMainBackground_Fade extends Circle
{
    public FadeTransitionService FadeInService, FadeOutService;

    public TicketsMainBackground_Fade()
    {
        FadeInService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(50), this, 1, 0);

        setFill(SECONDHALF_GRADIENT(1));
        setLayoutX(30*UNIT); setLayoutY(30*UNIT);
        setRadius(20*UNIT);
        setEffect(new GaussianBlur(10*UNIT));
        setOpacity(0);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FadeInService.setExecutor(AnimationThreadPool);
        FadeOutService.setExecutor(AnimationThreadPool);
    }
}