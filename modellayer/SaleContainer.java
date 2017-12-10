package modellayer;


import java.util.*;
public class SaleContainer {
    private static SaleContainer instance = null;
    ArrayList<Sale> cont;
    private String key;
    private int currentIndex;
    
    public SaleContainer() 
    {
        cont = new ArrayList<>();
    }
    
    public static SaleContainer getInstance() 
    {
        if(instance == null) 
        {
            instance = new SaleContainer();
        }
        return instance;
    }

    public int createAction(int amount, Item item) 
    { 
        Sale sale = new Sale(amount, item);
        cont.add(sale);
        cont.trimToSize();
        currentIndex = sale.getSerial();
        return currentIndex--;
    }

    public void addCustomer(Customer cust) 
    {
        cont.get(currentIndex).addCustomer(cust);
    }         
    
    public void addItemLine(int amount, Item item) 
    {
        cont.get(currentIndex).getAction().addItem(amount, item);
    }    
        
    public void deleteSale() 
    {
        if(currentIndex == (cont.size()-1)) 
        {
            cont.remove(cont.get(currentIndex));
            cont.trimToSize();
        }
        else
        {
            cont.set(currentIndex, null);
        }
    }    
    
    public boolean deleteAL(int i) 
    {
        if(cont.get(currentIndex).getAction().delete(i) == true)
        {
            return true;
        }
        else return false;
    }

    public String search(int i) {        
        String bill = cont.get(i).getBill(); 
        currentIndex = Integer.valueOf(bill.substring(10,15));
        return bill;
    }
    
    public String getRD() 
    {  
        String a = cont.get(currentIndex).runningDisplay(); 
        return a;
    }
    
    public String getBill() {String bill = cont.get(currentIndex).bill(); return bill;}    
    
    public void setStatus(int status) 
    {
        String output = "";

        if(status == -1) 
        {
            output = "Billed: Unpaid";
        }        
        if(status == 0) 
        {
            output = "Billed: Paid";
        }
        if(status == 1) 
        {
            output = "Paid";
        }
            
        cont.get(currentIndex).setStatus(output);
    }
}