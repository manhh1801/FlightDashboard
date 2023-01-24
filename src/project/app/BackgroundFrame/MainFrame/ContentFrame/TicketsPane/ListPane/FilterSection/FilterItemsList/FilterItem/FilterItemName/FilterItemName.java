package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemName;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemName.DateItemName.DateItemName;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemName.DateItemName.DateItemName_Fade;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemName.PriceItemName.PriceItemName;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemName.PriceItemName.PriceItemName_Fade;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemName.RouteItemName.RouteItemName;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemName.RouteItemName.RouteItemName_Fade;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.*;

public class FilterItemName extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;
    public SimpleIntegerProperty FilterTypeState;

    public ExecutorService AnimationThreadPool;

    public DateItemName DateItemName_var;
    public DateItemName_Fade DateItemName_Fade_var;
    public RouteItemName RouteItemName_var;
    public RouteItemName_Fade RouteItemName_Fade_var;
    public PriceItemName PriceItemName_var;
    public PriceItemName_Fade PriceItemName_Fade_var;
    
    public FilterItemName()
    {
        DateItemName_var=new DateItemName();
        DateItemName_Fade_var=new DateItemName_Fade();
        RouteItemName_var=new RouteItemName();
        RouteItemName_Fade_var=new RouteItemName_Fade();
        PriceItemName_var=new PriceItemName();
        PriceItemName_Fade_var=new PriceItemName_Fade();

        setLayoutX(17*UNIT); setLayoutY(39*UNIT);
        setPrefSize(26*UNIT, 11*UNIT);
        getChildren().addAll(RouteItemName_var, RouteItemName_Fade_var, PriceItemName_var, PriceItemName_Fade_var, DateItemName_var, DateItemName_Fade_var);

        AnimationThreadPool=Executors.newFixedThreadPool(4);
        DateItemName_var.setAnimationThreadPool(AnimationThreadPool);
        RouteItemName_var.setAnimationThreadPool(AnimationThreadPool);
        PriceItemName_var.setAnimationThreadPool(AnimationThreadPool);
        DateItemName_Fade_var.setAnimationThreadPool(AnimationThreadPool);
        RouteItemName_Fade_var.setAnimationThreadPool(AnimationThreadPool);
        PriceItemName_Fade_var.setAnimationThreadPool(AnimationThreadPool);
        
        FilterTypeState=new SimpleIntegerProperty(1);
        FilterTypeState.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldValue, Number NewValue)
                {
                    if(FilterTypeState.get()==1)
                    {
                        DateItemName_var.setOpacity(1);
                        RouteItemName_var.setOpacity(0);
                        PriceItemName_var.setOpacity(0);
                        DateItemName_Fade_var.setOpacity(1);
                        RouteItemName_Fade_var.setOpacity(0);
                        PriceItemName_Fade_var.setOpacity(0);
                        DateItemName_var.toFront();
                        DateItemName_Fade_var.toFront();
                    }
                    else if(FilterTypeState.get()==2)
                    {
                        DateItemName_var.setOpacity(0);
                        RouteItemName_var.setOpacity(1);
                        PriceItemName_var.setOpacity(0);
                        DateItemName_Fade_var.setOpacity(0);
                        RouteItemName_Fade_var.setOpacity(1);
                        PriceItemName_Fade_var.setOpacity(0);
                        RouteItemName_var.toFront();
                        RouteItemName_Fade_var.toFront();
                    }
                    else
                    {
                        DateItemName_var.setOpacity(0);
                        RouteItemName_var.setOpacity(0);
                        PriceItemName_var.setOpacity(1);
                        DateItemName_Fade_var.setOpacity(0);
                        RouteItemName_Fade_var.setOpacity(0);
                        PriceItemName_Fade_var.setOpacity(1);
                        PriceItemName_var.toFront();
                        PriceItemName_Fade_var.toFront();
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
                                if(DateItemName_var.ExitService.isRunning()==true) {DateItemName_Fade_var.ExitService.cancel();}
                                if(DateItemName_Fade_var.ExitService.isRunning()==true) {DateItemName_Fade_var.ExitService.cancel();}
                                DateItemName_var.EnterService.restart();
                                DateItemName_Fade_var.EnterService.restart();
                            }
                            else
                            {
                                if(DateItemName_var.EnterService.isRunning()==true) {DateItemName_Fade_var.EnterService.cancel();}
                                if(DateItemName_Fade_var.EnterService.isRunning()==true) {DateItemName_Fade_var.EnterService.cancel();}
                                DateItemName_var.ExitService.restart();
                                DateItemName_Fade_var.ExitService.restart();
                            }
                        }
                        else if(FilterTypeState.get()==2)
                        {
                            if(NewValue==true)
                            {
                                if(RouteItemName_var.ExitService.isRunning()==true) {RouteItemName_var.ExitService.cancel();}
                                if(RouteItemName_Fade_var.ExitService.isRunning()==true) {RouteItemName_Fade_var.ExitService.cancel();}
                                RouteItemName_var.EnterService.restart();
                                RouteItemName_Fade_var.EnterService.restart();
                            }
                            else
                            {
                                if(RouteItemName_var.EnterService.isRunning()==true) {RouteItemName_var.EnterService.cancel();}
                                if(RouteItemName_Fade_var.EnterService.isRunning()==true) {RouteItemName_Fade_var.EnterService.cancel();}
                                RouteItemName_var.ExitService.restart();
                                RouteItemName_Fade_var.ExitService.restart();
                            }
                        }
                        else
                        {
                            if(NewValue==true)
                            {
                                if(PriceItemName_var.ExitService.isRunning()==true) {PriceItemName_var.ExitService.cancel();}
                                if(PriceItemName_Fade_var.ExitService.isRunning()==true) {PriceItemName_Fade_var.ExitService.cancel();}
                                PriceItemName_var.EnterService.restart();
                                PriceItemName_Fade_var.EnterService.restart();
                            }
                            else
                            {
                                if(PriceItemName_var.EnterService.isRunning()==true) {PriceItemName_var.EnterService.cancel();}
                                if(PriceItemName_Fade_var.EnterService.isRunning()==true) {PriceItemName_Fade_var.EnterService.cancel();}
                                PriceItemName_var.ExitService.restart();
                                PriceItemName_Fade_var.ExitService.restart();
                            }
                        }
                    }
                    else
                    {
                        if(FilterTypeState.get()==1)
                        {
                            if(NewValue==true)
                            {
                                if(DateItemName_Fade_var.OnExitService.isRunning()==true) {DateItemName_Fade_var.OnExitService.cancel();}
                                DateItemName_Fade_var.OnEnterService.restart();
                            }
                            else
                            {
                                if(DateItemName_Fade_var.OnEnterService.isRunning()==true) {DateItemName_Fade_var.OnEnterService.cancel();}
                                DateItemName_Fade_var.OnExitService.restart();
                            }
                        }
                        else if(FilterTypeState.get()==2)
                        {
                            if(NewValue==true)
                            {
                                if(RouteItemName_Fade_var.OnExitService.isRunning()==true) {RouteItemName_Fade_var.OnExitService.cancel();}
                                RouteItemName_Fade_var.OnEnterService.restart();
                            }
                            else
                            {
                                if(RouteItemName_Fade_var.OnEnterService.isRunning()==true) {RouteItemName_Fade_var.OnEnterService.cancel();}
                                RouteItemName_Fade_var.OnExitService.restart();
                            }
                        }
                        else
                        {
                            if(NewValue==true)
                            {
                                if(PriceItemName_Fade_var.OnExitService.isRunning()==true) {PriceItemName_Fade_var.OnExitService.cancel();}
                                PriceItemName_Fade_var.OnEnterService.restart();
                            }
                            else
                            {
                                if(PriceItemName_Fade_var.OnEnterService.isRunning()==true) {PriceItemName_Fade_var.OnEnterService.cancel();}
                                PriceItemName_Fade_var.OnExitService.restart();
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
                            if(DateItemName_var.ClickOffService.isRunning()==true) {DateItemName_var.ClickOffService.cancel();}
                            if(DateItemName_Fade_var.ClickOffService.isRunning()==true) {DateItemName_Fade_var.ClickOffService.cancel();}
                            DateItemName_var.ClickOnService.restart();
                            DateItemName_Fade_var.ClickOnService.restart();

                        }
                        else
                        {
                            if(DateItemName_var.ClickOnService.isRunning()==true) {DateItemName_var.ClickOnService.cancel();}
                            if(DateItemName_Fade_var.ClickOnService.isRunning()==true) {DateItemName_Fade_var.ClickOnService.cancel();}
                            DateItemName_var.ClickOffService.restart();
                            DateItemName_Fade_var.ClickOffService.restart();
                        }
                    }
                    else if(FilterTypeState.get()==2)
                    {
                        if(NewValue==true)
                        {
                            if(RouteItemName_var.ClickOffService.isRunning()==true) {RouteItemName_var.ClickOffService.cancel();}
                            if(RouteItemName_Fade_var.ClickOffService.isRunning()==true) {RouteItemName_Fade_var.ClickOffService.cancel();}
                            RouteItemName_var.ClickOnService.restart();
                            RouteItemName_Fade_var.ClickOnService.restart();
                        }
                        else
                        {
                            if(RouteItemName_var.ClickOnService.isRunning()==true) {RouteItemName_var.ClickOnService.cancel();}
                            if(RouteItemName_Fade_var.ClickOnService.isRunning()==true) {RouteItemName_Fade_var.ClickOnService.cancel();}
                            RouteItemName_var.ClickOffService.restart();
                            RouteItemName_Fade_var.ClickOffService.restart();
                        }
                    }
                    else
                    {
                        if(NewValue==true)
                        {
                            if(PriceItemName_var.ClickOffService.isRunning()==true) {PriceItemName_var.ClickOffService.cancel();}
                            if(PriceItemName_Fade_var.ClickOffService.isRunning()==true) {PriceItemName_Fade_var.ClickOffService.cancel();}
                            PriceItemName_var.ClickOnService.restart();
                            PriceItemName_var.ClickOnService.restart();
                        }
                        else
                        {
                            if(PriceItemName_var.ClickOnService.isRunning()==true) {PriceItemName_var.ClickOnService.cancel();}
                            if(PriceItemName_Fade_var.ClickOnService.isRunning()==true) {PriceItemName_Fade_var.ClickOnService.cancel();}
                            PriceItemName_var.ClickOffService.restart();
                            PriceItemName_var.ClickOffService.restart();
                        }
                    }
                }
            }
        );
    }
}