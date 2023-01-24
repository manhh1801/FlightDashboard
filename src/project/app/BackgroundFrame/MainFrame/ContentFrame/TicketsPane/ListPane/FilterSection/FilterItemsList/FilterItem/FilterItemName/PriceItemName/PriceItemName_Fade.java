package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemName.PriceItemName;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.geometry.VPos;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;
import project.app.Utilities.AnimationUtils.FillTransitionService;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class PriceItemName_Fade extends Text
{
    public ParallelTransitionService EnterService, ExitService;
    public FillTransitionService ClickOnService, ClickOffService;
    public FadeTransitionService OnEnterService, OnExitService;

    public PriceItemName_Fade()
    {
        FadeTransition EnterFade=new FadeTransition(Duration.millis(50), this); EnterFade.setFromValue(0); EnterFade.setToValue(1);
        FillTransition EnterFill=new FillTransition(Duration.millis(50), this, GRAY(1), WHITE(1));
        EnterService=new ParallelTransitionService(EnterFade, EnterFill);
        FadeTransition ExitFade=new FadeTransition(Duration.millis(50), this); ExitFade.setFromValue(1); ExitFade.setToValue(0);
        FillTransition ExitFill=new FillTransition(Duration.millis(50), this, WHITE(1), GRAY(1));
        ExitService=new ParallelTransitionService(ExitFade, ExitFill);
        ClickOnService=new FillTransitionService(Duration.millis(50), this, WHITE(1), BLACK(1));
        ClickOffService=new FillTransitionService(Duration.millis(50), this, BLACK(1), WHITE(1));
        OnEnterService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        OnExitService=new FadeTransitionService(Duration.millis(50), this, 1, 0);

        setText("Price");
        setFont(AVERTA(0, 9*UNIT));
        setFill(GRAY(1));
        setTextAlignment(TextAlignment.CENTER);
        setTextOrigin(VPos.CENTER);
        setLayoutX(2*UNIT); setLayoutY(5.5*UNIT);
        setEffect(new GaussianBlur(2.5*UNIT));
        setOpacity(0);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
        OnEnterService.setExecutor(AnimationThreadPool);
        OnExitService.setExecutor(AnimationThreadPool);
    }
}