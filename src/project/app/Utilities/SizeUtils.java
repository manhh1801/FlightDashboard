package project.app.Utilities;

import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;

public class SizeUtils
{
    private static double UNIT()
    {
        Rectangle2D Screen_var= Screen.getPrimary().getBounds();
        return Screen_var.getHeight()/1200;
    }
    public final static double UNIT=UNIT();

    private static double SCREEN_WIDTH()
    {
        Rectangle2D Screen_var= Screen.getPrimary().getBounds();
        return Screen_var.getWidth()/(Screen_var.getHeight())*1200;
    }
    public final static double SCREEN_WIDTH=SCREEN_WIDTH();

    public final static double SCREEN_HEIGHT=1200;
}