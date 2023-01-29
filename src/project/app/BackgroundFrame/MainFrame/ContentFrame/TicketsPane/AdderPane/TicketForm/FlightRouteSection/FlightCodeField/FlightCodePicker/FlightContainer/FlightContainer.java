package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.FlightRouteSection.FlightCodeField.FlightCodePicker.FlightContainer;

import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;

import java.util.ArrayList;

import static project.app.Utilities.SizeUtils.UNIT;

public class FlightContainer extends FlowPane
{
    public SimpleObjectProperty FlightList;
    public SimpleStringProperty FlightCode;

    public ObservableList ContainerList=getChildren();

    public FlightContainer()
    {
        setLayoutX(0); setLayoutY(0);
        setPrefWidth(140*UNIT);

        FlightList=new SimpleObjectProperty<ArrayList<String>>();
        FlightList.addListener
        (
            new ChangeListener<ArrayList<String>>()
            {
                public void changed(ObservableValue<? extends ArrayList<String>> observableValue, ArrayList<String> OldValue, ArrayList<String> NewValue)
                {
                    FlightCode.set(NewValue.get(0));
                    setPrefHeight(NewValue.size()*40*UNIT);
                    ContainerList.clear();
                    for(String Flight:NewValue) {ContainerList.add(new FlightItem(Flight));}
                }
            }
        );

        FlightCode=new SimpleStringProperty("--");
        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent m)
                {
                    double position=(m.getY())/(40*UNIT);
                    if((position>0)&&((position-(int)position)!=0)) {FlightCode.set(((ArrayList<String>)(FlightList.get())).get((int)position));}
                }
            }
        );
    }
}