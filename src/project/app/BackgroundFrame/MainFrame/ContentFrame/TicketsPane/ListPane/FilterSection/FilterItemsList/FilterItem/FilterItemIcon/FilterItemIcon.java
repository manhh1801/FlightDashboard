package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemIcon;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemIcon.DateItemIcon.DateItemIcon;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemIcon.DateItemIcon.DateItemIcon_Fade;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemIcon.PriceItemIcon.PriceItemIcon;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemIcon.PriceItemIcon.PriceItemIcon_Fade;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemIcon.RouteItemIcon.RouteItemIcon;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemIcon.RouteItemIcon.RouteItemIcon_Fade;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.*;

public class FilterItemIcon extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;
    public SimpleIntegerProperty FilterTypeState;

    public ExecutorService AnimationThreadPool;

    public DateItemIcon DateItemIcon_var;
    public DateItemIcon_Fade DateItemIcon_Fade_var;
    public RouteItemIcon RouteItemIcon_var;
    public RouteItemIcon_Fade RouteItemIcon_Fade_var;
    public PriceItemIcon PriceItemIcon_var;
    public PriceItemIcon_Fade PriceItemIcon_Fade_var;

    public FilterItemIcon()
    {
        DateItemIcon_var=new DateItemIcon();
        DateItemIcon_Fade_var=new DateItemIcon_Fade();
        RouteItemIcon_var=new RouteItemIcon();
        RouteItemIcon_Fade_var=new RouteItemIcon_Fade();
        PriceItemIcon_var=new PriceItemIcon();
        PriceItemIcon_Fade_var=new PriceItemIcon_Fade();

        setLayoutX(20*UNIT); setLayoutY(15*UNIT);
        setPrefSize(20*UNIT, 20*UNIT);
        getChildren().addAll(DateItemIcon_var, DateItemIcon_Fade_var, RouteItemIcon_var, RouteItemIcon_Fade_var, PriceItemIcon_var, PriceItemIcon_Fade_var);

        AnimationThreadPool=Executors.newFixedThreadPool(4);
        DateItemIcon_var.setAnimationThreadPool(AnimationThreadPool);
        RouteItemIcon_var.setAnimationThreadPool(AnimationThreadPool);
        PriceItemIcon_var.setAnimationThreadPool(AnimationThreadPool);
        DateItemIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);
        RouteItemIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);
        PriceItemIcon_Fade_var.setAnimationThreadPool(AnimationThreadPool);

        FilterTypeState=new SimpleIntegerProperty(1);
        FilterTypeState.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldValue, Number NewValue)
                {
                    if(NewValue.intValue()==1)
                    {
                        DateItemIcon_var.setOpacity(1);
                        RouteItemIcon_var.setOpacity(0);
                        PriceItemIcon_var.setOpacity(0);
                        DateItemIcon_Fade_var.setOpacity(1);
                        RouteItemIcon_Fade_var.setOpacity(0);
                        PriceItemIcon_Fade_var.setOpacity(0);
                    }
                    else if(NewValue.intValue()==2)
                    {
                        DateItemIcon_var.setOpacity(0);
                        RouteItemIcon_var.setOpacity(1);
                        PriceItemIcon_var.setOpacity(0);
                        DateItemIcon_Fade_var.setOpacity(0);
                        RouteItemIcon_Fade_var.setOpacity(1);
                        PriceItemIcon_Fade_var.setOpacity(0);
                    }
                    else
                    {
                        DateItemIcon_var.setOpacity(0);
                        RouteItemIcon_var.setOpacity(0);
                        PriceItemIcon_var.setOpacity(1);
                        DateItemIcon_Fade_var.setOpacity(0);
                        RouteItemIcon_Fade_var.setOpacity(0);
                        PriceItemIcon_Fade_var.setOpacity(1);
                    }
                }
            }
        );

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(ClickState.get()==false)
                    {
                        if(FilterTypeState.get()==1)
                        {
                            if(NewValue==true)
                            {
                                if(DateItemIcon_var.ExitService.isRunning()==true) {DateItemIcon_Fade_var.ExitService.cancel();}
                                if(DateItemIcon_Fade_var.ExitService.isRunning()==true) {DateItemIcon_Fade_var.ExitService.cancel();}
                                DateItemIcon_var.EnterService.restart();
                                DateItemIcon_Fade_var.EnterService.restart();
                            }
                            else
                            {
                                if(DateItemIcon_var.EnterService.isRunning()==true) {DateItemIcon_Fade_var.EnterService.cancel();}
                                if(DateItemIcon_Fade_var.EnterService.isRunning()==true) {DateItemIcon_Fade_var.EnterService.cancel();}
                                DateItemIcon_var.ExitService.restart();
                                DateItemIcon_Fade_var.ExitService.restart();
                            }
                        }
                        else if(FilterTypeState.get()==2)
                        {
                            if(NewValue==true)
                            {
                                if(RouteItemIcon_var.ExitService.isRunning()==true) {RouteItemIcon_var.ExitService.cancel();}
                                if(RouteItemIcon_Fade_var.ExitService.isRunning()==true) {RouteItemIcon_Fade_var.ExitService.cancel();}
                                RouteItemIcon_var.EnterService.restart();
                                RouteItemIcon_Fade_var.EnterService.restart();
                            }
                            else
                            {
                                if(RouteItemIcon_var.EnterService.isRunning()==true) {RouteItemIcon_var.EnterService.cancel();}
                                if(RouteItemIcon_Fade_var.EnterService.isRunning()==true) {RouteItemIcon_Fade_var.EnterService.cancel();}
                                RouteItemIcon_var.ExitService.restart();
                                RouteItemIcon_Fade_var.ExitService.restart();
                            }
                        }
                        else
                        {
                            if(NewValue==true)
                            {
                                if(PriceItemIcon_var.ExitService.isRunning()==true) {PriceItemIcon_var.ExitService.cancel();}
                                if(PriceItemIcon_Fade_var.ExitService.isRunning()==true) {PriceItemIcon_Fade_var.ExitService.cancel();}
                                PriceItemIcon_var.EnterService.restart();
                                PriceItemIcon_Fade_var.EnterService.restart();
                            }
                            else
                            {
                                if(PriceItemIcon_var.EnterService.isRunning()==true) {PriceItemIcon_var.EnterService.cancel();}
                                if(PriceItemIcon_Fade_var.EnterService.isRunning()==true) {PriceItemIcon_Fade_var.EnterService.cancel();}
                                PriceItemIcon_var.ExitService.restart();
                                PriceItemIcon_Fade_var.ExitService.restart();
                            }
                        }
                    }
                    else
                    {
                        if(FilterTypeState.get()==1)
                        {
                            if(NewValue==true)
                            {
                                if(DateItemIcon_Fade_var.OnExitService.isRunning()==true) {DateItemIcon_Fade_var.OnExitService.cancel();}
                                DateItemIcon_Fade_var.OnEnterService.restart();
                            }
                            else
                            {
                                if(DateItemIcon_Fade_var.OnEnterService.isRunning()==true) {DateItemIcon_Fade_var.OnEnterService.cancel();}
                                DateItemIcon_Fade_var.OnExitService.restart();
                            }
                        }
                        else if(FilterTypeState.get()==2)
                        {
                            if(NewValue==true)
                            {
                                if(RouteItemIcon_Fade_var.OnExitService.isRunning()==true) {RouteItemIcon_Fade_var.OnExitService.cancel();}
                                RouteItemIcon_Fade_var.OnEnterService.restart();
                            }
                            else
                            {
                                if(RouteItemIcon_Fade_var.OnEnterService.isRunning()==true) {RouteItemIcon_Fade_var.OnEnterService.cancel();}
                                RouteItemIcon_Fade_var.OnExitService.restart();
                            }
                        }
                        else
                        {
                            if(NewValue==true)
                            {
                                if(PriceItemIcon_Fade_var.OnExitService.isRunning()==true) {PriceItemIcon_Fade_var.OnExitService.cancel();}
                                PriceItemIcon_Fade_var.OnEnterService.restart();
                            }
                            else
                            {
                                if(PriceItemIcon_Fade_var.OnEnterService.isRunning()==true) {PriceItemIcon_Fade_var.OnEnterService.cancel();}
                                PriceItemIcon_Fade_var.OnExitService.restart();
                            }
                        }
                    }
                }
            }
        );
        
        ClickState=new SimpleBooleanProperty(false);
        ClickState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(FilterTypeState.get()==1)
                    {
                        if(NewValue==true)
                        {
                            if(DateItemIcon_var.ClickOffService.isRunning()==true) {DateItemIcon_var.ClickOffService.cancel();}
                            if(DateItemIcon_Fade_var.ClickOffService.isRunning()==true) {DateItemIcon_Fade_var.ClickOffService.cancel();}
                            DateItemIcon_var.ClickOnService.restart();
                            DateItemIcon_Fade_var.ClickOnService.restart();

                        }
                        else
                        {
                            if(DateItemIcon_var.ClickOnService.isRunning()==true) {DateItemIcon_var.ClickOnService.cancel();}
                            if(DateItemIcon_Fade_var.ClickOnService.isRunning()==true) {DateItemIcon_Fade_var.ClickOnService.cancel();}
                            DateItemIcon_var.ClickOffService.restart();
                            DateItemIcon_Fade_var.ClickOffService.restart();
                        }
                    }
                    else if(FilterTypeState.get()==2)
                    {
                        if(NewValue==true)
                        {
                            if(RouteItemIcon_var.ClickOffService.isRunning()==true) {RouteItemIcon_var.ClickOffService.cancel();}
                            if(RouteItemIcon_Fade_var.ClickOffService.isRunning()==true) {RouteItemIcon_Fade_var.ClickOffService.cancel();}
                            RouteItemIcon_var.ClickOnService.restart();
                            RouteItemIcon_Fade_var.ClickOnService.restart();
                        }
                        else
                        {
                            if(RouteItemIcon_var.ClickOnService.isRunning()==true) {RouteItemIcon_var.ClickOnService.cancel();}
                            if(RouteItemIcon_Fade_var.ClickOnService.isRunning()==true) {RouteItemIcon_Fade_var.ClickOnService.cancel();}
                            RouteItemIcon_var.ClickOffService.restart();
                            RouteItemIcon_Fade_var.ClickOffService.restart();
                        }
                    }
                    else
                    {
                        if(NewValue==true)
                        {
                            if(PriceItemIcon_var.ClickOffService.isRunning()==true) {PriceItemIcon_var.ClickOffService.cancel();}
                            if(PriceItemIcon_Fade_var.ClickOffService.isRunning()==true) {PriceItemIcon_Fade_var.ClickOffService.cancel();}
                            PriceItemIcon_var.ClickOnService.restart();
                            PriceItemIcon_var.ClickOnService.restart();
                        }
                        else
                        {
                            if(PriceItemIcon_var.ClickOnService.isRunning()==true) {PriceItemIcon_var.ClickOnService.cancel();}
                            if(PriceItemIcon_Fade_var.ClickOnService.isRunning()==true) {PriceItemIcon_Fade_var.ClickOnService.cancel();}
                            PriceItemIcon_var.ClickOffService.restart();
                            PriceItemIcon_var.ClickOffService.restart();
                        }
                    }
                }
            }
        );
    }
}