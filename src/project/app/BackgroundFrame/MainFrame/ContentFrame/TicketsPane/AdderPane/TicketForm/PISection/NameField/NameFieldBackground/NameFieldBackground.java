package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.NameField.NameFieldBackground;

import javafx.animation.FadeTransition;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.UNIT;

public class NameFieldBackground extends Pane
{
    public ParallelTransitionService TypingOnService, TypingOffService;

    public NameFieldBackground()
    {
        Rectangle TypingOffBackground=new Rectangle();
        TypingOffBackground.setFill(DARK_GRAY(1));
        TypingOffBackground.setArcWidth(20*UNIT); TypingOffBackground.setArcHeight(20*UNIT);
        TypingOffBackground.setLayoutX(0); TypingOffBackground.setLayoutY(0);
        TypingOffBackground.setWidth(260*UNIT); TypingOffBackground.setHeight(40*UNIT);
        SVGPath TypingOnBackground=new SVGPath();
        TypingOnBackground.setContent("M0 11C0 5.47713 4.47715 0.999976 10 0.999976C10.3333 0.981666 11 1.15603 11 1.99998C11 2.84392 10.3333 3.0549 10 3.0549C5.50005 3.55235 2 7.36742 2 12V30C2 34.9705 6.02944 39 11 39H249C253.971 39 258 34.9705 258 30V12C258 7.02941 253.971 2.99998 249 2.99998H52C51.6667 2.99998 51 2.79998 51 2C51 1.20002 51.6667 0.999992 52 0.999976H250C255.523 0.999976 260 5.47713 260 11V31C260 36.5228 255.523 41 250 41H10C4.47716 41 0 36.5228 0 31V11Z");
        TypingOnBackground.setFill(WHITE(1));
        TypingOnBackground.setScaleX(UNIT); TypingOnBackground.setScaleY(UNIT);
        Bounds Bounds=TypingOnBackground.getBoundsInParent();
        TypingOnBackground.setLayoutX(-Bounds.getMinX()); TypingOnBackground.setLayoutY(-Bounds.getMinY());
        TypingOnBackground.setOpacity(0);

        FadeTransition OffFadeIn=new FadeTransition(Duration.millis(100), TypingOffBackground); OffFadeIn.setFromValue(0); OffFadeIn.setToValue(1);
        FadeTransition OffFadeOut=new FadeTransition(Duration.millis(100), TypingOffBackground); OffFadeOut.setFromValue(1); OffFadeOut.setToValue(0);
        FadeTransition OnFadeIn=new FadeTransition(Duration.millis(100), TypingOnBackground); OnFadeIn.setFromValue(0); OnFadeIn.setToValue(1);
        FadeTransition OnFadeOut=new FadeTransition(Duration.millis(100), TypingOnBackground); OnFadeOut.setFromValue(1); OnFadeOut.setToValue(0);
        TypingOnService=new ParallelTransitionService(OffFadeOut, OnFadeIn);
        TypingOffService=new ParallelTransitionService(OffFadeIn, OnFadeOut);

        setLayoutX(0); setLayoutY(10*UNIT);
        setPrefSize(260*UNIT, 40*UNIT);
        getChildren().addAll(TypingOffBackground, TypingOnBackground);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        TypingOnService.setExecutor(AnimationThreadPool);
        TypingOffService.setExecutor(AnimationThreadPool);
    }
}