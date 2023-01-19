package project.app.BackgroundFrame.MainFrame.TitleBar.ModeChooser.ModeChooserBackground;

import javafx.scene.shape.Rectangle;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class ModeChooserBackground extends Rectangle
{
    public ModeChooserBackground()
    {
        setFill(DARK_GRAY(1));
        setWidth(205*UNIT); setHeight(40*UNIT);
        setArcWidth(40*UNIT); setArcHeight(40*UNIT);
        setLayoutX(0); setLayoutY(0);
    }
}