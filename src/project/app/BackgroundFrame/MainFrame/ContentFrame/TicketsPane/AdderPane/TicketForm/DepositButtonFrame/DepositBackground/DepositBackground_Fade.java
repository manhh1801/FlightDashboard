package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DepositButtonFrame.DepositBackground;

import javafx.scene.effect.GaussianBlur;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.MAIN_GRADIENT;
import static project.app.Utilities.SizeUtils.UNIT;

public class DepositBackground_Fade extends Rectangle
{
    public FadeTransitionService EnterService, ExitService;

    public DepositBackground_Fade()
    {
        EnterService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        ExitService=new FadeTransitionService(Duration.millis(50), this, 1, 0);

        setFill(MAIN_GRADIENT);
        setArcWidth(40*UNIT); setArcHeight(40*UNIT);
        setLayoutX(0); setLayoutY(0);
        setWidth(120*UNIT); setHeight(40*UNIT);
        setEffect(new GaussianBlur(25*UNIT));
        setOpacity(0);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
    }
}