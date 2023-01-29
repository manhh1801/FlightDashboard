package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.BaseCostField;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.BaseCostField.LetterCountDisplay.LetterCountDisplay;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.BaseCostField.BaseCostFieldBackground.BaseCostFieldBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.BaseCostField.BaseCostFieldTitle.BaseCostFieldTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.BaseCostField.BaseCostTypeField.BaseCostTypeField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.UNIT;

public class BaseCostField extends Pane
{
    public SimpleBooleanProperty TypingState;

    public SimpleIntegerProperty BaseCost;

    public ExecutorService AnimationThreadPool;

    public BaseCostFieldBackground BaseCostFieldBackground_var;
    public BaseCostFieldTitle BaseCostFieldTitle_var;
    public LetterCountDisplay LetterCountDisplay_var;
    public BaseCostTypeField BaseCostTypeField_var;

    public BaseCostField()
    {
        BaseCostFieldBackground_var=new BaseCostFieldBackground();
        BaseCostFieldTitle_var=new BaseCostFieldTitle();
        LetterCountDisplay_var=new LetterCountDisplay();
        BaseCostTypeField_var=new BaseCostTypeField();

        setLayoutX(0); setLayoutY(30*UNIT);
        setPrefSize(160*UNIT, 50*UNIT);
        getChildren().addAll(BaseCostFieldBackground_var, BaseCostFieldTitle_var, LetterCountDisplay_var, BaseCostTypeField_var);

        AnimationThreadPool=Executors.newFixedThreadPool(3);
        BaseCostFieldBackground_var.setAnimationThreadPool(AnimationThreadPool);
        BaseCostFieldTitle_var.setAnimationThreadPool(AnimationThreadPool);
        LetterCountDisplay_var.setAnimationThreadPool(AnimationThreadPool);

        BaseCost=new SimpleIntegerProperty(20000);
        BaseCost.bind
        (
            new IntegerBinding()
            {
                {bind(BaseCostTypeField_var.textProperty());}
                protected int computeValue()
                {
                    String Value=BaseCostTypeField_var.textProperty().get();
                    try
                    {
                        if(Value!="") {return Integer.parseInt(Value);}
                        else {return 0;}
                    }
                    catch(Exception e) {return 0;}
                }
            }
        );

        TypingState=new SimpleBooleanProperty();
        TypingState.bind(BaseCostTypeField_var.focusedProperty());
        TypingState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(TypingState.get()==true)
                    {
                        if(BaseCostFieldBackground_var.TypingOffService.isRunning()==true) {
                            BaseCostFieldBackground_var.TypingOffService.cancel();}
                        if(BaseCostFieldTitle_var.TypingOffService.isRunning()==true) {
                            BaseCostFieldTitle_var.TypingOffService.cancel();}
                        if(LetterCountDisplay_var.TypingOffService.isRunning()==true) {LetterCountDisplay_var.TypingOffService.cancel();}
                        BaseCostFieldBackground_var.TypingOnService.restart();
                        BaseCostFieldTitle_var.TypingOnService.restart();
                        LetterCountDisplay_var.TypingOnService.restart();
                    }
                    else
                    {
                        if(BaseCostFieldBackground_var.TypingOnService.isRunning()==true) {
                            BaseCostFieldBackground_var.TypingOnService.cancel();}
                        if(BaseCostFieldTitle_var.TypingOnService.isRunning()==true) {
                            BaseCostFieldTitle_var.TypingOnService.cancel();}
                        if(LetterCountDisplay_var.TypingOnService.isRunning()==true) {LetterCountDisplay_var.TypingOnService.cancel();}
                        BaseCostFieldBackground_var.TypingOffService.restart();
                        BaseCostFieldTitle_var.TypingOffService.restart();
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
                                BaseCostTypeField_var.requestFocus();
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
                                BaseCostTypeField_var.requestFocus();
                            }
            }
        );

        setOnKeyPressed
        (
            new EventHandler<KeyEvent>()
            {
                public void handle(KeyEvent keyEvent)
                {
                    if(keyEvent.getCode()==KeyCode.ESCAPE||keyEvent.getCode()==KeyCode.ENTER) {requestFocus();}
                }
            }
        );

        LetterCountDisplay_var.LetterCount.bindBidirectional(BaseCostTypeField_var.LetterCount);
    }
}