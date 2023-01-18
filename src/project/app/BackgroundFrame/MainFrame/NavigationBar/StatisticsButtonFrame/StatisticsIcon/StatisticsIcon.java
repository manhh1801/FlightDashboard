package project.app.BackgroundFrame.MainFrame.NavigationBar.StatisticsButtonFrame.StatisticsIcon;

import javafx.geometry.Bounds;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import java.util.concurrent.ExecutorService;
import javafx.util.Duration;

import project.app.Utilities.AnimationUtils.FillTransitionService;
import static project.app.Utilities.SizeUtils.*;
import static project.app.Utilities.ColorUtils.*;


public class StatisticsIcon extends SVGPath
{
    public FillTransitionService ClickOnService, ClickOffService;

    public StatisticsIcon()
    {
        ClickOnService=new FillTransitionService(Duration.millis(50), this, GRAY(1), WHITE(1));
        ClickOffService=new FillTransitionService(Duration.millis(50), this, WHITE(1), GRAY(1));

        setContent("M17 18H4C1 18 0 17 0 14V1C0 0.5 0.5 0 1 0C1.5 0 2 0.5 2 1V14C2 15.5 2.5 16 4 16H17C17.5 16 18 16.5 18 17C18 17.5 17.5 18 17 18Z M5 10C5 9.44772 5.44772 9 6 9C6.55228 9 7 9.44772 7 10V12C7 12.5523 6.55228 13 6 13C5.44772 13 5 12.5523 5 12V10Z M9 4C9 3.44772 9.44772 3 10 3C10.5523 3 11 3.44772 11 4V12C11 12.5523 10.5523 13 10 13C9.44772 13 9 12.5523 9 12V4Z M13 7C13 6.44772 13.4477 6 14 6C14.5523 6 15 6.44772 15 7V12C15 12.5523 14.5523 13 14 13C13.4477 13 13 12.5523 13 12V7Z");
        setFill(GRAY(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(11*UNIT-Bounds.getMinX()); setLayoutY(11*UNIT-Bounds.getMinY());
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}
