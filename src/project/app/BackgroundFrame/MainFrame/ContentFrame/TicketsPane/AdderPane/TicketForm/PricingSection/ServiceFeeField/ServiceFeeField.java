package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.ServiceFeeField;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.ServiceFeeField.LetterCountDisplay.LetterCountDisplay;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.ServiceFeeField.ServiceFeeFieldBackground.ServiceFeeFieldBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.ServiceFeeField.ServiceFeeFieldTitle.ServiceFeeFieldTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.ServiceFeeField.ServiceFeeTypeField.ServiceFeeTypeField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.UNIT;

public class ServiceFeeField extends Pane
{
    public SimpleBooleanProperty TypingState;

    public ExecutorService AnimationThreadPool;

    public ServiceFeeFieldBackground ServiceFeeFieldBackground_var;
    public ServiceFeeFieldTitle ServiceFeeFieldTitle_var;
    public LetterCountDisplay LetterCountDisplay_var;
    public ServiceFeeTypeField ServiceFeeTypeField_var;

    public ServiceFeeField()
    {
        ServiceFeeFieldBackground_var=new ServiceFeeFieldBackground();
        ServiceFeeFieldTitle_var=new ServiceFeeFieldTitle();
        LetterCountDisplay_var=new LetterCountDisplay();
        ServiceFeeTypeField_var=new ServiceFeeTypeField();

        setLayoutX(0); setLayoutY(100*UNIT);
        setPrefSize(160*UNIT, 50*UNIT);
        getChildren().addAll(ServiceFeeFieldBackground_var, ServiceFeeFieldTitle_var, LetterCountDisplay_var, ServiceFeeTypeField_var);

        AnimationThreadPool=Executors.newFixedThreadPool(3);
        ServiceFeeFieldBackground_var.setAnimationThreadPool(AnimationThreadPool);
        ServiceFeeFieldTitle_var.setAnimationThreadPool(AnimationThreadPool);
        LetterCountDisplay_var.setAnimationThreadPool(AnimationThreadPool);

        TypingState=new SimpleBooleanProperty();
        TypingState.bind(ServiceFeeTypeField_var.focusedProperty());
        TypingState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(TypingState.get()==true)
                    {
                        if(ServiceFeeFieldBackground_var.TypingOffService.isRunning()==true) {
                            ServiceFeeFieldBackground_var.TypingOffService.cancel();}
                        if(ServiceFeeFieldTitle_var.TypingOffService.isRunning()==true) {
                            ServiceFeeFieldTitle_var.TypingOffService.cancel();}
                        if(LetterCountDisplay_var.TypingOffService.isRunning()==true) {LetterCountDisplay_var.TypingOffService.cancel();}
                        ServiceFeeFieldBackground_var.TypingOnService.restart();
                        ServiceFeeFieldTitle_var.TypingOnService.restart();
                        LetterCountDisplay_var.TypingOnService.restart();
                    }
                    else
                    {
                        if(ServiceFeeFieldBackground_var.TypingOnService.isRunning()==true) {
                            ServiceFeeFieldBackground_var.TypingOnService.cancel();}
                        if(ServiceFeeFieldTitle_var.TypingOnService.isRunning()==true) {
                            ServiceFeeFieldTitle_var.TypingOnService.cancel();}
                        if(LetterCountDisplay_var.TypingOnService.isRunning()==true) {LetterCountDisplay_var.TypingOnService.cancel();}
                        ServiceFeeFieldBackground_var.TypingOffService.restart();
                        ServiceFeeFieldTitle_var.TypingOffService.restart();
                        LetterCountDisplay_var.TypingOffService.restart();
                    }
                }
            }
        );
        addEventFilter
        (
            MouseEvent.MOUSE_PRESSED,
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                            {
                                ServiceFeeTypeField_var.requestFocus();
                            }
            }
        );
        addEventHandler
        (
            MouseEvent.MOUSE_RELEASED,
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                            {
                                ServiceFeeTypeField_var.requestFocus();
                            }
            }
        );

        LetterCountDisplay_var.LetterCount.bindBidirectional(ServiceFeeTypeField_var.LetterCount);
    }
}