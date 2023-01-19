package project.app.BackgroundFrame.MainFrame.TitleBar.ModeChooser;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.TitleBar.ModeChooser.BreakLine.BreakLine;
import project.app.BackgroundFrame.MainFrame.TitleBar.ModeChooser.DomesticButtonFrame.DomesticButtonFrame;
import project.app.BackgroundFrame.MainFrame.TitleBar.ModeChooser.InternationalButtonFrame.InternationalButtonFrame;
import project.app.BackgroundFrame.MainFrame.TitleBar.ModeChooser.ModeChooserBackground.ModeChooserBackground;

import static project.app.Utilities.SizeUtils.*;

public class ModeChooser extends Pane
{
    public SimpleBooleanProperty ModeState;

    public ModeChooserBackground ModeChooserBackground_var;
    public BreakLine BreakLine_var;
    public DomesticButtonFrame DomesticButtonFrame_var;
    public InternationalButtonFrame InternationalButtonFrame_var;

    public ModeChooser()
    {
        ModeChooserBackground_var=new ModeChooserBackground();
        BreakLine_var=new BreakLine();
        DomesticButtonFrame_var=new DomesticButtonFrame();
        InternationalButtonFrame_var=new InternationalButtonFrame();

        ModeState=new SimpleBooleanProperty(false);
        ModeState.bindBidirectional(DomesticButtonFrame_var.ModeState);
        ModeState.bindBidirectional(InternationalButtonFrame_var.ModeState);

        setLayoutX(1215*UNIT); setLayoutY(10*UNIT);
        setPrefSize(205*UNIT, 40*UNIT);
        getChildren().addAll(ModeChooserBackground_var, BreakLine_var, DomesticButtonFrame_var, InternationalButtonFrame_var);
    }
}