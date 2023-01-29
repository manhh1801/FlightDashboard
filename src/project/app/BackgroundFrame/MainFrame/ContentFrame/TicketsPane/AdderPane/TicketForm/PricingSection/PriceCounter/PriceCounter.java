package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.PriceCounter;

import javafx.beans.binding.IntegerBinding;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static project.app.Utilities.MapUtils.MapUtils.*;
import static project.app.Utilities.ColorUtils.WHITE;
import static project.app.Utilities.FontUtils.AVERTA;
import static project.app.Utilities.SizeUtils.UNIT;

public class PriceCounter extends Pane
{
    public SimpleIntegerProperty FromLocation, ToLocation, BaseCost, ServiceFee;
    public SimpleIntegerProperty Distance, Price;

    public PriceCounter()
    {
        Text Plus=new Text("+");
        Plus.setFont(AVERTA(1, 15*UNIT));
        Plus.setFill(WHITE(1));
        Plus.setTextAlignment(TextAlignment.CENTER);
        Plus.setTextOrigin(VPos.CENTER);
        Plus.setLayoutX(75.5*UNIT); Plus.setLayoutY(95*UNIT);
        Text DistanceDisplay=new Text("*  0 (km)");
        DistanceDisplay.setFont(AVERTA(1, 15*UNIT));
        DistanceDisplay.setFill(WHITE(1));
        DistanceDisplay.setTextAlignment(TextAlignment.LEFT);
        DistanceDisplay.setTextOrigin(VPos.CENTER);
        DistanceDisplay.setLayoutX(170*UNIT); DistanceDisplay.setLayoutY(60*UNIT);
        Text PriceDisplay=new Text("=  0 (VND)");
        PriceDisplay.setFont(AVERTA(1, 15*UNIT));
        PriceDisplay.setFill(WHITE(1));
        PriceDisplay.setTextAlignment(TextAlignment.RIGHT);
        PriceDisplay.setTextOrigin(VPos.CENTER);
        PriceDisplay.setLayoutX(440*UNIT+PriceDisplay.getBoundsInParent().getMinX()-PriceDisplay.getBoundsInParent().getWidth()); PriceDisplay.setLayoutY(95*UNIT);

        setLayoutX(0); setLayoutY(0);
        setPrefSize(440*UNIT, 150*UNIT);
        getChildren().addAll(Plus, DistanceDisplay, PriceDisplay);

        FromLocation=new SimpleIntegerProperty(); ToLocation=new SimpleIntegerProperty();
        BaseCost=new SimpleIntegerProperty(20000); ServiceFee=new SimpleIntegerProperty(0);

        Distance=new SimpleIntegerProperty(0);
        Distance.bind
        (
            new IntegerBinding()
            {
                {bind(FromLocation, ToLocation);}
                protected int computeValue()
                {
                    return getDistance(FromLocation.get(), ToLocation.get());
                }
            }
        );
        Distance.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldValue, Number NewValue)
                {
                    DistanceDisplay.setText("*  "+NewValue+" (km)");
                }
            }
        );

        Price=new SimpleIntegerProperty(0);
        Price.bind
        (
            new IntegerBinding()
            {
                {bind(BaseCost, ServiceFee, Distance);}
                protected int computeValue()
                {
                    return BaseCost.get()*Distance.get()+ServiceFee.get();
                }
            }
        );
        Price.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldValue, Number NewValue)
                {
                    PriceDisplay.setText("=  "+NewValue+" (VND)");
                    PriceDisplay.setLayoutX(440*UNIT+PriceDisplay.getBoundsInLocal().getMinX()-PriceDisplay.getBoundsInLocal().getWidth());
                }
            }
        );
    }
}