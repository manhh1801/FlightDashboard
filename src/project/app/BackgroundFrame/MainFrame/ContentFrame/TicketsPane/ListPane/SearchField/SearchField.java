package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchBackground.SearchBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchDeleteButtonFrame.SearchDeleteButtonFrame;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchIcon.SearchIcon;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchTextField.SearchTextField;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.*;

public class SearchField extends Pane
{
    public SimpleBooleanProperty TypingState;
    public SimpleStringProperty SearchString;

    public ExecutorService AnimationThreadPool;

    public SearchBackground SearchBackground_var;
    public SearchIcon SearchIcon_var;
    public SearchTextField SearchTextField_var;
    public SearchDeleteButtonFrame SearchDeleteButtonFrame_var;

    public SearchField()
    {
        SearchBackground_var=new SearchBackground();
        SearchIcon_var=new SearchIcon();
        SearchTextField_var=new SearchTextField();
        SearchDeleteButtonFrame_var=new SearchDeleteButtonFrame();

        SearchDeleteButtonFrame_var.setSearchTextField(SearchTextField_var);

        setLayoutX(0); setLayoutY(0);
        setPrefSize(940*UNIT, 60*UNIT);
        getChildren().addAll(SearchBackground_var, SearchIcon_var, SearchTextField_var, SearchDeleteButtonFrame_var);

        AnimationThreadPool= Executors.newFixedThreadPool(4);
        SearchBackground_var.setAnimationThreadPool(AnimationThreadPool);
        SearchIcon_var.setAnimationThreadPool(AnimationThreadPool);
        SearchDeleteButtonFrame_var.SearchDeleteIcon_var.setAnimationThreadPool(AnimationThreadPool);

        TypingState=new SimpleBooleanProperty(false);
        TypingState.bind(SearchTextField_var.focusedProperty());
        TypingState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(TypingState.get()==true)
                    {
                        if(SearchBackground_var.TypingOffService.isRunning()==true) {SearchBackground_var.TypingOffService.cancel();}
                        if(SearchIcon_var.TypingOffService.isRunning()==true) {SearchIcon_var.TypingOffService.cancel();}
                        if(SearchDeleteButtonFrame_var.SearchDeleteIcon_var.TypingOffService.isRunning()==true) {SearchDeleteButtonFrame_var.SearchDeleteIcon_var.TypingOffService.cancel();}
                        SearchBackground_var.TypingOnService.restart();
                        SearchIcon_var.TypingOnService.restart();
                        SearchDeleteButtonFrame_var.SearchDeleteIcon_var.TypingOnService.restart();
                    }
                    else
                    {
                        if(SearchBackground_var.TypingOnService.isRunning()==true) {SearchBackground_var.TypingOnService.cancel();}
                        if(SearchIcon_var.TypingOnService.isRunning()==true) {SearchIcon_var.TypingOnService.cancel();}
                        if(SearchDeleteButtonFrame_var.SearchDeleteIcon_var.TypingOnService.isRunning()==true) {SearchDeleteButtonFrame_var.SearchDeleteIcon_var.TypingOnService.cancel();}
                        SearchBackground_var.TypingOffService.restart();
                        SearchIcon_var.TypingOffService.restart();
                        SearchDeleteButtonFrame_var.SearchDeleteIcon_var.TypingOffService.restart();
                    }
                }
            }
        );

        SearchString=new SimpleStringProperty("");
        SearchString.bind(SearchTextField_var.textProperty());
        SearchString.addListener
        (
            new ChangeListener<String>()
            {
                public void changed(ObservableValue<? extends String> observableValue, String OldString, String NewString)
                {
                    if(OldString!=""&&NewString=="")
                    {
                        if(SearchDeleteButtonFrame_var.FadeInService.isRunning()==true) {SearchDeleteButtonFrame_var.FadeInService.cancel();}
                        SearchDeleteButtonFrame_var.FadeOutService.restart();
                    }
                    else if(OldString==""&&NewString!="")
                    {
                        if(SearchDeleteButtonFrame_var.FadeOutService.isRunning()==true) {SearchDeleteButtonFrame_var.FadeOutService.cancel();}
                        SearchDeleteButtonFrame_var.FadeInService.restart();
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
                    SearchTextField_var.requestFocus();
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
                    SearchTextField_var.requestFocus();
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
    }
}