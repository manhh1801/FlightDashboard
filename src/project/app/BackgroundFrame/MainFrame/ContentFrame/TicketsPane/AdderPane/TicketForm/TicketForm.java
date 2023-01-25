package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.AddButtonFrame.AddButtonFrame;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.DetailTitle.DetailTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PISection;

import static project.app.Utilities.SizeUtils.*;

public class TicketForm extends Pane
{
    public DetailTitle DetailTitle_var;
    public AddButtonFrame AddButtonFrame_var;
    public PISection PISection_var;

    public TicketForm()
    {
        DetailTitle_var=new DetailTitle();
        AddButtonFrame_var=new AddButtonFrame();
        PISection_var=new PISection();

        setLayoutX(0); setLayoutY(320*UNIT);
        setPrefSize(440*UNIT, 960*UNIT);
        getChildren().addAll(DetailTitle_var, AddButtonFrame_var, PISection_var);
    }
}