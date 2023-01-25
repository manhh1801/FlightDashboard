package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.DecoratingShapes;

import javafx.animation.FillTransition;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.ColorUtils.BLACK;
import static project.app.Utilities.SizeUtils.*;

public class DecoratingShapes extends Pane
{
    public ParallelTransitionService EconomicService, BusinessService;

    public DecoratingShapes()
    {
        Circle DecoratingCircle=new Circle(5*UNIT);
        DecoratingCircle.setFill(BLACK(1));
        DecoratingCircle.setLayoutX(200*UNIT); DecoratingCircle.setLayoutY(20*UNIT);

        Rectangle DecoratingRectangle=new Rectangle(40*UNIT, 2*UNIT);
        DecoratingRectangle.setFill(BLACK(1));
        DecoratingRectangle.setArcWidth(2*UNIT); DecoratingRectangle.setArcHeight(2*UNIT);
        DecoratingRectangle.setLayoutX(180*UNIT); DecoratingRectangle.setLayoutY(219*UNIT);

        FillTransition EconomicCircle=new FillTransition(Duration.millis(150), DecoratingCircle, WHITE(1), BLACK(1));
        FillTransition EconomicRectangle=new FillTransition(Duration.millis(150), DecoratingRectangle, WHITE(1), BLACK(1));
        EconomicService=new ParallelTransitionService(EconomicCircle, EconomicRectangle);
        FillTransition BusinessCircle=new FillTransition(Duration.millis(150), DecoratingCircle, BLACK(1), WHITE(1));
        FillTransition BusinessRectangle=new FillTransition(Duration.millis(150), DecoratingRectangle, BLACK(1), WHITE(1));
        BusinessService=new ParallelTransitionService(BusinessCircle, BusinessRectangle);

        setLayoutX(0); setLayoutY(0);
        setPrefSize(400*UNIT, 240*UNIT);
        getChildren().addAll(DecoratingCircle, DecoratingRectangle);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EconomicService.setExecutor(AnimationThreadPool);
        BusinessService.setExecutor(AnimationThreadPool);
    }
}