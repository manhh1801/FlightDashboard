package project.app.Utilities.AnimationUtils;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class LinearFillTransitionService<Void> extends Service
{
    public SequentialTransition Transition;

    public LinearFillTransitionService(Duration Duration_args, Shape Shape_args, String Direction, String Gradient1From, String Gradient1To, String Gradient2From, String Gradient2To)
    {
        Shape_args.getStyleClass().add("linear-fill-transition-"+Direction);
        Shape_args.setStyle("-gradient-from: #"+Gradient1From+"; -gradient-to: #"+Gradient2From+";");

        SimpleObjectProperty<Color> FromColor=new SimpleObjectProperty();
        FromColor.addListener
        (
            new ChangeListener<Color>()
            {
                public void changed(ObservableValue<? extends Color> observableValue, Color OldColor, Color NewColor)
                {
                    Shape_args.setStyle(String.format("-gradient-from: #%02x%02x%02x;", (int)(NewColor.getRed()*255), (int)(NewColor.getGreen()*255), (int)(NewColor.getBlue()*255)));
                }
            }
        );
        Timeline GradientFromTransition=new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(FromColor, Color.web(Gradient1From))), new KeyFrame(Duration_args, new KeyValue(FromColor, Color.web(Gradient2From))));

        SimpleObjectProperty<Color> ToColor=new SimpleObjectProperty();
        ToColor.addListener
        (
            new ChangeListener<Color>()
            {
                public void changed(ObservableValue<? extends Color> observableValue, Color OldColor, Color NewColor)
                {
                    Shape_args.setStyle(String.format("-gradient-to: #%02x%02x%02x;", (int)(NewColor.getRed()*255), (int)(NewColor.getGreen()*255), (int)(NewColor.getBlue()*255)));
                }
            }
        );
        Timeline GradientToTransition=new Timeline(new KeyFrame(Duration.ZERO, new KeyValue(ToColor, Color.web(Gradient1To))), new KeyFrame(Duration_args, new KeyValue(ToColor, Color.web(Gradient2To))));

        Transition=new SequentialTransition(GradientFromTransition);

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