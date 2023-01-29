package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DepositButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DepositButtonFrame.DepositBackground.DepositBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DepositButtonFrame.DepositBackground.DepositBackground_Fade;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DepositButtonFrame.DepositTitle.DepositTitle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.UNIT;

public class DepositButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState;

    public ExecutorService AnimationThreadPool;

    public DepositBackground DepositBackground_var;
    public DepositBackground_Fade DepositBackground_Fade_var;
    public DepositTitle DepositTitle_var;

    public DepositButtonFrame()
    {
        DepositBackground_var=new DepositBackground();
        DepositBackground_Fade_var=new DepositBackground_Fade();
        DepositTitle_var=new DepositTitle();

        setLayoutX(160*UNIT); setLayoutY(570*UNIT);
        setPrefSize(120*UNIT, 40*UNIT);
        getChildren().addAll(DepositBackground_var, DepositBackground_Fade_var, DepositTitle_var);

        AnimationThreadPool= Executors.newFixedThreadPool(1);
        DepositBackground_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(MousePosState.get()==true)
                    {
                        if(DepositBackground_Fade_var.ExitService.isRunning()==true) {DepositBackground_Fade_var.ExitService.cancel();}
                        DepositBackground_Fade_var.EnterService.restart();
                    }
                    else
                    {
                        if(DepositBackground_Fade_var.EnterService.isRunning()==true) {DepositBackground_Fade_var.EnterService.cancel();}
                        DepositBackground_Fade_var.ExitService.restart();
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
}