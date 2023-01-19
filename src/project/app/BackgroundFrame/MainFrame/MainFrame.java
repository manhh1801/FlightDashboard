package project.app.BackgroundFrame.MainFrame;

import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.ContentPane.ContentPane;
import project.app.BackgroundFrame.MainFrame.MainFrameBackground.MainFrameBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.NavigationBar;
import project.app.BackgroundFrame.MainFrame.SystemBar.SystemBar;

import static project.app.Utilities.SizeUtils.*;

public class MainFrame extends Pane
{
    MainFrameBackground MainFrameBackground_var;
    SystemBar SystemBar_var;
    NavigationBar NavigationBar_var;
    ContentPane ContentPane_var;

    public MainFrame()
    {
        MainFrameBackground_var=new MainFrameBackground();
        SystemBar_var=new SystemBar();
        NavigationBar_var=new NavigationBar();
        ContentPane_var=new ContentPane();

        setLayoutX((SCREEN_WIDTH-1600)*UNIT/2); setLayoutY(0);
        setPrefWidth(1600*UNIT); setPrefHeight(1200*UNIT);
        getChildren().addAll(MainFrameBackground_var, SystemBar_var, NavigationBar_var, ContentPane_var);
    }
}