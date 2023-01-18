package project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.TicketsMainButtonFrame.TicketsMainIcon;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import java.util.concurrent.ExecutorService;

import project.app.Utilities.AnimationUtils.SequentialTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class TicketsMainIcon extends Pane
{
    public SequentialTransitionService ClickOnService, ClickOffService;

    public TicketsMainIcon()
    {
        SVGPath MainPath=new SVGPath();
        MainPath.setFillRule(FillRule.EVEN_ODD);
        MainPath.setContent("M5.5 15C8.53757 15 11 13.433 11 11.5C11 9.567 8.53757 8 5.5 8C2.46243 8 0 9.567 0 11.5C0 13.433 2.46243 15 5.5 15ZM5.5 13.5C7.433 13.5 9 12.6046 9 11.5C9 10.3954 7.433 9.5 5.5 9.5C3.567 9.5 2 10.3954 2 11.5C2 12.6046 3.567 13.5 5.5 13.5Z M5.5 7C7.433 7 9 5.433 9 3.5C9 1.567 7.433 0 5.5 0C3.567 0 2 1.567 2 3.5C2 5.433 3.567 7 5.5 7ZM5.5 5C6.32843 5 7 4.32843 7 3.5C7 2.67157 6.32843 2 5.5 2C4.67157 2 4 2.67157 4 3.5C4 4.32843 4.67157 5 5.5 5Z");
        MainPath.setFill(GREEN_WHITE(1));
        MainPath.setScaleX(UNIT); MainPath.setScaleY(UNIT);
        Bounds MainPathBounds=MainPath.getBoundsInParent();
        MainPath.setLayoutX(4*UNIT-MainPathBounds.getMinX()); MainPath.setLayoutY(5*UNIT-MainPathBounds.getMinY());
        SVGPath SubPath=new SVGPath();
        SubPath.setContent("M2 8.40525C2 7.94324 2.29804 7.5526 2.70773 7.42442C3.11729 7.54167 3.50075 7.69054 3.85086 7.86629C5.15778 8.52237 6 9.55312 6 10.7122C6 11.8713 5.15778 12.902 3.85086 13.5581C3.50075 13.7339 3.11729 13.8828 2.70773 14C2.29803 13.8718 2 13.4812 2 13.0192C2 12.8421 2.04378 12.6755 2.12084 12.5302C2.53818 12.4022 2.90599 12.2263 3.20303 12.015C3.70097 11.6608 4 11.2069 4 10.7122C4 10.2175 3.70097 9.76366 3.20303 9.40942C2.90599 9.19811 2.53818 9.02224 2.12084 8.89425C2.04378 8.7489 2 8.58232 2 8.40525Z M0.5 5.07298C1.32843 5.07298 2 4.3844 2 3.535C2 2.68561 1.32843 1.99703 0.5 1.99703C0.363307 1.99703 0.230884 2.01578 0.105044 2.0509C0.0372567 1.87558 0 1.68444 0 1.48437C0 0.774767 0.468712 0.177404 1.10602 0C2.75018 0.294269 4 1.76499 4 3.535C4 5.30502 2.75018 6.77574 1.10602 7.07001C0.468712 6.8926 0 6.29524 0 5.58563C0 5.38557 0.0372568 5.19443 0.105045 5.01911C0.230884 5.05423 0.363307 5.07298 0.5 5.07298Z");
        SubPath.setFill(GREEN_WHITE(1));
        SubPath.setScaleX(UNIT); SubPath.setScaleY(UNIT);
        Bounds SubPathBounds=SubPath.getBoundsInParent();
        SubPath.setLayoutX(14*UNIT-SubPathBounds.getMinX()); SubPath.setLayoutY(5*UNIT-SubPathBounds.getMinY());

        TranslateTransition MainTranslate1=new TranslateTransition(Duration.millis(150), MainPath);
        MainTranslate1.setToX(2.5*UNIT);
        TranslateTransition SubTranslate1=new TranslateTransition(Duration.millis(150), SubPath);
        SubTranslate1.setToX(-2.5*UNIT);
        FadeTransition SubFadeOut=new FadeTransition(Duration.millis(150), SubPath);
        SubFadeOut.setToValue(0);
        TranslateTransition MainTranslate2=new TranslateTransition(Duration.millis(150), MainPath);
        MainTranslate2.setToX(0);
        TranslateTransition SubTranslate2=new TranslateTransition(Duration.millis(150), SubPath);
        SubTranslate2.setToX(0);
        FadeTransition SubFadeIn=new FadeTransition(Duration.millis(150), SubPath);
        SubFadeIn.setToValue(1);
        FillTransition MainFillOn=new FillTransition(Duration.millis(100), MainPath, GREEN_WHITE(1), GREEN_BLACK(1));
        FillTransition MainFillOff=new FillTransition(Duration.millis(100), MainPath, GREEN_BLACK(1), GREEN_WHITE(1));
        FillTransition SubFillOn=new FillTransition(Duration.millis(100), SubPath, GREEN_WHITE(1), GREEN_BLACK(1));
        FillTransition SubFillOff=new FillTransition(Duration.millis(100), SubPath, GREEN_BLACK(1), GREEN_WHITE(1));
        ClickOnService=new SequentialTransitionService(new ParallelTransition(MainTranslate1, SubTranslate1, SubFadeOut), new ParallelTransition(MainTranslate2, SubTranslate2, SubFadeIn, MainFillOn, SubFillOn));
        ClickOffService=new SequentialTransitionService(new ParallelTransition(MainTranslate1, SubTranslate1, SubFadeOut), new ParallelTransition(MainTranslate2, SubTranslate2, SubFadeIn, MainFillOff, SubFillOff));

        setLayoutX(18*UNIT); setLayoutY(18*UNIT);
        setPrefSize(24*UNIT, 24*UNIT);
        getChildren().addAll(SubPath, MainPath);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}