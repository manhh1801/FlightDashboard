package project.app.BackgroundFrame.MainFrame;

import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.ContentPane.ContentPane;
import project.app.BackgroundFrame.MainFrame.MainFrameBackground.MainFrameBackground;
import project.app.BackgroundFrame.MainFrame.NavigationBar.NavigationBar;
import project.app.BackgroundFrame.MainFrame.SystemBar.SystemBar;
import project.app.BackgroundFrame.MainFrame.TitleBar.TitleBar;

import static project.app.Utilities.SizeUtils.*;

public class MainFrame extends Pane
{
    public MainFrameBackground MainFrameBackground_var;
    public SystemBar SystemBar_var;
    public NavigationBar NavigationBar_var;
    public TitleBar TitleBar_var;
    public ContentPane ContentPane_var;

    public MainFrame()
    {
        MainFrameBackground_var=new MainFrameBackground();
        SystemBar_var=new SystemBar();
        NavigationBar_var=new NavigationBar();
        TitleBar_var=new TitleBar();
        ContentPane_var=new ContentPane();

        NavigationBar_var.PaneState.bindBidirectional(TitleBar_var.PaneTitle_var.PaneState);

        setLayoutX((SCREEN_WIDTH-1600)*UNIT/2); setLayoutY(0);
        setPrefWidth(1600*UNIT); setPrefHeight(1200*UNIT);
        getChildren().addAll(MainFrameBackground_var, SystemBar_var, NavigationBar_var, TitleBar_var, ContentPane_var);
    }
}