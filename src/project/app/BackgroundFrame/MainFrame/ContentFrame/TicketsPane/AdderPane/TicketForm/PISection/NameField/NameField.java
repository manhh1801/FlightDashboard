package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.NameField;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.NameField.LetterCountDisplay.LetterCountDisplay;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.NameField.NameFieldBackground.NameFieldBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.NameField.NameFieldTitle.NameFieldTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.NameField.NameTypeField.NameTypeField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.UNIT;

public class NameField extends Pane
{
    public SimpleBooleanProperty TypingState;

    public ExecutorService AnimationThreadPool;

    public NameFieldBackground NameFieldBackground_var;
    public NameFieldTitle NameFieldTitle_var;
    public LetterCountDisplay LetterCountDisplay_var;
    public NameTypeField NameTypeField_var;

    public NameField()
    {
        NameFieldBackground_var=new NameFieldBackground();
        NameFieldTitle_var=new NameFieldTitle();
        LetterCountDisplay_var=new LetterCountDisplay();
        NameTypeField_var=new NameTypeField();

        setLayoutX(0); setLayoutY(30*UNIT);
        setPrefSize(260*UNIT, 50*UNIT);
        getChildren().addAll(NameFieldBackground_var, NameFieldTitle_var, LetterCountDisplay_var, NameTypeField_var);

        AnimationThreadPool=Executors.newFixedThreadPool(3);
        NameFieldBackground_var.setAnimationThreadPool(AnimationThreadPool);
        NameFieldTitle_var.setAnimationThreadPool(AnimationThreadPool);
        LetterCountDisplay_var.setAnimationThreadPool(AnimationThreadPool);

        TypingState=new SimpleBooleanProperty();
        TypingState.bind(NameTypeField_var.focusedProperty());
        TypingState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(TypingState.get()==true)
                    {
                        if(NameFieldBackground_var.TypingOffService.isRunning()==true) {NameFieldBackground_var.TypingOffService.cancel();}
                        if(NameFieldTitle_var.TypingOffService.isRunning()==true) {NameFieldTitle_var.TypingOffService.cancel();}
                        if(LetterCountDisplay_var.TypingOffService.isRunning()==true) {LetterCountDisplay_var.TypingOffService.cancel();}
                        NameFieldBackground_var.TypingOnService.restart();
                        NameFieldTitle_var.TypingOnService.restart();
                        LetterCountDisplay_var.TypingOnService.restart();
                    }
                    else
                    {
                        if(NameFieldBackground_var.TypingOnService.isRunning()==true) {NameFieldBackground_var.TypingOnService.cancel();}
                        if(NameFieldTitle_var.TypingOnService.isRunning()==true) {NameFieldTitle_var.TypingOnService.cancel();}
                        if(LetterCountDisplay_var.TypingOnService.isRunning()==true) {LetterCountDisplay_var.TypingOnService.cancel();}
                        NameFieldBackground_var.TypingOffService.restart();
                        NameFieldTitle_var.TypingOffService.restart();
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
                                NameTypeField_var.requestFocus();
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
                                NameTypeField_var.requestFocus();
                            }
            }
        );

        LetterCountDisplay_var.LetterCount.bindBidirectional(NameTypeField_var.LetterCount);
    }
}