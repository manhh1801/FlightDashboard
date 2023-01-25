package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.TicketDisplayFrontBackground;

import javafx.animation.FadeTransition;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class TicketDisplayFrontBackground extends Pane
{
    public ParallelTransitionService EconomicService, BusinessService;

    public TicketDisplayFrontBackground()
    {
        Rectangle EconomicBackground=new Rectangle();
        EconomicBackground.setFill(WHITE_GRADIENT());
        EconomicBackground.setArcWidth(55*UNIT); EconomicBackground.setArcHeight(55*UNIT);
        EconomicBackground.setLayoutX(0); EconomicBackground.setLayoutY(0);
        EconomicBackground.setWidth(400*UNIT); EconomicBackground.setHeight(240*UNIT);
        Rectangle BusinessBackground=new Rectangle();
        BusinessBackground.setFill(BLACK_GRADIENT());
        BusinessBackground.setArcWidth(55*UNIT); BusinessBackground.setArcHeight(55*UNIT);
        BusinessBackground.setLayoutX(0); BusinessBackground.setLayoutY(0);
        BusinessBackground.setWidth(400*UNIT); BusinessBackground.setHeight(240*UNIT);
        BusinessBackground.setOpacity(0);

        FadeTransition EconomicFadeIn=new FadeTransition(Duration.millis(150), EconomicBackground); EconomicFadeIn.setFromValue(0); EconomicFadeIn.setToValue(1);
        FadeTransition EconomicFadeOut=new FadeTransition(Duration.millis(150), EconomicBackground); EconomicFadeOut.setFromValue(1); EconomicFadeOut.setToValue(0);
        FadeTransition BusinessFadeIn=new FadeTransition(Duration.millis(150), BusinessBackground); BusinessFadeIn.setFromValue(0); BusinessFadeIn.setToValue(1);
        FadeTransition BusinessFadeOut=new FadeTransition(Duration.millis(150), BusinessBackground); BusinessFadeOut.setFromValue(1); BusinessFadeOut.setToValue(0);
        EconomicService=new ParallelTransitionService(EconomicFadeIn, BusinessFadeOut);
        BusinessService=new ParallelTransitionService(EconomicFadeOut, BusinessFadeIn);

        setLayoutX(0); setLayoutY(0);
        setPrefSize(400*UNIT, 240*UNIT);
        getChildren().addAll(EconomicBackground, BusinessBackground);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EconomicService.setExecutor(AnimationThreadPool);
        BusinessService.setExecutor(AnimationThreadPool);
    }
}