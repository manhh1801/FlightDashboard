package project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.SchedulesMainButtonFrame.SchedulesMainIcon;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import java.util.concurrent.ExecutorService;
import javafx.util.Duration;

import project.app.Utilities.AnimationUtils.SequentialTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class SchedulesMainIcon extends Pane
{
    public SequentialTransitionService ClickOnService, ClickOffService;

    public SchedulesMainIcon()
    {
        SVGPath MainPath=new SVGPath();
        MainPath.setFillRule(FillRule.EVEN_ODD);
        MainPath.setContent("M11.8685 17.5C11.5987 17.5 11.3288 17.4457 11.0825 17.3262C11.0238 17.2936 10.9651 17.261 10.9182 17.2175L8.95894 15.6748L7.03485 17.2175C6.97619 17.261 6.91753 17.2936 6.85887 17.3262C6.40131 17.5326 5.88509 17.5543 5.42754 17.3696C4.95825 17.1849 4.60628 16.8264 4.44203 16.381L4.0666 15.338C3.86715 14.7948 4.04313 14.1103 4.47723 13.6975L6.43651 11.9157L6.42478 10.3404L2.89337 11.7419C2.30676 11.97 1.69669 11.9483 1.2274 11.655C0.769841 11.3834 0.5 10.8727 0.5 10.2861V9.27568C0.5 8.42826 1.13354 7.52652 1.97826 7.18973L6.42478 5.41884V3.34375C6.42478 2.27904 7.18737 1.12742 8.20808 0.671114C8.71256 0.442962 9.28744 0.442962 9.79193 0.671114C10.8126 1.16001 11.5752 2.31163 11.5752 3.34375V5.41884L16.0217 7.18973C16.8665 7.51566 17.5 8.4174 17.5 9.27568V10.2861C17.5 10.8727 17.2302 11.3834 16.7491 11.6658C16.2681 11.9483 15.6698 11.9809 15.0832 11.7528L11.5635 10.3513V11.9483L13.4758 13.7192C13.9099 14.1212 14.0859 14.8165 13.8865 15.3597L13.511 16.3918C13.3468 16.8373 12.9948 17.1958 12.5255 17.3696C12.3144 17.4565 12.0914 17.5 11.8685 17.5ZM8.9824 14.0669C9.3813 14.0669 9.76846 14.1864 10.0852 14.4145L11.9037 15.8486L12.2205 14.8382L10.3081 13.0782C10.0031 12.8066 9.80366 12.3503 9.80366 11.9483V9.93841C9.80366 9.44951 10.0266 9.0258 10.4255 8.77592C10.8244 8.52604 11.3406 8.49345 11.8333 8.68901L15.7284 10.2317L15.7402 9.27568C15.7402 9.06926 15.529 8.76506 15.3295 8.68901L10.6953 6.84207C10.1908 6.64651 9.81539 6.12502 9.81539 5.59267V3.34375C9.81539 2.92004 9.4165 2.3225 9.00587 2.12694C8.58351 2.3225 8.18461 2.90917 8.18461 3.34375V5.59267C8.18461 6.10329 7.82091 6.63564 7.30469 6.84207L2.68219 8.68901C2.48275 8.76506 2.25983 9.08013 2.25983 9.27568V10.2317L6.1432 8.69987C6.62422 8.50431 7.12871 8.52604 7.53934 8.77592C7.94997 9.0258 8.18461 9.44951 8.18461 9.94927V11.9592C8.18461 12.3503 7.98516 12.8066 7.68013 13.0891L5.70911 14.8817L6.08454 15.8378L7.85611 14.4471C8.18461 14.1972 8.58351 14.0669 8.9824 14.0669ZM11.3875 5.34279L11.3992 5.35365C11.3992 5.34279 11.3875 5.34279 11.3875 5.34279Z");
        MainPath.setFill(GREEN_WHITE(1));
        MainPath.setScaleX(UNIT); MainPath.setScaleY(UNIT);
        Bounds Bounds=MainPath.getBoundsInParent();
        MainPath.setLayoutX(3.5*UNIT-Bounds.getMinX()); MainPath.setLayoutY(3.5*UNIT-Bounds.getMinY());
        Circle SubPath1=new Circle(1*UNIT);
        SubPath1.setFill(GREEN_WHITE(1));
        SubPath1.setLayoutX(12*UNIT); SubPath1.setLayoutY(19*UNIT);
        SubPath1.setOpacity(0);
        Circle SubPath2=new Circle(1*UNIT);
        SubPath2.setFill(GREEN_WHITE(1));
        SubPath2.setLayoutX(12*UNIT); SubPath2.setLayoutY(21*UNIT);
        SubPath2.setOpacity(0);
        Circle SubPath3=new Circle(1*UNIT);
        SubPath3.setFill(GREEN_WHITE(1));
        SubPath3.setLayoutX(12*UNIT); SubPath3.setLayoutY(23*UNIT);
        SubPath3.setOpacity(0);

        TranslateTransition MainTranslate1=new TranslateTransition(Duration.millis(100), MainPath);
        MainTranslate1.setToY(-1.5*UNIT);
        FadeTransition Sub2FadeIn=new FadeTransition(Duration.millis(100), SubPath2);
        Sub2FadeIn.setToValue(1);
        TranslateTransition MainTranslate2=new TranslateTransition(Duration.millis(100), MainPath);
        MainTranslate2.setToY(-3.5*UNIT);
        FadeTransition Sub1FadeIn=new FadeTransition(Duration.millis(100), SubPath1);
        Sub1FadeIn.setToValue(1);
        FadeTransition Sub2FadeOut=new FadeTransition(Duration.millis(100), SubPath2);
        Sub2FadeOut.setToValue(0);
        FadeTransition Sub3FadeIn=new FadeTransition(Duration.millis(100), SubPath3);
        Sub3FadeIn.setToValue(1);
        TranslateTransition MainTranslate3=new TranslateTransition(Duration.millis(100), MainPath);
        MainTranslate3.setToY(0);
        FadeTransition Sub1FadeOut=new FadeTransition(Duration.millis(100), SubPath1);
        Sub1FadeOut.setToValue(0);
        FadeTransition Sub3FadeOut=new FadeTransition(Duration.millis(100), SubPath3);
        Sub3FadeOut.setToValue(0);
        FillTransition MainFillOn=new FillTransition(Duration.millis(100), MainPath, GREEN_WHITE(1), GREEN_BLACK(1));
        FillTransition MainFillOff=new FillTransition(Duration.millis(100), MainPath, GREEN_BLACK(1), GREEN_WHITE(1));
        FillTransition Sub1FillOn=new FillTransition(Duration.millis(100), SubPath1, GREEN_WHITE(1), GREEN_BLACK(1));
        FillTransition Sub1FillOff=new FillTransition(Duration.millis(100), SubPath1, GREEN_BLACK(1), GREEN_WHITE(1));
        FillTransition Sub2FillOn=new FillTransition(Duration.millis(100), SubPath2, GREEN_WHITE(1), GREEN_BLACK(1));
        FillTransition Sub2FillOff=new FillTransition(Duration.millis(100), SubPath2, GREEN_BLACK(1), GREEN_WHITE(1));
        FillTransition Sub3FillOn=new FillTransition(Duration.millis(100), SubPath3, GREEN_WHITE(1), GREEN_BLACK(1));
        FillTransition Sub3FillOff=new FillTransition(Duration.millis(100), SubPath3, GREEN_BLACK(1), GREEN_WHITE(1));
        ClickOnService=new SequentialTransitionService(new ParallelTransition(MainTranslate1, Sub2FadeIn), new ParallelTransition(MainTranslate2, Sub1FadeIn, Sub2FadeOut, Sub3FadeIn), new ParallelTransition(MainTranslate3, Sub1FadeOut, Sub3FadeOut, MainFillOn, Sub1FillOn, Sub2FillOn, Sub3FillOn));
        ClickOffService=new SequentialTransitionService(new ParallelTransition(MainTranslate1, Sub2FadeIn), new ParallelTransition(MainTranslate2, Sub1FadeIn, Sub2FadeOut, Sub3FadeIn), new ParallelTransition(MainTranslate3, Sub1FadeOut, Sub3FadeOut, MainFillOff, Sub1FillOff, Sub2FillOff, Sub3FillOff));

        setLayoutX(18*UNIT); setLayoutY(18*UNIT);
        setPrefSize(24*UNIT, 24*UNIT);
        getChildren().addAll(MainPath, SubPath1, SubPath2, SubPath3);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}