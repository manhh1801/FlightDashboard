package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemIcon.PriceItemIcon;

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

public class PriceItemIcon_Fade extends SVGPath
{
    public ParallelTransitionService EnterService, ExitService;
    public FillTransitionService ClickOnService, ClickOffService;
    public FadeTransitionService OnEnterService, OnExitService;

    public PriceItemIcon_Fade()
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

        setContent("M8.04006 10.3073H6.7825C5.81836 10.3073 5.03867 9.50283 5.03867 8.50562C5.03867 8.16205 5.32372 7.87713 5.66745 7.87713C6.01119 7.87713 6.29624 8.16205 6.29624 8.50562C6.29624 8.8073 6.51421 9.05031 6.7825 9.05031H8.04006C8.23289 9.05031 8.3838 8.87434 8.3838 8.65646C8.3838 8.36316 8.3335 8.34641 8.14067 8.27937L6.12018 7.57546C5.39079 7.32406 5.03028 6.81289 5.03028 6.0168C5.03028 5.11178 5.75129 4.36597 6.63159 4.36597H7.88916C8.85329 4.36597 9.63299 5.17043 9.63299 6.16764C9.63299 6.51121 9.34794 6.79613 9.0042 6.79613C8.66047 6.79613 8.37542 6.51121 8.37542 6.16764C8.37542 5.86596 8.15744 5.62295 7.88916 5.62295H6.63159C6.43876 5.62295 6.28785 5.79892 6.28785 6.0168C6.28785 6.3101 6.33815 6.32686 6.53098 6.3939L8.55148 7.0978C9.28087 7.35758 9.63299 7.86875 9.63299 8.65646C9.64137 9.56987 8.92036 10.3073 8.04006 10.3073Z M7.3358 10.9776C6.99206 10.9776 6.70702 10.6927 6.70702 10.3491V9.72902C6.70702 9.38544 6.99206 9.10052 7.3358 9.10052C7.67954 9.10052 7.96459 9.38544 7.96459 9.72902V10.3491C7.96459 10.7011 7.67954 10.9776 7.3358 10.9776Z M7.3358 5.61454C6.99206 5.61454 6.70702 5.32963 6.70702 4.98605V4.33242C6.70702 3.98885 6.99206 3.70393 7.3358 3.70393C7.67954 3.70393 7.96459 3.98885 7.96459 4.33242V4.98605C7.96459 5.32963 7.67954 5.61454 7.3358 5.61454Z M7.32744 14.648C3.28645 14.648 0 11.3631 0 7.32401C0 3.28491 3.28645 0 7.32744 0C11.3684 0 14.6549 3.28491 14.6549 7.32401C14.6549 11.3631 11.36 14.648 7.32744 14.648ZM7.32744 1.26536C3.9823 1.26536 1.25757 3.98882 1.25757 7.33239C1.25757 10.676 3.9823 13.391 7.32744 13.391C10.6726 13.391 13.3973 10.6676 13.3973 7.32401C13.3973 3.98044 10.6726 1.26536 7.32744 1.26536Z M13.2212 18C11.6702 18 10.2114 17.2459 9.31437 15.9721C9.11316 15.6872 9.18023 15.2933 9.46528 15.0922C9.75033 14.8911 10.1444 14.9582 10.3456 15.2431C11.0079 16.1816 12.081 16.7347 13.2212 16.7347C15.1663 16.7347 16.7424 15.1593 16.7424 13.2151C16.7424 12.0839 16.1891 11.0112 15.2669 10.3492C14.9818 10.1481 14.9231 9.75425 15.1243 9.46934C15.3256 9.18442 15.7196 9.12576 16.0046 9.32688C17.2538 10.2235 18 11.6732 18 13.2151C18 15.8632 15.8621 18 13.2212 18Z");
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