package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchBackground;

import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.util.Duration;
import java.util.concurrent.ExecutorService;

import project.app.Utilities.AnimationUtils.StrokeTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class SearchBackground extends Rectangle
{
    public StrokeTransitionService TypingOnService, TypingOffService;

    public SearchBackground()
    {
        TypingOnService=new StrokeTransitionService(Duration.millis(50), this, GRAY(1), WHITE(1));
        TypingOffService=new StrokeTransitionService(Duration.millis(50), this, WHITE(1), GRAY(1));

        setFill(GRAY(0));
        setStroke(GRAY(1)); setStrokeWidth(2*UNIT); setStrokeType(StrokeType.INSIDE);
        setArcWidth(40*UNIT); setArcHeight(40*UNIT);
        setLayoutX(0); setLayoutY(0);
        setWidth(940*UNIT); setHeight(60*UNIT);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        TypingOnService.setExecutor(AnimationThreadPool);
        TypingOffService.setExecutor(AnimationThreadPool);
    }
}