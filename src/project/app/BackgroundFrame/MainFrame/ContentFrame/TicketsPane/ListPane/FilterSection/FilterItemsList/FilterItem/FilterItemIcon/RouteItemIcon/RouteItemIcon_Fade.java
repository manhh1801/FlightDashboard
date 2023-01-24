package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemIcon.RouteItemIcon;

import javafx.animation.FadeTransition;
import javafx.animation.FillTransition;
import javafx.geometry.Bounds;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.shape.SVGPath;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FadeTransitionService;
import project.app.Utilities.AnimationUtils.FillTransitionService;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class RouteItemIcon_Fade extends SVGPath
{
    public ParallelTransitionService EnterService, ExitService;
    public FillTransitionService ClickOnService, ClickOffService;
    public FadeTransitionService OnEnterService, OnExitService;

    public RouteItemIcon_Fade()
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

        setContent("M3.55116 7.95349C2.95777 7.95349 2.35601 7.73581 1.89634 7.29209C0.358516 5.82698 -0.259955 4.22791 0.0994265 2.66233C0.52567 0.820465 2.13871 0 3.55116 0C4.96362 0 6.58502 0.828837 7.0029 2.66233C7.36229 4.22791 6.73546 5.82698 5.20599 7.29209C4.74632 7.73581 4.15292 7.95349 3.55116 7.95349ZM1.31965 2.94698C1.00206 4.34512 1.92977 5.58419 2.76554 6.37953C3.2085 6.80651 3.90219 6.79814 4.34515 6.37953C5.18092 5.58419 6.10863 4.34512 5.78268 2.9386C5.49851 1.69954 4.40365 1.25581 3.55952 1.25581C2.70704 1.25581 1.61217 1.69953 1.31965 2.94698Z M3.5846 4.14419C3.12492 4.14419 2.74882 3.76744 2.74882 3.30698C2.74882 2.84651 3.11656 2.46977 3.5846 2.46977H3.59295C4.05263 2.46977 4.42873 2.84651 4.42873 3.30698C4.42873 3.76744 4.05263 4.14419 3.5846 4.14419Z M14.4329 18C13.8395 18 13.2378 17.7823 12.7697 17.3386C11.2236 15.8735 10.5967 14.2744 10.9645 12.7005C11.3907 10.867 13.0121 10.0381 14.4329 10.0381C15.8537 10.0381 17.4751 10.867 17.9014 12.7005C18.2608 14.266 17.6339 15.8735 16.0877 17.3302C15.6281 17.7823 15.0347 18 14.4329 18ZM14.4329 11.3023C13.5804 11.3023 12.4772 11.746 12.1847 12.9935C11.8587 14.3916 12.7948 15.6391 13.6306 16.4344C14.0735 16.8614 14.7756 16.8614 15.2269 16.4344C16.0627 15.6391 16.9987 14.4 16.6728 13.0019C16.397 11.746 15.2938 11.3023 14.4329 11.3023Z M14.4663 14.1907C14.0067 14.1907 13.6306 13.814 13.6306 13.3535C13.6306 12.893 13.9983 12.5163 14.4663 12.5163H14.4747C14.9344 12.5163 15.3105 12.893 15.3105 13.3535C15.3105 13.814 14.926 14.1907 14.4663 14.1907Z M9.00876 15.4884H6.76889C5.79939 15.4884 4.95526 14.9023 4.62095 13.9981C4.27829 13.094 4.52902 12.0977 5.25614 11.453L11.934 5.60093C12.3351 5.2493 12.3435 4.77209 12.2265 4.44558C12.1011 4.11907 11.7835 3.76744 11.2486 3.76744H9.00876C8.66609 3.76744 8.38193 3.48279 8.38193 3.13953C8.38193 2.79628 8.66609 2.51163 9.00876 2.51163H11.2486C12.2181 2.51163 13.0623 3.09767 13.3966 4.00186C13.7392 4.90605 13.4885 5.90233 12.7614 6.54698L6.08355 12.3991C5.68238 12.7507 5.67403 13.2279 5.79103 13.5544C5.9164 13.8809 6.23399 14.2326 6.76889 14.2326H9.00876C9.35142 14.2326 9.63559 14.5172 9.63559 14.8605C9.63559 15.2037 9.35142 15.4884 9.00876 15.4884Z M9.00876 15.4884H6.76889C5.79939 15.4884 4.95526 14.9023 4.62095 13.9981C4.27829 13.094 4.52902 12.0977 5.25614 11.453L11.934 5.60093C12.3351 5.2493 12.3435 4.77209 12.2265 4.44558C12.1011 4.11907 11.7835 3.76744 11.2486 3.76744H9.00876C8.66609 3.76744 8.38193 3.48279 8.38193 3.13953C8.38193 2.79628 8.66609 2.51163 9.00876 2.51163H11.2486C12.2181 2.51163 13.0623 3.09767 13.3966 4.00186C13.7392 4.90605 13.4885 5.90233 12.7614 6.54698L6.08355 12.3991C5.68238 12.7507 5.67403 13.2279 5.79103 13.5544C5.9164 13.8809 6.23399 14.2326 6.76889 14.2326H9.00876C9.35142 14.2326 9.63559 14.5172 9.63559 14.8605C9.63559 15.2037 9.35142 15.4884 9.00876 15.4884Z");
        setFill(GRAY(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(1*UNIT-Bounds.getMinX()); setLayoutY(1*UNIT-Bounds.getMinY());
        setEffect(new GaussianBlur(5*UNIT));
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