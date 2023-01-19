package project.app.BackgroundFrame.MainFrame.TitleBar.ModeChooser.BreakLine;

import javafx.scene.shape.Rectangle;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class BreakLine extends Rectangle
{
    public BreakLine()
    {
        setFill(WHITE(1));
        setWidth(UNIT); setHeight(20*UNIT);
        setLayoutX(91.5*UNIT); setLayoutY(10*UNIT);
    }
}