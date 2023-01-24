package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.DateColumnTitle.DateColumnTitleText;

import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class DateColumnTitleText extends Text
{
    public DateColumnTitleText()
    {
        setText("Date");
        setFont(AVERTA(1, 18*UNIT));
        setFill(WHITE(1));
        setTextAlignment(TextAlignment.LEFT);
        setTextOrigin(VPos.CENTER);
        setLayoutX(0*UNIT); setLayoutY(30*UNIT);
    }
}