package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DetailTitle;

import javafx.geometry.VPos;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class DetailTitle extends Pane
{
    public DetailTitle()
    {
        Circle DetailTitleCircle=new Circle(10*UNIT);
        DetailTitleCircle.setFill(MAIN_GRADIENT);
        DetailTitleCircle.setLayoutX(10*UNIT); DetailTitleCircle.setLayoutY(20*UNIT);
        Text DetailTitleText=new Text("Ticket Detailing");
        DetailTitleText.setFont(AVERTA(2, 24*UNIT));
        DetailTitleText.setFill(WHITE(1));
        DetailTitleText.setTextAlignment(TextAlignment.LEFT);
        DetailTitleText.setTextOrigin(VPos.CENTER);
        DetailTitleText.setLayoutX(40*UNIT); DetailTitleText.setLayoutY(20*UNIT);

        setLayoutX(0); setLayoutY(0);
        setPrefSize(220*UNIT, 40*UNIT);
        getChildren().addAll(DetailTitleCircle, DetailTitleText);
    }
}