package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.layout.FlowPane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItem;

import static project.app.Utilities.SizeUtils.*;

public class FilterItemsList extends FlowPane
{
    public SimpleIntegerProperty FilterItemsCount;

    public ObservableList ItemsList=getChildren();

    public FilterItemsList()
    {
        setHgap(20*UNIT);
        setLayoutX(20*UNIT); setLayoutY(40*UNIT);
        setPrefSize(860*UNIT, 60*UNIT);

        FilterItemsCount=new SimpleIntegerProperty(0);
        FilterItemsCount.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldValue, Number NewValue)
                {
                    if(NewValue.intValue()==0) {ItemsList.clear();}
                    if(NewValue.intValue()-OldValue.intValue()==1)
                    {
                        FilterItem FilterItem_var=new FilterItem();
                        ItemsList.add(FilterItem_var);
                        FilterItem_var.FilterCount.set(NewValue.intValue());
                        FilterItem_var.FadeInService.restart();
                    }
                }
            }
        );
    }
}