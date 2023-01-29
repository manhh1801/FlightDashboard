package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DepositButtonFrame.DepositTitle;

import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static project.app.Utilities.ColorUtils.BLACK;
import static project.app.Utilities.FontUtils.AVERTA;
import static project.app.Utilities.SizeUtils.UNIT;

public class DepositTitle extends Text
{
    public DepositTitle()
    {
        setText("Deposit");
        setFont(AVERTA(1, 14*UNIT));
        setFill(BLACK(1));
        setTextAlignment(TextAlignment.CENTER);
        setTextOrigin(VPos.CENTER);
        setLayoutX(34*UNIT); setLayoutY(20*UNIT);
    }
}