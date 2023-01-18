package project.app.BackgroundFrame.MainFrame.NavigationBar.HomeButtonFrame.HomeIcon;

import javafx.geometry.Bounds;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.shape.SVGPath;
import java.util.concurrent.ExecutorService;
import javafx.util.Duration;

import project.app.Utilities.AnimationUtils.FadeTransitionService;
import project.app.Utilities.AnimationUtils.FillTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class HomeIcon_Fade extends SVGPath
{
    public FadeTransitionService FadeInService, FadeOutService;
    public FillTransitionService ClickOnService, ClickOffService;

    public HomeIcon_Fade()
    {
        FadeInService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(50), this, 1, 0);
        ClickOnService=new FillTransitionService(Duration.millis(50), this, GRAY(1), WHITE(1));
        ClickOffService=new FillTransitionService(Duration.millis(50), this, WHITE(1), GRAY(1));

        setContent("M14.2922 20H11.7566C10.7889 19.9758 10.0466 19.1714 10.0466 18.1688V15.8666C10.0466 15.5234 9.77009 15.2444 9.43906 15.2444H8.56156C8.23755 15.2463 7.95405 15.5262 7.95405 15.8666V18.1666C7.85922 19.0873 7.14406 20 6.24405 20H3.70805C1.12528 20 0 18.8888 0 16.1051V8.00107C0.00878061 7.07664 0.410932 6.23034 1.10548 5.67327L6.84361 0.795387C8.10713 -0.264819 9.86765 -0.264819 11.1285 0.793527L16.9079 5.67606C17.5867 6.22383 17.9888 7.06827 18.0002 7.98154V16.1051C18.0002 18.8888 16.8753 19.9999 14.2922 20ZM10.2884 13.291C11.3456 13.291 12.2061 14.1959 12.2061 15.3081V17.3835C12.2061 17.6225 12.3869 17.7721 12.6187 17.7777H14.2923C15.6112 17.7777 15.7503 17.4834 15.7503 16.1052V8.88893C15.7441 8.41463 15.6552 7.79673 15.289 7.50006L9.85527 2.7779L9.83878 2.76732C8.9959 2.22665 8.99475 2.22591 8.14355 2.77789L2.71657 7.50005C2.33637 7.80603 2.25463 8.40626 2.25024 8.88893L2.24585 16.1067C2.24585 17.485 2.37297 17.7777 3.69182 17.7777H5.39757C5.63553 17.7777 5.8287 17.6343 5.8287 17.3888L5.84539 15.3081C5.84539 14.2024 6.70062 13.2984 7.7499 13.291H10.2884Z");
        setFill(WHITE(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(11*UNIT-Bounds.getMinX()); setLayoutY(10*UNIT-Bounds.getMinY());
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