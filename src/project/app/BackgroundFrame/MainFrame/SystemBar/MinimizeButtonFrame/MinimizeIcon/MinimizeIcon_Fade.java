package project.app.BackgroundFrame.MainFrame.SystemBar.MinimizeButtonFrame.MinimizeIcon;

import javafx.animation.FadeTransition;
import javafx.geometry.Bounds;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class MinimizeIcon_Fade extends SVGPath
{
    public FadeTransitionService FadeInService;
    public FadeTransitionService FadeOutService;

    public FadeTransition FadeInTransition, FadeOutTransition;
    
    public MinimizeIcon_Fade()
    {
        FadeInService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(50), this, 1, 0);

        FadeInTransition=new FadeTransition(Duration.millis(50), this);
        FadeInTransition.setFromValue(0); FadeInTransition.setToValue(1);
        FadeOutTransition=new FadeTransition(Duration.millis(50), this);
        FadeOutTransition.setFromValue(1); FadeOutTransition.setToValue(0);

        setContent("M0.25 1C0.25 0.5 0.5 0.25 1 0.25H11C11.5 0.25 11.75 0.5 11.75 1C11.75 1.5 11.5 1.75 11 1.75H1C0.5 1.75 0.25 1.5 0.25 1Z");
        setFill(WHITE(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(14.25*UNIT-Bounds.getMinX()); setLayoutY(19.25*UNIT-Bounds.getMinY());
        setEffect(new GaussianBlur(10*UNIT));
        setOpacity(0);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FadeInService.setExecutor(AnimationThreadPool);
        FadeOutService.setExecutor(AnimationThreadPool);
    }
}