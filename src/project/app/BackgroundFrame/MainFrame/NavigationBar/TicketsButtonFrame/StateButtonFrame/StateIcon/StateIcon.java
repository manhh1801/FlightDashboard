package project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.StateButtonFrame.StateIcon;

import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.GREEN_WHITE;
import static project.app.Utilities.SizeUtils.UNIT;


public class StateIcon extends Pane
{
    public ParallelTransitionService ClickOnService, ClickOffService;

    public StateIcon()
    {
        SVGPath UpPath=new SVGPath();
        UpPath.setContent("M1.30165 6.76102C1.00388 7.07956 0.521099 7.07956 0.223328 6.76102C-0.0744427 6.44248 -0.0744427 5.92603 0.223328 5.60749L5.08344 0.408431C5.59348 -0.136153 6.4068 -0.13616 6.91656 0.408509L11.7767 5.60757C12.0744 5.92611 12.0744 6.44256 11.7767 6.7611C11.4789 7.07963 10.9961 7.07963 10.6983 6.7611L6.19255 1.94106L6.19093 1.93942C6.00014 1.7464 5.9996 1.74585 5.80738 1.94106L1.30165 6.76102Z");
        UpPath.setFill(GREEN_WHITE(1));
        UpPath.setScaleX(UNIT); UpPath.setScaleY(UNIT);
        Bounds UpPathBounds=UpPath.getBoundsInParent();
        UpPath.setLayoutX(4*UNIT-UpPathBounds.getMinX()); UpPath.setLayoutY(0*UNIT-UpPathBounds.getMinY());
        UpPath.setOpacity(0);
        Circle MidPath =new Circle(1.5*UNIT);
        MidPath.setFill(GREEN_WHITE(1));
        MidPath.setLayoutX(10*UNIT); MidPath.setLayoutY(1.5*UNIT);
        SVGPath DownPath=new SVGPath();
        DownPath.setContent("M10.6983 0.238979C10.9961 -0.0795593 11.4789 -0.0795593 11.7767 0.238979C12.0744 0.557517 12.0744 1.07397 11.7767 1.39251L6.91656 6.59157C6.40652 7.13615 5.5932 7.13616 5.08344 6.59149L0.223328 1.39243C-0.0744438 1.07389 -0.0744429 0.557441 0.223329 0.238904C0.521099 -0.0796342 1.00388 -0.0796342 1.30165 0.238904L5.80745 5.05894L5.80907 5.06058C5.99986 5.2536 6.0004 5.25415 6.19262 5.05894L10.6983 0.238979Z");
        DownPath.setFill(GREEN_WHITE(1));
        DownPath.setScaleX(UNIT); DownPath.setScaleY(UNIT);
        Bounds DownPathBounds=DownPath.getBoundsInParent();
        DownPath.setLayoutX(4*UNIT-DownPathBounds.getMinX()); DownPath.setLayoutY(3*UNIT-DownPathBounds.getMinY());

        FadeTransition UpFadeIn=new FadeTransition(Duration.millis(150), UpPath);
        UpFadeIn.setToValue(1);
        FadeTransition UpFadeOut=new FadeTransition(Duration.millis(150), UpPath);
        UpFadeOut.setToValue(0);
        FadeTransition DownFadeIn=new FadeTransition(Duration.millis(150), DownPath);
        DownFadeIn.setToValue(1);
        FadeTransition DownFadeOut=new FadeTransition(Duration.millis(150), DownPath);
        DownFadeOut.setToValue(0);
        TranslateTransition MidTranslateUp=new TranslateTransition(Duration.millis(300), MidPath);
        MidTranslateUp.setToY(0);
        TranslateTransition MidTranslateDown=new TranslateTransition(Duration.millis(300), MidPath);
        MidTranslateDown.setToY(7*UNIT);
        ClickOnService=new ParallelTransitionService(MidTranslateDown, new SequentialTransition(DownFadeOut, UpFadeIn));
        ClickOffService=new ParallelTransitionService(MidTranslateUp, new SequentialTransition(UpFadeOut, DownFadeIn));

        setLayoutX(10*UNIT); setLayoutY(10*UNIT);
        setPrefSize(20*UNIT, 10*UNIT);
        getChildren().addAll(UpPath, MidPath, DownPath);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}