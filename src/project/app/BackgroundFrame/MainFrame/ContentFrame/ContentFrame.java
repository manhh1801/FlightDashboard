package project.app.BackgroundFrame.MainFrame.ContentFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.StackPane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.ContentFrame.ContactsPane.ContactsPane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.HomePane.HomePane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.SchedulesPane.SchedulesPane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.SettingsPane.SettingsPane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.StatisticsPane.StatisticsPane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.TicketsPane;

import static project.app.Utilities.SizeUtils.*;

public class ContentFrame extends StackPane
{
    public SimpleIntegerProperty PaneState;

    public ExecutorService AnimationThreadPool;

    public HomePane HomePane_var;
    public SchedulesPane SchedulesPane_var;
    public TicketsPane TicketsPane_var;
    public StatisticsPane StatisticsPane_var;
    public ContactsPane ContactsPane_var;
    public SettingsPane SettingsPane_var;

    public ContentFrame()
    {
        HomePane_var=new HomePane();
        SchedulesPane_var=new SchedulesPane();
        TicketsPane_var=new TicketsPane();
        StatisticsPane_var=new StatisticsPane();
        ContactsPane_var=new ContactsPane();
        SettingsPane_var=new SettingsPane();

        setLayoutX(140*UNIT); setLayoutY(200*UNIT);
        setPrefSize(1420*UNIT, 960*UNIT);
        getChildren().addAll(HomePane_var, SchedulesPane_var, TicketsPane_var, StatisticsPane_var, ContactsPane_var, SettingsPane_var);

        AnimationThreadPool= Executors.newFixedThreadPool(1);
        HomePane_var.setAnimationThreadPool(AnimationThreadPool);
        SchedulesPane_var.setAnimationThreadPool(AnimationThreadPool);
        TicketsPane_var.setAnimationThreadPool(AnimationThreadPool);
        StatisticsPane_var.setAnimationThreadPool(AnimationThreadPool);
        ContactsPane_var.setAnimationThreadPool(AnimationThreadPool);
        SettingsPane_var.setAnimationThreadPool(AnimationThreadPool);

        SimpleIntegerProperty LastFlag=new SimpleIntegerProperty(1);
        PaneState=new SimpleIntegerProperty(1);
        PaneState.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldCurrentFlag, Number NewCurrentFlag)
                {
                    if(LastFlag.get()==3) {if(TicketsPane_var.FadeOutService.isRunning()==true) {TicketsPane_var.FadeOutService.cancel();}}
                    else if(LastFlag.get()==2) {if(SchedulesPane_var.FadeOutService.isRunning()==true) {SchedulesPane_var.FadeOutService.cancel();}}
                    else if(LastFlag.get()==1) {if(HomePane_var.FadeOutService.isRunning()==true) {HomePane_var.FadeOutService.cancel();}}
                    else if(LastFlag.get()==4) {if(StatisticsPane_var.FadeOutService.isRunning()==true) {StatisticsPane_var.FadeOutService.cancel();}}
                    else if(LastFlag.get()==5) {if(ContactsPane_var.FadeOutService.isRunning()==true) {ContactsPane_var.FadeOutService.cancel();}}
                    else {if(SettingsPane_var.FadeOutService.isRunning()==true) {SettingsPane_var.FadeOutService.cancel();}}

                    LastFlag.set(OldCurrentFlag.intValue());
                    if(LastFlag.get()==3)
                    {
                        if(TicketsPane_var.FadeInService.isRunning()==true) {TicketsPane_var.FadeInService.cancel();}
                        TicketsPane_var.FadeOutService.restart();
                    }
                    else if(LastFlag.get()==2)
                    {
                        if(SchedulesPane_var.FadeInService.isRunning()==true) {TicketsPane_var.FadeInService.cancel();}
                        SchedulesPane_var.FadeOutService.restart();
                    }
                    else if(LastFlag.get()==1)
                    {
                        if(HomePane_var.FadeInService.isRunning()==true) {TicketsPane_var.FadeInService.cancel();}
                        HomePane_var.FadeOutService.restart();
                    }
                    else if(LastFlag.get()==4)
                    {
                        if(StatisticsPane_var.FadeInService.isRunning()==true) {TicketsPane_var.FadeInService.cancel();}
                        StatisticsPane_var.FadeOutService.restart();
                    }
                    else if(LastFlag.get()==5)
                    {
                        if(ContactsPane_var.FadeInService.isRunning()==true) {TicketsPane_var.FadeInService.cancel();}
                        ContactsPane_var.FadeOutService.restart();
                    }
                    else
                    {
                        if(SettingsPane_var.FadeInService.isRunning()==true) {TicketsPane_var.FadeInService.cancel();}
                        SettingsPane_var.FadeOutService.restart();
                    }

                    if(NewCurrentFlag.intValue()==3)
                    {
                        TicketsPane_var.FadeInService.restart();
                        TicketsPane_var.toFront();
                    }
                    else if(NewCurrentFlag.intValue()==2)
                    {
                        SchedulesPane_var.FadeInService.restart();
                        SchedulesPane_var.toFront();
                    }
                    else if(NewCurrentFlag.intValue()==1)
                    {
                        HomePane_var.FadeInService.restart();
                        HomePane_var.toFront();
                    }
                    else if(NewCurrentFlag.intValue()==4)
                    {
                        StatisticsPane_var.FadeInService.restart();
                        StatisticsPane_var.toFront();
                    }
                    else if(NewCurrentFlag.intValue()==5)
                    {
                        ContactsPane_var.FadeInService.restart();
                        ContactsPane_var.toFront();
                    }
                    else
                    {
                        SettingsPane_var.FadeInService.restart();
                        SettingsPane_var.toFront();
                    }
                }
            }
        );
    }
}