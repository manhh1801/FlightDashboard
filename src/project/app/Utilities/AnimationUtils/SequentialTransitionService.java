package project.app.Utilities.AnimationUtils;

import javafx.animation.Animation;
import javafx.animation.SequentialTransition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

public class SequentialTransitionService<Void> extends Service
{
    public SequentialTransition Animation;

    public SequentialTransitionService(Animation... AnimationList)
    {
        Animation=new SequentialTransition(AnimationList);
        setOnCancelled
        (
            new EventHandler<WorkerStateEvent>()
            {
                public void handle(WorkerStateEvent workerStateEvent)
                {
                    Animation.stop();
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
                Animation.play();
                return null;
            }
        };
    }

    public void setAnimation(Animation... TransitionList)
    {
        Animation=new SequentialTransition(TransitionList);
        setOnCancelled
        (
            new EventHandler<WorkerStateEvent>()
            {
                public void handle(WorkerStateEvent workerStateEvent)
                {
                    Animation.stop();
                }
            }
        );
    }
}