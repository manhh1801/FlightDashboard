package project.app.BackgroundFrame.MainFrame.SystemBar.AppName;

import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class AppName extends Text
{
    public AppName()
    {
        setText("Flight Dashboard");
        setFont(AVERTA(0, 18*UNIT));
        setFill(WHITE(1));
        setTextAlignment(TextAlignment.CENTER);
        setTextOrigin(VPos.CENTER);
        setLayoutX(727*UNIT); setLayoutY(30*UNIT);
    }
}