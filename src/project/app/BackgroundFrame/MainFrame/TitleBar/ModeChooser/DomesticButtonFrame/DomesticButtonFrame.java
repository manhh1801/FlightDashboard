package project.app.BackgroundFrame.MainFrame.TitleBar.ModeChooser.DomesticButtonFrame;

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

public class DomesticButtonFrame extends Pane
{
    public SimpleBooleanProperty UnderlineState, ModeState;

    public ExecutorService AnimationThreadPool;

    public ParallelTransitionService UnderlineEnter, UnderlineExit;
    public FillTransitionService ClickOn, ClickOff;

    public DomesticButtonFrame()
    {
        Text DomesticText=new Text("Domestic");
        DomesticText.setFont(AVERTA(0, 13*UNIT));
        DomesticText.setFill(WHITE(1));
        DomesticText.setTextAlignment(TextAlignment.CENTER);
        DomesticText.setTextOrigin(VPos.CENTER);
        DomesticText.setLayoutX(5*UNIT); DomesticText.setLayoutY(13*UNIT);

        Timeline UnderlineOn=new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(DomesticText.underlineProperty(), true)));
        UnderlineEnter=new ParallelTransitionService(UnderlineOn);
        Timeline UnderlineOff=new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(DomesticText.underlineProperty(), false)));
        UnderlineExit=new ParallelTransitionService(UnderlineOff);
        ClickOn=new FillTransitionService(Duration.millis(50), DomesticText, GRAY(1), WHITE(1));
        ClickOff=new FillTransitionService(Duration.millis(50), DomesticText, WHITE(1), GRAY(1));

        setLayoutX(15*UNIT); setLayoutY(7*UNIT);
        setPrefSize(67*UNIT, 26*UNIT);
        getChildren().add(DomesticText);

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
                        if(ClickOff.isRunning()==true) {ClickOff.cancel();}
                        ClickOn.restart();
                    }
                    else
                    {
                        if(ClickOn.isRunning()==true) {ClickOn.cancel();}
                        ClickOff.restart();
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
                    ModeState.set(false);
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