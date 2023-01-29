package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.BaseCostField.BaseCostTypeField;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;

import static project.app.Utilities.FontUtils.AVERTA;
import static project.app.Utilities.SizeUtils.UNIT;

public class BaseCostTypeField extends TextField
{
    private final int MAX_LENGTH=6;

    public SimpleIntegerProperty LetterCount;

    public BaseCostTypeField()
    {
        setText("20000");
        setPromptText("Base Cost");
        setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-highlight-fill: #292A32; -fx-text-fill: #636678; -fx-prompt-text-fill: #636678;");
        setFont(AVERTA(0, 13*UNIT));
        setAlignment(Pos.CENTER_LEFT);
        setLayoutX(5*UNIT); setLayoutY(15.5*UNIT);
        setPrefSize(120*UNIT, 16*UNIT);

        LetterCount=new SimpleIntegerProperty(MAX_LENGTH);

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
                            setPromptText("Base Cost");
                            setStyle("-fx-border-color: transparent; -fx-background-color: transparent; -fx-highlight-fill: #4A4F56; -fx-text-fill: #636678; -fx-prompt-text-fill: #636678;");
                        }
                    }
                }
            }
        );

        textProperty().addListener
        (
            new ChangeListener<String>()
            {
                public void changed(ObservableValue<? extends String> observableValue, String OldValue, String NewValue)
                {
                    if(NewValue.length()<=MAX_LENGTH)
                    {
                        if (!NewValue.matches("\\d*")) {textProperty().set(NewValue.replaceAll("[^\\d]", ""));}
                        else {LetterCount.set(NewValue.length());}
                    }
                    else {textProperty().set(OldValue);}
                }
            }
        );
    }
}