package project.app.BackgroundFrame.MainFrame.TitleBar;

import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.TitleBar.ModeChooser.ModeChooser;
import project.app.BackgroundFrame.MainFrame.TitleBar.PaneTitle.PaneTitle;

import static project.app.Utilities.SizeUtils.*;

public class TitleBar extends Pane
{
    public PaneTitle PaneTitle_var;
    public ModeChooser ModeChooser_var;

    public TitleBar()
    {
        PaneTitle_var=new PaneTitle();
        ModeChooser_var=new ModeChooser();

        setLayoutX(140*UNIT); setLayoutY(100*UNIT);
        setPrefSize(1420*UNIT, 60*UNIT);
        getChildren().addAll(PaneTitle_var, ModeChooser_var);
    }
}