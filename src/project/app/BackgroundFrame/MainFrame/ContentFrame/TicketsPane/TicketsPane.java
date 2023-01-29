package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane;

import javafx.beans.property.SimpleBooleanProperty;
import project.app.BackgroundFrame.MainFrame.ContentFrame.ContentPane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.AdderPane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.ListPane;

public class TicketsPane extends ContentPane
{
    public SimpleBooleanProperty ModeState;

    public ListPane ListPane_var;
    public AdderPane AdderPane_var;

    public TicketsPane()
    {
        super();

        ListPane_var=new ListPane();
        AdderPane_var=new AdderPane();

        getChildren().addAll(ListPane_var, AdderPane_var);
        setOpacity(0);

        ModeState=new SimpleBooleanProperty(false);
        ModeState.bindBidirectional(AdderPane_var.TicketForm_var.ModeState);
    }
}