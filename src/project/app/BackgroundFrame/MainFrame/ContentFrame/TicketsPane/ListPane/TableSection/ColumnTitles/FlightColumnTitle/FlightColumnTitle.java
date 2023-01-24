package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.FlightColumnTitle;

import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.FlightColumnTitle.FlightColumnTitleText.FlightColumnTitleText;

import static project.app.Utilities.SizeUtils.*;

public class FlightColumnTitle extends Pane
{
    public FlightColumnTitleText FlightColumnTitleText_var;

    public FlightColumnTitle()
    {
        FlightColumnTitleText_var=new FlightColumnTitleText();

        setLayoutX(380*UNIT); setLayoutY(0);
        setPrefSize(160*UNIT, 60*UNIT);
        getChildren().addAll(FlightColumnTitleText_var);
    }
}