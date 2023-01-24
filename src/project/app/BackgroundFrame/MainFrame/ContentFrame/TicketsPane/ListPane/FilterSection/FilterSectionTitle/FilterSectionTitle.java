package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.ListPane.FilterSection.FilterSectionTitle;

import javafx.geometry.Bounds;
import javafx.geometry.VPos;
import javafx.scene.layout.Pane;
import javafx.scene.shape.FillRule;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import static project.app.Utilities.ColorUtils.*;
import static project.app.Utilities.FontUtils.*;
import static project.app.Utilities.SizeUtils.*;

public class FilterSectionTitle extends Pane
{
    public FilterSectionTitle()
    {
        SVGPath FilterIcon=new SVGPath();
        FilterIcon.setFillRule(FillRule.EVEN_ODD);
        FilterIcon.setContent("M5.55742 7.8757C5.57219 7.88883 5.58614 7.90113 5.60009 7.9159C6.48542 8.82334 6.97363 10.0253 6.97363 11.3012V14.5699L8.80829 13.5706C8.9527 13.4918 9.04214 13.3376 9.04214 13.1677V11.2913C9.04214 10.0204 9.52542 8.82252 10.4026 7.92L14.3714 3.69868C14.6282 3.42547 14.7693 3.06692 14.7693 2.68868V1.92072C14.7693 1.54002 14.469 1.23071 14.1014 1.23071H1.89958C1.53117 1.23071 1.23086 1.54002 1.23086 1.92072V2.68868C1.23086 3.06692 1.37199 3.42547 1.62881 3.69786L5.55742 7.8757ZM6.6839 16C6.51815 16 6.35405 15.9557 6.20472 15.8671C5.9159 15.6948 5.74277 15.3904 5.74277 15.0524V11.3012C5.74277 10.3699 5.39569 9.49285 4.76308 8.82088C4.7442 8.80529 4.72533 8.78806 4.70892 8.77001L0.732718 4.54213C0.260103 4.04 0 3.38116 0 2.68868V1.92072C0 0.861494 0.852513 0 1.89949 0H14.1013C15.1475 0 16 0.861494 16 1.92072V2.68868C16 3.38034 15.7399 4.03836 15.2689 4.54131L11.2919 8.77001C10.633 9.44936 10.2728 10.3429 10.2728 11.2913V13.1677C10.2728 13.788 9.93723 14.3558 9.39733 14.6511L7.1319 15.8851C6.99077 15.9614 6.83733 16 6.6839 16Z");
        FilterIcon.setFill(GRAY(1));
        FilterIcon.setScaleX(UNIT); FilterIcon.setScaleY(UNIT);
        Bounds Bounds=FilterIcon.getBoundsInParent();
        FilterIcon.setLayoutX(2*UNIT-Bounds.getMinX()); FilterIcon.setLayoutY(2*UNIT-Bounds.getMinY());
        Text FilterText=new Text("Filtered by");
        FilterText.setFont(AVERTA(1 , 13*UNIT));
        FilterText.setFill(GRAY(1));
        FilterText.setTextAlignment(TextAlignment.LEFT);
        FilterText.setTextOrigin(VPos.CENTER);
        FilterText.setLayoutX(25*UNIT); FilterText.setLayoutY(10*UNIT);

        setLayoutX(20*UNIT); setLayoutY(0);
        setPrefSize(100*UNIT, 20*UNIT);
        getChildren().addAll(FilterIcon, FilterText);
    }
}