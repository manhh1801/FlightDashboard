package project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection;

import javafx.scene.layout.Pane;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.PriceCounter.PriceCounter;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.ServiceFeeField.ServiceFeeField;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.PricingSectionTitle.PricingSectionTitle;
import project.app.BackgroundFrame.MainFrame.ContentFrame.TicketsPane.AdderPane.TicketForm.PricingSection.BaseCostField.BaseCostField;

import static project.app.Utilities.SizeUtils.UNIT;

public class PricingSection extends Pane
{
    public PricingSectionTitle PricingSectionTitle_var;
    public PriceCounter PriceCounter_var;
    public ServiceFeeField ServiceFeeField_var;
    public BaseCostField BaseCostField_var;

    public PricingSection()
    {
        PricingSectionTitle_var=new PricingSectionTitle();
        PriceCounter_var=new PriceCounter();
        BaseCostField_var=new BaseCostField();
        ServiceFeeField_var=new ServiceFeeField();

        setLayoutX(0); setLayoutY(380*UNIT);
        setPrefSize(440*UNIT, 150*UNIT);
        getChildren().addAll(PricingSectionTitle_var, PriceCounter_var, BaseCostField_var, ServiceFeeField_var);
    }
}