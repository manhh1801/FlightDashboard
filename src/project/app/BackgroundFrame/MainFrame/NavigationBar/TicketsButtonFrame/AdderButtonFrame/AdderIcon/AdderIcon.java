package project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.AdderButtonFrame.AdderIcon;

import javafx.geometry.Bounds;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import java.util.concurrent.ExecutorService;

import project.app.Utilities.AnimationUtils.FillTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class AdderIcon extends SVGPath
{
    public FillTransitionService ClickOnService, ClickOffService;

    public AdderIcon()
    {
        ClickOnService=new FillTransitionService(Duration.millis(50), this, GREEN_GRAY(1), GREEN_WHITE(1));
        ClickOffService=new FillTransitionService(Duration.millis(50), this, GREEN_WHITE(1), GREEN_GRAY(1));

        setFillRule(FillRule.EVEN_ODD);
        setContent("M7 5.25C7.5 5.25 8 5.55 8 6C8 6.5 7.5 6.75 7 6.75H1.5V11C1.5 12 2 12.5 3 12.5H12C13 12.5 13.5 12 13.5 11V9C13.5 8.5 13.75 8 14.25 8C14.75 8 15 8.5 15 9V11C15 13 14 14 12 14H3C1 14 0 13 0 11V4C0 2 1 1 3 1H7C7.5 1 8 1.25 8 1.75C8 2.25 7.5 2.5 7 2.5H3C2 2.5 1.5 3 1.5 4V5.25H7Z M13 6C12.5 6 12.25 5.5 12.25 5V3.75H11C10.5 3.75 10 3.5 10 3C10 2.5 10.5 2.25 11 2.25H12.25V1C12.25 0.5 12.5 0 13 0C13.5 0 13.75 0.5 13.75 1V2.25H15C15.5 2.25 16 2.5 16 3C16 3.5 15.5 3.75 15 3.75H13.75V5C13.75 5.5 13.5 6 13 6Z");
        setFill(GREEN_WHITE(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(12*UNIT-Bounds.getMinX()); setLayoutY(13*UNIT-Bounds.getMinY());
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}