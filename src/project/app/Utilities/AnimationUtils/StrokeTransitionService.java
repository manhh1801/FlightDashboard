package project.app.Utilities.AnimationUtils;

import javafx.animation.StrokeTransition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class StrokeTransitionService<Void> extends Service
{
    public StrokeTransition Transition;

    public StrokeTransitionService(Duration Duration_arg, Shape Shape_arg, Color FromColor_arg, Color ToColor_arg)
    {
        Transition=new StrokeTransition(Duration_arg, Shape_arg, FromColor_arg, ToColor_arg);
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