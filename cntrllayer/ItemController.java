package cntrllayer;

import modellayer.*;
import java.util.ArrayList;

public class ItemController
{
    private StockController s;
    private ItemContainer cont;
    private boolean first = true;
    
    public ItemController()
    {
        s = new StockController();
        cont = new ItemContainer();
    }

    public int add (int stock, int i, int iAmount, int iLAmount, String name, Product prod)
    {
        if(i == 1)
        {
            s.addStock(stock);            
            int position = s.last();
            Item item = new Item (1, null, new ItemLine(prod, position, iLAmount));
            cont.addSingle(item);
            return 0;
        }
        else
        {
            if(first == true)
            { 
                Item item = new Item (iAmount, name, new ItemLine(prod, 0, iLAmount));
                cont.addPackage(item);
                first = false;
                return 1;
            }
            else
            {
                s.addStock(stock);            
                int position = s.last();                
                ItemLine itemLine = new ItemLine(prod, position, iLAmount);
                cont.addItemLine(itemLine);                
                            
                Item item = new Item (1, null, itemLine);

                cont.addSingle(item);                
                return 2;
            }
        }
    }    
        
    public String getSearchString(int s, String p)
    {
        ArrayList<Item> matches = cont.getSingle(p);
        ArrayList<Item> matches2 = cont.getMultiple(p);
        
        String output = "";
        int i = 1;
        int j = 1;
        if(s == 0 || s ==1)
        {
            for(Item item : matches)
            {
                for (ItemLine itemLine : item.getArray()) 
                {
                    output += i + ". (" + itemLine.getAmount() + ") " + itemLine.getName() + (": $") + itemLine.getPrice() + "\n";                
                }
            }
        }
        
        if(s == 0 || s == 2)
        {
            return output;
        }
        else
        {
            for(Item item : matches2)
            {
                output += i + ". (" + item.getAmount() + ")" + item.getName() + "\n";                
                for (ItemLine itemLine : item.getArray())         
                {                
                    output += "     " + j + ". (" + itemLine.getAmount() + ")" + itemLine.getName() + (": $") + itemLine.getPrice() + "\n";     
                    j++;                          
                }
            }
            j = 1;
        }
        return output;    
    }   
    
    public int last() {int a = s.last(); return a;}    
    
    public ArrayList <Item> getAll(String p)
    {
        ArrayList<Item> matches = cont.getSingle(p); 
        ArrayList<Item> matches2 = cont.getMultiple(p);
        
        ArrayList<Item> matched = new ArrayList<>();
        
        for(int i = 0; i < matches.size(); i++)
        {            
            matched.addAll(i,matches);
        }
        
        for(int j = matches.size(); j < matches2.size(); j++)
        {
            matched.addAll(j,matches2);
        }
        return matched;
    }
    
    public ArrayList <Item> getSingle(String p) 
    {
        ArrayList<Item> matches = cont.getSingle(p); 
        return matches;
    }

    public ArrayList <Item> getMultiple(String p) 
    {
        ArrayList<Item> matches = cont.getMultiple(p); 
        return matches;
    }
    
    public void changeStock(int index, int amount) 
    {
        s.changeStock(index, amount);
    }
    
    public int checkStock(int index) 
    {   
        int a = s.checkStock(index);
        return a;
    }        
}