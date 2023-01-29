package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.Flight;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FillTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class FlightContent extends Text
{
    public SimpleStringProperty FlightCode;

    public FillTransitionService EconomicService, BusinessService;

    public FlightContent()
    {
        EconomicService=new FillTransitionService(Duration.millis(150), this, WHITE(1), BLACK(1));
        BusinessService=new FillTransitionService(Duration.millis(150), this, BLACK(1), WHITE(1));

        setText("--");
        setFont(FLARE(13*UNIT));
        setFill(BLACK(1));
        setTextAlignment(TextAlignment.LEFT);
        setTextOrigin(VPos.CENTER);
        setLayoutX(20*UNIT); setLayoutY(66.5*UNIT);

        FlightCode=new SimpleStringProperty();
        FlightCode.addListener
        (
            new ChangeListener<String>()
            {
                public void changed(ObservableValue<? extends String> observableValue, String OldValue, String NewValue)
                {
                    setText(NewValue);
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