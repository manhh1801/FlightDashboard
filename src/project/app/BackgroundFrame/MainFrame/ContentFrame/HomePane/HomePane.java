package project.app.BackgroundFrame.MainFrame.ContentFrame.HomePane;

import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import project.app.BackgroundFrame.MainFrame.ContentFrame.ContentPane;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class HomePane extends ContentPane
{
    public HomePane()
    {
        super();

        Text WelcomeText=new Text();
        WelcomeText.setText("Welcome!");
        WelcomeText.setFont(AVERTA(2, 24*UNIT));
        WelcomeText.setFill(WHITE(1));
        WelcomeText.setTextAlignment(TextAlignment.LEFT);
        WelcomeText.setTextOrigin(VPos.CENTER);
        WelcomeText.setLayoutX(0); WelcomeText.setLayoutY(30*UNIT);

        getChildren().add(WelcomeText);
    }
}