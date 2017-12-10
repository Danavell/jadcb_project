package modellayer;

import java.util.*;
public class Action 
{
    private ArrayList<Item> pList;
    private double salePrice;
    private int amount;
    
    public Action(int a, Item item) 
    {
        pList = new ArrayList<>();
        pList.add(item);
        amount = a;
        calcSalePrice();
    }
 
    public String actionPrint()     
    {
        String output = "";
        int i = 1;
        int j = 1;
        for(Item item : pList)
        {
            if(item.getArray().size() == 1) 
            {
                for(ItemLine itemLine : item.getArray())         
                {   
                    output += i + ". (" + amount * itemLine.getAmount() + ")" + itemLine.getName() + (": $") + itemLine.getPrice() + "\n";     
                    i++;                          
                }            
            }
            else            
            {
                output += i + ". (" + amount * item.getAmount() + ")" + item.getName() + "\n";                
                for (ItemLine itemLine : item.getArray())         
                {                
                    output += "     " + j + ". (" + itemLine.getAmount() + ")" + itemLine.getName() + (": $") + itemLine.getPrice() + "\n";     
                    j++;                          
                }
                j = 1;
                output += "\n";
            }
        }
        return output;
    }
    
    public double calcSalePrice() 
    {
        int i;
        for(i = 0; i < pList.size(); i++)
        {
            Item item = pList.get(i);
            salePrice += (double)amount * item.getAmount() * item.getPrice();   
        }
        return salePrice;
    }       

    public void addItem(int amount, Item item)
    {   
        pList.add(item);    
    }
    
    public boolean update(int i, Item item)
    {
        i--; 
        if(i < pList.size())
        {
            pList.add(i, item);
            return true;
        }
        else return false;
    }    
    
    public boolean delete(int i) 
    {
        i--;        
        if(i < pList.size())
        {        
            pList.remove(i);
            return true;
        }
        else return false;
    }
}