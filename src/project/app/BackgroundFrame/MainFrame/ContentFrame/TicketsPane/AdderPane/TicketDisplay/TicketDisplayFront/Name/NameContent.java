package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketDisplay.TicketDisplayFront.Name;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;
import project.app.Utilities.AnimationUtils.FillTransitionService;

import java.util.concurrent.ExecutorService;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.FLARE;
import static project.app.Utilities.SizeUtils.UNIT;

public class NameContent extends Text
{
    public SimpleStringProperty CustomerName;

    public FillTransitionService EconomicService, BusinessService;

    public NameContent()
    {
        EconomicService=new FillTransitionService(Duration.millis(150), this, WHITE(1), BLACK(1));
        BusinessService=new FillTransitionService(Duration.millis(150), this, BLACK(1), WHITE(1));

        setText("");
        setFont(FLARE(13*UNIT));
        setFill(BLACK(1));
        setTextAlignment(TextAlignment.LEFT);
        setTextOrigin(VPos.CENTER);
        setLayoutX(240*UNIT); setLayoutY(106.5*UNIT);

        Text Test=new Text();
        Test.setFont(FLARE(13*UNIT));
        CustomerName=new SimpleStringProperty();
        CustomerName.addListener
        (
            new ChangeListener<String>()
            {
                public void changed(ObservableValue<? extends String> observableValue, String OldValue, String NewValue)
                {
                    Test.setText("");
                    String Text=NewValue.toLowerCase();
                    boolean Flag=false; int CountFlag=0; boolean AddFlag=false;
                    for(int count=1; count<=Text.length(); count++)
                    {
                        CountFlag=count;
                        Test.setText(Text.substring(0, count));
                        if(Test.getBoundsInParent().getWidth()>140*UNIT)
                        {
                            Flag=true;
                            AddFlag=true;
                            break;
                        }
                    }
                    while(Flag==true)
                    {
                        CountFlag--;
                        Test.setText(Text.substring(0, CountFlag)+" . . .");
                        if(Test.getBoundsInParent().getWidth()<=140*UNIT) {Flag=false;}
                        Test.setText(Text.substring(0, CountFlag));
                    }
                    if(AddFlag==false) {setText(Test.getText());}
                    else {setText(Test.getText()+" . . .");}
                }
            }
        );
    }

    public void setAnimationThreadPool(ExecutorService AnimationThreadPool)
    {
        EconomicService.setExecutor(AnimationThreadPool);
        BusinessService.setExecutor(AnimationThreadPool);
    }
}