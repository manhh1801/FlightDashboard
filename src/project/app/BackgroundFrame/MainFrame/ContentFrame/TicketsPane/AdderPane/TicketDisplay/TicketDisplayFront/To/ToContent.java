package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.To;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FillTransitionService;
import project.app.Utilities.MapUtils.MapUtils;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.FLARE;
import static project.app.Utilities.SizeUtils.UNIT;

public class ToContent extends Text
{
    public SimpleIntegerProperty ToLocation;

    public FillTransitionService EconomicService, BusinessService;

    public ToContent()
    {
        EconomicService=new FillTransitionService(Duration.millis(150), this, WHITE(1), BLACK(1));
        BusinessService=new FillTransitionService(Duration.millis(150), this, BLACK(1), WHITE(1));

        setText("-- (--)");
        setFont(FLARE(13*UNIT));
        setFill(BLACK(1));
        setTextAlignment(TextAlignment.LEFT);
        setTextOrigin(VPos.CENTER);
        setLayoutX(20*UNIT); setLayoutY(146.5*UNIT);

        ToLocation=new SimpleIntegerProperty(0);
        ToLocation.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldValue, Number NewValue)
                {
                    setText(MapUtils.getLocationName(NewValue.intValue()).toLowerCase());
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EconomicService.setExecutor(AnimationThreadPool);
        BusinessService.setExecutor(AnimationThreadPool);
    }
}