package project.app.BackgroundFrame.MainFrame.TitleBar.PaneTitle.PaneTitleLight;

import javafx.scene.layout.Region;

import static project.app.Utilities.SizeUtils.*;

public class PaneTitleLight extends Region
{
    public PaneTitleLight()
    {
        setStyle("-fx-background-color: linear-gradient(to right, #92FE9D 0%, #00C9FF 100%); -fx-background-radius: 2.5px 5px 5px 2.5px");
        setLayoutX(0); setLayoutY(0);
        setPrefSize(10*UNIT, 40*UNIT);
    }
}