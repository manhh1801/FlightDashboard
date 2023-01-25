package project.app.Utilities;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;

public class ColorUtils
{
    public final static Color BLACK(double Opacity) {return Color.web("020414", Opacity);}
    public final static Color DARK_GRAY(double Opacity) {return Color.web("292A32", Opacity);}
    public final static Color GRAY(double Opacity) {return Color.web("636678", Opacity);}
    public final static Color LIGHT_GRAY=Color.web("4A4F56");
    public final static Color WHITE(double Opacity) {return Color.web("EDFFFC", Opacity);}
    public final static Color GREEN_BLACK(double Opacity) {return Color.web("092E27", Opacity);}
    public final static Color GREEN_GRAY(double Opacity){return Color.web("95A7A4", Opacity);}
    public final static Color GREEN_WHITE(double Opacity) {return Color.web("C5F9E6", Opacity);}

    private static LinearGradient MAIN_GRADIENT()
    {
        Stop GradientStops[]={new Stop(0, Color.web("92FE9D")), new Stop(1, Color.web("00C9FF"))};
        LinearGradient MainGradient=new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, GradientStops);
        return MainGradient;
    }
    public final static LinearGradient MAIN_GRADIENT=MAIN_GRADIENT();

    public final static LinearGradient FIRSTHALF_GRADIENT(double Opacity)
    {
        Stop GradientStops[]={new Stop(0, Color.web("92FE9D", Opacity)), new Stop(1, Color.web("47E3D0", Opacity))};
        LinearGradient MainGradient=new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, GradientStops);
        return MainGradient;
    }

    public final static LinearGradient SECONDHALF_GRADIENT(double Opacity)
    {
        Stop GradientStops[]={new Stop(0, Color.web("47E3D0", Opacity)), new Stop(1, Color.web("00C9FF", Opacity))};
        LinearGradient MainGradient=new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, GradientStops);
        return MainGradient;
    }

    public final static LinearGradient WHITE_GRADIENT()
    {
        Stop GradientStops[]={new Stop(0, Color.web("EDFFFC", 0.3)), new Stop(1, Color.web("EDFFFC", 0.7))};
        LinearGradient MainGradient=new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, GradientStops);
        return MainGradient;
    }

    public final static LinearGradient BLACK_GRADIENT()
    {
        Stop GradientStops[]={new Stop(0, Color.web("020414", 0.3)), new Stop(1, Color.web("020414", 0.7))};
        LinearGradient MainGradient=new LinearGradient(0, 0, 1, 1, true, CycleMethod.NO_CYCLE, GradientStops);
        return MainGradient;
    }
}