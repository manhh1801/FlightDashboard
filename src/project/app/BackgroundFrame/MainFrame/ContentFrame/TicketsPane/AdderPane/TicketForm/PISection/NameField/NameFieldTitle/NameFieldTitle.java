package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.NameField.NameFieldTitle;

import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.WHITE;
import static project.app.Utilities.FontUtils.AVERTA;
import static project.app.Utilities.SizeUtils.UNIT;

public class NameFieldTitle extends Text
{
    public FadeTransitionService TypingOnService, TypingOffService;

    public NameFieldTitle()
    {
        TypingOnService=new FadeTransitionService(Duration.millis(100), this, 0, 1);
        TypingOffService=new FadeTransitionService(Duration.millis(100), this, 1, 0);

        setText("Name");
        setFont(AVERTA(1, 11*UNIT));
        setFill(WHITE(1));
        setTextAlignment(TextAlignment.LEFT);
        setTextOrigin(VPos.CENTER);
        setLayoutX(15*UNIT); setLayoutY(10*UNIT);
        setOpacity(0);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        TypingOnService.setExecutor(AnimationThreadPool);
        TypingOffService.setExecutor(AnimationThreadPool);
    }
}