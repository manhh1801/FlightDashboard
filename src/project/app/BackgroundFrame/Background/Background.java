package project.app.BackgroundFrame.Background;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import static project.app.Utilities.SizeUtils.*;

public class Background extends Rectangle
{

    public Background()
    {
        setFill(Color.web("#000000"));
        setLayoutX(0); setLayoutY(0);
        setWidth(SCREEN_WIDTH*UNIT); setHeight(SCREEN_HEIGHT*UNIT);
    }
}
