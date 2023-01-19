package project.app.BackgroundFrame.MainFrame.TitleBar.ModeChooser.InternationalButtonFrame;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javafx.util.Duration;

import project.app.Utilities.AnimationUtils.FillTransitionService;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class InternationalButtonFrame extends Pane
{
    public SimpleBooleanProperty UnderlineState, ModeState;

    public ExecutorService AnimationThreadPool;

    public ParallelTransitionService UnderlineEnter, UnderlineExit;
    public FillTransitionService ClickOn, ClickOff;

    public InternationalButtonFrame()
    {
        Text InternationalText=new Text("International");
        InternationalText.setFont(AVERTA(0, 13*UNIT));
        InternationalText.setFill(GRAY(1));
        InternationalText.setTextAlignment(TextAlignment.CENTER);
        InternationalText.setTextOrigin(VPos.CENTER);
        InternationalText.setLayoutX(5*UNIT); InternationalText.setLayoutY(13*UNIT);

        Timeline UnderlineOn=new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(InternationalText.underlineProperty(), true)));
        UnderlineEnter=new ParallelTransitionService(UnderlineOn);
        Timeline UnderlineOff=new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(InternationalText.underlineProperty(), false)));
        UnderlineExit=new ParallelTransitionService(UnderlineOff);
        ClickOn=new FillTransitionService(Duration.millis(50), InternationalText, GRAY(1), WHITE(1));
        ClickOff=new FillTransitionService(Duration.millis(50), InternationalText, WHITE(1), GRAY(1));

        setLayoutX(102*UNIT); setLayoutY(7*UNIT);
        setPrefSize(88*UNIT, 26*UNIT);
        getChildren().add(InternationalText);

        AnimationThreadPool=Executors.newFixedThreadPool(1);
        setAnimationThreadPool(AnimationThreadPool);

        UnderlineState=new SimpleBooleanProperty(false);
        UnderlineState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(UnderlineState.get()==true)
                    {
                        if(UnderlineExit.isRunning()==true) {UnderlineExit.cancel();}
                        UnderlineEnter.restart();
                    }
                    else
                    {
                        if(UnderlineEnter.isRunning()==true) {UnderlineEnter.cancel();}
                        UnderlineExit.restart();
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
                                UnderlineState.set(true);
                            }
            }
        );
        setOnMouseExited
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                            {
                                UnderlineState.set(false);
                            }
            }
        );

        ModeState=new SimpleBooleanProperty(false);
        ModeState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(ModeState.get()==false)
                    {
                        if(ClickOn.isRunning()==true) {ClickOn.cancel();}
                        ClickOff.restart();
                    }
                    else
                    {
                        if(ClickOff.isRunning()==true) {ClickOff.cancel();}
                        ClickOn.restart();
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
                    ModeState.set(true);
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        UnderlineEnter.setExecutor(AnimationThreadPool);
        UnderlineExit.setExecutor(AnimationThreadPool);
        ClickOn.setExecutor(AnimationThreadPool);
        ClickOff.setExecutor(AnimationThreadPool);
    }
}