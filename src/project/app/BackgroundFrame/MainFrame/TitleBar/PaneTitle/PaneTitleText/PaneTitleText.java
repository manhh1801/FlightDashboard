package project.app.BackgroundFrame.MainFrame.TitleBar.PaneTitle.PaneTitleText;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

import project.app.Utilities.AnimationUtils.SequentialTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class PaneTitleText extends Pane
{
    public SequentialTransitionService CurrentService;
    public SequentialTransitionService ToHomeService, ToSchedulesService, ToTicketsService, ToStatisticsService, ToContactsService, ToSettingsService;

    public PaneTitleText()
    {
        Text TitleText=new Text("Home");
        TitleText.setFont(AVERTA(2, 32*UNIT));
        TitleText.setFill(WHITE(1));
        TitleText.setTextAlignment(TextAlignment.LEFT);
        TitleText.setTextOrigin(VPos.CENTER);
        TitleText.setLayoutX(0); TitleText.setLayoutY(20*UNIT);

        TranslateTransition LeftTranslate=new TranslateTransition(Duration.millis(295), TitleText);
        LeftTranslate.setToX(-160*UNIT);
        TranslateTransition RightTranslate=new TranslateTransition(Duration.millis(295), TitleText);
        RightTranslate.setToX(0);
        Timeline ToHome=new Timeline(new KeyFrame(Duration.millis(10), new KeyValue(TitleText.textProperty(), "Home")));
        Timeline ToSchedules=new Timeline(new KeyFrame(Duration.millis(10), new KeyValue(TitleText.textProperty(), "Schedules")));
        Timeline ToTickets=new Timeline(new KeyFrame(Duration.millis(10), new KeyValue(TitleText.textProperty(), "Tickets")));
        Timeline ToStatistics=new Timeline(new KeyFrame(Duration.millis(10), new KeyValue(TitleText.textProperty(), "Statistics")));
        Timeline ToContacts=new Timeline(new KeyFrame(Duration.millis(10), new KeyValue(TitleText.textProperty(), "Contacts")));
        Timeline ToSettings=new Timeline(new KeyFrame(Duration.millis(10), new KeyValue(TitleText.textProperty(), "Settings")));
        ToHomeService=new SequentialTransitionService(LeftTranslate, ToHome, RightTranslate);
        ToHomeService.setOnRunning(new EventHandler<WorkerStateEvent>() {public void handle(WorkerStateEvent workerStateEvent) {CurrentService=ToHomeService;}});
        ToSchedulesService=new SequentialTransitionService(LeftTranslate, ToSchedules, RightTranslate);
        ToSchedulesService.setOnRunning(new EventHandler<WorkerStateEvent>() {public void handle(WorkerStateEvent workerStateEvent) {CurrentService=ToSchedulesService;}});
        ToTicketsService=new SequentialTransitionService(LeftTranslate, ToTickets, RightTranslate);
        ToTicketsService.setOnRunning(new EventHandler<WorkerStateEvent>() {public void handle(WorkerStateEvent workerStateEvent) {CurrentService=ToTicketsService;}});
        ToStatisticsService=new SequentialTransitionService(LeftTranslate, ToStatistics, RightTranslate);
        ToStatisticsService.setOnRunning(new EventHandler<WorkerStateEvent>() {public void handle(WorkerStateEvent workerStateEvent) {CurrentService=ToStatisticsService;}});
        ToContactsService=new SequentialTransitionService(LeftTranslate, ToContacts, RightTranslate);
        ToContactsService.setOnRunning(new EventHandler<WorkerStateEvent>() {public void handle(WorkerStateEvent workerStateEvent) {CurrentService=ToContactsService;}});
        ToSettingsService=new SequentialTransitionService(LeftTranslate, ToSettings, RightTranslate);
        ToSettingsService.setOnRunning(new EventHandler<WorkerStateEvent>() {public void handle(WorkerStateEvent workerStateEvent) {CurrentService=ToSettingsService;}});
        CurrentService=new SequentialTransitionService();

        setLayoutX(20*UNIT); setLayoutY(0);
        setPrefSize(160*UNIT, 40*UNIT);
        setClip(new Rectangle(160*UNIT, 40*UNIT));
        getChildren().add(TitleText);
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        ToHomeService.setExecutor(AnimationThreadPool);
        ToSchedulesService.setExecutor(AnimationThreadPool);
        ToTicketsService.setExecutor(AnimationThreadPool);
        ToStatisticsService.setExecutor(AnimationThreadPool);
        ToContactsService.setExecutor(AnimationThreadPool);
        ToSettingsService.setExecutor(AnimationThreadPool);
    }
}