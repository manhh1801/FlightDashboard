package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DepositButtonFrame.DepositBackground;

import javafx.scene.shape.Rectangle;

import static project.app.Utilities.ColorUtils.MAIN_GRADIENT;
import static project.app.Utilities.SizeUtils.UNIT;

public class DepositBackground extends Rectangle
{
    public DepositBackground()
    {
        setFill(MAIN_GRADIENT);
        setArcWidth(40*UNIT); setArcHeight(40*UNIT);
        setLayoutX(0); setLayoutY(0);
        setWidth(120*UNIT); setHeight(40*UNIT);
    }
}