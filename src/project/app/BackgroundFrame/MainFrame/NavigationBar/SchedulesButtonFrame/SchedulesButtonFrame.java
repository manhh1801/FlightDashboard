package project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.MapButtonFrame.MapButtonFrame;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.SchedulesBackground.SchedulesBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.SchedulesMainButtonFrame.SchedulesMainButtonFrame;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.StateButtonFrame.StateButtonFrame;
import project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.TimetableButtonFrame.TimetableButtonFrame;

import static project.app.Utilities.SizeUtils.*;

public class SchedulesButtonFrame extends Pane
{
    public SimpleBooleanProperty ClickState;

    public ExecutorService AnimationThreadPool;

    public SchedulesBackground SchedulesBackground_var;
    public SchedulesMainButtonFrame SchedulesMainButtonFrame_var;
    public MapButtonFrame MapButtonFrame_var;
    public TimetableButtonFrame TimetableButtonFrame_var;
    public StateButtonFrame StateButtonFrame_var;

    public SchedulesButtonFrame()
    {
        SchedulesBackground_var=new SchedulesBackground();
        SchedulesMainButtonFrame_var=new SchedulesMainButtonFrame();
        MapButtonFrame_var=new MapButtonFrame();
        TimetableButtonFrame_var=new TimetableButtonFrame();
        StateButtonFrame_var=new StateButtonFrame();

        MapButtonFrame_var.layoutYProperty().bind
        (
            new DoubleBinding()
            {
                {bind(SchedulesBackground_var.heightProperty());}
                protected double computeValue() {return SchedulesBackground_var.heightProperty().getValue()-150*UNIT;}
            }
        );
        TimetableButtonFrame_var.layoutYProperty().bind
        (
            new DoubleBinding()
            {
                {bind(SchedulesBackground_var.heightProperty());}
                protected double computeValue() {return SchedulesBackground_var.heightProperty().getValue()-100*UNIT;}
            }
        );
        StateButtonFrame_var.layoutYProperty().bind
        (
            new DoubleBinding()
            {
                {bind(SchedulesBackground_var.heightProperty());}
                protected double computeValue() {return SchedulesBackground_var.heightProperty().getValue()-50*UNIT;}
            }
        );
        StateButtonFrame_var.SizeState.bindBidirectional(SchedulesMainButtonFrame_var.ClickState);

        setPrefWidth(60*UNIT); prefHeightProperty().bindBidirectional(SchedulesBackground_var.heightProperty());
        getChildren().addAll(SchedulesBackground_var, MapButtonFrame_var, TimetableButtonFrame_var, SchedulesMainButtonFrame_var, StateButtonFrame_var);

        AnimationThreadPool= Executors.newFixedThreadPool(3);
        SchedulesBackground_var.setAnimationThreadPool(AnimationThreadPool);
        MapButtonFrame_var.setAnimationThreadPool(AnimationThreadPool);
        TimetableButtonFrame_var.setAnimationThreadPool(AnimationThreadPool);

        ClickState=new SimpleBooleanProperty();
        ClickState.bindBidirectional(SchedulesMainButtonFrame_var.ClickState);
        ClickState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {
                    if(ClickState.get()==true)
                    {
                        if(SchedulesBackground_var.ClickOffService.isRunning()==true) {SchedulesBackground_var.ClickOffService.cancel();}
                        if(MapButtonFrame_var.FadeOutService.isRunning()==true) {MapButtonFrame_var.FadeOutService.cancel();}
                        if(TimetableButtonFrame_var.FadeOutService.isRunning()==true) {TimetableButtonFrame_var.FadeOutService.cancel();}
                        SchedulesBackground_var.ClickOnService.restart();
                        MapButtonFrame_var.FadeInService.restart();
                        TimetableButtonFrame_var.FadeInService.restart();
                    }
                    else
                    {
                        if(SchedulesBackground_var.ClickOnService.isRunning()==true) {SchedulesBackground_var.ClickOnService.cancel();}
                        if(MapButtonFrame_var.FadeInService.isRunning()==true) {MapButtonFrame_var.FadeInService.cancel();}
                        if(TimetableButtonFrame_var.FadeInService.isRunning()==true) {TimetableButtonFrame_var.FadeInService.cancel();}
                        SchedulesBackground_var.ClickOffService.restart();
                        MapButtonFrame_var.FadeOutService.restart();
                        TimetableButtonFrame_var.FadeOutService.restart();
                    }
                }
            }
        );
    }
}