package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.CustomerColumnTitle;

import javafx.scene.layout.Pane;

import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.CustomerColumnTitle.CustomerColumnTitleText.CustomerColumnTitleText;

import static project.app.Utilities.SizeUtils.*;

public class CustomerColumnTitle extends Pane
{
    public CustomerColumnTitleText CustomerColumnTitleText_var;

    public CustomerColumnTitle()
    {
        CustomerColumnTitleText_var=new CustomerColumnTitleText();

        setLayoutX(180*UNIT); setLayoutY(0);
        setPrefSize(200*UNIT, 60*UNIT);
        getChildren().addAll(CustomerColumnTitleText_var);
    }
}