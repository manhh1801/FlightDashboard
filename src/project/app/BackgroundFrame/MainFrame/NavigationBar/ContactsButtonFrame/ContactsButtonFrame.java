package project.app.BackgroundFrame.MainFrame.NavigationBar.ContactsButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.NavigationBar.ContactsButtonFrame.ContactsBackground.ContactsBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.ContactsButtonFrame.ContactsIcon.ContactsIcon;
import project.app.BackgroundFrame.MainFrame.NavigationBar.ContactsButtonFrame.ContactsIcon.ContactsIcon_Fade;

import static project.app.Utilities.SizeUtils.*;

public class ContactsButtonFrame extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;

    public ExecutorService AnimationThreadPool;

    public ContactsBackground ContactsBackground_var;
    public ContactsIcon ContactsIcon_var;
    public ContactsIcon_Fade ContactsIcon_Fade_var;

    public ContactsButtonFrame()
    {
        ContactsBackground_var=new ContactsBackground();
        ContactsIcon_var=new ContactsIcon();
        ContactsIcon_Fade_var=new ContactsIcon_Fade();

        setPrefSize(40 * UNIT, 40 * UNIT);
        getChildren().addAll(ContactsBackground_var, ContactsIcon_var, ContactsIcon_Fade_var);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        ContactsBackground_var.setAnimationThreadPool(AnimationThreadPool);
        ContactsIcon_var.setAnimationThreadPool(AnimationThreadPool);
        ContactsIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        final SimpleBooleanProperty LastFlag=new SimpleBooleanProperty(false);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(ClickState.get()==false)
                    {
                        if(MousePosState.get()==true)
                        {
                            if(ContactsBackground_var.ExitService.isRunning()==true) {ContactsBackground_var.ExitService.cancel();}
                            if(ContactsIcon_Fade_var.FadeOutService.isRunning()==true) {ContactsIcon_Fade_var.FadeOutService.cancel();}
                            ContactsBackground_var.EnterService.restart();
                            ContactsIcon_Fade_var.FadeInService.restart();
                        }
                        else
                        {
                            if(ContactsBackground_var.EnterService.isRunning()==true) {ContactsBackground_var.ExitService.cancel();}
                            if(ContactsIcon_Fade_var.FadeInService.isRunning()==true) {ContactsIcon_Fade_var.FadeOutService.cancel();}
                            ContactsBackground_var.ExitService.restart();
                            ContactsIcon_Fade_var.FadeOutService.restart();
                        }
                    }
                    else
                    {
                        if(MousePosState.get()==true)
                        {
                            if(ContactsIcon_Fade_var.FadeOutService.isRunning()==true) {ContactsIcon_Fade_var.FadeOutService.cancel();}
                            ContactsIcon_Fade_var.FadeInService.restart();
                        }
                        else
                        {
                            if(LastFlag.get()==false)
                            {
                                if(ContactsIcon_Fade_var.FadeInService.isRunning()==true) {ContactsIcon_Fade_var.FadeOutService.cancel();}
                                ContactsIcon_Fade_var.FadeOutService.restart();
                            }
                            else
                            {
                                if(ContactsBackground_var.EnterService.isRunning()==true) {ContactsBackground_var.ExitService.cancel();}
                                if(ContactsIcon_Fade_var.FadeInService.isRunning()==true) {ContactsIcon_Fade_var.FadeOutService.cancel();}
                                ContactsBackground_var.ExitService.restart();
                                ContactsIcon_Fade_var.FadeOutService.restart();
                                LastFlag.set(false);
                            }
                        }
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

        ClickState=new SimpleBooleanProperty(false);
        ClickState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(ClickState.get()==true)
                    {
                        if(ContactsIcon_var.ClickOffService.isRunning()==true) {ContactsIcon_var.ClickOffService.cancel();}
                        if(ContactsIcon_Fade_var.ClickOffService.isRunning()==true) {ContactsIcon_Fade_var.ClickOffService.cancel();}
                        ContactsIcon_var.ClickOnService.restart();
                        ContactsIcon_Fade_var.ClickOnService.restart();
                        LastFlag.set(true);
                    }
                    else
                    {
                        if(ContactsIcon_var.ClickOnService.isRunning()==true) {ContactsIcon_var.ClickOnService.cancel();}
                        if(ContactsIcon_Fade_var.ClickOnService.isRunning()==true) {ContactsIcon_Fade_var.ClickOnService.cancel();}
                        ContactsIcon_var.ClickOffService.restart();
                        ContactsIcon_Fade_var.ClickOffService.restart();
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
                    ClickState.set(true);
                }
            }
        );
    }
}
