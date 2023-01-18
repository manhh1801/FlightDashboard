package project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.ListButtonFrame.ListButtonFrame;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.TicketsBackground.TicketsBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.TicketsMainButtonFrame.TicketsMainButtonFrame;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.StateButtonFrame.StateButtonFrame;
import project.app.BackgroundFrame.MainFrame.NavigationBar.TicketsButtonFrame.AdderButtonFrame.AdderButtonFrame;

import static project.app.Utilities.SizeUtils.*;

public class TicketsButtonFrame extends Pane
{
    public SimpleBooleanProperty ClickState;

    public ExecutorService AnimationThreadPool;

    public TicketsBackground TicketsBackground_var;
    public TicketsMainButtonFrame TicketsMainButtonFrame_var;
    public ListButtonFrame ListButtonFrame_var;
    public AdderButtonFrame AdderButtonFrame_var;
    public StateButtonFrame StateButtonFrame_var;

    public TicketsButtonFrame()
    {
        TicketsBackground_var =new TicketsBackground();
        TicketsMainButtonFrame_var =new TicketsMainButtonFrame();
        ListButtonFrame_var =new ListButtonFrame();
        AdderButtonFrame_var =new AdderButtonFrame();
        StateButtonFrame_var=new StateButtonFrame();

        ListButtonFrame_var.layoutYProperty().bind
        (
            new DoubleBinding()
            {
                {bind(TicketsBackground_var.heightProperty());}
                protected double computeValue() {return TicketsBackground_var.heightProperty().getValue()-150*UNIT;}
            }
        );
        AdderButtonFrame_var.layoutYProperty().bind
        (
            new DoubleBinding()
            {
                {bind(TicketsBackground_var.heightProperty());}
                protected double computeValue() {return TicketsBackground_var.heightProperty().getValue()-100*UNIT;}
            }
        );
        StateButtonFrame_var.layoutYProperty().bind
        (
            new DoubleBinding()
            {
                {bind(TicketsBackground_var.heightProperty());}
                protected double computeValue() {return TicketsBackground_var.heightProperty().getValue()-50*UNIT;}
            }
        );
        StateButtonFrame_var.ClickState.bindBidirectional(TicketsMainButtonFrame_var.ClickState);

        setPrefWidth(60*UNIT); prefHeightProperty().bindBidirectional(TicketsBackground_var.heightProperty());
        getChildren().addAll(TicketsBackground_var, ListButtonFrame_var, AdderButtonFrame_var, TicketsMainButtonFrame_var, StateButtonFrame_var);

        AnimationThreadPool= Executors.newFixedThreadPool(3);
        TicketsBackground_var.setAnimationThreadPool(AnimationThreadPool);
        ListButtonFrame_var.setAnimationThreadPool(AnimationThreadPool);
        AdderButtonFrame_var.setAnimationThreadPool(AnimationThreadPool);

        ClickState=new SimpleBooleanProperty();
        ClickState.bindBidirectional(TicketsMainButtonFrame_var.ClickState);
        ClickState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(ClickState.get()==true)
                    {
                        if(TicketsBackground_var.ClickOffService.isRunning()==true) {TicketsBackground_var.ClickOffService.cancel();}
                        if(ListButtonFrame_var.FadeOutService.isRunning()==true) {ListButtonFrame_var.FadeOutService.cancel();}
                        if(AdderButtonFrame_var.FadeOutService.isRunning()==true) {AdderButtonFrame_var.FadeOutService.cancel();}
                        TicketsBackground_var.ClickOnService.restart();
                        ListButtonFrame_var.FadeInService.restart();
                        AdderButtonFrame_var.FadeInService.restart();
                    }
                    else
                    {
                        if(TicketsBackground_var.ClickOnService.isRunning()==true) {TicketsBackground_var.ClickOnService.cancel();}
                        if(ListButtonFrame_var.FadeInService.isRunning()==true) {ListButtonFrame_var.FadeInService.cancel();}
                        if(AdderButtonFrame_var.FadeInService.isRunning()==true) {AdderButtonFrame_var.FadeInService.cancel();}
                        TicketsBackground_var.ClickOffService.restart();
                        ListButtonFrame_var.FadeOutService.restart();
                        AdderButtonFrame_var.FadeOutService.restart();
                    }
                }
            }
        );
    }
}