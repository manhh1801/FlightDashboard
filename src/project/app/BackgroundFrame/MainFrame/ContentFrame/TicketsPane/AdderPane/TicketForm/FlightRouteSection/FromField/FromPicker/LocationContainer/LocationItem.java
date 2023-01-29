package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FromField.FromPicker.LocationContainer;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.MapUtils.MapUtils.*;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.AVERTA;
import static project.app.Utilities.SizeUtils.UNIT;

public class LocationItem extends Pane
{
    public SimpleBooleanProperty MousePosState;

    public ExecutorService AnimationThreadPool;

    public FadeTransitionService EnterService, ExitService;

    public LocationItem(int Location)
    {
        Rectangle ItemBackground=new Rectangle();
        ItemBackground.setFill(LIGHT_GRAY(1));
        ItemBackground.setLayoutX(0); ItemBackground.setLayoutY(0);
        ItemBackground.setWidth(210*UNIT); ItemBackground.setHeight(40*UNIT);
        ItemBackground.setOpacity(0);

        Text LocationDisplay=new Text(getLocationName(Location));
        LocationDisplay.setFont(AVERTA(0, 13*UNIT));
        LocationDisplay.setFill(WHITE(1));
        LocationDisplay.setTextAlignment(TextAlignment.LEFT);
        LocationDisplay.setTextOrigin(VPos.CENTER);
        LocationDisplay.setLayoutX(15*UNIT); LocationDisplay.setLayoutY(20*UNIT);

        EnterService=new FadeTransitionService(Duration.millis(50), ItemBackground, 0, 1);
        ExitService=new FadeTransitionService(Duration.millis(50), ItemBackground, 1, 0);

        setPrefSize(210*UNIT, 40*UNIT);
        getChildren().addAll(ItemBackground, LocationDisplay);

        AnimationThreadPool=Executors.newFixedThreadPool(1);
        setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        if(ExitService.isRunning()==true) {ExitService.cancel();}
                        EnterService.restart();
                    }
                    else
                    {
                        if(EnterService.isRunning()==true) {EnterService.cancel();}
                        ExitService.restart();
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
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
    }
}