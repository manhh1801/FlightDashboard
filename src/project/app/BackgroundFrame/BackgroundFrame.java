package project.app.BackgroundFrame;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.Background.Background;
import project.app.BackgroundFrame.MainFrame.MainFrame;

import static project.app.Utilities.SizeUtils.*;

public class BackgroundFrame extends Pane
{
    Background Background_var;
    MainFrame MainFrame_var;
    public BackgroundFrame()
    {
        Background_var=new Background();
        MainFrame_var=new MainFrame();

        setLayoutX(0); setLayoutY(0);
        setPrefWidth(SCREEN_WIDTH*UNIT); setPrefHeight(SCREEN_HEIGHT*UNIT);
        getChildren().addAll(Background_var, MainFrame_var);
    }
}
