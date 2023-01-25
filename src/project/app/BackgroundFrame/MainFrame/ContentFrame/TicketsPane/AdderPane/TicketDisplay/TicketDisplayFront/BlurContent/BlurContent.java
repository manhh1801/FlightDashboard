package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.BlurContent;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.ParallelTransitionService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.ExecutorService;

import static project.app.Utilities.SizeUtils.*;

public class BlurContent extends Pane
{
    public SimpleBooleanProperty MousePosState, TicketTypeState;
    
    public ParallelTransitionService EconomicService, BusinessService, EnterService, ExitService;
    
    public BlurContent()
    {
        Rectangle MainFrameBackground=new Rectangle();
        MainFrameBackground.setFill(Color.web("#0B0B12"));
        MainFrameBackground.setArcWidth(55*UNIT); MainFrameBackground.setArcHeight(55*UNIT);
        MainFrameBackground.setLayoutX(0); MainFrameBackground.setLayoutY(0);
        MainFrameBackground.setWidth(400*UNIT); MainFrameBackground.setHeight(240*UNIT);
        ImageView TicketDisplayBackEconomic=new ImageView();
        try {TicketDisplayBackEconomic.setImage(new Image(new FileInputStream("resources/Images/economic.png")));}
        catch(FileNotFoundException f) {}
        TicketDisplayBackEconomic.setSmooth(true);
        TicketDisplayBackEconomic.setCache(true);
        TicketDisplayBackEconomic.setLayoutX(-40*UNIT); TicketDisplayBackEconomic.setLayoutY(-40*UNIT);
        TicketDisplayBackEconomic.setFitWidth(400*UNIT); TicketDisplayBackEconomic.setFitHeight(240*UNIT);
        ImageView TicketDisplayBackBusiness=new ImageView();
        try {TicketDisplayBackBusiness.setImage(new Image(new FileInputStream("resources/Images/business.png")));}
        catch(FileNotFoundException f) {}
        TicketDisplayBackBusiness.setSmooth(true);
        TicketDisplayBackBusiness.setCache(true);
        TicketDisplayBackBusiness.setLayoutX(-40*UNIT); TicketDisplayBackBusiness.setLayoutY(-40*UNIT);
        TicketDisplayBackBusiness.setFitWidth(400*UNIT); TicketDisplayBackBusiness.setFitHeight(240*UNIT);
        TicketDisplayBackBusiness.setOpacity(0);

        FadeTransition EconomicFadeIn=new FadeTransition(Duration.millis(150), TicketDisplayBackEconomic); EconomicFadeIn.setFromValue(0); EconomicFadeIn.setToValue(1);
        FadeTransition EconomicFadeOut=new FadeTransition(Duration.millis(150), TicketDisplayBackEconomic); EconomicFadeOut.setFromValue(1); EconomicFadeOut.setToValue(0);
        FadeTransition BusinessFadeIn=new FadeTransition(Duration.millis(150), TicketDisplayBackBusiness); BusinessFadeIn.setFromValue(0); BusinessFadeIn.setToValue(1);
        FadeTransition BusinessFadeOut=new FadeTransition(Duration.millis(150), TicketDisplayBackBusiness); BusinessFadeOut.setFromValue(1); BusinessFadeOut.setToValue(0);
        EconomicService=new ParallelTransitionService(EconomicFadeIn, BusinessFadeOut);
        BusinessService=new ParallelTransitionService(EconomicFadeOut, BusinessFadeIn);
        TranslateTransition EconomicEnter=new TranslateTransition(Duration.millis(150), TicketDisplayBackEconomic); EconomicEnter.setToX(40*UNIT); EconomicEnter.setToY(40*UNIT);
        TranslateTransition EconomicExit=new TranslateTransition(Duration.millis(150), TicketDisplayBackEconomic); EconomicExit.setToX(0); EconomicExit.setToY(0);
        TranslateTransition BusinessEnter=new TranslateTransition(Duration.millis(150), TicketDisplayBackBusiness); BusinessEnter.setToX(40*UNIT); BusinessEnter.setToY(40*UNIT);
        TranslateTransition BusinessExit=new TranslateTransition(Duration.millis(150), TicketDisplayBackBusiness); BusinessExit.setToX(0); BusinessExit.setToY(0);
        EnterService=new ParallelTransitionService(EconomicEnter, BusinessEnter);
        ExitService=new ParallelTransitionService(EconomicExit, BusinessExit);

        Pane BlurWrapper=new Pane();
        BlurWrapper.setLayoutX(0); BlurWrapper.setLayoutY(0);
        BlurWrapper.setPrefSize(400*UNIT, 240*UNIT);
        BlurWrapper.setEffect(new GaussianBlur(50*UNIT));
        BlurWrapper.getChildren().addAll(MainFrameBackground, TicketDisplayBackEconomic, TicketDisplayBackBusiness);

        Rectangle ClipRec=new Rectangle();
        ClipRec.setArcWidth(55*UNIT); ClipRec.setArcHeight(55*UNIT);
        ClipRec.setLayoutX(0); MainFrameBackground.setLayoutY(0);
        ClipRec.setWidth(400*UNIT); ClipRec.setHeight(240*UNIT);

        setLayoutX(0); setLayoutY(0);
        setPrefSize(400*UNIT, 240*UNIT);
        getChildren().add(BlurWrapper);
        setClip(ClipRec);


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

        TicketTypeState=new SimpleBooleanProperty(false);
        TicketTypeState.addListener
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