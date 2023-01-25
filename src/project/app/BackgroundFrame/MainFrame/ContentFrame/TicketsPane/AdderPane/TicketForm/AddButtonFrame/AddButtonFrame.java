package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.AddButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class AddButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState;

    public ExecutorService AnimationThreadPool;

    public FadeTransitionService EnterService, ExitService;

    public AddButtonFrame()
    {
        Text AddIcon=new Text("+");
        AddIcon.setFont(AVERTA(1, 28*UNIT));
        AddIcon.setFill(WHITE(1));
        AddIcon.setTextAlignment(TextAlignment.CENTER);
        AddIcon.setTextOrigin(VPos.CENTER);
        AddIcon.setLayoutX(0*UNIT); AddIcon.setLayoutY(18*UNIT);
        Text AddIcon_Fade=new Text("+");
        AddIcon_Fade.setFont(AVERTA(1, 28*UNIT));
        AddIcon_Fade.setFill(WHITE(1));
        AddIcon_Fade.setTextAlignment(TextAlignment.CENTER);
        AddIcon_Fade.setTextOrigin(VPos.CENTER);
        AddIcon_Fade.setLayoutX(0*UNIT); AddIcon_Fade.setLayoutY(18*UNIT);
        AddIcon_Fade.setEffect(new GaussianBlur(10*UNIT));
        AddIcon_Fade.setOpacity(0);

        EnterService=new FadeTransitionService(Duration.millis(50), AddIcon_Fade, 0, 1);
        ExitService=new FadeTransitionService(Duration.millis(50), AddIcon_Fade, 1, 0);

        setLayoutX(420*UNIT); setLayoutY(2*UNIT);
        setPrefSize(20*UNIT, 36*UNIT);
        getChildren().addAll(AddIcon, AddIcon_Fade);

        AnimationThreadPool= Executors.newFixedThreadPool(1);
        setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
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
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
    }
}