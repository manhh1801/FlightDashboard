package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.BlurContent.BlurContent;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.DecoratingShapes.DecoratingShapes;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.DepartureTime.DepartureTimeContent;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.DepartureTime.DepartureTimeTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.Flight.FlightContent;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.Flight.FlightTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.From.FromContent;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.From.FromTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.Name.NameContent;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.Name.NameTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.PassportID.PassportIDContent;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.PassportID.PassportIDTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.TicketDisplayFrontBackground.TicketDisplayFrontBackground;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.TicketType.TicketTypeContent;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.TicketType.TicketTypeTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.To.ToContent;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.To.ToTitle;
import project.app.Utilities.AnimationUtils.TranslateTransitionService;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static project.app.Utilities.SizeUtils.*;

public class TicketDisplayFront extends Pane
{
    public SimpleBooleanProperty MousePosState, TicketType;

    public ExecutorService AnimationThreadPool;

    public TranslateTransitionService EnterService, ExitService;

    public BlurContent BlurContent_var;
    public TicketDisplayFrontBackground TicketDisplayFrontBackground_var;
    public DecoratingShapes DecoratingShapes_var;
    public FlightTitle FlightTitle_var;
    public FromTitle FromTitle_var;
    public ToTitle ToTitle_var;
    public DepartureTimeTitle DepartureTimeTitle_var;
    public TicketTypeTitle TicketTypeTitle_var;
    public NameTitle NameTitle_var;
    public PassportIDTitle PassportIDTitle_var;
    public FlightContent FlightContent_var;
    public FromContent FromContent_var;
    public ToContent ToContent_var;
    public DepartureTimeContent DepartureTimeContent_var;
    public TicketTypeContent TicketTypeContent_var;
    public NameContent NameContent_var;
    public PassportIDContent PassportIDContent_var;

