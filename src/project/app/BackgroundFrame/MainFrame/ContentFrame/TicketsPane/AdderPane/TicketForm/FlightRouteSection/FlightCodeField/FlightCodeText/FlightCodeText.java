package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField.FlightCodeText;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FillTransitionService;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.ColorUtils.GRAY;
import static project.app.Utilities.ColorUtils.WHITE;
import static project.app.Utilities.FontUtils.AVERTA;
import static project.app.Utilities.MapUtils.MapUtils.getLocationName;
import static project.app.Utilities.SizeUtils.UNIT;

public class FlightCodeText extends Text
{
    public SimpleStringProperty FlightCode;

    public SimpleBooleanProperty FocusState;

    public ExecutorService AnimationThreadPool;

    public FillTransitionService FocusOnService, FocusOffService;
    public ParallelTransitionService TextService;

    public FlightCodeText()
    {
        FocusOnService=new FillTransitionService(Duration.millis(50), this, GRAY(1), WHITE(1));
        FocusOffService=new FillTransitionService(Duration.millis(50), this, WHITE(1), GRAY(1));
        TextService=new ParallelTransitionService(new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(textProperty(), "To"))));

        setText("Flight");
        setFont(AVERTA(0, 13*UNIT));
        setFill(GRAY(1));
        setTextAlignment(TextAlignment.LEFT);
        setTextOrigin(VPos.CENTER);
        setLayoutX(15*UNIT); setLayoutY(20*UNIT);

        AnimationThreadPool=Executors.newFixedThreadPool(2);
        setAnimationThreadPool(AnimationThreadPool);

        FlightCode =new SimpleStringProperty("--");
        FlightCode.addListener
        (
            new ChangeListener<String>()
            {
                public void changed(ObservableValue<? extends String> observableValue, String OldValue, String NewValue)
                {
                    if(TextService.isRunning()==true) {TextService.cancel();}
                    if(FlightCode.get()!="--") {TextService.setAnimation(new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(textProperty(), NewValue))));}
                    else {TextService.setAnimation(new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(textProperty(), "Flight"))));}
                    TextService.restart();
                }
            }
        );

        FocusState=new SimpleBooleanProperty(false);
        FocusState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        if(FocusOffService.isRunning()==true) {FocusOffService.cancel();}
                        if(TextService.isRunning()==true) {TextService.cancel();}
                        TextService.setAnimation(new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(textProperty(), "Flight"))));
                        FocusOnService.restart();
                        TextService.restart();
                    }
                    else
                    {
                        if(FocusOnService.isRunning()==true) {FocusOnService.cancel();}
                        if(TextService.isRunning()==true) {TextService.cancel();}
                        if(FlightCode.get()!="--") {TextService.setAnimation(new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(textProperty(), FlightCode.get()))));}
                        else {TextService.setAnimation(new Timeline(new KeyFrame(Duration.millis(50), new KeyValue(textProperty(), "Flight"))));}
                        FocusOffService.restart();
                        TextService.restart();
                    }
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FocusOnService.setExecutor(AnimationThreadPool);
        FocusOffService.setExecutor(AnimationThreadPool);
        TextService.setExecutor(AnimationThreadPool);
    }
}