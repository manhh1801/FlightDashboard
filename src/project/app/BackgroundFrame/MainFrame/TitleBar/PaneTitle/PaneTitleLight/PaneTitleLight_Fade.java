package project.app.BackgroundFrame.MainFrame.TitleBar.PaneTitle.PaneTitleLight;

import javafx.animation.FadeTransition;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.Region;
import javafx.util.Duration;
import java.util.concurrent.ExecutorService;

import project.app.Utilities.AnimationUtils.SequentialTransitionService;
import static project.app.Utilities.SizeUtils.*;

public class PaneTitleLight_Fade extends Region
{
    public SequentialTransitionService FadeService;

    public PaneTitleLight_Fade()
    {
        FadeTransition Fade=new FadeTransition(Duration.millis(300), this);
        Fade.setFromValue(0); Fade.setToValue(1);
        Fade.setAutoReverse(true);
        Fade.setCycleCount(2);
        FadeService=new SequentialTransitionService(Fade);

        setStyle("-fx-background-color: linear-gradient(to right, #92FE9D 0%, #00C9FF 100%); -fx-background-radius: 2.5px 5px 5px 2.5px");
        setLayoutX(0); setLayoutY(0);
        setPrefSize(10*UNIT, 40*UNIT);
        setEffect(new GaussianBlur(20*UNIT));
        setOpacity(0);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FadeService.setExecutor(AnimationThreadPool);
    }
}