package project.app.Utilities.AnimationUtils;

import javafx.animation.TranslateTransition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

public class TranslateTransitionService<Void> extends Service
{
    public TranslateTransition Transition;

    public TranslateTransitionService(Duration Duration_arg, Node Node_arg, double ToX, double ToY)
    {
        Transition=new TranslateTransition(Duration_arg, Node_arg);
        Transition.setToX(ToX); Transition.setToY(ToY);
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

    public void setToX(double ToX) {Transition.setToX(ToX);}
    public void setToY(double ToY) {Transition.setToY(ToY);}

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