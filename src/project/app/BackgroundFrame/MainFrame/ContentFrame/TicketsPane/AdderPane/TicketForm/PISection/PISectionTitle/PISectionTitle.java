package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PISectionTitle;

import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static project.app.Utilities.ColorUtils.WHITE;
import static project.app.Utilities.FontUtils.AVERTA;
import static project.app.Utilities.SizeUtils.UNIT;

public class PISectionTitle extends Text
{
    public PISectionTitle()
    {
        setText("◊  PERSONAL INFORMATION");
        setFont(AVERTA(1, 16*UNIT));
        setFill(WHITE(1));
        setTextAlignment(TextAlignment.LEFT);
        setTextOrigin(VPos.CENTER);
        setLayoutX(0); setLayoutY(10*UNIT);
    }
}