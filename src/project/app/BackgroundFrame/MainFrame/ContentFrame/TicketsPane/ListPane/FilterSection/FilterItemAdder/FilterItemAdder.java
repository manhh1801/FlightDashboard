package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemAdder;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;
import project.app.Utilities.AnimationUtils.TranslateTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class FilterItemAdder extends Pane
{
    public SimpleBooleanProperty MousePosState;
    public SimpleIntegerProperty FilterItemsCount;

    public ExecutorService AnimationThreadPool;

    public FadeTransitionService EnterService, ExitService, FadeInService, FadeOutService;
    public TranslateTransitionService TranslateService;

    public FilterItemAdder()
    {
        FadeInService=new FadeTransitionService(Duration.millis(150), this, 0, 1);
        FadeInService.setOnRunning
        (
            new EventHandler<WorkerStateEvent>()
            {
                public void handle(WorkerStateEvent workerStateEvent)
                {
                    FadeInService.Transition.stop();
                    setVisible(true);
                }
            }
        );
        FadeOutService=new FadeTransitionService(Duration.millis(150), this, 1, 0);
        FadeOutService.setOnSucceeded
        (
            new EventHandler<WorkerStateEvent>()
            {
                public void handle(WorkerStateEvent workerStateEvent)
                {
                    FadeOutService.Transition.stop();
                    setVisible(false);
                }
            }
        );

        Rectangle FilterItemAdderBackground=new Rectangle();
        FilterItemAdderBackground.setFill(GRAY(0));
        FilterItemAdderBackground.setStroke(GRAY(1)); FilterItemAdderBackground.setStrokeWidth(2*UNIT); FilterItemAdderBackground.setStrokeType(StrokeType.INSIDE); FilterItemAdderBackground.getStrokeDashArray().add(10*UNIT); FilterItemAdderBackground.setStrokeLineCap(StrokeLineCap.ROUND);
        FilterItemAdderBackground.setArcWidth(20*UNIT); FilterItemAdderBackground.setArcHeight(20*UNIT);
        FilterItemAdderBackground.setLayoutX(0); FilterItemAdderBackground.setLayoutY(0);
        FilterItemAdderBackground.setWidth(60*UNIT); FilterItemAdderBackground.setHeight(60*UNIT);
        SVGPath FilterItemAdderIcon=new SVGPath();
        FilterItemAdderIcon.setContent("M9 19C9 19.5523 9.44772 20 10 20C10.5523 20 11 19.5523 11 19V11H19C19.5523 11 20 10.5523 20 10C20 9.44772 19.5523 9 19 9H11V1C11 0.447715 10.5523 0 10 0C9.44772 0 9 0.447716 9 1V9H1C0.447715 9 0 9.44772 0 10C0 10.5523 0.447716 11 1 11H9V19Z");
        FilterItemAdderIcon.setFill(GRAY(1));
        FilterItemAdderIcon.setScaleX(UNIT); FilterItemAdderIcon.setScaleY(UNIT);
        Bounds FilterItemAdderIconBounds=FilterItemAdderIcon.getBoundsInParent();
        FilterItemAdderIcon.setLayoutX(20*UNIT-FilterItemAdderIconBounds.getMinX()); FilterItemAdderIcon.setLayoutY(20*UNIT-FilterItemAdderIconBounds.getMinY());
        Pane FilterItemAdderPane=new Pane(FilterItemAdderBackground, FilterItemAdderIcon);
        FilterItemAdderPane.setLayoutX(0); FilterItemAdderPane.setLayoutY(0);
        FilterItemAdderPane.setPrefSize(60*UNIT, 60*UNIT);

        Rectangle FilterItemAdderBackground_Fade=new Rectangle();
        FilterItemAdderBackground_Fade.setFill(GRAY(0));
        FilterItemAdderBackground_Fade.setStroke(GRAY(1)); FilterItemAdderBackground_Fade.setStrokeWidth(2*UNIT); FilterItemAdderBackground_Fade.setStrokeType(StrokeType.INSIDE); FilterItemAdderBackground_Fade.getStrokeDashArray().add(10*UNIT); FilterItemAdderBackground_Fade.setStrokeLineCap(StrokeLineCap.ROUND);
        FilterItemAdderBackground_Fade.setArcWidth(20*UNIT); FilterItemAdderBackground_Fade.setArcHeight(20*UNIT);
        FilterItemAdderBackground_Fade.setLayoutX(0); FilterItemAdderBackground_Fade.setLayoutY(0);
        FilterItemAdderBackground_Fade.setWidth(60*UNIT); FilterItemAdderBackground_Fade.setHeight(60*UNIT);
        SVGPath FilterItemAdderIcon_Fade=new SVGPath();
        FilterItemAdderIcon_Fade.setContent("M9 19C9 19.5523 9.44772 20 10 20C10.5523 20 11 19.5523 11 19V11H19C19.5523 11 20 10.5523 20 10C20 9.44772 19.5523 9 19 9H11V1C11 0.447715 10.5523 0 10 0C9.44772 0 9 0.447716 9 1V9H1C0.447715 9 0 9.44772 0 10C0 10.5523 0.447716 11 1 11H9V19Z");
        FilterItemAdderIcon_Fade.setFill(GRAY(1));
        FilterItemAdderIcon_Fade.setScaleX(UNIT); FilterItemAdderIcon_Fade.setScaleY(UNIT);
        Bounds FilterItemAdderIcon_FadeBounds=FilterItemAdderIcon_Fade.getBoundsInParent();
        FilterItemAdderIcon_Fade.setLayoutX(20*UNIT-FilterItemAdderIcon_FadeBounds.getMinX()); FilterItemAdderIcon_Fade.setLayoutY(20*UNIT-FilterItemAdderIcon_FadeBounds.getMinY());
        Pane FilterItemAdderPane_Fade=new Pane(FilterItemAdderBackground_Fade, FilterItemAdderIcon_Fade);
        FilterItemAdderPane_Fade.setLayoutX(0); FilterItemAdderPane_Fade.setLayoutY(0);
        FilterItemAdderPane_Fade.setPrefSize(60*UNIT, 60*UNIT);
        FilterItemAdderPane_Fade.setEffect(new GaussianBlur(10*UNIT));
        FilterItemAdderPane_Fade.setOpacity(0);

        EnterService=new FadeTransitionService(Duration.millis(50), FilterItemAdderPane_Fade, 0, 1);
        ExitService=new FadeTransitionService(Duration.millis(50), FilterItemAdderPane_Fade, 1, 0);
        TranslateService=new TranslateTransitionService(Duration.millis(150), this, 0, 0);

        setLayoutX(20*UNIT); setLayoutY(40*UNIT);
        setPrefSize(60*UNIT, 60*UNIT);
        getChildren().addAll(FilterItemAdderPane, FilterItemAdderPane_Fade);

        AnimationThreadPool=Executors.newFixedThreadPool(3);
        setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldState, Boolean NewState)
                {
                    if(NewState==true)
                    {
                        if(ExitService.isRunning()==true) {ExitService.cancel();}
                        EnterService.restart();
                    }
                    else
                    {
                        if(EnterService.isRunning()==true) {EnterService.cancel();}
                        ExitService.restart();
                    }
                }
            }
        );
        setOnMouseEntered
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    MousePosState.set(true);
                }
            }
        );
        setOnMouseExited
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    MousePosState.set(false);
                }
            }
        );

        FilterItemsCount=new SimpleIntegerProperty(0);
        FilterItemsCount.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldValue, Number NewValue)
                {
                    if(TranslateService.isRunning()==true) {TranslateService.cancel();}

                    if(NewValue.intValue()!=11)
                    {
                        TranslateService.setToX((NewValue.intValue())*80*UNIT);
                        if(OldValue.intValue()==11)
                        {
                            if(FadeOutService.isRunning()==true) {FadeOutService.cancel();}
                            FadeInService.restart();
                        }
                        TranslateService.restart();
                    }
                    else
                    {
                        if(FadeInService.isRunning()==true) {FadeInService.cancel();}
                        FadeOutService.restart();
                    }
                }
            }
        );
        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    if(FilterItemsCount.get()!=11)
                    {
                        FilterItemsCount.set(FilterItemsCount.get()+1);
                    }
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
        TranslateService.setExecutor(AnimationThreadPool);
        FadeInService.setExecutor(AnimationThreadPool);
        FadeOutService.setExecutor(AnimationThreadPool);
    }
}