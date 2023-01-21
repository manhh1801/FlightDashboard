package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchDeleteButtonFrame;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchDeleteButtonFrame.SearchDeleteBackground.SearchDeleteBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchDeleteButtonFrame.SearchDeleteIcon.SearchDeleteIcon;

import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchTextField.SearchTextField;
import project.app.Utilities.AnimationUtils.FadeTransitionService;
import static project.app.Utilities.SizeUtils.*;

public class SearchDeleteButtonFrame extends Pane
{
    public FadeTransitionService FadeInService, FadeOutService;

    public SimpleBooleanProperty MousePosState;

    public SearchTextField SearchTextField_linked;

    public ExecutorService AnimationThreadPool;

    public SearchDeleteBackground SearchDeleteBackground_var;
    public SearchDeleteIcon SearchDeleteIcon_var;

    public SearchDeleteButtonFrame()
    {
        FadeInService=new FadeTransitionService(Duration.millis(50), this, 0, 1);
        FadeInService.setOnRunning
        (
            new EventHandler<WorkerStateEvent>()
            {
                public void handle(WorkerStateEvent workerStateEvent)
                {
                    setVisible(true);
                }
            }
        );
        FadeOutService=new FadeTransitionService(Duration.millis(50), this, 1, 0);
        FadeOutService.setOnSucceeded
        (
            new EventHandler<WorkerStateEvent>()
            {
                public void handle(WorkerStateEvent workerStateEvent)
                {
                    setVisible(false);
                }
            }
        );

        SearchDeleteBackground_var=new SearchDeleteBackground();
        SearchDeleteIcon_var=new SearchDeleteIcon();

        setLayoutX(900*UNIT); setLayoutY(20*UNIT);
        setPrefSize(20*UNIT, 20*UNIT);
        getChildren().addAll(SearchDeleteBackground_var, SearchDeleteIcon_var);
        setOpacity(0);

        AnimationThreadPool=Executors.newFixedThreadPool(1);
        SearchDeleteBackground_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1)
                {

                    if(MousePosState.get()==true)
                    {
                        if(SearchDeleteBackground_var.ExitService.isRunning()==true) {SearchDeleteBackground_var.ExitService.cancel();}
                        SearchDeleteBackground_var.EnterService.restart();
                    }
                    else
                    {
                        if(SearchDeleteBackground_var.EnterService.isRunning()==true) {SearchDeleteBackground_var.EnterService.cancel();}
                        SearchDeleteBackground_var.ExitService.restart();
                    }
                }
            }
        );
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

        setOnMouseClicked
        (
            new EventHandler<MouseEvent>()
            {
                public void handle(MouseEvent mouseEvent)
                {
                    SearchTextField_linked.setText("");
                    mouseEvent.consume();
                }
            }
        );
    }

    public void setSearchTextField(SearchTextField SearchTextField_arg) {SearchTextField_linked=SearchTextField_arg;}

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        FadeInService.setExecutor(AnimationThreadPool);
        FadeOutService.setExecutor(AnimationThreadPool);
    }
}