package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchDeleteButtonFrame.SearchDeleteIcon;

import javafx.geometry.Bounds;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FillTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class SearchDeleteIcon extends SVGPath
{
    public FillTransitionService TypingOnService, TypingOffService;

    public SearchDeleteIcon()
    {
        TypingOnService=new FillTransitionService(Duration.millis(50), this, GRAY(1), WHITE(1));
        TypingOffService=new FillTransitionService(Duration.millis(50), this, WHITE(1), GRAY(1));

        setContent("M1.62809 9.72066C1.25564 10.0931 0.651785 10.0931 0.279337 9.72066C-0.0931122 9.34821 -0.0931122 8.74435 0.279337 8.3719L3.65124 4.99998L0.279367 1.6281C-0.0930814 1.25565 -0.0930816 0.651787 0.279367 0.279337C0.651816 -0.0931125 1.25567 -0.0931125 1.62812 0.279337L5 3.65122L8.37188 0.279339C8.74432 -0.093111 9.34818 -0.0931112 9.72063 0.279339C10.0931 0.651789 10.0931 1.25565 9.72063 1.6281L6.34876 4.99998L9.72066 8.3719C10.0931 8.74435 10.0931 9.34821 9.72066 9.72066C9.34821 10.0931 8.74436 10.0931 8.37191 9.72066L5 6.34874L1.62809 9.72066Z");
        setFill(GRAY(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(5*UNIT-Bounds.getMinX()); setLayoutY(5*UNIT-Bounds.getMinY());
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        TypingOnService.setExecutor(AnimationThreadPool);
        TypingOffService.setExecutor(AnimationThreadPool);
    }
}