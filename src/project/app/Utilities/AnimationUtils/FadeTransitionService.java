package project.app.Utilities.AnimationUtils;

import javafx.animation.FadeTransition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;

import javafx.util.Duration;

public class FadeTransitionService<Void> extends Service
{
    public FadeTransition Transition;

    public FadeTransitionService(Duration Duration_arg, Node Node_arg, double FromOpacity_arg, double ToOpacity_arg)
    {
        Transition=new FadeTransition(Duration_arg, Node_arg);
        Transition.setFromValue(FromOpacity_arg); Transition.setToValue(ToOpacity_arg);
        setOnCancelled
        (
            new EventHandler<WorkerStateEvent>()
            {
                public void handle(WorkerStateEvent workerStateEvent)
                {
                    Transition.stop();
                }
            }
        );
    }

    public Task<Void> createTask()
    {
        return new Task<Void>()
        {
            protected Void call()
            {
                Transition.play();
                return null;
            }
        };
    }
}