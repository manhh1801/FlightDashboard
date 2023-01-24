package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.ClearButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;
import project.app.Utilities.AnimationUtils.TranslateTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class ClearButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState;
    public SimpleIntegerProperty FilterItemsCount;

    public ExecutorService AnimationThreadPool;

    public FadeTransitionService EnterService, ExitService;
    public TranslateTransitionService TranslateService;

    public ClearButtonFrame()
    {
        SVGPath ClearIcon=new SVGPath();
        ClearIcon.setContent("M0 19V1C0 0.447717 0.447715 1.36532e-06 1 1.36532e-06C1.55228 1.36532e-06 2 0.447717 2 1V7.58576L9.29595 0.289811C9.68647 -0.100713 10.3196 -0.100713 10.7102 0.289811C11.1007 0.680335 11.1007 1.3135 10.7102 1.70402L3.41418 9H19C19.5523 9 20 9.44772 20 10C20 10.5523 19.5523 11 19 11H3.41415L10.7068 18.2927C11.0974 18.6832 11.0974 19.3164 10.7068 19.7069C10.3163 20.0974 9.68314 20.0974 9.29262 19.7069L2 12.4143V19C2 19.5523 1.55228 20 1 20C0.447715 20 0 19.5523 0 19Z");
        ClearIcon.setFill(GRAY(1));
        ClearIcon.setScaleX(UNIT); ClearIcon.setScaleY(UNIT);
        Bounds ClearIconBounds=ClearIcon.getBoundsInParent();
        ClearIcon.setLayoutX(-ClearIconBounds.getMinX()); ClearIcon.setLayoutY(-ClearIconBounds.getMinY());

        SVGPath ClearIcon_Fade=new SVGPath();
        ClearIcon_Fade.setContent("M0 19V1C0 0.447717 0.447715 1.36532e-06 1 1.36532e-06C1.55228 1.36532e-06 2 0.447717 2 1V7.58576L9.29595 0.289811C9.68647 -0.100713 10.3196 -0.100713 10.7102 0.289811C11.1007 0.680335 11.1007 1.3135 10.7102 1.70402L3.41418 9H19C19.5523 9 20 9.44772 20 10C20 10.5523 19.5523 11 19 11H3.41415L10.7068 18.2927C11.0974 18.6832 11.0974 19.3164 10.7068 19.7069C10.3163 20.0974 9.68314 20.0974 9.29262 19.7069L2 12.4143V19C2 19.5523 1.55228 20 1 20C0.447715 20 0 19.5523 0 19Z");
        ClearIcon_Fade.setFill(GRAY(1));
        ClearIcon_Fade.setScaleX(UNIT); ClearIcon_Fade.setScaleY(UNIT);
        Bounds ClearIcon_FadeBounds=ClearIcon_Fade.getBoundsInParent();
        ClearIcon_Fade.setLayoutX(-ClearIcon_FadeBounds.getMinX()); ClearIcon_Fade.setLayoutY(-ClearIcon_FadeBounds.getMinY());
        ClearIcon_Fade.setEffect(new GaussianBlur(10*UNIT));
        ClearIcon_Fade.setOpacity(0);

        EnterService =new FadeTransitionService(Duration.millis(50), ClearIcon_Fade, 0, 1);
        ExitService =new FadeTransitionService(Duration.millis(50), ClearIcon_Fade, 1, 0);
        TranslateService=new TranslateTransitionService(Duration.millis(150), this, 0, 0);

        setLayoutX(100*UNIT); setLayoutY(60*UNIT);
        setPrefSize(20*UNIT, 20*UNIT);
        getChildren().addAll(ClearIcon, ClearIcon_Fade);

        AnimationThreadPool=Executors.newFixedThreadPool(1);
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
                        TranslateService.restart();
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
                    FilterItemsCount.set(0);
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
        TranslateService.setExecutor(AnimationThreadPool);
    }
}