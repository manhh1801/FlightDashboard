package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection;

import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.ColumnTitles;

import static project.app.Utilities.SizeUtils.*;

public class TableSection extends Pane
{
    public ColumnTitles ColumnTitles_var;

    public TableSection()
    {
        ColumnTitles_var=new ColumnTitles();

        setLayoutX(0); setLayoutY(220*UNIT);
        setPrefSize(940*UNIT, 740*UNIT);
        getChildren().addAll(ColumnTitles_var);
    }
}