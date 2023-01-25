package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.SearchField.SearchTextField;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class SearchTextField extends TextField
{
    public SearchTextField()
    {
        setPromptText("Type here to search by customer's name . . .");
        setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-highlight-fill: #4A4F56; -fx-text-fill: #EDFFFC; -fx-prompt-text-fill: #636678;");
        setFont(AVERTA(0, 16*UNIT));
        setAlignment(Pos.CENTER_LEFT);
        setLayoutX(45*UNIT); setLayoutY(12*UNIT);
        setPrefSize(850*UNIT, 20*UNIT);

        SimpleBooleanProperty FirstFlag=new SimpleBooleanProperty(true);
        focusedProperty().addListener
        (
            new ChangeListener<Boolean>()
            {
                public void changed(ObservableValue<? extends Boolean> arg0, Boolean oldPropertyValue, Boolean newPropertyValue)
                {
                    if(FirstFlag.get())
                    {
                        getParent().requestFocus();
                        FirstFlag.setValue(false);
                    }
                    else
                    {
                        if(newPropertyValue)
                        {
                            setPromptText("");
                            setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-highlight-fill: #4A4F56; -fx-text-fill: #EDFFFC; -fx-prompt-text-fill: #636678;");
                        }
                        else
                        {
                            setPromptText("Type here to search by customer's name . . .");
                            setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-highlight-fill: #4A4F56; -fx-text-fill: #636678; -fx-prompt-text-fill: #636678;");
                        }
                    }
                }
            }
        );
    }
}