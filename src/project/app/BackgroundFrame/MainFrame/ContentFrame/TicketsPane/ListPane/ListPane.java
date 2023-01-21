package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchField;

import static project.app.Utilities.SizeUtils.*;

public class ListPane extends Pane
{
    public SearchField SearchField_var;

    public ListPane()
    {
        SearchField_var=new SearchField();

        setLayoutX(0); setLayoutY(0);
        setPrefSize(940*UNIT, 960*UNIT);
        getChildren().addAll(SearchField_var);
    }
}