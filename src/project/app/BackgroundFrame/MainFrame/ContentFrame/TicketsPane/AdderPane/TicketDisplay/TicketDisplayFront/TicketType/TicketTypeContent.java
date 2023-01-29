package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.TicketType;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FillTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.FLARE;
import static project.app.Utilities.SizeUtils.UNIT;

public class TicketTypeContent extends Text
{
    public SimpleBooleanProperty TicketType;

    public FillTransitionService EconomicService, BusinessService;

    public TicketTypeContent()
    {
        EconomicService=new FillTransitionService(Duration.millis(150), this, WHITE(1), BLACK(1));
        BusinessService=new FillTransitionService(Duration.millis(150), this, BLACK(1), WHITE(1));

        setText("economic");
        setFont(FLARE(13*UNIT));
        setFill(BLACK(1));
        setTextAlignment(TextAlignment.LEFT);
        setTextOrigin(VPos.CENTER);
        setLayoutX(240*UNIT); setLayoutY(66.5*UNIT);

        TicketType=new SimpleBooleanProperty(false);
        TicketType.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==false) {setText("economic");}
                    else {setText("business");}
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