    public TicketDisplayFront()
    {
        EnterService=new TranslateTransitionService(Duration.millis(150), this, -20*UNIT, -20*UNIT);
        ExitService=new TranslateTransitionService(Duration.millis(150), this, 0, 0);

        BlurContent_var=new BlurContent();
        TicketDisplayFrontBackground_var=new TicketDisplayFrontBackground();
        DecoratingShapes_var=new DecoratingShapes();
        FlightTitle_var=new FlightTitle();
        FromTitle_var=new FromTitle();
        ToTitle_var=new ToTitle();
        DepartureTimeTitle_var=new DepartureTimeTitle();
        TicketTypeTitle_var=new TicketTypeTitle();
        NameTitle_var=new NameTitle();
        PassportIDTitle_var=new PassportIDTitle();
        FlightContent_var=new FlightContent();
        FromContent_var=new FromContent();
        ToContent_var=new ToContent();
        DepartureTimeContent_var=new DepartureTimeContent();
        TicketTypeContent_var=new TicketTypeContent();
        NameContent_var=new NameContent();
        PassportIDContent_var=new PassportIDContent();

        setLayoutX(40*UNIT); setLayoutY(40*UNIT);
        setPrefSize(400*UNIT, 240*UNIT);
        getChildren().addAll(BlurContent_var, TicketDisplayFrontBackground_var, DecoratingShapes_var, FlightTitle_var, FromTitle_var, ToTitle_var, DepartureTimeTitle_var, TicketTypeTitle_var, NameTitle_var, PassportIDTitle_var, FlightContent_var, FromContent_var, ToContent_var, DepartureTimeContent_var, TicketTypeContent_var, NameContent_var, PassportIDContent_var);

        AnimationThreadPool=Executors.newFixedThreadPool(18);
        setAnimationThreadPool(AnimationThreadPool);
        BlurContent_var.setAnimationThreadPool(AnimationThreadPool);
        TicketDisplayFrontBackground_var.setAnimationThreadPool(AnimationThreadPool);
        DecoratingShapes_var.setAnimationThreadPool(AnimationThreadPool);
        FlightTitle_var.setAnimationThreadPool(AnimationThreadPool);
        FromTitle_var.setAnimationThreadPool(AnimationThreadPool);
        ToTitle_var.setAnimationThreadPool(AnimationThreadPool);
        DepartureTimeTitle_var.setAnimationThreadPool(AnimationThreadPool);
        TicketTypeTitle_var.setAnimationThreadPool(AnimationThreadPool);
        NameTitle_var.setAnimationThreadPool(AnimationThreadPool);
        PassportIDTitle_var.setAnimationThreadPool(AnimationThreadPool);
        FlightContent_var.setAnimationThreadPool(AnimationThreadPool);
        FromContent_var.setAnimationThreadPool(AnimationThreadPool);
        ToContent_var.setAnimationThreadPool(AnimationThreadPool);
        DepartureTimeContent_var.setAnimationThreadPool(AnimationThreadPool);
        TicketTypeContent_var.setAnimationThreadPool(AnimationThreadPool);
        NameContent_var.setAnimationThreadPool(AnimationThreadPool);
        PassportIDContent_var.setAnimationThreadPool(AnimationThreadPool);

        MousePosState=new SimpleBooleanProperty(false);
        MousePosState.bindBidirectional(BlurContent_var.MousePosState);
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
        TicketType.bindBidirectional(TicketTypeContent_var.TicketType);
        TicketType.addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean OldValue, Boolean NewValue)
                {
                    if(NewValue==true)
                    {
                        if(BlurContent_var.EconomicService.isRunning()==true) {BlurContent_var.EconomicService.cancel();}
                        if(TicketDisplayFrontBackground_var.EconomicService.isRunning()==true) {TicketDisplayFrontBackground_var.EconomicService.cancel();}
                        if(DecoratingShapes_var.EconomicService.isRunning()==true) {DecoratingShapes_var.EconomicService.cancel();}
                        if(FlightTitle_var.EconomicService.isRunning()==true) {FlightTitle_var.EconomicService.cancel();}
                        if(FromTitle_var.EconomicService.isRunning()==true) {FromTitle_var.EconomicService.cancel();}
                        if(ToTitle_var.EconomicService.isRunning()==true) {ToTitle_var.EconomicService.cancel();}
                        if(DepartureTimeTitle_var.EconomicService.isRunning()==true) {DepartureTimeTitle_var.EconomicService.cancel();}
                        if(TicketTypeTitle_var.EconomicService.isRunning()==true) {TicketTypeTitle_var.EconomicService.cancel();}
                        if(NameTitle_var.EconomicService.isRunning()==true) {NameTitle_var.EconomicService.cancel();}
                        if(PassportIDTitle_var.EconomicService.isRunning()==true) {PassportIDTitle_var.EconomicService.cancel();}
                        if(FlightContent_var.EconomicService.isRunning()==true) {FlightContent_var.EconomicService.cancel();}
                        if(FromContent_var.EconomicService.isRunning()==true) {FromContent_var.EconomicService.cancel();}
                        if(ToContent_var.EconomicService.isRunning()==true) {ToContent_var.EconomicService.cancel();}
                        if(DepartureTimeContent_var.EconomicService.isRunning()==true) {DepartureTimeContent_var.EconomicService.cancel();}
                        if(TicketTypeContent_var.EconomicService.isRunning()==true) {TicketTypeContent_var.EconomicService.cancel();}
                        if(NameContent_var.EconomicService.isRunning()==true) {NameContent_var.EconomicService.cancel();}
                        if(PassportIDContent_var.EconomicService.isRunning()==true) {PassportIDContent_var.EconomicService.cancel();}
                        BlurContent_var.BusinessService.restart();
                        TicketDisplayFrontBackground_var.BusinessService.restart();
                        DecoratingShapes_var.BusinessService.restart();
                        FlightTitle_var.BusinessService.restart();
                        FromTitle_var.BusinessService.restart();
                        ToTitle_var.BusinessService.restart();
                        DepartureTimeTitle_var.BusinessService.restart();
                        TicketTypeTitle_var.BusinessService.restart();
                        NameTitle_var.BusinessService.restart();
                        PassportIDTitle_var.BusinessService.restart();
                        FlightContent_var.BusinessService.restart();
                        FromContent_var.BusinessService.restart();
                        ToContent_var.BusinessService.restart();
                        DepartureTimeContent_var.BusinessService.restart();
                        TicketTypeContent_var.BusinessService.restart();
                        NameContent_var.BusinessService.restart();
                        PassportIDContent_var.BusinessService.restart();
                    }
                    else
                    {
                        if(BlurContent_var.BusinessService.isRunning()==true) {BlurContent_var.BusinessService.cancel();}
                        if(TicketDisplayFrontBackground_var.BusinessService.isRunning()==true) {TicketDisplayFrontBackground_var.BusinessService.cancel();}
                        if(DecoratingShapes_var.BusinessService.isRunning()==true) {DecoratingShapes_var.BusinessService.cancel();}
                        if(FlightTitle_var.BusinessService.isRunning()==true) {FlightTitle_var.BusinessService.cancel();}
                        if(FromTitle_var.BusinessService.isRunning()==true) {FromTitle_var.BusinessService.cancel();}
                        if(ToTitle_var.BusinessService.isRunning()==true) {ToTitle_var.BusinessService.cancel();}
                        if(DepartureTimeTitle_var.BusinessService.isRunning()==true) {DepartureTimeTitle_var.BusinessService.cancel();}
                        if(TicketTypeTitle_var.BusinessService.isRunning()==true) {TicketTypeTitle_var.BusinessService.cancel();}
                        if(NameTitle_var.BusinessService.isRunning()==true) {NameTitle_var.BusinessService.cancel();}
                        if(PassportIDTitle_var.BusinessService.isRunning()==true) {PassportIDTitle_var.BusinessService.cancel();}
                        if(FlightContent_var.BusinessService.isRunning()==true) {FlightContent_var.BusinessService.cancel();}
                        if(FromContent_var.BusinessService.isRunning()==true) {FromContent_var.BusinessService.cancel();}
                        if(ToContent_var.BusinessService.isRunning()==true) {ToContent_var.BusinessService.cancel();}
                        if(DepartureTimeContent_var.BusinessService.isRunning()==true) {DepartureTimeContent_var.BusinessService.cancel();}
                        if(TicketTypeContent_var.BusinessService.isRunning()==true) {TicketTypeContent_var.BusinessService.cancel();}
                        if(NameContent_var.BusinessService.isRunning()==true) {NameContent_var.BusinessService.cancel();}
                        if(PassportIDContent_var.BusinessService.isRunning()==true) {PassportIDContent_var.BusinessService.cancel();}
                        BlurContent_var.EconomicService.restart();
                        TicketDisplayFrontBackground_var.EconomicService.restart();
                        DecoratingShapes_var.EconomicService.restart();
                        FlightTitle_var.EconomicService.restart();
                        FromTitle_var.EconomicService.restart();
                        ToTitle_var.EconomicService.restart();
                        DepartureTimeTitle_var.EconomicService.restart();
                        TicketTypeTitle_var.EconomicService.restart();
                        NameTitle_var.EconomicService.restart();
                        PassportIDTitle_var.EconomicService.restart();
                        FlightContent_var.EconomicService.restart();
                        FromContent_var.EconomicService.restart();
                        ToContent_var.EconomicService.restart();
                        DepartureTimeContent_var.EconomicService.restart();
                        TicketTypeContent_var.EconomicService.restart();
                        NameContent_var.EconomicService.restart();
                        PassportIDContent_var.EconomicService.restart();
                    }
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EnterService.setExecutor(AnimationThreadPool);
        ExitService.setExecutor(AnimationThreadPool);
    }
}