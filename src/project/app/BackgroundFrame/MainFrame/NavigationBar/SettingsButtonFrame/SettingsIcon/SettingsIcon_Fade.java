package project.app.BackgroundFrame.MainFrame.NavigationBar.SettingsButtonFrame.SettingsIcon;

import javafx.geometry.Bounds;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.paint.Color;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import java.util.concurrent.ExecutorService;
import javafx.util.Duration;

import project.app.Utilities.AnimationUtils.FadeTransitionService;
import project.app.Utilities.AnimationUtils.FillTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class SettingsIcon_Fade extends SVGPath
{
    public FadeTransitionService FadeInService, FadeOutService;
    public FillTransitionService ClickOnService, ClickOffService;

    public SettingsIcon_Fade()
    {
        FadeInService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(50), this, 1, 0);
        ClickOnService=new FillTransitionService(Duration.millis(50), this, GRAY(1), WHITE(1));
        ClickOffService=new FillTransitionService(Duration.millis(50), this, WHITE(1), GRAY(1));

        setFillRule(FillRule.EVEN_ODD);
        setContent("M5 7V11H3.5C1.567 11 0 12.567 0 14.5C0 16.433 1.567 18 3.5 18C5.433 18 7 16.433 7 14.5V13H11V14.5C11 16.433 12.567 18 14.5 18C16.433 18 18 16.433 18 14.5C18 12.567 16.433 11 14.5 11H13V7H14.5C16.433 7 18 5.433 18 3.5C18 1.567 16.433 0 14.5 0C12.567 0 11 1.567 11 3.5V5H7V3.5C7 1.567 5.433 0 3.5 0C1.567 0 0 1.567 0 3.5C0 5.433 1.567 7 3.5 7H5ZM7 11V7H11V11H7ZM5 3.5C5 2.67157 4.32843 2 3.5 2C2.67157 2 2 2.67157 2 3.5C2 4.32843 2.67157 5 3.5 5H5V3.5ZM14.5 5C15.3284 5 16 4.32843 16 3.5C16 2.67157 15.3284 2 14.5 2C13.6716 2 13 2.67157 13 3.5V5H14.5ZM3.5 16C4.32843 16 5 15.3284 5 14.5V13H3.5C2.67157 13 2 13.6716 2 14.5C2 15.3284 2.67157 16 3.5 16ZM14.5 16C15.3284 16 16 15.3284 16 14.5C16 13.6716 15.3284 13 14.5 13H13V14.5C13 15.3284 13.6716 16 14.5 16Z");
        setFill(GRAY(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(11*UNIT-Bounds.getMinX()); setLayoutY(11*UNIT-Bounds.getMinY());
        setEffect(new GaussianBlur(10*UNIT));
        setOpacity(0);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FadeInService.setExecutor(AnimationThreadPool);
        FadeOutService.setExecutor(AnimationThreadPool);
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}