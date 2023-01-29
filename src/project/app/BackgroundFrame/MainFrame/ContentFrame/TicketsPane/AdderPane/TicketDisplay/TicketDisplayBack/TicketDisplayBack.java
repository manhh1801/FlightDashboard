package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayBack;

import javafx.animation.*;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;
import project.app.Utilities.AnimationUtils.TranslateTransitionService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.*;

public class TicketDisplayBack extends Pane
{
    public SimpleBooleanProperty MousePosState, TicketType;

    public ExecutorService AnimationThreadPool;

    public ParallelTransitionService EconomicService, BusinessService;
    public TranslateTransitionService EnterService, ExitService;

    public TicketDisplayBack()
    {
        ImageView TicketDisplayBackEconomic=new ImageView();
        try {TicketDisplayBackEconomic.setImage(new Image(new FileInputStream("resources/Images/economic.png")));}
        catch(FileNotFoundException f) {}
        TicketDisplayBackEconomic.setLayoutX(0); TicketDisplayBackEconomic.setLayoutY(0);
        TicketDisplayBackEconomic.setFitWidth(400*UNIT); TicketDisplayBackEconomic.setFitHeight(240*UNIT);
        ImageView TicketDisplayBackBusiness=new ImageView();
        try {TicketDisplayBackBusiness.setImage(new Image(new FileInputStream("resources/Images/business.png")));}
        catch(FileNotFoundException f) {}
        TicketDisplayBackBusiness.setLayoutX(0); TicketDisplayBackBusiness.setLayoutY(0);
        TicketDisplayBackBusiness.setFitWidth(400*UNIT); TicketDisplayBackBusiness.setFitHeight(240*UNIT);
        TicketDisplayBackBusiness.setOpacity(0);

        setLayoutX(0); setLayoutY(0);
        setPrefSize(400*UNIT, 240*UNIT);
        getChildren().addAll(TicketDisplayBackEconomic, TicketDisplayBackBusiness);
        GaussianBlur Blur=new GaussianBlur(0);
        setEffect(Blur);

        FadeTransition EconomicFadeIn=new FadeTransition(Duration.millis(150), TicketDisplayBackEconomic); EconomicFadeIn.setFromValue(0); EconomicFadeIn.setToValue(1);
        FadeTransition EconomicFadeOut=new FadeTransition(Duration.millis(150), TicketDisplayBackEconomic); EconomicFadeOut.setFromValue(1); EconomicFadeOut.setToValue(0);
        FadeTransition BusinessFadeIn=new FadeTransition(Duration.millis(150), TicketDisplayBackBusiness); BusinessFadeIn.setFromValue(0); BusinessFadeIn.setToValue(1);
        FadeTransition BusinessFadeOut=new FadeTransition(Duration.millis(150), TicketDisplayBackBusiness); BusinessFadeOut.setFromValue(1); BusinessFadeOut.setToValue(0);
        EconomicService=new ParallelTransitionService(EconomicFadeIn, BusinessFadeOut);
        BusinessService=new ParallelTransitionService(EconomicFadeOut, BusinessFadeIn);
        EnterService=new TranslateTransitionService(Duration.millis(150), this, 20*UNIT, 20*UNIT);
        ExitService=new TranslateTransitionService(Duration.millis(150), this, 0, 0);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        if(ExitService.isRunning()==true) {ExitService.cancel();}
                        EnterService.restart();
                    }
                    else
                    {
                        if(EnterService.isRunning()==true) {EnterService.cancel();}
                        ExitService.restart();
                    }
                }
            }
        );

        TicketType=new SimpleBooleanProperty(false);
        TicketType.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        if(EconomicService.isRunning()==true) {EconomicService.cancel();}
                        BusinessService.restart();
                    }
                    else
                    {
                        if(BusinessService.isRunning()==true) {BusinessService.cancel();}
                        EconomicService.restart();
                    }
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
        EconomicService.setExecutor(AnimationThreadPool);
        BusinessService.setExecutor(AnimationThreadPool);
    }
}