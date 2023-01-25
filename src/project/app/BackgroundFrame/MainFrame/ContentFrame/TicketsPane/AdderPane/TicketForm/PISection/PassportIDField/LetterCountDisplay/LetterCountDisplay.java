package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PassportIDField.LetterCountDisplay;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FillTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.GRAY;
import static project.app.Utilities.ColorUtils.WHITE;
import static project.app.Utilities.FontUtils.AVERTA;
import static project.app.Utilities.SizeUtils.UNIT;

public class LetterCountDisplay extends Text
{
    private final int MAX_LENGTH=10;

    public SimpleIntegerProperty LetterCount;

    public FillTransitionService TypingOnService, TypingOffService;

    public LetterCountDisplay()
    {
        TypingOnService=new FillTransitionService(Duration.millis(100), this, GRAY(1), WHITE(1));
        TypingOffService=new FillTransitionService(Duration.millis(100), this, WHITE(1), GRAY(1));

        setText(String.valueOf(MAX_LENGTH));
        setFont(AVERTA(1, 11*UNIT));
        setFill(GRAY(1));
        setTextAlignment(TextAlignment.CENTER);
        setTextOrigin(VPos.CENTER);
        setLayoutX(134.5*UNIT); setLayoutY(30*UNIT);

        LetterCount=new SimpleIntegerProperty(MAX_LENGTH);
        LetterCount.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldValue, Number NewValue)
                {
                    setText(String.valueOf(MAX_LENGTH-NewValue.intValue()));
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        TypingOnService.setExecutor(AnimationThreadPool);
        TypingOffService.setExecutor(AnimationThreadPool);
    }
}