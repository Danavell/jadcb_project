package modellayer;

import java.util.ArrayList;
public class Item
{
    private ArrayList<ItemLine> items;
    private int amount;
    private double price;
    private int index;
    private String name;
    private String bill;
    private boolean single;
    
    public Item(int number, String n, ItemLine itemLine)
    {         
        items = new ArrayList<>();  
        amount = number;
        
        addItemLine(itemLine);
                
        name = n;
        index++;
    }
    
    public void addItemLine(ItemLine itemLine) 
    {
        items.add(itemLine); items.trimToSize();
      
        price += (double)amount * (double)itemLine.getAmount() * itemLine.getPrice();
    }
    
    public void finish() 
    {            
        if(items.size() == 1)
        {
            name = items.get(0).getName();
            single = true;
        }
        else
        {
            single = false;
        }              
    }
    
    public int getAmount() {int n = amount; return n;}
    public int getIndex() {int a = index; return a;}
    public String getName() {String n = name; return n;}
    public int getSize() {int a = items.size(); return a;}
    public ItemLine getItemLine(int i) {ItemLine itemLine = items.get(i); return itemLine;}
    public double getPrice() {double a = price; return a;} 
    public boolean getSingle() {boolean a = single; return a;}
    
    public ItemLine gets(int i) 
    {
        ArrayList<ItemLine>trans = new ArrayList<>();

        for(ItemLine itemLine : items)
        {
            trans.add(itemLine);
        }        
        ItemLine temp = trans.get(i);
        return temp;
    }    
    
    public ArrayList<ItemLine> getArray() 
    {
        ArrayList<ItemLine>trans = new ArrayList<>();
        for(ItemLine itemLine : items)
        {
            trans.add(itemLine);
        }
        return trans;
    }
    
    public ItemLine getPosition(int i) 
    {
        ArrayList<ItemLine>trans = new ArrayList<>();
        ItemLine a = items.get(i);
        return a;
    }
}
