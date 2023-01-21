package project.app.BackgroundFrame.MainFrame.ContentFrame;

import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.concurrent.ExecutorService;

import project.app.Utilities.AnimationUtils.FadeTransitionService;
import static project.app.Utilities.SizeUtils.*;

public class ContentPane extends Pane
{
    public FadeTransitionService FadeInService, FadeOutService;

    public ContentPane()
    {
        FadeInService=new FadeTransitionService(Duration.millis(300), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(300), this, 1, 0);

        setLayoutX(0); setLayoutY(0);
        setPrefSize(1420*UNIT, 960*UNIT);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FadeInService.setExecutor(AnimationThreadPool);
        FadeInService.setExecutor(AnimationThreadPool);
    }
}