package cntrllayer;

import java.util.ArrayList;
import modellayer.*;
public class SaleController
{
    private CustomerController cCntrl;
    private ItemController iCntrl;
    private SaleContainer cont;
    private Employee employee;
    private ArrayList<Customer> cust;
    private ArrayList<Item> prod;

    private boolean first = false;
    private int show;
    
    public SaleController() 
    {
        cont = SaleContainer.getInstance();
        cCntrl = new CustomerController();
        iCntrl = new ItemController(); 
    }
 
    public String showProductMatches(int s, String p) 
    {
        String output = iCntrl.getSearchString(s, p);

        show = s;
        if(show == 0)
        {
            prod = iCntrl.getAll(p);
        }
        if(show == 1)
        {
            prod = iCntrl.getSingle(p); 
        }
        if(show == 2)
        {
            prod = iCntrl.getMultiple(p);
        }    
        return output;
    }    

    public int addAction(int index, int amount)
    {
        index--;
        int size = prod.size();
        
        if(index >= 0) 
        {
            if(amount > 0)
            {
                int error = 0;
                if(index < size)
                {   
                    for(ItemLine itemLine : prod.get(index).getArray())
                    {
                        if((amount * itemLine.getAmount()) > iCntrl.checkStock(itemLine.getIndex()))
                        {
                            error++;
                        }    
                    }
                }
                if(error > 0)
                {
                    if(prod.get(index).getSize() == 1 && iCntrl.checkStock(0) > 0)
                    {
                        return iCntrl.checkStock(0);
                    }
                    else 
                    {
                        return -1;
                    }
                }
                else
                {
                    for(ItemLine itemLine : prod.get(index).getArray())
                    {
                        iCntrl.changeStock((amount * itemLine.getAmount()), itemLine.getIndex());
                    }
                    if(first == true)
                    {
                        cont.createAction(amount,prod.get(index));
                    }
                    else
                    {
                        cont.addItemLine(amount, prod.get(index));
                    }
                    first = false;
                    return 0;
                }
                
            }
            return - 2;
        }
        return -3;        
    }    

    public void finish()
    {
        first = true;
        prod.removeAll(prod);
    }
    
    public String getRunningDisplay() 
    {
        String display = cont.getRD(); 
        return display;
    }

    public void showCustomerMatches(String c) 
    {
        String output = cCntrl.getSearchString(c);
        cust = cCntrl.getSearchResults(c);
    }    

    public boolean setCustomer(int index)     
    {
        index--;
        if(index > 0 && index < cust.size()) 
        {            
            cont.addCustomer(cust.get(index));
            return true;            
        }
        else
        return false;
    }
    
    public String bill() {String bill = cont.getBill(); return bill;}    
    
    public String searchSale(int i) {String sale = cont.search(i); return sale;}
    
    public void setBillStatus(int index) {cont.setStatus(index);}
}