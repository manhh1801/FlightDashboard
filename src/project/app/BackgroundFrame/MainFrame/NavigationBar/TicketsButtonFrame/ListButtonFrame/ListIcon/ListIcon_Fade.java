package project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.ListButtonFrame.ListIcon;

import javafx.geometry.Bounds;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;
import project.app.Utilities.AnimationUtils.FillTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.GREEN_GRAY;
import static project.app.Utilities.ColorUtils.GREEN_WHITE;
import static project.app.Utilities.SizeUtils.UNIT;

public class ListIcon_Fade extends SVGPath
{
    public FadeTransitionService FadeInService, FadeOutService;
    public FillTransitionService ClickOnService, ClickOffService;

    public ListIcon_Fade()
    {
        FadeInService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(50), this, 1, 0);
        ClickOnService=new FillTransitionService(Duration.millis(50), this, GREEN_GRAY(1), GREEN_WHITE(1));
        ClickOffService=new FillTransitionService(Duration.millis(50), this, GREEN_WHITE(1), GREEN_GRAY(1));

        setFillRule(FillRule.EVEN_ODD);
        setContent("M8 18C7.68821 18 7.37641 17.9299 7.08103 17.7896L1.50974 15.142C0.590769 14.7037 0 13.7306 0 12.6522C0 12.2928 0.413105 12 0.749515 12C1.08593 12 1.50974 12.2928 1.50974 12.6522C1.70214 13.317 1.80052 13.5031 2.33534 13.8268L7.41877 16.1966C7.68133 16.3193 8.31983 16.3193 8.5906 16.1966L13.6743 13.8268C14.3186 13.4955 14.4903 13.3375 14.5978 12.661C14.5978 12.3016 14.9487 12 15.2851 12C15.6215 12 16 12.3016 16 12.661C16 13.7393 15.4092 14.7124 14.4903 15.1508L8.91897 17.7984C8.62359 17.9299 8.3118 18 8 18Z M8 13C7.68821 13 7.37641 12.9299 7.08103 12.7896L1.50974 10.142C0.590769 9.70367 0 8.73055 0 7.65223C0 7.29279 0.413105 7 0.749515 7C1.08593 7 1.50974 7.29279 1.50974 7.65223C1.70214 8.31696 1.80052 8.50306 2.33534 8.82683L7.41877 11.1966C7.68133 11.3193 8.31983 11.3193 8.5906 11.1966L13.6743 8.82683C14.3186 8.49546 14.4903 8.33745 14.5978 7.661C14.5978 7.30156 14.9487 7 15.2851 7C15.6215 7 16 7.30156 16 7.661C16 8.73932 15.4092 9.71244 14.4903 10.1508L8.91897 12.7984C8.62359 12.9299 8.3118 13 8 13Z M7.99126 8C7.51912 8 7.03825 7.91954 6.6623 7.76666L1.50382 5.65854C0.19235 5.11944 0 4.39527 0 4.00101C0 3.60674 0.19235 2.88257 1.50382 2.34347L6.6623 0.235353C7.42295 -0.0784511 8.56831 -0.0784511 9.32896 0.235353L14.4962 2.34347C15.7989 2.87453 16 3.60674 16 4.00101C16 4.39527 15.8077 5.11944 14.4962 5.65854L9.32896 7.76666C8.94426 7.92758 8.47213 8 7.99126 8ZM8 1.42857C7.71429 1.42857 7.08571 1.6 6.85714 1.71429L2.57143 3.42654C2.05714 3.65184 1.71429 3.77369 1.71429 4.00101C1.71429 4.22833 2.05714 4.34286 2.57143 4.56629L6.85714 6.28571C7.08571 6.4 7.71429 6.5709 8 6.57143C8.28572 6.57196 8.91429 6.4 9.14286 6.28571L13.4286 4.57143C13.9429 4.35418 14.2857 4.22857 14.2857 4C14.2857 3.77143 13.9429 3.65714 13.4286 3.42857L9.14286 1.71429C8.91429 1.6 8.28572 1.42857 8 1.42857Z");
        setFill(GREEN_WHITE(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(12*UNIT-Bounds.getMinX()); setLayoutY(11*UNIT-Bounds.getMinY());
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