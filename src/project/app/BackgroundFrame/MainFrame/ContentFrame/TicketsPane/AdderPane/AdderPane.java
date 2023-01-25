package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplay;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.TicketForm;

import static project.app.Utilities.SizeUtils.*;

public class AdderPane extends Pane
{
    public TicketDisplay TicketDisplay_var;
    public TicketForm TicketForm_var;

    public AdderPane()
    {
        TicketDisplay_var=new TicketDisplay();
        TicketForm_var=new TicketForm();

        setLayoutX(980*UNIT); setLayoutY(0);
        setPrefSize(440*UNIT, 960*UNIT);
        getChildren().addAll(TicketDisplay_var, TicketForm_var);
    }
}