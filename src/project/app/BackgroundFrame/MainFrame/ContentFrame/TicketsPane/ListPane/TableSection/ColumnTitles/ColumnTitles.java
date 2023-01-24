package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.CustomerColumnTitle.CustomerColumnTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.DateColumnTitle.DateColumnTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.FlightColumnTitle.FlightColumnTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.TableSection.ColumnTitles.RouteColumnTitle.RouteColumnTitle;

import static project.app.Utilities.SizeUtils.*;

public class ColumnTitles extends Pane
{
    public DateColumnTitle DateColumnTitle_var;
    public CustomerColumnTitle CustomerColumnTitle_var;
    public FlightColumnTitle FlightColumnTitle_var;
    public RouteColumnTitle RouteColumnTitle_var;

    public ColumnTitles()
    {
        DateColumnTitle_var=new DateColumnTitle();
        CustomerColumnTitle_var=new CustomerColumnTitle();
        FlightColumnTitle_var=new FlightColumnTitle();
        RouteColumnTitle_var=new RouteColumnTitle();

        setLayoutX(0); setLayoutY(0);
        setPrefSize(940*UNIT, 60*UNIT);
        getChildren().addAll(DateColumnTitle_var, CustomerColumnTitle_var, FlightColumnTitle_var, RouteColumnTitle_var);
    }
}