package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.DateColumnTitle;

import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.DateColumnTitle.DateColumnTitleText.DateColumnTitleText;

import static project.app.Utilities.SizeUtils.*;

public class DateColumnTitle extends Pane
{
    public DateColumnTitleText DateColumnTitleText_var;

    public DateColumnTitle()
    {
        DateColumnTitleText_var=new DateColumnTitleText();

        setLayoutX(20*UNIT); setLayoutY(0);
        setPrefSize(160*UNIT, 60*UNIT);
        getChildren().addAll(DateColumnTitleText_var);
    }
}