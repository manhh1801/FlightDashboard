package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane;

import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterSection;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchField;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.TableSection;

import static project.app.Utilities.SizeUtils.*;

public class ListPane extends Pane
{
    public SearchField SearchField_var;
    public FilterSection FilterSection_var;
    public TableSection TableSection_var;

    public ListPane()
    {
        SearchField_var=new SearchField();
        FilterSection_var=new FilterSection();
        TableSection_var=new TableSection();

        setLayoutX(0); setLayoutY(0);
        setPrefSize(940*UNIT, 960*UNIT);
        getChildren().addAll(SearchField_var, FilterSection_var, TableSection_var);
    }
}