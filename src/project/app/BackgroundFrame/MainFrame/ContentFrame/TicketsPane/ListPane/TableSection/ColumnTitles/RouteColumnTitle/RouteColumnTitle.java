package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.RouteColumnTitle;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.RouteColumnTitle.RouteColumnTitleText.RouteColumnTitleText;

import static project.app.Utilities.SizeUtils.*;

public class RouteColumnTitle extends Pane
{
    public RouteColumnTitleText RouteColumnTitleText_var;

    public RouteColumnTitle()
    {
        RouteColumnTitleText_var=new RouteColumnTitleText();

        setLayoutX(540*UNIT); setLayoutY(0);
        setPrefSize(360*UNIT, 60*UNIT);
        getChildren().addAll(RouteColumnTitleText_var);
    }
}