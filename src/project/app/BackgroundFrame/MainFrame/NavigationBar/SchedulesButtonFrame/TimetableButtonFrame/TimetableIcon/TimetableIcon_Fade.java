package project.app.BackgroundFrame.MainFrame.NavigationBar.SchedulesButtonFrame.TimetableButtonFrame.TimetableIcon;

import javafx.geometry.Bounds;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import java.util.concurrent.ExecutorService;
import javafx.util.Duration;

import project.app.Utilities.AnimationUtils.FadeTransitionService;
import project.app.Utilities.AnimationUtils.FillTransitionService;
import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.ColorUtils.GREEN_WHITE;
import static project.app.Utilities.SizeUtils.*;

public class TimetableIcon_Fade extends SVGPath
{
    public FadeTransitionService FadeInService, FadeOutService;
    public FillTransitionService ClickOnService, ClickOffService;

    public TimetableIcon_Fade()
    {
        FadeInService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(50), this, 1, 0);
        ClickOnService=new FillTransitionService(Duration.millis(50), this, GREEN_GRAY(1), GREEN_WHITE(1));
        ClickOffService=new FillTransitionService(Duration.millis(50), this, GREEN_WHITE(1), GREEN_GRAY(1));

        setFillRule(FillRule.EVEN_ODD);
        setContent("M5 19.5H11C13.5 19.5 15.5 17.9167 15.5 15.2778V6.7785C15.5 4.30739 14.4035 2.92351 12.2412 2.65824C12.2707 2.81515 12.2857 2.97584 12.2857 3.13889C12.2857 3.42609 12.238 3.70296 12.15 3.96234C13.4103 4.12039 13.8929 4.82251 13.8929 6.83333V15.2778C13.8929 16.8611 12.2857 17.9167 11 17.9167H5C3.5 17.9167 2.10714 16.8611 2.10714 15.2778V6.83333C2.10714 4.82364 2.58881 4.11307 3.8479 3.96161C3.97815 4.34914 4.20147 4.70459 4.50828 5.0037C4.61708 5.10978 4.73316 5.20562 4.8554 5.29081C5.31091 5.60827 5.85196 5.77778 6.42105 5.77778H9.57895C10.1686 5.77778 10.7158 5.59148 11.1617 5.27628C11.6187 4.95316 11.9693 4.49457 12.15 3.96234C12.238 3.70296 12.2857 3.42609 12.2857 3.13889C12.2857 2.97584 12.2707 2.81515 12.2412 2.65824C12.1435 2.13797 11.8868 1.65929 11.4917 1.27408C10.9774 0.772689 10.3008 0.5 9.57895 0.5H6.42105C5.10062 0.5 3.99312 1.4342 3.75961 2.65814C1.59675 2.92315 0.5 4.3619 0.5 6.83333V15.2778C0.5 17.9167 2.5 19.5 5 19.5ZM5.46466 4.07129C5.21203 3.825 5.06767 3.49074 5.06767 3.13889C5.06767 3.05252 5.07613 2.96811 5.09229 2.88642C5.21272 2.2776 5.76078 1.81944 6.42105 1.81944H9.57895C9.93985 1.81944 10.2827 1.96019 10.5353 2.20648C10.7267 2.39303 10.8559 2.63003 10.9074 2.88692C10.9238 2.96921 10.9323 3.05353 10.9323 3.13889C10.9323 3.53443 10.7549 3.88865 10.4732 4.13024C10.235 4.33458 9.92211 4.45833 9.57895 4.45833H6.42105C6.08933 4.45833 5.77286 4.33943 5.52768 4.12895C5.50611 4.11044 5.48509 4.09121 5.46466 4.07129Z M8.31818 10.75H4.68182C4.30909 10.75 4 10.41 4 10C4 9.59 4.30909 9.25 4.68182 9.25H8.31818C8.69091 9.25 9 9.59 9 10C9 10.41 8.69091 10.75 8.31818 10.75Z M11.3684 14.75H4.63158C4.28632 14.75 4 14.41 4 14C4 13.59 4.28632 13.25 4.63158 13.25H11.3684C11.7137 13.25 12 13.59 12 14C12 14.41 11.7137 14.75 11.3684 14.75Z");
        setFill(GREEN_WHITE(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(12.5*UNIT-Bounds.getMinX()); setLayoutY(10.5*UNIT-Bounds.getMinY());
        setEffect(new GaussianBlur(10*UNIT));
        setOpacity(0);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FadeInService.setExecutor(AnimationThreadPool);
        FadeOutService.setExecutor(AnimationThreadPool);
        ClickOnService.setExecutor(AnimationThreadPool);
        ClickOffService.setExecutor(AnimationThreadPool);
    }
}