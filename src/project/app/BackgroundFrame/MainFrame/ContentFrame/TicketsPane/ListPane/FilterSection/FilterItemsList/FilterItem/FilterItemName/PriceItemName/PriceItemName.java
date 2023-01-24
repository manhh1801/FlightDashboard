package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemName.PriceItemName;

import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FillTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class PriceItemName extends Text
{
    public FillTransitionService EnterService, ExitService, ClickOnService, ClickOffService;

    public PriceItemName()
    {
        EnterService=new FillTransitionService(Duration.millis(50), this, GRAY(1), WHITE(1));
        ExitService=new FillTransitionService(Duration.millis(50), this, WHITE(1), GRAY(1));
        ClickOnService=new FillTransitionService(Duration.millis(50), this, WHITE(1), BLACK(1));
        ClickOffService=new FillTransitionService(Duration.millis(50), this, BLACK(1), WHITE(1));

        setText("Price");
        setFont(AVERTA(0, 9*UNIT));
        setFill(GRAY(1));
        setTextAlignment(TextAlignment.CENTER);
        setTextOrigin(VPos.CENTER);
        setLayoutX(2*UNIT); setLayoutY(5.5*UNIT);
        setOpacity(0);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}