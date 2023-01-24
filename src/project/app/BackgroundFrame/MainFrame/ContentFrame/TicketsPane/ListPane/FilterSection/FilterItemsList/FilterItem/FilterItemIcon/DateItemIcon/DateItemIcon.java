package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemIcon.DateItemIcon;

import javafx.geometry.Bounds;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FillTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class DateItemIcon extends SVGPath
{
    public FillTransitionService EnterService, ExitService, ClickOnService, ClickOffService;

    public DateItemIcon()
    {
        EnterService=new FillTransitionService(Duration.millis(50), this, GRAY(1), WHITE(1));
        ExitService=new FillTransitionService(Duration.millis(50), this, WHITE(1), GRAY(1));
        ClickOnService=new FillTransitionService(Duration.millis(50), this, WHITE(1), BLACK(1));
        ClickOffService=new FillTransitionService(Duration.millis(50), this, BLACK(1), WHITE(1));

        setContent("M8.67316 18H3.31987C1.7585 18 0.618447 17.3386 0.180601 16.2C-0.273768 15.0112 0.147555 13.5377 1.23804 12.5414L5.07126 9L1.23804 5.4586C0.147555 4.46233 -0.273768 2.98884 0.180601 1.8C0.618447 0.653023 1.7585 0 3.31987 0H8.67316C10.2345 0 11.3746 0.661395 11.8124 1.8C12.2668 2.98884 11.8455 4.46233 10.755 5.4586L6.92178 9L10.7633 12.5414C11.8455 13.5377 12.2751 15.0112 11.8207 16.2C11.3746 17.3386 10.2345 18 8.67316 18ZM5.99652 9.84558L2.07243 13.4623C1.37848 14.107 1.07282 15.0447 1.33718 15.7395C1.58501 16.3842 2.28722 16.7442 3.31987 16.7442H8.67316C9.70582 16.7442 10.408 16.3926 10.6559 15.7395C10.9202 15.0447 10.6228 14.107 9.92061 13.4623L5.99652 9.84558ZM3.31987 1.25581C2.28722 1.25581 1.58501 1.60744 1.33718 2.26047C1.07282 2.95535 1.37022 3.89302 2.07243 4.53767L5.99652 8.15442L9.92061 4.53767C10.6146 3.89302 10.9202 2.95535 10.6559 2.26047C10.408 1.61581 9.70582 1.25581 8.67316 1.25581H3.31987Z");
        setFill(GRAY(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(4*UNIT-Bounds.getMinX()); setLayoutY(1*UNIT-Bounds.getMinY());
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}