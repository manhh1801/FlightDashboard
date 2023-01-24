package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemBackground.FilterItemBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemIcon.FilterItemIcon;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItem.FilterItemName.FilterItemName;
import project.app.Utilities.AnimationUtils.FadeTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.SizeUtils.*;

public class FilterItem extends Pane
{
    public SimpleBooleanProperty MousePosState, ClickState;
    public SimpleIntegerProperty FilterCount, FilterTypeState;

    public FadeTransitionService FadeInService, FadeOutService;

    public FilterItemBackground FilterItemBackground_var;
    public FilterItemIcon FilterItemIcon_var;
    public FilterItemName FilterItemName_var;

    public FilterItem()
    {
        FadeInService=new FadeTransitionService(Duration.millis(150), this, 0, 1);
        FadeOutService=new FadeTransitionService(Duration.millis(150), this, 1, 0);

        FilterItemBackground_var=new FilterItemBackground();
        FilterItemIcon_var=new FilterItemIcon();
        FilterItemName_var=new FilterItemName();

        setPrefSize(60*UNIT, 60*UNIT);
        getChildren().addAll(FilterItemBackground_var, FilterItemIcon_var, FilterItemName_var);
        setOpacity(0);

        FilterTypeState=new SimpleIntegerProperty(1);
        FilterTypeState.bindBidirectional(FilterItemIcon_var.FilterTypeState);
        FilterTypeState.bindBidirectional(FilterItemName_var.FilterTypeState);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.bindBidirectional(FilterItemBackground_var.MousePosState);
        MousePosState.bindBidirectional(FilterItemIcon_var.MousePosState);
        MousePosState.bindBidirectional(FilterItemName_var.MousePosState);
        setOnMouseEntered
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                            {
                                MousePosState.set(true);
                            }
            }
        );
        setOnMouseExited
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                            {
                                MousePosState.set(false);
                            }
            }
        );

        FilterCount=new SimpleIntegerProperty(1);

        ClickState=new SimpleBooleanProperty(false);
        ClickState.bindBidirectional(FilterItemBackground_var.ClickState);
        ClickState.bindBidirectional(FilterItemIcon_var.ClickState);
        ClickState.bindBidirectional(FilterItemName_var.ClickState);
        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    ClickState.set(!ClickState.get());
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FadeInService.setExecutor(AnimationThreadPool);
        FadeOutService.setExecutor(AnimationThreadPool);
    }
}