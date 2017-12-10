package cntrllayer;

import modellayer.*;
import java.util.ArrayList;
public class StockController
{
    private Stock cont;

    /**
     * Constructor for objects of class StockController
     */
    public StockController()
    {
        cont = Stock.getInstance();        
    }

    public int create(int stock, int i, int iAmount, int iLAmount, String name, double price, String barcode) 
    {
        ItemController iC = new ItemController();
        
        Product prod = new Product (name,barcode, price);
        cont.add(stock);

        int outcome = iC.add(stock, i, iAmount, iLAmount, name, prod); 
        return outcome;
    }
    
    public int addStock(int amount)
    {
        int a = cont.add(amount);
        return a;
    }

    public int last() {int a = cont.last(); return a;}
    
    public int delete ()
    {
        ItemController iC = new ItemController();
        return 1;
    }
    
    public void changeStock(int i, int amount)
    {
        cont.decrease(i,amount);
    }
    
    public int checkStock(int i)
    {
        int a = cont.check(i);
        return a;
    }
}
