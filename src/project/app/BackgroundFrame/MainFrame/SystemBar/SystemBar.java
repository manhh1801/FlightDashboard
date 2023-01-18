package project.app.BackgroundFrame.MainFrame.SystemBar;

import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.SystemBar.AppName.AppName;
import project.app.BackgroundFrame.MainFrame.SystemBar.CloseButtonFrame.CloseButtonFrame;
import project.app.BackgroundFrame.MainFrame.SystemBar.DateDisplay.DateDisplay;
import project.app.BackgroundFrame.MainFrame.SystemBar.MinimizeButtonFrame.MinimizeButtonFrame;

import static project.app.Utilities.SizeUtils.*;

public class SystemBar extends Pane
{
    public DateDisplay Date_var;
    public AppName AppName_var;
    public MinimizeButtonFrame MinimizeButtonFrame_var;
    public CloseButtonFrame CloseButtonFrame_var;

    public SystemBar()
    {
        Date_var=new DateDisplay();
        AppName_var=new AppName();
        MinimizeButtonFrame_var=new MinimizeButtonFrame();
        CloseButtonFrame_var=new CloseButtonFrame();

        setLayoutX(0); setLayoutY(0);
        setPrefSize(1600*UNIT, 60*UNIT);
        getChildren().addAll(Date_var, AppName_var, MinimizeButtonFrame_var, CloseButtonFrame_var);
    }
}