package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.NameField.NameField;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PISectionTitle.PISectionTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PISection.PassportIDField.PassportIDField;

import static project.app.Utilities.SizeUtils.*;

public class PISection extends Pane
{
    public PISectionTitle PISectionTitle_var;
    public NameField NameField_var;
    public PassportIDField PassportIDField_var;

    public PISection()
    {
        PISectionTitle_var=new PISectionTitle();
        NameField_var=new NameField();
        PassportIDField_var=new PassportIDField();

        setLayoutX(0); setLayoutY(80*UNIT);
        setPrefSize(440*UNIT, 80*UNIT);
        getChildren().addAll(PISectionTitle_var, NameField_var, PassportIDField_var);
    }
}