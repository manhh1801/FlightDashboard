package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FromField.FromPicker;

import javafx.beans.binding.DoubleBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FromField.FromPicker.LocationContainer.LocationContainer;
import project.app.Utilities.AnimationUtils.FadeTransitionService;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.MapUtils.MapUtils.*;
import static project.app.Utilities.SizeUtils.UNIT;

public class FromPicker extends ScrollPane
{
    public SimpleBooleanProperty ModeState;
    public SimpleBooleanProperty FocusState;
    public SimpleDoubleProperty Height;

    public ExecutorService AnimationThreadPool;

    public FadeTransitionService FocusOnService, FocusOffService;
    public ParallelTransitionService ToScrollService;

    public LocationContainer LocationContainer_var;

    public FromPicker()
    {
        FocusOnService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        FocusOnService.setOnRunning
        (
            new EventHandler<WorkerStateEvent>()
            {
                public void handle(WorkerStateEvent workerStateEvent)
                {
                    setVisible(true);
                }
            }
        );
        FocusOffService=new FadeTransitionService(Duration.millis(50), this, 1, 0);
        FocusOffService.setOnSucceeded
        (
            new EventHandler<WorkerStateEvent>()
            {
                public void handle(WorkerStateEvent workerStateEvent)
                {
                    setVisible(false);
                }
            }
        );
        ToScrollService=new ParallelTransitionService();

        LocationContainer_var=new LocationContainer();

        setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        setVbarPolicy(ScrollBarPolicy.NEVER); setHbarPolicy(ScrollBarPolicy.NEVER);
        setPadding(new Insets(0, 0, 0, 0));
        setLayoutX(0); setLayoutY(40*UNIT);
        setPrefViewportWidth(210*UNIT); setPrefViewportHeight(200*UNIT);
        prefViewportHeightProperty().bind
        (
            new DoubleBinding()
            {
                {bind(LocationContainer_var.prefHeightProperty());}
                protected double computeValue()
                {
                    return LocationContainer_var.prefHeightProperty().get()<200*UNIT?LocationContainer_var.prefHeightProperty().get():200*UNIT;
                }
            }
        );
        Rectangle ClipRec=new Rectangle(0, -40*UNIT, 210*UNIT, 240*UNIT);
        ClipRec.heightProperty().bind
        (
            new DoubleBinding()
            {
                {bind(LocationContainer_var.prefHeightProperty());}
                protected double computeValue()
                {
                    return LocationContainer_var.prefHeightProperty().get()<200*UNIT?LocationContainer_var.prefHeightProperty().get()+40*UNIT:240*UNIT;
                }
            }
        );
        ClipRec.setArcWidth(20*UNIT); ClipRec.setArcHeight(20*UNIT);
        setClip(ClipRec);
        setContent(LocationContainer_var);
        setOpacity(0);
        setVisible(false);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        setAnimationThreadPool(AnimationThreadPool);

        Height=new SimpleDoubleProperty(200*UNIT);
        Height.bind(prefViewportHeightProperty());

        LocationContainer_var.LocationList.set(getDomesticList());

        ModeState=new SimpleBooleanProperty(false);
        ModeState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        FocusState.set(false);
                        LocationContainer_var.LocationList.set(getInternationalList());
                    }
                    else
                    {
                        FocusState.set(false);
                        LocationContainer_var.LocationList.set(getDomesticList());
                    }
                }
            }
        );

        FocusState=new SimpleBooleanProperty(false);
        FocusState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        if(FocusOffService.isRunning()==true) {FocusOffService.cancel();}
                        FocusOnService.restart();
                    }
                    else
                    {
                        if(FocusOnService.isRunning()==true) {FocusOnService.cancel();}
                        FocusOffService.restart();
                    }
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FocusOnService.setExecutor(AnimationThreadPool);
        FocusOffService.setExecutor(AnimationThreadPool);
    }
}