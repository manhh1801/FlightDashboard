package project.app.BackgroundFrame.MainFrame.NavigationBar;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.NavigationBar.AppLogo.AppLogo;
import project.app.BackgroundFrame.MainFrame.NavigationBar.ContactsButtonFrame.ContactsButtonFrame;
import project.app.BackgroundFrame.MainFrame.NavigationBar.HomeButtonFrame.HomeButtonFrame;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.SchedulesButtonFrame;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SettingsButtonFrame.SettingsButtonFrame;
import project.app.BackgroundFrame.MainFrame.NavigationBar.StatisticsButtonFrame.StatisticsButtonFrame;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.TicketsButtonFrame;

import static project.app.Utilities.SizeUtils.*;

public class NavigationBar extends Pane
{
    public SimpleIntegerProperty PaneState;
    public SimpleBooleanProperty PaneStateController;

    public AppLogo AppLogo_var;
    public HomeButtonFrame HomeButtonFrame_var;
    public SchedulesButtonFrame SchedulesButtonFrame_var;
    public TicketsButtonFrame TicketsButtonFrame_var;
    public StatisticsButtonFrame StatisticsButtonFrame_var;
    public ContactsButtonFrame ContactsButtonFrame_var;
    public SettingsButtonFrame SettingsButtonFrame_var;

    public NavigationBar()
    {
        AppLogo_var=new AppLogo();
        HomeButtonFrame_var=new HomeButtonFrame();
        SchedulesButtonFrame_var =new SchedulesButtonFrame();
        TicketsButtonFrame_var=new TicketsButtonFrame();
        StatisticsButtonFrame_var=new StatisticsButtonFrame();
        ContactsButtonFrame_var=new ContactsButtonFrame();
        SettingsButtonFrame_var=new SettingsButtonFrame();

        PaneState=new SimpleIntegerProperty(1);
        PaneStateController=new SimpleBooleanProperty();
        PaneStateController.bind
        (
            new BooleanBinding()
            {
                {bind(HomeButtonFrame_var.ClickState, SchedulesButtonFrame_var.ClickState, TicketsButtonFrame_var.ClickState, StatisticsButtonFrame_var.ClickState, ContactsButtonFrame_var.ClickState, SettingsButtonFrame_var.ClickState);}
                protected boolean computeValue() {return HomeButtonFrame_var.ClickState.get()||SchedulesButtonFrame_var.ClickState.get()||TicketsButtonFrame_var.ClickState.get()||StatisticsButtonFrame_var.ClickState.get()||ContactsButtonFrame_var.ClickState.get()||SettingsButtonFrame_var.ClickState.get();}
            }
        );
        PaneStateController.addListener
        (
            new InvalidationListener()
            {
                public void invalidated(Observable observable)
                {
                    if(PaneState.get()==3) {TicketsButtonFrame_var.ClickState.set(false);}
                    else if(PaneState.get()==2) {SchedulesButtonFrame_var.ClickState.set(false);}
                    else if(PaneState.get()==1) {HomeButtonFrame_var.ClickState.set(false);}
                    else if(PaneState.get()==4) {StatisticsButtonFrame_var.ClickState.set(false);}
                    else if(PaneState.get()==5) {ContactsButtonFrame_var.ClickState.set(false);}
                    else {SettingsButtonFrame_var.ClickState.set(false);}

                    if(TicketsButtonFrame_var.ClickState.get()==true) {PaneState.set(3);}
                    else if(SchedulesButtonFrame_var.ClickState.get()==true) {PaneState.set(2);}
                    else if(HomeButtonFrame_var.ClickState.get()==true) {PaneState.set(1);}
                    else if(StatisticsButtonFrame_var.ClickState.get()==true) {PaneState.set(4);}
                    else if(ContactsButtonFrame_var.ClickState.get()==true) {PaneState.set(5);}
                    else {PaneState.set(6);}

                    PaneStateController.getValue();
                }
            }
        );

        FlowPane PaneNavigators=new FlowPane();
        PaneNavigators.setOrientation(Orientation.VERTICAL);
        PaneNavigators.setLayoutX(0); PaneNavigators.setLayoutY(0);
        PaneNavigators.setPrefSize(60*UNIT, 820*UNIT);
        FlowPane.setMargin(AppLogo_var, new Insets(10*UNIT, 10*UNIT, 50*UNIT, 10*UNIT));
        FlowPane.setMargin(HomeButtonFrame_var, new Insets(10*UNIT, 10*UNIT, 40*UNIT, 10*UNIT));
        FlowPane.setMargin(SchedulesButtonFrame_var, new Insets(0, 0, 20*UNIT, 0));
        FlowPane.setMargin(TicketsButtonFrame_var, new Insets(0, 0, 30*UNIT, 0));
        FlowPane.setMargin(StatisticsButtonFrame_var, new Insets(10*UNIT, 10*UNIT, 30*UNIT, 10*UNIT));
        FlowPane.setMargin(ContactsButtonFrame_var, new Insets(10*UNIT, 10*UNIT, 10*UNIT, 10*UNIT));
        PaneNavigators.getChildren().addAll(AppLogo_var, HomeButtonFrame_var, SchedulesButtonFrame_var, TicketsButtonFrame_var, StatisticsButtonFrame_var, ContactsButtonFrame_var);

        setLayoutX(40*UNIT); setLayoutY(100*UNIT);
        setPrefWidth(60*UNIT); setPrefHeight(1060*UNIT);
        getChildren().addAll(PaneNavigators, SettingsButtonFrame_var);
    }
}