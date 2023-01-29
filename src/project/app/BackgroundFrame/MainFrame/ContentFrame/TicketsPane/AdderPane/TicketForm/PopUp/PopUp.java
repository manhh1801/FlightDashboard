package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PopUp;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.AVERTA;
import static project.app.Utilities.SizeUtils.UNIT;

public class PopUp extends Text
{
    public SimpleIntegerProperty PopUpState;

    public PopUp()
    {
        setText("");
        setFont(AVERTA(0, 12*UNIT));
        setFill(WHITE(0));
        setTextAlignment(TextAlignment.CENTER);
        setTextOrigin(VPos.CENTER);
        setLayoutX(220*UNIT); setLayoutY(630*UNIT);

        PopUpState=new SimpleIntegerProperty(0);
        PopUpState.addListener
        (
            new ChangeListener<Number>()
            {
                public void changed(ObservableValue<? extends Number> observableValue, Number OldValue, Number NewValue)
                {
                    if(NewValue.intValue()==4)
                    {
                        setText("<Ticket successfully deposited>");
                        setFill(GREEN(1));
                        setLayoutX(133.5*UNIT);
                    }
                    else if(NewValue.intValue()==3)
                    {
                        setText("<Ticket unsuccessfully deposited>");
                        setFill(RED(1));
                        setLayoutX(126.5*UNIT);
                    }
                    else if(NewValue.intValue()==2)
                    {
                        setText("<Flight not available anymore>");
                        setFill(RED(1));
                        setLayoutX(132.5*UNIT);
                    }
                    else if(NewValue.intValue()==1)
                    {
                        setText("<Please fill in all fields>");
                        setFill(RED(1));
                        setLayoutX(155.5*UNIT);
                    }
                    else
                    {
                        setText("");
                        setFill(WHITE(0));
                        setLayoutX(220*UNIT);
                    }
                }
            }
        );
    }
}