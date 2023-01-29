package project.app.Utilities;

import javafx.scene.text.Font;

public class FontUtils
{
    public static Font AVERTA(int FontWeight, double FontSize)
    {
        if(FontWeight==0) {return Font.loadFont("file:resources/Fonts/Averta-Regular.otf", FontSize);}
        else if(FontWeight==1) {return Font.loadFont("file:resources/Fonts/Averta-Semibold.otf", FontSize);}
        else if(FontWeight==2) {return Font.loadFont("file:resources/Fonts/Averta-Bold.otf", FontSize);}
        else return null;
    }

    public static Font FLARE(double FontSize) {return Font.loadFont("file:resources/Fonts/Flare.otf", FontSize);}
}
