package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FromField.FromPicker.LocationContainer;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

import static project.app.Utilities.SizeUtils.UNIT;

public class LocationContainer extends FlowPane
{
    public SimpleObjectProperty LocationList;
    public SimpleIntegerProperty FromLocation;

    public ObservableList ContainerList=getChildren();

    public LocationContainer()
    {
        setLayoutX(0); setLayoutY(0);
        setPrefWidth(210*UNIT);

        LocationList=new SimpleObjectProperty<ArrayList<Integer>>();
        LocationList.addListener
        (
            new ChangeListener<ArrayList<Integer>>()
            {
                public void changed(ObservableValue<? extends ArrayList<Integer>> observableValue, ArrayList<Integer> OldValue, ArrayList<Integer> NewValue)
                {
                    FromLocation.set(NewValue.get(0));
                    setPrefHeight(NewValue.size()*40*UNIT);
                    ContainerList.clear();
                    for(int Location:NewValue) {ContainerList.add(new LocationItem(Location));}
                }
            }
        );

        FromLocation =new SimpleIntegerProperty(0);
        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent m)
                {
                    double position=(m.getY())/(40*UNIT);
                    if((position>0)&&((position-(int)position)!=0)) {FromLocation.set(((ArrayList<Integer>)(LocationList.get())).get((int)position));}
                }
            }
        );
    }
}