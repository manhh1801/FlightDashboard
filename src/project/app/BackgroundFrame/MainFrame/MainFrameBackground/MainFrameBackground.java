package project.app.BackgroundFrame.MainFrame.MainFrameBackground;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static project.app.Utilities.SizeUtils.*;

public class MainFrameBackground extends Rectangle
{

    public MainFrameBackground()
    {
        setFill(Color.web("#0B0B12"));
        setLayoutX(0); setLayoutY(0);
        setWidth(1600*UNIT); setHeight(1200*UNIT);
    }
}
