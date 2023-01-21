package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchIcon;

import javafx.geometry.Bounds;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import java.util.concurrent.ExecutorService;
import javafx.util.Duration;

import project.app.Utilities.AnimationUtils.FillTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class SearchIcon extends SVGPath
{
    public FillTransitionService TypingOnService, TypingOffService;

    public SearchIcon()
    {
        TypingOnService=new FillTransitionService(Duration.millis(50), this, GRAY(1), WHITE(1));
        TypingOffService=new FillTransitionService(Duration.millis(50), this, WHITE(1), GRAY(1));

        setFillRule(FillRule.EVEN_ODD);
        setContent("M20 8.06922C20 12.5257 16.3873 16.1384 11.9308 16.1384C10.0661 16.1384 8.3491 15.5059 6.98269 14.4437L1.72188 19.7046C1.32797 20.0985 0.68933 20.0985 0.295427 19.7046C-0.0984757 19.3107 -0.0984757 18.672 0.295427 18.2781L5.55625 13.0173C4.49408 11.6509 3.86158 9.93392 3.86158 8.06922C3.86158 3.61271 7.47429 0 11.9308 0C16.3873 0 20 3.61271 20 8.06922ZM11.9308 14.1211C15.2732 14.1211 17.9827 11.4116 17.9827 8.06922C17.9827 4.72684 15.2732 2.01731 11.9308 2.01731C8.58842 2.01731 5.87888 4.72684 5.87888 8.06922C5.87888 11.4116 8.58842 14.1211 11.9308 14.1211Z");
        setFill(GRAY(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(20*UNIT-Bounds.getMinX()); setLayoutY(20*UNIT-Bounds.getMinY());
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        TypingOnService.setExecutor(AnimationThreadPool);
        TypingOffService.setExecutor(AnimationThreadPool);
    }
}