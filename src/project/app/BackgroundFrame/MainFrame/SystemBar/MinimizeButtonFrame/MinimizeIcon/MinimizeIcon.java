package project.app.BackgroundFrame.MainFrame.SystemBar.MinimizeButtonFrame.MinimizeIcon;

import javafx.geometry.Bounds;
import javafx.scene.shape.SVGPath;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class MinimizeIcon extends SVGPath
{
    public MinimizeIcon()
    {
        setContent("M0.25 1C0.25 0.5 0.5 0.25 1 0.25H11C11.5 0.25 11.75 0.5 11.75 1C11.75 1.5 11.5 1.75 11 1.75H1C0.5 1.75 0.25 1.5 0.25 1Z");
        setFill(WHITE(1));
        setScaleX(UNIT); setScaleY(UNIT);
        Bounds Bounds=getBoundsInParent();
        setLayoutX(14.25*UNIT-Bounds.getMinX()); setLayoutY(19.25*UNIT-Bounds.getMinY());
    }

}