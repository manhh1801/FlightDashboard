package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection;

import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.ClearButtonFrame.ClearButtonFrame;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemAdder.FilterItemAdder;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterItemsList.FilterItemsList;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterSectionTitle.FilterSectionTitle;

import static project.app.Utilities.SizeUtils.*;

public class FilterSection extends Pane
{
    public FilterSectionTitle FilterSectionTitle_var;
    public FilterItemsList FilterItemsList_var;
    public FilterItemAdder FilterItemAdder_var;
    public ClearButtonFrame ClearButtonFrame_var;

    public FilterSection()
    {
        FilterSectionTitle_var=new FilterSectionTitle();
        FilterItemsList_var=new FilterItemsList();
        FilterItemAdder_var=new FilterItemAdder();
        ClearButtonFrame_var=new ClearButtonFrame();

        FilterItemsList_var.FilterItemsCount.bindBidirectional(FilterItemAdder_var.FilterItemsCount);
        FilterItemsList_var.FilterItemsCount.bindBidirectional(ClearButtonFrame_var.FilterItemsCount);

        setLayoutX(0); setLayoutY(80*UNIT);
        setPrefSize(940*UNIT, 100*UNIT);
        getChildren().addAll(FilterSectionTitle_var, FilterItemsList_var, FilterItemAdder_var, ClearButtonFrame_var);
    }
}