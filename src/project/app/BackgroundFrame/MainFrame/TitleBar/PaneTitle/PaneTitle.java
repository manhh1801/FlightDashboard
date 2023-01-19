package project.app.BackgroundFrame.MainFrame.TitleBar.PaneTitle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.Pane;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import project.app.BackgroundFrame.MainFrame.TitleBar.PaneTitle.PaneTitleLight.PaneTitleLight;
import project.app.BackgroundFrame.MainFrame.TitleBar.PaneTitle.PaneTitleLight.PaneTitleLight_Fade;
import project.app.BackgroundFrame.MainFrame.TitleBar.PaneTitle.PaneTitleText.PaneTitleText;

import static project.app.Utilities.SizeUtils.*;

public class PaneTitle extends Pane
{
    public SimpleIntegerProperty PaneState;

    public ExecutorService AnimationThreadPool;

    public PaneTitleLight PaneTitleLight_var;
    public PaneTitleLight_Fade PaneTitleLight_Fade_var;
    public PaneTitleText PaneTitleText_var;

    public PaneTitle()
    {
        PaneTitleLight_var=new PaneTitleLight();
        PaneTitleLight_Fade_var=new PaneTitleLight_Fade();
        PaneTitleText_var=new PaneTitleText();

        setLayoutX(0); setLayoutY(10*UNIT);
        setPrefSize(180*UNIT, 40*UNIT);
        getChildren().addAll(PaneTitleLight_var, PaneTitleLight_Fade_var, PaneTitleText_var);

        AnimationThreadPool= Executors.newFixedThreadPool(2);
        PaneTitleLight_Fade_var.setAnimationThreadPool(AnimationThreadPool);
        PaneTitleText_var.setAnimationThreadPool(AnimationThreadPool);

        PaneState=new SimpleIntegerProperty(1);
        PaneState.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1)
                {
                    if(PaneState.get()==1)
                    {
                        if(PaneTitleLight_Fade_var.FadeService.isRunning()) {PaneTitleLight_Fade_var.FadeService.cancel();}
                        if(PaneTitleText_var.CurrentService.isRunning()) {PaneTitleText_var.CurrentService.cancel();}
                        PaneTitleLight_Fade_var.FadeService.restart();
                        PaneTitleText_var.ToHomeService.restart();
                    }
                    if(PaneState.get()==2)
                    {
                        if(PaneTitleLight_Fade_var.FadeService.isRunning()) {PaneTitleLight_Fade_var.FadeService.cancel();}
                        if(PaneTitleText_var.CurrentService.isRunning()) {PaneTitleText_var.CurrentService.cancel();}
                        PaneTitleLight_Fade_var.FadeService.restart();
                        PaneTitleText_var.ToSchedulesService.restart();
                    }
                    if(PaneState.get()==3)
                    {
                        if(PaneTitleLight_Fade_var.FadeService.isRunning()) {PaneTitleLight_Fade_var.FadeService.cancel();}
                        if(PaneTitleText_var.CurrentService.isRunning()) {PaneTitleText_var.CurrentService.cancel();}
                        PaneTitleLight_Fade_var.FadeService.restart();
                        PaneTitleText_var.ToTicketsService.restart();
                    }
                    if(PaneState.get()==4)
                    {
                        if(PaneTitleLight_Fade_var.FadeService.isRunning()) {PaneTitleLight_Fade_var.FadeService.cancel();}
                        if(PaneTitleText_var.CurrentService.isRunning()) {PaneTitleText_var.CurrentService.cancel();}
                        PaneTitleLight_Fade_var.FadeService.restart();
                        PaneTitleText_var.ToStatisticsService.restart();
                    }
                    if(PaneState.get()==5)
                    {
                        if(PaneTitleLight_Fade_var.FadeService.isRunning()) {PaneTitleLight_Fade_var.FadeService.cancel();}
                        if(PaneTitleText_var.CurrentService.isRunning()) {PaneTitleText_var.CurrentService.cancel();}
                        PaneTitleLight_Fade_var.FadeService.restart();
                        PaneTitleText_var.ToContactsService.restart();
                    }
                    if(PaneState.get()==6)
                    {
                        if(PaneTitleLight_Fade_var.FadeService.isRunning()) {PaneTitleLight_Fade_var.FadeService.cancel();}
                        if(PaneTitleText_var.CurrentService.isRunning()) {PaneTitleText_var.CurrentService.cancel();}
                        PaneTitleLight_Fade_var.FadeService.restart();
                        PaneTitleText_var.ToSettingsService.restart();
                    }
                }
            }
        );
    }
}