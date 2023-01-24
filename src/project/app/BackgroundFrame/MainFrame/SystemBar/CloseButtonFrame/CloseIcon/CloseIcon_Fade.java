package project.app.BackgroundFrame.MainFrame.SystemBar.CloseButtonFrame.CloseIcon;

import javafx.geometry.Bounds;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class CloseIcon_Fade extends SVGPath
{
    public FadeTransitionService FadeInService, FadeOutService;

    public CloseIcon_Fade()
    {
        FadeInService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(50), this, 1, 0);

        setContent("M6.25 7C6.25 7.41421 6.58579 7.75 7 7.75C7.41421 7.75 7.75 7.41421 7.75 7H6.25ZM7.75 1C7.75 0.585786 7.41421 0.25 7 0.25C6.58579 0.25 6.25 0.585786 6.25 1H7.75ZM3.32079 4.25487C3.61625 3.96457 3.62044 3.48972 3.33014 3.19426C3.03984 2.89879 2.56498 2.89461 2.26952 3.18491L3.32079 4.25487ZM11.7305 3.18491C11.435 2.89461 10.9602 2.89879 10.6699 3.19426C10.3796 3.48972 10.3838 3.96457 10.6792 4.25487L11.7305 3.18491ZM7.75 7V1H6.25V7H7.75ZM12.25 8C12.25 10.8995 9.8995 13.25 7 13.25V14.75C10.7279 14.75 13.75 11.7279 13.75 8H12.25ZM7 13.25C4.10051 13.25 1.75 10.8995 1.75 8H0.25C0.25 11.7279 3.27208 14.75 7 14.75V13.25ZM1.75 8C1.75 6.53334 2.35043 5.20828 3.32079 4.25487L2.26952 3.18491C1.02393 4.40873 0.25 6.11467 0.25 8H1.75ZM10.6792 4.25487C11.6496 5.20828 12.25 6.53334 12.25 8H13.75C13.75 6.11467 12.9761 4.40873 11.7305 3.18491L10.6792 4.25487Z");
        setFill(MAIN_GRADIENT);
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(14*UNIT-Bounds.getMinX()); setLayoutY(13*UNIT-Bounds.getMinY());
        setEffect(new GaussianBlur(10*UNIT));
        setOpacity(0);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FadeInService.setExecutor(AnimationThreadPool);
        FadeOutService.setExecutor(AnimationThreadPool);
    }
}