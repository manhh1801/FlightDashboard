package project.app.Utilities.AnimationUtils;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;

public class ParallelTransitionService<Void> extends Service
{
    public ParallelTransition Animation;

    public ParallelTransitionService(Animation... TransitionList)
    {
        Animation=new ParallelTransition(TransitionList);
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
        Animation=new ParallelTransition(TransitionList);
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
