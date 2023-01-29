package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PassportIDField;

import javafx.beans.binding.StringBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PassportIDField.LetterCountDisplay.LetterCountDisplay;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PassportIDField.PassportIDFieldBackground.PassportIDFieldBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PassportIDField.PassportIDFieldTitle.PassportIDFieldTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PassportIDField.PassportIDTypeField.PassportIDTypeField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.UNIT;

public class PassportIDField extends Pane
{
    public SimpleBooleanProperty TypingState;
    public SimpleStringProperty PassportID;

    public ExecutorService AnimationThreadPool;

    public PassportIDFieldBackground PassportIDFieldBackground_var;
    public PassportIDFieldTitle PassportIDFieldTitle_var;
    public LetterCountDisplay LetterCountDisplay_var;
    public PassportIDTypeField PassportIDTypeField_var;

    public PassportIDField()
    {
        PassportIDFieldBackground_var=new PassportIDFieldBackground();
        PassportIDFieldTitle_var=new PassportIDFieldTitle();
        LetterCountDisplay_var=new LetterCountDisplay();
        PassportIDTypeField_var=new PassportIDTypeField();

        setLayoutX(280*UNIT); setLayoutY(30*UNIT);
        setPrefSize(160*UNIT, 50*UNIT);
        getChildren().addAll(PassportIDFieldBackground_var, PassportIDFieldTitle_var, LetterCountDisplay_var, PassportIDTypeField_var);

        AnimationThreadPool=Executors.newFixedThreadPool(3);
        PassportIDFieldBackground_var.setAnimationThreadPool(AnimationThreadPool);
        PassportIDFieldTitle_var.setAnimationThreadPool(AnimationThreadPool);
        LetterCountDisplay_var.setAnimationThreadPool(AnimationThreadPool);

        PassportID=new SimpleStringProperty("");
        PassportID.bind
        (
            new StringBinding()
            {
                {bind(PassportIDTypeField_var.textProperty());}
                protected String computeValue()
                {
                    return PassportIDTypeField_var.textProperty().get().trim();
                }
            }
        );

        TypingState=new SimpleBooleanProperty();
        TypingState.bind(PassportIDTypeField_var.focusedProperty());
        TypingState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(TypingState.get()==true)
                    {
                        if(PassportIDFieldBackground_var.TypingOffService.isRunning()==true) {
                            PassportIDFieldBackground_var.TypingOffService.cancel();}
                        if(PassportIDFieldTitle_var.TypingOffService.isRunning()==true) {
                            PassportIDFieldTitle_var.TypingOffService.cancel();}
                        if(LetterCountDisplay_var.TypingOffService.isRunning()==true) {LetterCountDisplay_var.TypingOffService.cancel();}
                        PassportIDFieldBackground_var.TypingOnService.restart();
                        PassportIDFieldTitle_var.TypingOnService.restart();
                        LetterCountDisplay_var.TypingOnService.restart();
                    }
                    else
                    {
                        if(PassportIDFieldBackground_var.TypingOnService.isRunning()==true) {
                            PassportIDFieldBackground_var.TypingOnService.cancel();}
                        if(PassportIDFieldTitle_var.TypingOnService.isRunning()==true) {
                            PassportIDFieldTitle_var.TypingOnService.cancel();}
                        if(LetterCountDisplay_var.TypingOnService.isRunning()==true) {LetterCountDisplay_var.TypingOnService.cancel();}
                        PassportIDFieldBackground_var.TypingOffService.restart();
                        PassportIDFieldTitle_var.TypingOffService.restart();
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
                                PassportIDTypeField_var.requestFocus();
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
                                PassportIDTypeField_var.requestFocus();
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

        LetterCountDisplay_var.LetterCount.bindBidirectional(PassportIDTypeField_var.LetterCount);
    }
}